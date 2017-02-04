package com.wmjun.payment.controller.common;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by wmjun on 2017. 2. 4..
 */
@RestControllerAdvice
public class PaymentApiExceptionHandler {
    @ExceptionHandler(Exception.class)
    public String responseCommonException(){
        return "Error";
    }
}
