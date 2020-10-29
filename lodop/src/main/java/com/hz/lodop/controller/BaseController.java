package com.hz.lodop.controller;

import com.alibaba.fastjson.JSON;
import com.hz.lodop.dto.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

public class BaseController {
    private static final Logger logger= LoggerFactory.getLogger(BaseController.class);

    @ExceptionHandler
    public String exceptionHandler(HttpServletRequest req, Exception ex){
        logger.error("server exception:[ path:{}, param:{} ,ex:{}]",req.getRequestURL(),req.getQueryString(),
                ex.toString());
        Result<Object> result=new Result<Object>(Result.SERVERERR,false,"系统异常");
        return JSON.toJSONString(result);
    }
}
