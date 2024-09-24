package com.chan.week3_project.global.exception;

import lombok.Getter;

// 커스텀 에러 객체
@Getter
public class CustomException extends RuntimeException {

    private Exception originException;
    private final ErrorCode errorCode;

    public CustomException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public CustomException(Exception originException, ErrorCode errorCode) {
        this.originException = originException;
        this.errorCode = errorCode;
    }
}
