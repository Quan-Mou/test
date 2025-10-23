package com.quan.factory.pattern;

public class FordFactory implements CarFactory{
    @Override
    public Car createCar() {
        return new Ford();
    }
}
