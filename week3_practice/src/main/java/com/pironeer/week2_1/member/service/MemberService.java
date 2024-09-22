package com.pironeer.week2_1.member.service;

import com.pironeer.week2_1.global.dto.response.JwtTokenSet;
import com.pironeer.week2_1.global.dto.response.result.SingleResult;
import com.pironeer.week2_1.global.exception.CustomException;
import com.pironeer.week2_1.global.exception.ErrorCode;
import com.pironeer.week2_1.global.service.AuthService;
import com.pironeer.week2_1.global.service.ResponseService;
import com.pironeer.week2_1.member.dto.request.MemberCreateReq;
import com.pironeer.week2_1.member.dto.request.MemberLoginReq;
import com.pironeer.week2_1.member.entity.Member;
import com.pironeer.week2_1.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final AuthService authService;

    public SingleResult<JwtTokenSet> register(MemberCreateReq req) {
        // 아이디 중복 체크
        if (memberRepository.existByMemberId(req.memberId())) {
            throw new CustomException(ErrorCode.USER_ALREADY_EXIST);
        }

        Member newMember = Member.builder()
                .memberId(req.memberId())
                .password(req.password())
                .name(req.name())
                .build();
        newMember = memberRepository.save(newMember);

        JwtTokenSet jwtTokenSet = authService.generateToken(newMember.getId());

        return ResponseService.getSingleResult(jwtTokenSet);
    }

    public SingleResult<JwtTokenSet> login(MemberLoginReq req) {
        Member member = memberRepository.findByMemberId(req.memberId())
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_EXIST));

        // 비밀번호 검증
        if (!member.getPassword().equals(req.password())) {
            throw new CustomException(ErrorCode.USER_WRONG_PASSWORD);
        }

        JwtTokenSet jwtTokenSet = authService.generateToken(member.getId());

        return ResponseService.getSingleResult(jwtTokenSet);
    }
}
