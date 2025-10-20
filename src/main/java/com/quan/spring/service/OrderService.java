package com.quan.spring.service;

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
