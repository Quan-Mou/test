package com.quan.ioc.annotation.service.impl;

import com.quan.ioc.annotation.dao.PaymentDao;
import com.quan.ioc.annotation.service.PaymentService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {



//    @Resource()
    private PaymentDao payDaoImpl23;


    @Resource
    public void setPayDaoImpl23(PaymentDao payDaoImpl23) {
        this.payDaoImpl23 = payDaoImpl23;
    }

    @Override
    public void pay() {
        payDaoImpl23.pay();
    }
}
