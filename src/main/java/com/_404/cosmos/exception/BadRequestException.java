package com._404.cosmos.exception;

import com._404.cosmos.common.ErrorCode;

public class BadRequestException extends BaseCustomException {

    public BadRequestException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

}
