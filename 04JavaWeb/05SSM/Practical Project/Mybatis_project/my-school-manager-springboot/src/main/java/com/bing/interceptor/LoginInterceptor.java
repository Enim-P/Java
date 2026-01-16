package com.bing.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.bing.pojo.ReturnData;
import com.bing.util.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录校验拦截器
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    // 目标方法前拦截，返回true放行，返回false不放行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1.获取请求url
        String url = request.getRequestURL().toString();

        // 2.如果在注册拦截器时，没有写排除登录和注册，就要这这里对其放行
        // 就是判断url中是否包含 /login 或 /register 然后放行
        // 这里的第二步可以省略，因为我们在注册拦截器时已经对齐进行了排除
        if(url.contains("/login") || url.contains("/register")){
            return true;
        }

        // 3.获取请求头中的令牌（token）
        String jwt = request.getHeader("token");

        // 4.判断是否存在令牌，如果不存在，返回未登录信息
        if(!StringUtils.hasLength(jwt)){
            ReturnData error = ReturnData.error("NOT_LOGIN");
            String ret = JSONObject.toJSONString(error);
            response.getWriter().write(ret);
            return false;
        }

        // 5.如果携带了token，验证token
        try{
            // 解析失败就会发生异常
            Claims claims = JwtUtils.parseJWT(jwt);
        }catch (Exception e){
            ReturnData error = ReturnData.error("NOT_LOGIN");
            String ret = JSONObject.toJSONString(error);
            response.getWriter().write(ret);
            return false;
        }

        // 6.token验证成功，放行
        return true;
    }




    // 目标方法后运行（通常做一些善后事宜）
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    // 渲染完成后，最后运行（通常做一些释放资源的事宜）
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
