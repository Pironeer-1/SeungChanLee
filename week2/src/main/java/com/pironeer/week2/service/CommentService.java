package com.pironeer.week2.service;

import com.pironeer.week2.dto.request.CommentCreateRequest;
import com.pironeer.week2.dto.request.CommentUpdateRequest;
import com.pironeer.week2.dto.response.CommentResponse;
import com.pironeer.week2.mapper.CommentMapper;
import com.pironeer.week2.repository.CommentRepository;
import com.pironeer.week2.repository.domain.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public void save(CommentCreateRequest request) {
        commentRepository.save(CommentMapper.from(request));
    }

    public CommentResponse findById(Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("COMMENT NOT FOUND"));
        return CommentResponse.of(comment);
    }

    public List<CommentResponse> findAll() {
        List<Comment> comments = commentRepository.findAll();
        return comments.stream()
                .map(CommentResponse::of)
                .collect(Collectors.toList());
    }

    public CommentResponse update(CommentUpdateRequest request) {
        Comment comment = commentRepository.findById(request.commentId())
                .orElseThrow(() -> new RuntimeException("COMMENT NOT FOUND"));
        commentRepository.save(comment.update(request));
        return CommentResponse.of(comment);
    }

    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }

    // 주어진 댓글과 모든 하위 댓글 반환
    public CommentResponse findByIdWithChildren(Long commentId) {
        Comment comment = commentRepository.findByIdWithChildren(commentId);
        if (comment == null) {
            throw new RuntimeException("COMMENT NOT FOUND");
        }
        return CommentResponse.of(comment);
    }

    // 특정 토픽의 모든 댓글 반환
    public List<CommentResponse> findAllByTopicId(Long topicId) {
        List<Comment> comments = commentRepository.findAllByTopicId(topicId);
        return comments.stream()
                .map(CommentResponse::of)
                .collect(Collectors.toList());
    }

    // 특정 토픽의 모든 댓글과 하위 댓글 반환
    public List<CommentResponse> findAllByTopicIdWithChild(Long topicId) {
        List<Comment> comments = commentRepository.findAllByTopicIdWithChild(topicId);
        return comments.stream()
                .map(CommentResponse::of)
                .collect(Collectors.toList());
    }
}