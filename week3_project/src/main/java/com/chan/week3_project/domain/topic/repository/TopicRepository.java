package com.chan.week3_project.domain.topic.repository;

import com.chan.week3_project.domain.topic.entity.Topic;

import java.util.List;
import java.util.Optional;

public interface TopicRepository {

    Topic save(Topic topic);

    Optional<Topic> findById(Long id);

    List<Topic> findAll();

    Long deleteById(Long id);
}
