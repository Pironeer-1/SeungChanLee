package com.pironeer.week2.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CommentCreateRequest(
        @Schema(description = "부모 댓글의 ID (대댓글인 경우)")
        Long parentId,

        @NotNull
        @Schema(description = "댓글이 속한 토픽의 ID")
        Long topicId,

        @NotBlank
        @Schema(description = "댓글 내용", example = "이것은 댓글 내용입니다.")
        String content
) {}
