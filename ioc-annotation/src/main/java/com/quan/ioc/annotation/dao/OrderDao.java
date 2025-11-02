package com.quan.ioc.annotation.dao;

import com.quan.ioc.annotation.MyComponent;
import org.springframework.stereotype.Repository;

@MyComponent("orderDao")
@Repository
public class OrderDao {

    public void insert() {
        System.out.println("正在创建订单...");
    }

    @Override
    public String toString() {
        return "OrderDao{}";
    }
}
