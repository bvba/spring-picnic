package com._404.cosmos.exception;

import com._404.cosmos.common.ErrorCode;
import com._404.cosmos.controller.response.ReplyError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    @ResponseBody
    public ReplyError handleBadRequestException(BadRequestException e) {
        log.info("[Error] " + e.getErrorCode() + ": " + e.getMessage());
        return new ReplyError(e);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ReplyError handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.info("[Error] " + e.getParameter() + ": " + e.getMessage());
        return new ReplyError(new BaseCustomException(ErrorCode.INVALID_PARAMETER, e.getMessage()));
    }

}
