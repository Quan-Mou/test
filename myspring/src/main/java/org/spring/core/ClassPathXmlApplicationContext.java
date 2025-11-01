package org.spring.core;

import org.dom4j.*;
import org.dom4j.dom.DOMDocument;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ClassPathXmlApplicationContext implements ApplicationContext{
    Map<String,Object> mapBean = new HashMap<>();
    public ClassPathXmlApplicationContext(String configLocal)  {

//        获取到这个xml文件（使用dom4j）
//        解析这个xml文件
//        获取到所有的bean标签
//        得到了class包名 com.xxx.xxx.User
//        通过这个全限定包名去创建对象（先创建暂时不赋值，放入一个map中先进行曝光）
//        然后通过反射去获取它的properties。获取到name的值，就是它的属性名。
//        根据这个属性名拼接set去调用它的set方法进行赋值
        SAXReader saxReader = new SAXReader();
        InputStream in = this.getClass().getClassLoader().getResourceAsStream(configLocal);
        Document document = null;
        try {
            document = saxReader.read(in);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        List<Node> nodes = document.selectNodes("//bean");

        for(Node node : nodes) {
            Element el = (Element)node;
            Attribute id = el.attribute("id");
            Attribute className = el.attribute("class");
            Class<?> aClass = null;
            try {
                aClass = Class.forName(className.getValue());
                Constructor<?> constructor = aClass.getDeclaredConstructor();
                Object obj = constructor.newInstance();
                mapBean.put(id.getValue(),obj); // 曝光
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
//      进行属性赋值，通过setXXX
        for(Node node : nodes) {
            Element el = (Element)node;
            Attribute id = el.attribute("id");
            Attribute className = el.attribute("class");
            Class<?> aClass = null;
            try {
                aClass = Class.forName(className.getValue());
                Constructor<?> constructor = aClass.getDeclaredConstructor();

                Iterator<Element> elementIterator = el.elementIterator();
                while(elementIterator.hasNext()) {
                    Element next = elementIterator.next();
                    String propertiesNameValue = next.attributeValue("name");
                    String setFn = "set" + propertiesNameValue.toUpperCase().charAt(0) + propertiesNameValue.substring(1);

//              通过反射获取这个属性的类型：
                    Field field = aClass.getDeclaredField(propertiesNameValue);
                    Method method = aClass.getDeclaredMethod(setFn,field.getType());
                    Object obj = mapBean.get(id.getValue());
                    String simpleValue = next.attributeValue("value");
                    String refValue = next.attributeValue("ref");
                    if(simpleValue == null) {
                        method.invoke(obj,mapBean.get(refValue));
                    }
                    if(refValue == null) {
                        String propertySimpleName = field.getType().getSimpleName();
                        System.out.println("propertySimpleName:" + propertySimpleName);
                        Object simplePar = null;
                        switch (propertySimpleName) {
                            case "String":
                                simplePar = String.valueOf(simpleValue);
                                break;
                            case "int","Integer": // java14新版特性
                                simplePar = Integer.valueOf(simpleValue);
                                break;
                            case "byte","Byte":
                                simplePar = Byte.valueOf(simpleValue);
                                break;
                            case "long","Long":
                                simplePar = Long.valueOf(simpleValue);
                                break;
                            case "double","Double":
                                simplePar = Double.valueOf(simpleValue);
                                break;
                            case "float","Float":
                                simplePar = Float.valueOf(simpleValue);
                                break;
                            case "char","Character":
                                simplePar = Character.valueOf(simpleValue.charAt(0));
                                break;
                            case "boolean","Boolean":
                                simplePar = Boolean.valueOf(simpleValue);
                                break;
                            default :
                                throw new RuntimeException("不匹配的类型！");
                        }
                        method.invoke(obj,simplePar);
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
    }

    @Override
    public Object getBean(String beanName) {
        Object obj = mapBean.get(beanName);

        if(obj == null) {
            throw new RuntimeException("No bean named '"+beanName+"' available");
        }
        return mapBean.get(beanName);
    }
}
