package com.bing.filter;

import com.alibaba.fastjson.JSONObject;
import com.bing.pojo.ReturnData;
import com.bing.util.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 过滤器是JavaWeb的原生技术

/**
 * 登录校验过滤器
 */
@Slf4j
@WebFilter(urlPatterns = "/*")   //拦截所有请求
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 强转成HttpServletRequest 和 HttpServletResponse 专门用于处理http请求和响应
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        // 1.获取请求url
        String url = req.getRequestURL().toString();
        //log.info("请求地址：{}",url);

        // 2.判断请求url中是否包含login 或 register
        if(url.contains("/login") || url.contains("/register")){
            chain.doFilter(request,response);
            return;
        }

        // 3.请求请求，获取请求头中的令牌（token）
        String jwt = req.getHeader("token");

        // 4.判断是否存在令牌，如果不存在，返回未登录信息
        if(!StringUtils.hasLength(jwt)){
            ReturnData error = ReturnData.error("NOT_LOGIN");
            String ret = JSONObject.toJSONString(error);
            res.getWriter().write(ret);
            return;
        }

        // 5.如果携带了token，验证token
        try{
            // 解析失败就会发生异常
            Claims claims = JwtUtils.parseJWT(jwt);
        }catch (Exception e){
            ReturnData error = ReturnData.error("NOT_LOGIN");
            String ret = JSONObject.toJSONString(error);
            res.getWriter().write(ret);
            return;
        }

        // 6.token验证成功，放行
        chain.doFilter(request,response);
    }
}
