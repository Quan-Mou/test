package com.quan.spring;

import com.quan.spring.bean.User;
import com.quan.spring.service.OrderService;
import com.quan.spring.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCustomerMySqlDataSource {


    @Test
    public void testAutoWireByType() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean-autowireByType.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        System.out.println(userService);
    }

    @Test
    public void testAutoWireByName() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean-autowireByName.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        System.out.println(userService);
    }

    @Test
    public  void testUtil() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean-util.xml");
        UserService orderService = applicationContext.getBean("userService", UserService.class);
        System.out.println(orderService);
    }

    @Test
    public void testDic() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean-c.xml");
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        System.out.println(orderService);
    }

    @Test
    public void testDip() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean-p.xml");
        User userService = applicationContext.getBean("user", User.class);
        System.out.println(userService);
    }

    @Test
    public void testDiMap() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean-map.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        System.out.println(userService);
    }

    @Test
    public void testDiArray() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean-arr.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        System.out.println(userService);
    }


    @Test
    public void testSetDi() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

        CustomerMySqlDataSource firstSpringBean = applicationContext.getBean("FirstSpringBean", CustomerMySqlDataSource.class);
        firstSpringBean.insert();
        System.out.println(firstSpringBean);
    }
}
