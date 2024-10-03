package com.chan.week3_project.domain.member.controller;

import com.chan.week3_project.global.dto.result.JwtTokenSet;
import com.chan.week3_project.global.dto.response.SuccessResponse;
import com.chan.week3_project.global.dto.result.SingleResult;
import com.chan.week3_project.domain.member.dto.request.MemberCreateReq;
import com.chan.week3_project.domain.member.dto.request.MemberLoginReq;
import com.chan.week3_project.domain.member.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "회원(Member)")
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    @Operation(summary = "회원가입")
    public SuccessResponse<SingleResult<JwtTokenSet>> register(@Valid @RequestBody MemberCreateReq req) {
        SingleResult<JwtTokenSet> result = memberService.register(req);
        return SuccessResponse.ok(result);
    }

    @PostMapping("/login")
    @Operation(summary = "로그인")
    public SuccessResponse<SingleResult<JwtTokenSet>> login(@Valid @RequestBody MemberLoginReq req) {
        SingleResult<JwtTokenSet> result = memberService.login(req);
        return SuccessResponse.ok(result);
    }
}
