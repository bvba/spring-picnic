package com._404.cosmos.controller.response;

import com._404.cosmos.common.ErrorCode;
import com._404.cosmos.exception.BaseCustomException;
import lombok.Data;

@Data
public class ReplyError {

    private ErrorCode errorCode;
    private String message;

    public ReplyError(BaseCustomException e) {
        this.errorCode = e.getErrorCode();
        this.message = e.getMessage();
    }

}
