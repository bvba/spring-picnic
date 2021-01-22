package com._404.cosmos.exception;

import com._404.cosmos.controller.response.ReplyError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    @ResponseBody
    public ReplyError handleBadRequestException(BadRequestException e) {
        return new ReplyError(e);
    }

}
