//package com.example.pet_manager.config;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {//nhiêm cứu lại xem dùng thư viện nào
//
//    private final JwtAuthenticationFilter jwtAuthenticationFilter;
//
//    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
//        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
//    }
//
//
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.cors()
//                .and()
//                .authorizeRequests()
//                .antMatchers("/api/auth/login").permitAll()
//                .antMatchers("/api/auth/register").permitAll()
//                .antMatchers("/api/auth/forgot-password").permitAll()
//                .antMatchers("/api/auth/profile").hasAnyAuthority("customer","doctor","host","admin")
//                .antMatchers("/api/auth/update-profile").hasAnyAuthority("customer","doctor","host","admin")
//                .antMatchers("/api/account").hasAnyAuthority("admin")
//                .anyRequest().authenticated()
//                .and()
//                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
//                .csrf().disable();
//    }
//}
