package com.quan.ioc.annotation.service.impl;

import com.quan.ioc.annotation.dao.DataSource;
import com.quan.ioc.annotation.dao.OrderDao;
import com.quan.ioc.annotation.dao.impl.MySQLDataSource;
import com.quan.ioc.annotation.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {


    @Value("嘻哈哈")
    public String name;


    @Autowired
    private OrderDao orderDao;

//    @Autowired
//    @Qualifier("oracleDataSource")
//    private DataSource dataSource;

    private DataSource dataSource;


    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

//    @Autowired
    public OrderServiceImpl( DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void insert() {
//        orderDao.insert();
        dataSource.insert();
    }

    @Override
    public String toString() {
        return "OrderServiceImpl{" +
                "name='" + name + '\'' +
                '}';
    }
}
