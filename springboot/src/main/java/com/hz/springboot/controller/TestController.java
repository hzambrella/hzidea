package com.hz.springboot.controller;


import com.hz.springboot.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//http://localhost:8080/print
@Controller
public class TestController {

    @Autowired
    DBService dbService;

    @RequestMapping("/print")
    @ResponseBody
    public String print() {
        return "hello SpringBoot!"+dbService.messageDealer();
    }

    @RequestMapping("/index")
    public String index() {
        return "websocket";
    }

}
