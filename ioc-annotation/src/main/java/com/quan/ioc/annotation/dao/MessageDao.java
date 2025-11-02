package com.quan.ioc.annotation.dao;

import com.quan.ioc.annotation.MyComponent;

@MyComponent("messageDao")
public class MessageDao {


    public void deleteById() {
        System.out.println("正在删除一条消息");
    }

    @Override
    public String toString() {
        return "MessageDao{}";
    }
}
