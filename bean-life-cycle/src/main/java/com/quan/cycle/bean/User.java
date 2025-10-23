package com.quan.cycle.bean;

public class User {

    private String name;

    public User() {
        System.out.println("1.实例化User");
    }

    public void setName(String name) {
        System.out.println("2.属性赋值");
        this.name = name;
    }

    public void beanInit() {
        System.out.println("3.初始化Bean");
    }

    public void beanDestroy() {
        System.out.println("5.销毁Bean");
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
