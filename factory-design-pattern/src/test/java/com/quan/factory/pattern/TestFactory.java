package com.quan.factory.pattern;

import org.junit.Test;

public class TestFactory {

    @Test
    public void test() {
        BMWFactory bmwFactory = new BMWFactory();
        Car car = bmwFactory.createCar();
        car.driver();

        FordFactory fordFactory = new FordFactory();
        Car ford = fordFactory.createCar();
        ford.driver();
    }
}
