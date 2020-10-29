package com.hz.research.controller;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;


@Configuration
@EnableWebSocket
public class WebSocketConfig  implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        System.out.println("....注册......");
        //前台 可以使用websocket环境
        registry.addHandler(myWebSocketHandler(),"/websocket");

    }
    // websocket 处理类
    @Bean
    public WebSocketHandler myWebSocketHandler(){
        return new WebSocketHandle();
    }


}
