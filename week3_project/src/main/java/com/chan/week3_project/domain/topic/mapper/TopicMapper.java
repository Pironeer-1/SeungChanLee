package com.chan.week3_project.domain.topic.mapper;

import com.chan.week3_project.domain.topic.dto.request.TopicCreateRequest;
import com.chan.week3_project.domain.topic.entity.Topic;

import java.time.LocalDateTime;

public class TopicMapper {
    public static Topic from(TopicCreateRequest request) {
        LocalDateTime now = LocalDateTime.now();
        return Topic.builder()
                .title(request.title())
                .content(request.content())
                .createdAt(now)
                .updatedAt(now)
                .build();
    }
}
