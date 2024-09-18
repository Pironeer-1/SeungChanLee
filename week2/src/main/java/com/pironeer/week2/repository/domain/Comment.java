package com.pironeer.week2.repository.domain;

//import com.pironeer.week2.dto.request.CommentUpdateRequest;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Comment {
    private Long commentId;
    private Long parentId;
    private Long topicId;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Builder
    public Comment(
            Long commentId,
            Long parentId,
            Long topicId,
            String content,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        this.commentId = commentId;
        this.parentId = parentId;
        this.topicId = topicId;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

//    public Comment update(CommentUpdateRequest request) {
//        this.topicId = request.getTopicId();
//        this.content = request.getContent();
//        this.updatedAt = LocalDateTime.now();
//        return this;
//    }
}