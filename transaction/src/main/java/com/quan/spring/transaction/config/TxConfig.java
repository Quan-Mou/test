package com.quan.spring.transaction.config;


import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan({"com.quan.spring.transaction"})
@EnableTransactionManagement // 这行对应XML配置的 <tx:annotation-driven transaction-manager="事务管理器对象" />
public class TxConfig {

//   需要JdbcTemplate对象，要配置数据源
    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource) { // 这里会自动注入
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource); // 或者调用getDrduidDataSource()方法的方式
        return jdbcTemplate;
    }

//   需要数据库连接池对象
    @Bean
    public DataSource getDrduidDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/learn_db");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("zqh123123123");
        return druidDataSource;
    }
//   需要一个事务管理器对象
    @Bean
    public TransactionManager getTransactionManager() {
        JdbcTransactionManager jdbcTransactionManager = new JdbcTransactionManager();
        jdbcTransactionManager.setDataSource(getDrduidDataSource());
        return jdbcTransactionManager;
    }
}
