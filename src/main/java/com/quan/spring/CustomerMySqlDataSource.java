package com.quan.spring;

import com.quan.spring.bean.User;

public class CustomerMySqlDataSource {

    public CustomerMySqlDataSource() {
        System.out.println("CustomerMySqlDataSource 无参构造执行---");
    }

    public CustomerMySqlDataSource(User user) {
        this.user = user;
    }

    private User user;

    public void insert() {
        user.save();
    }


    @Override
    public String toString() {
        return "CustomerMySqlDataSource{" +
                "user=" + user +
                '}';
    }

    public void setUser(User user) {
        this.user = user;
    }
}
