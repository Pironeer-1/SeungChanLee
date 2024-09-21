package com.pironeer.week2.service;

import com.pironeer.week2.dto.request.TopicCreateRequest;
import com.pironeer.week2.dto.request.TopicUpdateRequest;
import com.pironeer.week2.dto.response.TopicResponse;
import com.pironeer.week2.mapper.TopicMapper;
import com.pironeer.week2.repository.TopicRepository;
import com.pironeer.week2.repository.domain.Topic;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicService {
    // 의존성 주입을 위한 객체
    private final TopicRepository topicRepository;

    // 리퀘스트를 받아 Mapper로 topic객체를 만들어 레포지토리에 전달
    public void save(TopicCreateRequest request) {
        topicRepository.save(TopicMapper.from(request)); // 이 멥퍼가 리퀘스트를 토픽으로 만들어주는 구나
    }

    public TopicResponse findById(Long id) {
        Topic topic = topicRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TOPIC NOT FOUND"));
        return TopicResponse.of(topic);// 반환 타입이 dto!!
    }

    public List<TopicResponse> findAll() {
        List<Topic> topics = topicRepository.findAll();
        return topics.stream().map(TopicResponse::of).toList();
    }

    public TopicResponse update(TopicUpdateRequest request) {
        Topic topic = topicRepository.findById(request.id())
                .orElseThrow(() -> new RuntimeException("TOPIC NOT FOUND"));
        topicRepository.save(topic.update(request));
        return TopicResponse.of(topic);
    }

    public void deleteById(Long id) {
        topicRepository.deleteById(id);
    }
}