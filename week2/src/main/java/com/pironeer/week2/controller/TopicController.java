package com.pironeer.week2.controller;

import com.pironeer.week2.dto.request.TopicCreateRequest;
import com.pironeer.week2.dto.request.TopicUpdateRequest;
import com.pironeer.week2.dto.response.TopicResponse;
import com.pironeer.week2.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // RESTful 웹 서비스의 컨트롤러임을 나타냅니다.
@RequiredArgsConstructor // final 필드에 대한 생성자를 자동으로 생성해줍니다.
@Tag(name = "게시물(Topic)") // Swagger 문서화에서 이 컨트롤러를 '게시물' 그룹으로 표시합니다.
@RequestMapping("/api/topic") // 이 컨트롤러의 기본 URL 경로를 '/api/topic'으로 설정합니다.
public class TopicController {

    private final TopicService topicService;
    // 생성자를 안만들어도 돼??
    // 서비스 계층의 객체를 주입받음, @RequiredArgsConstructor가 생성자를 자동으로 생성

    @PostMapping
    @Operation(summary = "게시물 작성")
    public ResponseEntity<?> create(@Valid @RequestBody TopicCreateRequest request) {
        // 이 반환 타입은 머야?? 반환할 리스폰스가 딱히 없어서 그런가?? : 제너릭 와일드 카드
        topicService.save(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{topicId}")
    @Operation(summary = "게시물 단건 조회")
    public ResponseEntity<TopicResponse> read(@PathVariable("topicId") Long id) {
        TopicResponse response = topicService.findById(id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping
    @Operation(summary = "게시물 전체 조회")
    public ResponseEntity<List<TopicResponse>> readAll() {
        List<TopicResponse> responses = topicService.findAll();
        return ResponseEntity.ok().body(responses);
    }

    @PutMapping
    @Operation(summary = "게시물 수정")
    public ResponseEntity<TopicResponse> update(@Valid @RequestBody TopicUpdateRequest request) {
        TopicResponse response = topicService.update(request);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{topicId}")
    @Operation(summary = "게시물 삭제")
    public ResponseEntity<?> remove(@PathVariable("topicId") Long id) {
        topicService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}