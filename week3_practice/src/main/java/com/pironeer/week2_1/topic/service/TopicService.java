package com.pironeer.week2_1.topic.service;

import com.pironeer.week2_1.topic.dto.request.TopicCreateRequest;
import com.pironeer.week2_1.topic.dto.request.TopicUpdateRequest;
import com.pironeer.week2_1.topic.dto.response.TopicResponse;
import com.pironeer.week2_1.topic.mapper.TopicMapper;
import com.pironeer.week2_1.topic.repository.TopicRepository;
import com.pironeer.week2_1.topic.repository.domain.Topic;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicService {
    private final TopicRepository topicRepository;

    public void save(TopicCreateRequest request) {
        topicRepository.save(TopicMapper.from(request));
    }

    public TopicResponse findById(Long id) {
        Topic topic = topicRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TOPIC NOT FOUND"));
        return TopicResponse.of(topic);
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
