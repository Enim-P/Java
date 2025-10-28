package com.bing.web1.servlet;

import com.bing.web1.mapper.AdminMapper;
import com.bing.web1.pojo.Admin;
import com.bing.web1.util.MybatisUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

// 登录
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    // 返回用户Mapper对象
    AdminMapper adminMapper = MybatisUtil.getSession(true)
            .getMapper(AdminMapper.class);

    // GET请求方法
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 解决GET请求参数中文乱码问题

        // 方式一：直接在当前GET请求方法中解决
        // GET请求参数默认采用的编码是（ISO-8859-1）
        String loginId = req.getParameter("loginId");
        // 将原来采用ISO-8859-1编码的字符串数据，转为UTF-8编码
        String loginId2 = new String(loginId.getBytes("ISO-8859-1"),"UTF-8");
        System.out.println(loginId2);
        // 方式二：直接改tomcat服务器的配置，统一处理GET请求的参数编码
        // 修改server.xml配置文件中的配置
        /*
        Connector标签添加URIEncoding="UTF-8"属性，配完后，所有GET请求参数默认采用UTF-8编码
        <Connector port="8080" protocol="HTTP/1.1"
               connectionTimeout="20000"
               redirectPort="8443"
               maxParameterCount="1000"
               URIEncoding="UTF-8"
               />
        */
    }

    // POST请求方法
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 处理POST请求体的编码（该设置只对POST请求有效），否则提交的中文数据会出现乱码
        req.setCharacterEncoding("UTF-8");
        // 设置响应内容的类型
        resp.setContentType("text/html;charset=UTF-8");

        //getParameterMap方法，拿到前端提交过来的post请求参数，它返回一个Map集合
        //Map集合的键是String类型，值是String[]类型
        Map<String, String[]> map = req.getParameterMap();
        //遍历所有的参数
        /*
        map.forEach((k,v)->{
            System.out.println(k+" : "+ Arrays.toString(v));
        });
         */
        if(map.containsKey("loginId") && map.containsKey("loginPwd")){
            //getParameter方法，拿到前端提交的指定的参数
            String loginId = req.getParameter("loginId");
            String loginPwd = req.getParameter("loginPwd");
            Admin admin = adminMapper.getAdminByLoginId(loginId);
            if(admin!=null){
                if(admin.getLoginPwd().equals(loginPwd)){
                    resp.getWriter().write("登录成功！");
                }else{
                    resp.getWriter().write("密码错误！");
                }
            }else{
                resp.getWriter().write("登录名错误！");
            }
        }else{
            resp.getWriter().write("抱歉！登录数据不完整！");
        }
    }
}
