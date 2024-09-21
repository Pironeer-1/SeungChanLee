package com.pironeer.week2_1.topic.service;

import com.pironeer.week2_1.global.dto.response.result.ListResult;
import com.pironeer.week2_1.global.dto.response.result.SingleResult;
import com.pironeer.week2_1.global.service.ResponseService;
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

    public SingleResult<Long> save(TopicCreateRequest request) {
        Topic topic = topicRepository.save(TopicMapper.from(request));
        return ResponseService.getSingleResult(topic.getId());
    }

    public SingleResult<TopicResponse> findById(Long id) {
        Topic topic = topicRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TOPIC NOT FOUND"));
        TopicResponse topicResponse = TopicResponse.of(topic);
        return ResponseService.getSingleResult(topicResponse);
    }

    public ListResult<TopicResponse> findAll() {
        List<Topic> topics = topicRepository.findAll();
        List<TopicResponse> list = topics.stream().map(TopicResponse::of).toList();
        return ResponseService.getListResult(list);
    }

    public TopicResponse update(TopicUpdateRequest request) {
        Topic topic = topicRepository.findById(request.id())
                .orElseThrow(() -> new RuntimeException("TOPIC NOT FOUND"));
        topicRepository.save(topic.update(request));
        return TopicResponse.of(topic);
    }

    public Long deleteById(Long id) {
        topicRepository.deleteById(id);
        return id;
    }
}
