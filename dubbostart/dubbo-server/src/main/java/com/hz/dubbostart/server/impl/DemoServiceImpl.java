package com.hz.dubbostart.server.impl;

import com.hz.dubboapi.DemoService;

public class DemoServiceImpl implements DemoService {

    public String sayHello(String name) {
        return "hz hello dubbo:"+name;
    }
}
