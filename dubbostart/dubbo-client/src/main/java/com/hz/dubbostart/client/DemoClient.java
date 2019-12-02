package com.hz.dubbostart.client;

import com.hz.dubboapi.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class DemoClient {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "classpath:springmvc.xml" });
        context.start();

        DemoService demoApi = (DemoService) context.getBean("demoApi");
        System.out.println(demoApi.sayHello("终于学dubbo了"));
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
