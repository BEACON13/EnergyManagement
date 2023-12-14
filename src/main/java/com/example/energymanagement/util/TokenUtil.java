package com.example.energymanagement.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class TokenUtil {

    private static final String secretKey = "asdfghjklsderftgyhnujmiklxdcfvgbhnjmkl";

    public static String generateToken(Integer userId) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        JwtBuilder builder = Jwts.builder()
                .setSubject(String.valueOf(userId))
                .setIssuedAt(now)
                .signWith(SignatureAlgorithm.HS256, secretKey);
        return builder.compact();
    }

    public static Integer getUserInfoFromToken(String token) {
        // pre check
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
            System.out.println(token);
        }
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
        return Integer.valueOf(claims.getSubject());
    }
}
