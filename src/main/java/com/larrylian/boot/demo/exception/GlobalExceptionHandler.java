package com.larrylian.boot.demo.exception;

import com.larrylian.boot.demo.contants.ReplyContants;
import com.larrylian.boot.demo.utils.JsonReply;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Larry 06/09/2017
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonReply exceptionHandler(Exception e) {
        if (e instanceof MyException) {
            MyException myException = (MyException)e;
            return JsonReply.error(myException.getCode(), myException.getMessage());
        } else {
            return JsonReply.error(ReplyContants.EXCEPTION_CODE, e.getMessage());
        }
    }
}
