package com.pironeer.week2.repository;

import com.pironeer.week2.repository.domain.Topic;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class TopicRepository {
    private final AtomicLong topicIdxGenerator = new AtomicLong(0);
    // 음 내가 알기로 이거 하나씩 자동 증가? : ㅇㅇ
    private final Map<Long, Topic> topicMap = new HashMap<>();
    // 맵을 사용하는 이유??? : id를 묶어서 효율적 관리
    // 아이디 자동 관리 때문??
    public void save(Topic topic) {// 여기로 전달되는 토픽은 도메인에 정의된걸 리퀘스트dto에 정의 해서 받아오니깐?? : 서비스에서 맵핑해서 줌
        if(topic.getId() == null) {
            // 생성
            Long id = topicIdxGenerator.incrementAndGet();
            topic.setId(id);
            topicMap.put(id, topic);
        } else {
            // 업데이트
            topicMap.replace(topic.getId(), topic);
        }
    }

    public Optional<Topic> findById(Long id) {
        // assert가 머야??? : 에러 처리(null)
        Assert.notNull(id, "ID MUST NOT BE NULL");
        return Optional.ofNullable(topicMap.get(id));
    }

    public List<Topic> findAll() {
        return topicMap.values().stream().toList();
    }

    public void deleteById(Long id) {
        Assert.notNull(id, "ID MUST NOT BE NULL");
        topicMap.remove(id);
    }
}