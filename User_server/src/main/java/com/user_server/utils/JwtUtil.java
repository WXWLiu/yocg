package com.user_server.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JwtUtil {

    private static final String KEY = "yucg";
    private static final ObjectMapper objectMapper = new ObjectMapper();
	//接收业务数据,生成token并返回
    public static String genToken(Map<String, Object> claims) throws JsonProcessingException {
        String claimsJson = objectMapper.writeValueAsString(claims);
        System.out.println("Generated claims JSON: " + claimsJson); // 打印claimsJson
        String token = JWT.create()
                .withClaim("claims", claimsJson)
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 设置过期时间为1小时
                .sign(Algorithm.HMAC256(KEY));
        System.out.println("Generated Token: " + token); // 打印完整的Token
        return token;
    }

	//接收token,验证token,并返回业务数据
    public static Map<String, Object> parseToken(String token) throws JsonProcessingException {
        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256(KEY))
                .build()
                .verify(token);

        // 获取claims的字符串表示
        String claimsJson = decodedJWT.getClaim("claims").asString();

        // 检查claimsJson是否为null
        if (claimsJson == null) {
            throw new IllegalArgumentException("Claim 'claims' is missing or null");
        }

        // 将JSON字符串解析为Map
        return objectMapper.readValue(claimsJson, Map.class);
    }

}
