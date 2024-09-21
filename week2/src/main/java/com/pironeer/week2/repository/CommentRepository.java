package com.pironeer.week2.repository;

import com.pironeer.week2.repository.domain.Comment;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class CommentRepository {
    private final AtomicLong commentIdxGenerator = new AtomicLong(0);
    private final Map<Long, Comment> commentMap = new HashMap<>();

    public void save(Comment comment) {
        if (comment.getCommentId() == null) {
            Long id = commentIdxGenerator.incrementAndGet();
            comment.setCommentId(id);
            commentMap.put(id, comment);
        } else {
            commentMap.replace(comment.getCommentId(), comment);
        }
    }

    public Optional<Comment> findById(Long commentId) {
        Assert.notNull(commentId, "Comment ID must not be null");
        return Optional.ofNullable(commentMap.get(commentId));
    }

    private void buildCommentTree(Comment parentComment) {
        for (Comment comment : commentMap.values()) {
            if (parentComment.getCommentId().equals(comment.getParentId())) {
                parentComment.getReplies().add(comment);
                buildCommentTree(comment);
            }
        }
    }

    // 주어진 댓글과 모든 하위 댓글 반환
    public Comment findByIdWithChildren(Long commentId) {
        Assert.notNull(commentId, "Comment ID must not be null");
        Comment rootComment = commentMap.get(commentId);
        if (rootComment != null) {
            rootComment.setReplies(new ArrayList<>()); // 이전에 추가된 replies 초기화
            buildCommentTree(rootComment);
        }
        return rootComment;
    }

    public List<Comment> findAll() {
        return new ArrayList<>(commentMap.values());
    }

    // 특정 토픽의 모든 댓글 반환
    public List<Comment> findAllByTopicId(Long topicId) {
        Assert.notNull(topicId, "Topic ID must not be null");
        return commentMap.values().stream()
                .filter(comment -> topicId.equals(comment.getTopicId()))
                .collect(Collectors.toList());
    }

    // 특정 토픽의 모든 댓글과 하위 댓글 반환
    public List<Comment> findAllByTopicIdWithChild(Long topicId) {
        Assert.notNull(topicId, "Topic ID must not be null");
        List<Comment> rootComments = commentMap.values().stream()
                .filter(comment -> topicId.equals(comment.getTopicId()) && comment.getParentId() == 0)
                .collect(Collectors.toList());

        for (Comment rootComment : rootComments) {
            rootComment.setReplies(new ArrayList<>());
            buildCommentTree(rootComment);
        }

        return rootComments;
    }

    // 댓글 삭제
    public void deleteById(Long commentId) {
        Assert.notNull(commentId, "Comment ID must not be null");
        Comment comment = commentMap.remove(commentId);
        if (comment != null) {
            deleteChildComments(comment);
        }
    }

    private void deleteChildComments(Comment parentComment) {
        for (Iterator<Map.Entry<Long, Comment>> it = commentMap.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<Long, Comment> entry = it.next();
            Comment comment = entry.getValue();
            if (parentComment.getCommentId().equals(comment.getParentId())) {
                it.remove();
                deleteChildComments(comment);
            }
        }
    }
}