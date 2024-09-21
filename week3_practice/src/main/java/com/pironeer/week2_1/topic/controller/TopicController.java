package com.pironeer.week2_1.topic.controller;

import com.pironeer.week2_1.global.dto.response.SuccessResponse;
import com.pironeer.week2_1.global.dto.response.result.ListResult;
import com.pironeer.week2_1.global.dto.response.result.SingleResult;
import com.pironeer.week2_1.topic.dto.request.TopicCreateRequest;
import com.pironeer.week2_1.topic.dto.request.TopicUpdateRequest;
import com.pironeer.week2_1.topic.dto.response.TopicResponse;
import com.pironeer.week2_1.topic.service.TopicService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "게시물(Topic)")
@RequestMapping("/api/topic")
public class TopicController {
    private final TopicService topicService;

    @PostMapping
    @Operation(summary = "게시물 작성")
    public SuccessResponse<SingleResult<Long>> create(@Valid @RequestBody TopicCreateRequest request) {
        SingleResult<Long> save = topicService.save(request);
        return SuccessResponse.ok(save);
    }

    @GetMapping("/{topicId}")
    @Operation(summary = "게시물 단건 조회")
    public SuccessResponse<SingleResult<TopicResponse>> read(@PathVariable("topicId") Long id) {
        SingleResult<TopicResponse> result = topicService.findById(id);
        return SuccessResponse.ok(result);
    }

    @GetMapping
    @Operation(summary = "게시물 전체 조회")
    public SuccessResponse<ListResult<TopicResponse>> readAll() {
        ListResult<TopicResponse> result = topicService.findAll();
        return SuccessResponse.ok(result);
    }

    @PutMapping
    @Operation(summary = "게시물 수정")
    public ResponseEntity<TopicResponse> update(@Valid @RequestBody TopicUpdateRequest request) {
        TopicResponse response = topicService.update(request);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{topicId}")
    @Operation(summary = "게시물 삭제")
    public ResponseEntity<Long> remove(@PathVariable("topicId") Long id) {
        topicService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
