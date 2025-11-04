package com.quan.spring.transaction.dao.impl;

import com.quan.spring.transaction.dao.AccountDao;
import com.quan.spring.transaction.entify.Account;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository("AccountDaoImpl")
public class AccountDaoImpl implements AccountDao {

    private final Logger log = LoggerFactory.getLogger(AccountDaoImpl.class);

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public void transfer(String fromActno, String toActno, double balance) {

        String sql = "select act_name,balance from t_account where act_name = ?";
        Account fromAccount = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Account.class), fromActno);
        if(fromAccount == null) {
            throw new RuntimeException("被转账的账户不存在");
        }
        Account toAccount = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Account.class), toActno);
        if (toAccount == null) {
            throw new RuntimeException("转账的账户不存在");
        }

        if (fromAccount.getBalance() < balance) {
            throw new RuntimeException("余额不足");
        }

        fromAccount.setBalance(fromAccount.getBalance() - balance);
        toAccount.setBalance(toAccount.getBalance() + balance);
        String updateSql = "update  t_account set balance = ? where act_name = ?";
        int effectRow = 0;
        effectRow += jdbcTemplate.update(updateSql, fromAccount.getBalance(), fromAccount.getAct_name());
        System.out.println(1/0);
        effectRow += jdbcTemplate.update(updateSql, toAccount.getBalance(), toAccount.getAct_name());

        if(effectRow != 2) {
            throw new RuntimeException("转账失败");
        }

        log.info("转账成功");
    }

    @Override
    public Account getAccountByActName(String actName) {
        String sql = "select act_name,balance from t_account where act_name = ?";
        try {
            Account account = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Account.class), actName);
            return account;
        } catch (Exception e) {
            log.info("这个账户不存在！");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void insertAct(Account account) {
        String sql = "insert into t_account(actno,act_name,balance) values(?,?,?)";
        int update = jdbcTemplate.update(sql, account.getActno(), account.getAct_name(), account.getBalance());
        try {
            Thread.sleep(1000*10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(update>0) {
            log.info("新增数据成功！");
        } else {
            log.info("新增数据失败！");
        }
//        String s = null;
//        s.toString();
//        String deleteSql = "delete from t_account where act_id = ?";
//        jdbcTemplate.update(deleteSql,10000);
    }
}
