package com.chan.week3_project.domain.topic.repository;

import com.chan.week3_project.domain.topic.entity.Topic;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

//@Repository
public class TopicMemoryRepository implements TopicRepository {
    private final AtomicLong topicIdxGenerator = new AtomicLong(0);
    private final Map<Long, Topic> topicMap = new HashMap<>();

    @Override
    public Topic save(Topic topic) {
        if(topic.getId() == null) {
            Long id = topicIdxGenerator.incrementAndGet();
            topic.setId(id);
            topicMap.put(id, topic);
            return topic;
        } else {
            topicMap.replace(topic.getId(), topic);
            return topic;
        }
    }

    @Override
    public Optional<Topic> findById(Long id) {
        Assert.notNull(id, "ID MUST NOT BE NULL");
        return Optional.ofNullable(topicMap.get(id));
    }

    @Override
    public List<Topic> findAll() {
        return topicMap.values().stream().toList();
    }

    @Override
    public Long deleteById(Long id) {
        Assert.notNull(id, "ID MUST NOT BE NULL");
        topicMap.remove(id);
        return id;
    }
}
