package com.bing.intercepter;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

// 拦截器需要实现HandlerInterceptor接口
public class MainInterceptor implements HandlerInterceptor {
    //拦截前方法
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("我是拦截前...");
        // 比如：在这里判断用户的身份，从而确定是否放行，比如拿到该用户的session数据进行验证
        /*Object map = request.getSession().getAttribute("admin");
        if(map!=null){
            return true;
        }else{
            return false;
        }*/
        // 返回true表示放行
        return true;
    }

    //拦截后方法
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("我是拦截后...");
        // 比如：在这里可以统一在响应头中添加一些数据
    }

    //完成之后方法
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("我是完成之后方法...");
        // 无论控制器中是否发生了一些，最后都只去做的事情，放在完成之后方法中
    }

    // 正在执行的顺序是：1.拦截前 2.控制器 3.拦截后 4.完成
    // 如果在控制器中发生异常：1.拦截前 2.控制器 3.完成
    // 所以，控制器中一旦发生异常，拦截后就不执行了
}
