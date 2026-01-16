package com.bing.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

/**
 * Jwt令牌工具类
 */
public class JwtUtils {
    private static String singKey = "bing";   //签名秘钥
    private static Long expire = 43200000L;   //过期时间12h

    /**
     * 生成JWT令牌
     * @param claims 生成JWT令牌的载荷
     * @return 令牌信息（token信息）
     */
    public static String generateJwt(Map<String,Object> claims){
        String jwt = Jwts.builder()  // 构建一个令牌生成器
                .signWith(SignatureAlgorithm.HS256, singKey)  //签名算法
                .setClaims(claims)    // 指定载荷（其实就是指定生成token的那份数据）
                .setExpiration(new Date(System.currentTimeMillis()+expire))    // 设置有效时间（这里我们设置为12小时）
                .compact();
        return jwt;
    }

    /**
     * 解析JWT令牌
     * @param jwt JWT令牌信息（token信息）
     * @return 生成JWT令牌的载荷
     */
    public static Claims parseJWT(String jwt){
        Claims claims = Jwts.parser()  // 构建一个解析器
                .setSigningKey(singKey)    //指定签名秘钥
                .parseClaimsJws(jwt)      //指定解析的jwt令牌
                .getBody();
        return claims;
    }
}
