package com.chan.week3_project.global.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

// 응답은 성공 아니면 실패
// 그리고 이 열거 형은 코드와 메세지를 가진다.
@Getter
@AllArgsConstructor
public enum ResponseState {

    SUCCESS(1, "성공하였습니다."),
    FAIL(-1, "실패하였습니다.");

    private int code;
    private String message;
}
