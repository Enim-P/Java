package com.bing.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
// 如果要丢弃web.xml文件的配置，就必须要定义下面的类

// Servlet容器初始化配置类，这个类需要继承注解配置的DispatcherServlet类
public class ServletContainersInitConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    // 配置根容器
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    // 配置Servlet容器，这里这里就是MVC容器
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMvcConfig.class};
    }

    // 配置Servlet的映射路径
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}


// 1.当前配置就相当于之前在web.xml文件中的配置
// 2.getRootConfigClasses方法和getServletConfigClasses方法，就相当于之前在配置文件中注册的两个参数
// 3.getServletMappings方法，就相当于之前在配置文件中配置的映射路径