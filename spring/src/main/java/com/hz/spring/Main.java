package com.hz.spring;
import com.hz.pojo.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args){
        ApplicationContext context= new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        /*
        PojoB pojob=(PojoB)context.getBean("PojoB");
        PojoA pojoa=(PojoA)context.getBean("PojoA");
        System.out.println(pojob.getPojoA());
        System.out.println(pojoa.getPojoB());*/
        PojoD pojod=(PojoD)context.getBean("pojoD");
        System.out.println(pojod.getName());
    }
}
