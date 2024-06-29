package com.example.pet_manager.config;


import com.example.pet_manager.entity.User;
import com.example.pet_manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
@Component

public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if ("/api/auth/login".equals(request.getRequestURI()) || "/api/auth/register".equals(request.getRequestURI())) {
            filterChain.doFilter(request, response);
            return;
        }

        try {
            // Lấy token từ request
            String jwt = getJwtFromRequest(request);

            if (StringUtils.hasText(jwt) && JWTConfig.validateToken(jwt)) {
                String username = JWTConfig.getUsernameFromToken(jwt);
                UserDetails userDetails = userService.loadUserByUsername(username);
                // Tạo đối tượng Authentication
                Authentication authentication = new UsernamePasswordAuthenticationToken(username, null, userDetails.getAuthorities());

                // Lưu thông tin xác thực vào SecurityContextHolder
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else {
                // Nếu token không hợp lệ, trả về lỗi 401
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
        } catch (Exception ex) {
            // Log lỗi nếu cần
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        filterChain.doFilter(request, response);

    }



    private String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}
