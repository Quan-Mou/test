package com.quan.spring.transfer;

import com.quan.spring.transaction.config.TxConfig;
import com.quan.spring.transaction.entify.Account;
import com.quan.spring.transaction.service.AccountService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestTransfer {

    @Test
    public void testAnnotationUseTransaction() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);
        AccountService accountServiceImpl = (AccountService)context.getBean("AccountServiceImpl");
        Account act = new Account(4, "act04", 1000D);
        accountServiceImpl.insertAccount(act);
    }

    /**
     * 测试隔离级别（读未提交）
     * 两个方法：A（做新增数据（延迟睡眠20秒，避免提交事务））、B（做查询数据）
     */

    @Test
    public void testInsert() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountServiceImpl = (AccountService)context.getBean("AccountServiceImpl");
        Account act = new Account(3, "act03", 100d);
        accountServiceImpl.insertAccount(act);
    }

    @Test
    public void testSelect() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountServiceImpl = (AccountService)context.getBean("AccountServiceImpl");
        Account act = accountServiceImpl.getAccountByActName("act03");
        System.out.println(act);
    }



    @Test
    public void testTransfer() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        AccountService AccountService = context.getBean("AccountServiceImpl", AccountService.class);
        AccountService.transfer("actno01","actno02",100);
    }

}
