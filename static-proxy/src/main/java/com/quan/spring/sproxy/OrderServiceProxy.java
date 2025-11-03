package com.quan.spring.sproxy;

public class OrderServiceProxy implements OrderService {


    private OrderService orderService;

    public OrderServiceProxy(OrderService orderService) {
        this.orderService = orderService;

    }

    @Override
    public void generatorOrder() {
        long start = System.currentTimeMillis();
        orderService.generatorOrder();
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));
    }

    @Override
    public void detail() {
        long start = System.currentTimeMillis();
        orderService.detail();
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));
    }

    @Override
    public void delete() {
        long start = System.currentTimeMillis();
        orderService.delete();
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));
    }
}
