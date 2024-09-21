package com.pironeer.week2.controller;

import com.pironeer.week2.dto.request.CommentCreateRequest;
import com.pironeer.week2.dto.request.CommentUpdateRequest;
import com.pironeer.week2.dto.response.CommentResponse;
import com.pironeer.week2.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "댓글(Comment)")
@RequestMapping("/api/comment")
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    @Operation(summary = "댓글 작성")
    public ResponseEntity<Void> create(@Valid @RequestBody CommentCreateRequest request) {
        commentService.save(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{commentId}")
    @Operation(summary = "댓글 단건 조회 (대댓글 포함)")
    public ResponseEntity<CommentResponse> readWithReplies(@PathVariable("commentId") Long id) {
        CommentResponse response = commentService.findByIdWithChildren(id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/single/{commentId}")
    @Operation(summary = "댓글 단건 조회 (대댓글 미포함)")
    public ResponseEntity<CommentResponse> read(@PathVariable("commentId") Long id) {
        CommentResponse response = commentService.findById(id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/topic/{topicId}")
    @Operation(summary = "특정 토픽의 모든 댓글 조회 (대댓글 포함)")
    public ResponseEntity<List<CommentResponse>> readAllByTopicWithReplies(@PathVariable("topicId") Long topicId) {
        List<CommentResponse> responses = commentService.findAllByTopicIdWithChild(topicId);
        return ResponseEntity.ok().body(responses);
    }

    @GetMapping("/topic/{topicId}/single")
    @Operation(summary = "특정 토픽의 모든 댓글 조회 (대댓글 미포함)")
    public ResponseEntity<List<CommentResponse>> readAllByTopic(@PathVariable("topicId") Long topicId) {
        List<CommentResponse> responses = commentService.findAllByTopicId(topicId);
        return ResponseEntity.ok().body(responses);
    }

    @PutMapping
    @Operation(summary = "댓글 수정")
    public ResponseEntity<CommentResponse> update(@Valid @RequestBody CommentUpdateRequest request) {
        CommentResponse response = commentService.update(request);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{commentId}")
    @Operation(summary = "댓글 삭제")
    public ResponseEntity<Void> remove(@PathVariable("commentId") Long id) {
        commentService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}