package com.hz.dubbostart.server;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class ProviderMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:springmvc.xml");
        //context.start(); 这个方法不要，也能消费
        System.out.println("Dubbo provider is start.....");
        try {
            System.in.read();   // 按任意键退出 为保证服务一直开着，利用输入流的阻塞来模拟
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
