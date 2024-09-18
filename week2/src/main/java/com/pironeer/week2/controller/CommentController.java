package com.pironeer.week2.controller;

import com.pironeer.week2.dto.request.CommentCreateRequest;
import com.pironeer.week2.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "댓글(comment)")
@RequestMapping("/api/comment")
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    @Operation(summary = "댓글 작성")
    public ResponseEntity<?> create(@Valid @RequestBody CommentCreateRequest request) {
        commentService.save(request);
        return ResponseEntity.ok().build();
    }
}
