package com.hz.ideaweb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class HZRestAPIController {

    @RequestMapping("/ceshi")
    public String ceshi(){
        return "ceshi";
    }


}
