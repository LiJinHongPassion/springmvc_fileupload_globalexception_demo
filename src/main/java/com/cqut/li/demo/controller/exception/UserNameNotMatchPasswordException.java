package com.cqut.li.demo.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Li
 * @date 2019/4/15-22:28
 */
@ResponseStatus(value = HttpStatus.FORBIDDEN,reason = "@ResponseStatus方式--标记在类上-----错误")
public class UserNameNotMatchPasswordException extends RuntimeException{

}
