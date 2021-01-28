package com._404.cosmos.exception;

import com._404.cosmos.common.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BaseCustomException extends RuntimeException {

    private final ErrorCode errorCode;
    private final String message;

}
