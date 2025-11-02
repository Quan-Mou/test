package com.quan.ioc.annotation.dao.impl;

import com.quan.ioc.annotation.dao.DataSource;
import org.springframework.stereotype.Repository;

@Repository
public class OracleDataSource implements DataSource {
    @Override
    public void insert() {
        System.out.println("oracle正在进行插入数据...");
    }
}
