package com.pironeer.week2.service;

import com.pironeer.week2.dto.request.CommentCreateRequest;
import com.pironeer.week2.mapper.CommentMapper;
import com.pironeer.week2.repository.CommentRepository;
import com.pironeer.week2.repository.domain.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public void save(CommentCreateRequest request) {
        commentRepository.save(CommentMapper.from(request));
    }


}