package com.cqut.li.demo.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @ ExceptionHandler方式
 * 1. 通过@ControllerAdvice注解可以将对于控制器的全局配置放在同一个位置。
 * 2. 注解了@Controller的类的方法可以使用@ExceptionHandler、@InitBinder、@ModelAttribute注解到方法上。
 * 3. @ControllerAdvice注解将作用在所有注解了@RequestMapping的控制器的方法上
 * 4. @ExceptionHandler：用于全局处理控制器里的异常。
 *
 *
 *
 * @author Li
 * @date 2019/4/15-19:43
 */
@ControllerAdvice
public class GlobalExceptionController {
    //@ResponseBody
    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public String handlerMaxUploadSizeExceededException(ArrayIndexOutOfBoundsException e){
        //处理异常的方法

        System.out.println("处理异常.....");

        return "arrayerror";
    }

}
