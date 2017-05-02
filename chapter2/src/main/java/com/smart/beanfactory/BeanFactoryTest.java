package com.smart.beanfactory;

import com.smart.Car;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * Created by HP on 2017/4/16.
 */
public class BeanFactoryTest {
    public static void main(String[] args) {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource res = resolver.getResource("classpath:com/smart/beanfactory/beans.xml");
        BeanFactory bf = new XmlBeanFactory(res);
        System.out.println("init BeanFactory.");
        Car car = bf.getBean("car", Car.class);
        System.out.println("car bean is ready for use!");
    }
}
