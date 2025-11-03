package com.quan.spring.sproxy.client;

import com.quan.spring.sproxy.OrderServiceImpl;
import com.quan.spring.sproxy.OrderServiceProxy;

public class Main {
    public static void main(String[] args) {
//        目标对象
        OrderServiceImpl target = new OrderServiceImpl();
//        代理对象
        OrderServiceProxy proxy = new OrderServiceProxy(target);
//        通过代理执行，执行的是目标对象，另外对目标对象进行增强
        proxy.generatorOrder();;
        proxy.detail();
        proxy.delete();;


    }
}
