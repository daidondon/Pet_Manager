package com.example.petbe.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;
@Component

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        if ("/api/auth/login".equals(request.getRequestURI()) || "/api/auth/register".equals(request.getRequestURI())) {
            filterChain.doFilter(request, response);
            return;
        }
        try {

            String jwt = getJwtFromRequest(request);
            String name=getName(request);
            String a=request.getRequestURI();

            if (StringUtils.hasText(jwt) && JWTConfig.validateToken(jwt)&&JWTConfig.validateToken(jwt,name)) {
                String username = JWTConfig.getUsernameFromToken(jwt);
                // Tạo một đối tượng Authentication sử dụng thông tin từ token
                Authentication authentication = new UsernamePasswordAuthenticationToken(username, null, Collections.emptyList());
                // Lưu trữ thông tin xác thực vào SecurityContextHolder
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else {
                // Nếu token không hợp lệ, trả về lỗi hoặc cho phép truy cập không ủy quyền, tùy thuộc vào yêu cầu của bạn
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // Trả về mã lỗi 401
                return;
            }
        } catch (Exception ex) {
            // Log any exceptions if needed
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // Trả về mã lỗi 401
            return;
        }

        filterChain.doFilter(request, response);
    }



    private String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        return bearerToken.substring(7);

    }
    private String getName(HttpServletRequest request){
        String name=request.getHeader("name");
        return name;
    }
}
