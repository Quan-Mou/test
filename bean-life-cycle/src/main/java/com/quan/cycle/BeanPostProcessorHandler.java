package com.quan.cycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BeanPostProcessorHandler implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("再beanInit执行之前执行的");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("再beanInit执行之后执行的");
        return bean;
    }
}


/**
 * Bean生命周期之七步走
 * 1.实例化Bean
 * 2.bean属性赋值
 * 3.beanBeforeProcessor执行
 * 4.bean初始化
 * 5.beanAfterProcessor执行
 * 6.使用bean
 * 7.销毁bean
 */