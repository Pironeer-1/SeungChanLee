package com.pironeer.week4.comment.entity;

import com.pironeer.week4.comment.dto.request.CommentUpdateRequest;
import com.pironeer.week4.topic.entity.Topic;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Comment {
    private Long id;
    private Topic topic;
    private Comment parentComment;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Builder
    public Comment(
            Long id,
            Topic topic,
            Comment parentComment,
            String content,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        this.id = id;
        this.topic = topic;
        this.parentComment = parentComment;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Comment update(CommentUpdateRequest request) {
        this.content = request.content();
        return this;
    }
}
