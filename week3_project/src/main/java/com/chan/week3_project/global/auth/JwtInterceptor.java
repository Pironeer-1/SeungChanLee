package com.chan.week3_project.global.auth;

import com.chan.week3_project.global.exception.CustomException;
import com.chan.week3_project.global.exception.ErrorCode;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

// 인증 여부를 확인하고
// 토큰에서 아이디를 받아 유저 식별
@Component
public class JwtInterceptor implements HandlerInterceptor {

    private final JwtUtil jwtUtil;

    public JwtInterceptor(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        if (token != null && token.startsWith("Bearer ")) {
            String jwtToken = token.substring(7);
            jwtUtil.verify(jwtToken);

            Long id = jwtUtil.getId(jwtToken);
            request.setAttribute("id", id);
            return true;
        }
        throw new CustomException(ErrorCode.UNAUTHORIZED);
    }
}
