//package com.example.pet_manager.config;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.stereotype.Component;
//
//
//import jakarta.servlet.http.HttpServletResponse;
//import java.security.Key;
//import java.util.Date;
//import java.util.function.Function;
//
//@Component
//public class JWTConfig {
//    private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS512);
//    private static final long EXPIRATION_TIME = 86400000; // 24 hours
//    private static final String PREFIX_TOKEN = "Bearer ";
//
//    public static String generateToken(HttpServletResponse response, String username) {
//        Date now = new Date();
//        Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME);
//        String token = Jwts.builder()
//                .setSubject(username)
//                .setIssuedAt(new Date())
//                .setExpiration(expiryDate)
//                .signWith(SECRET_KEY)
//                .compact();
//        response.addHeader("Authorization", PREFIX_TOKEN + token);
//        return token;
//    }
//
//    public static boolean validateToken(String token) {
//        try {
//            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//    public String extractEmail(String token) {
//        return extractClaim(token, Claims::getSubject);
//    }
//    private Claims extractAllClaims(String token) {
//        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
//    }
//    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
//        final Claims claims = extractAllClaims(token);
//        return claimsResolver.apply(claims);
//    }
//
//
//
//    public static String getUsernameFromToken(String token) {
//        Claims claims = Jwts.parser()
//                .setSigningKey(SECRET_KEY)
//                .parseClaimsJws(token)
//                .getBody();
//
//        return claims.getSubject();
//    }
//}
