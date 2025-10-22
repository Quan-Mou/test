package com.quan.spring.ioc.service;

public class OrderService {

    private String name;

    private Integer age;

    public OrderService(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "OrderService{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
