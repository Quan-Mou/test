package com.quan.ioc.annotation.dao.impl;

import com.quan.ioc.annotation.dao.DataSource;
import org.springframework.stereotype.Repository;

public class MySQLDataSource implements DataSource {
    @Override
    public void insert() {
        System.out.println("MySQL正在进行插入数据...");
    }
}
