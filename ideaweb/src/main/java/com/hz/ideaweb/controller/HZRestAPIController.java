package com.hz.ideaweb.controller;

import com.alibaba.fastjson.JSON;
import com.hz.ideaweb.dto.Result;
import com.hz.ideaweb.model.Student;
import com.hz.ideaweb.server.IStudentService;
import com.hz.ideaweb.server.IUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/test")
public class HZRestAPIController {

    @Resource(name="StudentService")
    IStudentService studentService;

    @Resource(name="UserService")
    IUserService userService;
    //http://localhost:8085/ideaweb/test/ceshi
    @RequestMapping("/ceshi")
    public String ceshi(){
        Student student=studentService.getStudentInfo(1);
        Result<Student> result=new Result<>(Result.Success,true,"",student);
        return JSON.toJSONString(result);
    }
    //http://localhost:8085/ideaweb/test/tx?userid=114&pwd=1234
    @RequestMapping("/tx")
    public String ceshiTx(@RequestParam(value="userid")Integer userId,
                           @RequestParam(value="pwd")String pwd){
        Result<Object>result=new Result<>();
         if(userService.changeUserPWD(userId,pwd)){
             return JSON.toJSONString(result);
         }else{
             result.setSuccess(false);
             return JSON.toJSONString(result);
         }
    }


}
