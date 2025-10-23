package com.quan.cycle.bean;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * BeanNameAware、BeanClassLoaderAware、BeanFactoryAware
 * Initializing
 * DisposableBean
 */
public class Order implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware, InitializingBean, DisposableBean {


    private String name;

    public Order() {
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {

    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

    }

    @Override
    public void setBeanName(String name) {

    }

    @Override
    public void destroy() throws Exception {

    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
