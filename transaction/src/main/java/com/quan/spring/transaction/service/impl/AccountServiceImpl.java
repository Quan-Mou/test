package com.quan.spring.transaction.service.impl;

import com.quan.spring.transaction.dao.AccountDao;
import com.quan.spring.transaction.entify.Account;
import com.quan.spring.transaction.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("AccountServiceImpl")
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Autowired
    private AccountService accountService;


    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void transfer(String fromActno, String toActno, double balance) {
        accountDao.transfer(fromActno,toActno,balance);
//        accountService.test();
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void test() {
        System.out.println("test run....");
    }

    @Override
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public Account getAccountByActName(String actName) {
        return accountDao.getAccountByActName(actName);
    }


//    @Transactional(timeout = 10,readOnly = true)


    @Override
//    @Transactional()
    @Transactional(noRollbackFor = NullPointerException.class)
    public void insertAccount(Account account) {
        accountDao.insertAct(account);
    }
}
