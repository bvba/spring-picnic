package com._404.cosmos.common;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    INVALID_PARAMETER(HttpStatus.BAD_REQUEST, 404_0001);

    private final HttpStatus httpStatus;
    private final int code;

    ErrorCode(HttpStatus httpStatus, int code) {
        this.httpStatus = httpStatus;
        this.code = code;
    }

}
