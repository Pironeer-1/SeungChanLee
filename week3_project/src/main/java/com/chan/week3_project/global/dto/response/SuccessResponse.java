package com.chan.week3_project.global.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

// 성공 응답 규격화
// 제네릭한 응답 데이터가 가능하나
// 리스폰스 서비스를 이용하여 두가지의 응답 데이터 타입
// SingleResult<T>,ListResult<T>로 규격화 하여 응답 데이터
// 위의 성공여부, 상태코드, 응답메세지와 함께 응답됌
@Getter
public class SuccessResponse<T> {

    @Schema(description = "성공 여부", example = "true")
    private boolean success = true;

    @Schema(description = "상태 코드", example = "1")
    private int code;

    @Schema(description = "응답 메세지", example = "성공하였습니다.")
    private String message;

    @Schema(description = "응답 데이터")
    private T result;

    public SuccessResponse(int code, String message, T result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public static <T> SuccessResponse<T> of(int code, String message, T data) {
        return new SuccessResponse<>(code, message, data);
    }

    public static <T> SuccessResponse<T> ok(T data) {
        return of(ResponseState.SUCCESS.getCode(), ResponseState.SUCCESS.getMessage(), data);
    }
}
// ok -> of(성공 코드, 메세지, 데이터) -> 생성자 -> 생성한 객체 리턴

