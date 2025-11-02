package com.quan.ioc.annotation.dao.impl;

import com.quan.ioc.annotation.dao.PaymentDao;
import org.springframework.stereotype.Repository;

@Repository()
public class PayDaoImpl2 implements PaymentDao {
    @Override
    public void pay() {
        System.out.println("PayDaoImpl2 正在进行支付");
    }
}
