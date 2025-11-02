package com.quan.ioc.anntation;

import com.quan.ioc.annotation.MyComponent;
import com.quan.ioc.annotation.config.XmlConfig;
import com.quan.ioc.annotation.service.OrderService;
import com.quan.ioc.annotation.service.PaymentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class TestAnnotationIOC {


    @Test
    public void testAnnotationByConfigClass() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(XmlConfig.class);
        Object order = context.getBean("order");
        System.out.println(order);
    }

    @Test
    public void testResourceAnnotation() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        PaymentService paymentServiceImpl = (PaymentService) context.getBean("paymentServiceImpl");
        paymentServiceImpl.pay();
    }


    /**
     * 手动实现一个通过注解创建对象
     */
    @Test
    public void testAnnotationCreateObj() {
//        给你一个包名，获取这个包名下的所有类，查看哪些类上添加了 @Component、@Controller、@Service、@Repository
//        把这些对象对象创建出来，放入一个map中
        Map<String,Object> beanMap = new HashMap<>();
        String packageName = "com.quan.ioc.annotation.dao";
        String scanPackage = System.getProperty("user.dir") + "/src/main/java/" + packageName.replace('.','/');
        File file = new File(scanPackage);
        File[] files = file.listFiles();
        if(file.isDirectory()) {
            for(File item : files) {
//                使用反射创建目录下的所有对象，
                try {
                    Class<?> clazz = Class.forName(packageName + "." + item.getName().substring(0, item.getName().lastIndexOf(".")));
                    Annotation[] declaredAnnotations = clazz.getDeclaredAnnotations();
                    MyComponent annotation = clazz.getAnnotation(MyComponent.class);
                    if (annotation!=null) {
//                      创建这个对象
                        Constructor<?> constructor = clazz.getDeclaredConstructor();
                        Object obj = constructor.newInstance();
                        beanMap.put(annotation.value(),obj);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }



    @Test
    public void testAnnotationIOC() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Object userServiceImpl = context.getBean("orderServiceImpl");
        System.out.println(userServiceImpl);

        Object orderDao = context.getBean("orderDao");
        System.out.println(orderDao);
    }

    @Test
    public void testValue() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        OrderService order = (OrderService) context.getBean("orderServiceImpl");
        System.out.println(order);
        order.insert();
    }

}