package com.wmjun.payment.controller.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by wmjun on 2017. 2. 4..
 */
@Slf4j
@RestControllerAdvice
public class PaymentApiExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorDTO responseCommonException(Exception e) {
        log.error("500 Error - {}", e.getMessage());
        return new ErrorDTO(e.getMessage());
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    class ErrorDTO {
        private String message;
    }
}
