package com.quan.factory.pattern;

public class BMWFactory implements CarFactory{
    @Override
    public Car createCar() {
        return new BMW();
    }
}
