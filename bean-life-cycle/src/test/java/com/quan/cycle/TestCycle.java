package com.quan.cycle;

import com.quan.cycle.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCycle {


    @Test
    public void testLifeCycleFiveStep() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean-cycle.xml");
        User user1 = applicationContext.getBean("user1", User.class);
        System.out.println("4.使用bean");
        ClassPathXmlApplicationContext close = (ClassPathXmlApplicationContext)applicationContext;
        close.close(); // 销毁bean
    }

}
