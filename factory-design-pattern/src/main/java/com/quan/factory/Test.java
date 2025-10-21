package com.quan.factory;

public class Test {
    public static void main(String[] args) {
        Animal tiger = AnimalFactory.create("tiger");
        tiger.eat();

        Animal bear = AnimalFactory.create("bear");
        bear.eat();



    }
}
