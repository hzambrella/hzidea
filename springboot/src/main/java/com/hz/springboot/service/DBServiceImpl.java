package com.hz.springboot.service;

import org.springframework.stereotype.Service;

@Service
public class DBServiceImpl implements DBService{
    public String messageDealer(){
        return "hz";
    }
}
