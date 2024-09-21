package com.pironeer.week2.mapper;

import com.pironeer.week2.dto.request.CommentCreateRequest;
import com.pironeer.week2.repository.domain.Comment;

import java.time.LocalDateTime;

public class CommentMapper {
    public static Comment from(CommentCreateRequest request) {
        LocalDateTime now = LocalDateTime.now();
        return Comment.builder()
                .parentId(request.parentId())
                .topicId(request.topicId())
                .content(request.content())
                .createdAt(now)
                .updatedAt(now)
                .build();
    }
}
