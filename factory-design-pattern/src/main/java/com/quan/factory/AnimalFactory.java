package com.quan.factory;

public class AnimalFactory {

    public static Animal create(String type) {
        if ("bear".equals(type)) {
            return new Bear();
        } else if ("cow".equals(type)) {
            return new Cow();
        } else if ("tiger".equals(type)) {
            return new Tiger();
        } else {
            throw new RuntimeException("非法类型");
        }
    }

}
