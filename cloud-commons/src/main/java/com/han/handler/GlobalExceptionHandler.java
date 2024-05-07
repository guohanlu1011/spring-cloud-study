package com.han.handler;

import com.han.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @className: GlobalExceptionHandler
 * @description: TODO 类描述
 * @author: maybe
 * @date: 2024/4/24
 **/

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result<String> exception(Exception e) {
        e.printStackTrace();
        log.error(e.getMessage());
        return Result.fail(e.getMessage());
    }
}