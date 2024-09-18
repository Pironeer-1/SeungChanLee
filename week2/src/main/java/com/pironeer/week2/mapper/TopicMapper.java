package com.pironeer.week2.mapper;

import com.pironeer.week2.dto.request.TopicCreateRequest;
import com.pironeer.week2.dto.request.TopicUpdateRequest;
import com.pironeer.week2.repository.domain.Topic;

import java.time.LocalDateTime;

// 이 친구가 리퀘스트의 dto를 받아 topic 즉, 도메인을 생성
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