package com.quan.cycle;

import com.quan.cycle.bean.User;
import org.junit.Test;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;

public class TestManualBean {

    @Test
    public void testManualCreateBean() {
        User user = new User();
        user.setName("信号量、管程是用于进程间的互斥和同步的一种解决方案");

        ConfigurableBeanFactory factory = new DefaultListableBeanFactory();
        factory.registerSingleton("user",user);
        User getUser = factory.getBean("user", User.class);
        System.out.println(getUser);
    }
}
