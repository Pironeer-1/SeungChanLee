package com.pironeer.week2.repository;

import com.pironeer.week2.repository.domain.Comment;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class CommentRepository {
    private final AtomicLong commentIdxGenerator = new AtomicLong(0);
    private final Map<Long, Comment> commentMap= new HashMap<>();

    public void save(Comment comment) {
        if(comment.getCommentId() == null) {
            Long id = commentIdxGenerator.incrementAndGet();
            comment.setCommentId(id);
            commentMap.put(id, comment);
        }else {
            commentMap.replace(comment.getCommentId(), comment);
        }
    }

//    public Optional<Comment> findById(Long commentId) {
//        Assert.notNull(commentId, "Comment ID must not be null");
//        return Optional.ofNullable(commentMap.get(commentId));
//    }
//
//    public Optional<Comment> findByIdWithChild(Long commentId) {
//        Assert.notNull(commentId, "Comment ID must not be null");
//        return Optional.ofNullable(commentMap.get(commentId));
//    }
//
//    public List<Comment> findAll() {
//        return new ArrayList<>(commentMap.values());
//    }
//
//    public List<Comment> findAllByTopicId(Long topicId) {
//        return new ArrayList<>(commentMap.values());
//    }
//
//    public List<Comment> findAllByTopicIdWithChild(Long topicId) {
//        return new ArrayList<>(commentMap.values());
//    }
//    public void deleteById(Long commentId) {
//
//    }
}
