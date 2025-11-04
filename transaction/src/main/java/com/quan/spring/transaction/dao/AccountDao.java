package com.quan.spring.transaction.dao;

import com.quan.spring.transaction.entify.Account;

public interface AccountDao {


    void transfer(String fromActno, String toActno, double balance);


    /**
     *  根据账户名查询账户
     * @param actName
     * @return
     */
    Account getAccountByActName(String actName);


    /**
     * 新增一个账户
     * @param account
     */
    void insertAct(Account account);
}
