package com.pironeer.week2.dto.response;

import com.pironeer.week2.repository.domain.Comment;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public record CommentResponse(
        @Schema(description = "댓글의 ID", example = "1")
        Long commentId,
        @Schema(description = "부모 댓글의 ID (대댓글인 경우)", example = "0")
        Long parentId,
        @Schema(description = "댓글이 속한 토픽의 ID", example = "1")
        Long topicId,
        @Schema(description = "댓글 내용", example = "댓글입니다.")
        String content,
        @Schema(description = "댓글 생성 시간", example = "2024-10-10 10:10:00")
        LocalDateTime createdAt,
        @Schema(description = "댓글 수정 시간", example = "2024-10-13 10:10:00")
        LocalDateTime updatedAt,
        @Schema(description = "하위 댓글 리스트")
        List<CommentResponse> replies
) {
    public static CommentResponse of(Comment comment) {
        List<CommentResponse> replies = comment.getReplies().stream()
                .map(CommentResponse::of)
                .collect(Collectors.toList());

        return new CommentResponse(
                comment.getCommentId(),
                comment.getParentId(),
                comment.getTopicId(),
                comment.getContent(),
                comment.getCreatedAt(),
                comment.getUpdatedAt(),
                replies
        );
    }
}