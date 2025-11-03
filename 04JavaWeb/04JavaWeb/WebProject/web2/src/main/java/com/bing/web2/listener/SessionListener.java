package com.bing.web2.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

// servlet中的监听器，用于监听各个域对象创建、销毁、变化的时机
// servlet中有哪些域对象呢？request域对象，session域对象，servlet域对象

// 这里我们监听session域对象
@WebListener
public class SessionListener implements HttpSessionListener {
    // 监听session被创建
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("有一个session被创建了...");
    }

    // 监听session被销毁
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("有一个session被销毁了...");
    }
}
