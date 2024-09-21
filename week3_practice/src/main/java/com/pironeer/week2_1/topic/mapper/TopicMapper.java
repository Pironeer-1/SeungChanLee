package com.pironeer.week2_1.topic.mapper;

import com.pironeer.week2_1.topic.dto.request.TopicCreateRequest;
import com.pironeer.week2_1.topic.repository.domain.Topic;

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
