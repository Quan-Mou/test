package com.quan.ioc.annotation.bean;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Order {
//    @Value("张三")
    private String name;
//
//    @Value("20")
    private Integer age;

//    @Value("李四")
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @Value("22")
//    public void setAge(Integer age) {
//        this.age = age;
//    }



    public Order(@Value("哈哈哈") String name, @Value("188") Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
