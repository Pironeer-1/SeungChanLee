package com.pironeer.week2.repository.domain;

import com.pironeer.week2.dto.request.CommentUpdateRequest;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class Comment {
    private Long commentId;
    private Long parentId;
    private Long topicId;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<Comment> replies;

    @Builder
    public Comment(
            Long commentId,
            Long parentId,
            Long topicId,
            String content,
            LocalDateTime createdAt,
            LocalDateTime updatedAt,
            List<Comment> replies
    ) {
        this.commentId = commentId;
        this.parentId = parentId;
        this.topicId = topicId;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.replies = replies != null ? replies : new ArrayList<>();
    }

    public Comment update(CommentUpdateRequest request) {
        this.content = request.content();
        this.updatedAt = LocalDateTime.now();
        return this;
    }
}