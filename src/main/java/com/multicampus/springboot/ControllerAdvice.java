package com.multicampus.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    private Logger logger = LoggerFactory.getLogger(ControllerAdvice.class);

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String exception(Exception exception) {
        logger.error("Internal Server Exception: {}", exception.getMessage());  //{} 자리에 오류 문법 출력
        return exception.getMessage();
    }

    /*@ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String illegalArgumentException(IllegalArgumentException exception) {
        logger.error("IllegalArgumentException: {}", exception.getMessage());
        return exception.getMessage();
    }*/

    /*@ExceptionHandler(CommonException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String notFoundException(CommonException exception) {
        logger.error("CommonException: {}", exception.getMessage());
        return exception.getMessage();
    }*/
}
