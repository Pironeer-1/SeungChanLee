package com.pironeer.week2_1.topic.repository;

import com.pironeer.week2_1.topic.entity.Topic;

import java.util.List;
import java.util.Optional;

public interface TopicRepository {

    Topic save(Topic topic);

    Optional<Topic> findById(Long id);

    List<Topic> findAll();

    Long deleteById(Long id);
}
