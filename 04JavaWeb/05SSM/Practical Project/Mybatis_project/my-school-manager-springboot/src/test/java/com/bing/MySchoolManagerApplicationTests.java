package com.bing;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class MySchoolManagerApplicationTests {

    // 测试生成JWT令牌
    /*@Test
    void testGenJwt() {
        // 准备一份数据
        Map<String,Object> maps = new HashMap<>();
        maps.put("loginId","jack");
        maps.put("loginPwd","123456");
        // 根据这份数据，生成一个唯一的JWT令牌
        String jwt = Jwts.builder()  // 构建一个令牌生成器
                .signWith(SignatureAlgorithm.HS256, "bing")  //签名算法
                .setClaims(maps)    // 指定载荷（其实就是指定生成token的那份数据）
                .setExpiration(new Date(System.currentTimeMillis() +  3600*1000))    // 设置有效时间（这里我们设置为1小时）
                .compact();
        System.out.println(jwt);
    }*/

    // 测试解析JWT令牌
    /*@Test
    void testParseJwt(){
        // 生成的jwt令牌
        String jwt = "eyJhbGciOiJIUzI1NiJ9.eyJsb2dpbklkIjoiamFjayIsImxvZ2luUHdkIjoiMTIzNDU2IiwiZXhwIjoxNzY0MTMwMTAyfQ.Ib3nwbkBJaxVOgiratmYitTtOSBaCRFEy2Gwt6dXP4s";

        Claims claims = Jwts.parser()  // 构建一个解析器
                .setSigningKey("bing")    //指定签名秘钥
                .parseClaimsJws(jwt)      //指定解析的jwt令牌
                .getBody();
        System.out.println(claims);
    }*/

}
