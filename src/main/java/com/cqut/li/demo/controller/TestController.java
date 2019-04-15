package com.cqut.li.demo.controller;

import com.cqut.li.demo.controller.exception.UserNameNotMatchPasswordException;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  介绍了异常处理的四种配置方法
 * @author Li
 * @date 2019/4/15-21:27
 */
@Controller
public class TestController {

    /***
     * 测试 SimpleMappingExceptionResolver
     * 1. 配置方式在 spring-mvc.xml
     *
     * @return
     */
    @RequestMapping("/testSimpleMappingExceptionResolver")
    public String testSimpleMappingExceptionResolver(){
        List li = null;
        li.add("test");
        return "hello";
    }

    /***
     * 测试 @ControllerAdvice + @ExceptionHandler
     * 1. 配置方式在 GlobalExceptionController.java
     *
     * @return
     */
    @RequestMapping("/testGlobalExceptionMapping")
    public String testGlobalExceptionMapping(){
        int arrays[] = new int[10];
        System.out.println(arrays[11]);
        return "hello";
    }


    /***
     * 测试 @Controller + @ExceptionHandler
     * 1. 配置在TestController.java
     * @return
     */
    @RequestMapping("/testExceptionMapping")
    public String testExceptionMapping(){
        String s = "adsad";
        System.out.println(Integer.parseInt(s));
        return "hello";
    }
    //@ResponseBody
    @ExceptionHandler(NumberFormatException.class)
    public String handlerMaxUploadSizeExceededException(NumberFormatException e){
        //处理异常的方法

        System.out.println("处理异常.....");

        return "numbererror";
    }


    /**
     * 测试 @ResponseStatus 标记在自定义异常类上
     * 1. 配置在UserNameNotMatchPasswordException.java自定义异常类，设置value和reason
     * 2. 人为抛出异常
     * @return
     */
    @RequestMapping("/testResponseStatusExceptionResolver")
    @ResponseBody
    public String testResponseStatusExceptionResolver(){
        //人为抛出异常
        throw new UserNameNotMatchPasswordException();
    }


    /**
     * 测试 <error-page>
     * 1. 配置在web.xml
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/error", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> handle(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", request.getAttribute("javax.servlet.error.status_code"));
        map.put("reason", request.getAttribute("javax.servlet.error.message"));
        return map;
    }


}
