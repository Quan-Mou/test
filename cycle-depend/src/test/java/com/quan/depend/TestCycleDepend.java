package com.quan.depend;

import com.quan.depend.bean.Husband;
import com.quan.depend.bean.Wife;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestCycleDepend {


    @Test
    public void testReflect() throws Exception{
//        获取Husband对象的setWife方法。
        /**
         * 已知 com.quan.depend.bean.Husband 类
         * husband 属性
         * 有setHusband方法，如何通过反射机制去调用
         */

        String propertyName = "wife";
        Class<?> clazz = Class.forName("com.quan.depend.bean.Husband");
        Field field = clazz.getDeclaredField(propertyName);
        System.out.println("参数类型：" + field.getType());
        String methodName = "set" + String.valueOf(field.getName().charAt(0)).toUpperCase() + field.getName().substring(1);
        System.out.println("方法名字：" + methodName);
        Method declaredMethod = clazz.getDeclaredMethod(methodName, field.getType());
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object obj = constructor.newInstance();
        Wife wife = new Wife();
        wife.setName("李四");

        declaredMethod.invoke(obj,wife);
        System.out.println(obj);
    }

    @Test
    public void testCycleDepend() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean-depend.xml");
        Husband husband = applicationContext.getBean("husband", Husband.class);
        System.out.println(husband);
        Wife wife = applicationContext.getBean("wife", Wife.class);
        System.out.println(wife);
    }
}
