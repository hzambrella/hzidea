package com.hz.research.controller;

import com.alibaba.fastjson.JSON;
import com.hz.research.dto.Result;
import com.hz.research.model.Student;
import com.hz.research.server.IStudentService;
import com.hz.research.server.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/test")
public class HZRestAPIController extends BaseController{
    private static final Logger logger= LoggerFactory.getLogger(HZRestAPIController.class);

    @Resource(name="StudentService")
    IStudentService studentService;

    @Resource(name="UserService")
    IUserService userService;
    //http://localhost:8085/research/test/ceshi
    @RequestMapping("/ceshi")
    public String ceshi(){
        logger.info("===========ceshi=======");
        Student student=studentService.getStudentInfo(1);
        Result<Student> result=new Result<>(Result.Success,true,"",student);
        return JSON.toJSONString(result);
    }
    //http://localhost:8085/research/test/tx?userid=114&pwd=1234
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

    //http://localhost:8085/research/test/reset?userid=114
    @RequestMapping("/reset")
    public String ceshiReset(@RequestParam(value="userid")Integer userId){
        Result<Object>result=new Result<>();
        if(userService.resetUserPWD(userId)){
            return JSON.toJSONString(result);
        }else{
            result.setSuccess(false);
            return JSON.toJSONString(result);
        }
    }

}
