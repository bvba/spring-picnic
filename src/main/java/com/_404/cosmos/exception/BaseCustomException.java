package com._404.cosmos.exception;

import com._404.cosmos.common.ErrorCode;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class BaseCustomException extends RuntimeException {

    private final ErrorCode errorCode;
    private final String message;

    public BaseCustomException(ErrorCode errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
        log.info("[Error] " + errorCode.getHttpStatus() + ": " + message);
    }

}
