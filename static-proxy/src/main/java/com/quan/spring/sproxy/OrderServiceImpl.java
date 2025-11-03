package com.quan.spring.sproxy;

public class OrderServiceImpl implements OrderService{
    @Override
    public void generatorOrder() {
        try {
            Thread.sleep(1234);
            System.out.println("正在生成订单...");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void detail() {
        try {
            Thread.sleep(1234);
            System.out.println("正在查看订单详情...");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete() {
        try {
            Thread.sleep(1234);
            System.out.println("正在删除订单...");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
