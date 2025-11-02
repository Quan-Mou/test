package com.quan.ioc.annotation.dao.impl;

import com.quan.ioc.annotation.dao.PaymentDao;
import org.springframework.stereotype.Repository;

//@Repository()
public class PayDaoImpl implements PaymentDao {
    @Override
    public void pay() {
        System.out.println("payDao正在进行支付操作");
    }
}
