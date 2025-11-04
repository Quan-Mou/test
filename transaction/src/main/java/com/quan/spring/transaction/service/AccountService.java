package com.quan.spring.transaction.service;

import com.quan.spring.transaction.entify.Account;

public interface AccountService {

    /**
     * 账户转账
     * @param fromActno 转出账户
     * @param toActno 转入账户
     * @param balance 转入金额
     */
    void transfer(String fromActno, String toActno, double balance);
    void test();

    /**
     * 查询账户信息，根据账户名称
     * @param actName
     * @return
     */
    Account getAccountByActName(String actName);


    /**
     * 新增账户
     * @param account
     */
    void insertAccount(Account account);


}
