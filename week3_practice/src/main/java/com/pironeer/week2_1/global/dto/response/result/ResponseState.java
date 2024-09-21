package com.pironeer.week2_1.global.dto.response.result;

public enum ResponseState {

    SUCCESS(1, "성공하였습니다"),
    FAIL(-1, "실패햐셨습니다");

    private int code;
    private String message;

    ResponseState(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
