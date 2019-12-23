package com.hz.ideaweb.controller;

import com.alibaba.fastjson.JSON;
import com.hz.ideaweb.dto.Result;
import com.hz.ideaweb.model.Student;
import com.hz.ideaweb.server.IStudentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/test")
public class HZRestAPIController {

    @Resource(name="StudentService")
    IStudentService testService;

    @RequestMapping("/ceshi")
    public String ceshi(){
        Student student=testService.getStudentInfo(1);
        Result<Student> result=new Result<>(Result.Success,true,"",student);
        return JSON.toJSONString(result);

    }


}
