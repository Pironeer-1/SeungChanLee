package com.chan.week3_project.domain.topic.service;

import com.chan.week3_project.global.exception.CustomException;
import com.chan.week3_project.global.exception.ErrorCode;
import com.chan.week3_project.global.dto.result.ListResult;
import com.chan.week3_project.global.dto.result.SingleResult;

import com.chan.week3_project.global.response.ResponseService;
import com.chan.week3_project.domain.topic.dto.request.TopicCreateRequest;
import com.chan.week3_project.domain.topic.dto.request.TopicUpdateRequest;
import com.chan.week3_project.domain.topic.dto.response.TopicResponse;
import com.chan.week3_project.domain.topic.entity.Topic;
import com.chan.week3_project.domain.topic.mapper.TopicMapper;
import com.chan.week3_project.domain.topic.repository.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicService {
    private final TopicRepository topicRepository;

    public SingleResult<Long> save(TopicCreateRequest request) {
        Topic savedTopic = topicRepository.save(TopicMapper.from(request));
        return ResponseService.getSingleResult(savedTopic.getId());
    }

    public SingleResult<TopicResponse> findById(Long id) {
        Topic topic = topicRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.BOARD_NOT_FOUND));
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
        Long deleteId = topicRepository.deleteById(id);
        return deleteId;
    }
}
