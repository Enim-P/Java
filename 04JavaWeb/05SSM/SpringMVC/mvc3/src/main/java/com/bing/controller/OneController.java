package com.bing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.*;
import java.io.IOException;

@Controller
@ResponseBody
@RequestMapping(produces = "text/json;charset=UTF-8")
public class OneController {
    /*
        路径通配符：
        ?：表示任意一个字符
        *：表示任意长度的字符
        **：表示多级路径匹配
    */

    // 路径中的?，可以匹配任意一个字符
    @RequestMapping("/xuzhou/a?")
    public String xuzhou(){
        return "徐州";
    }

    // 路径中的*，可以匹配任意长度的字符（0个到n个）
    @RequestMapping("/lianyungang/a*")
    public String lianyungang(){
        return "连云港";
    }

    // 路径中的**，可以匹配多级路径（/aa/bb/cc/dd）
    @RequestMapping("/suqian/**")
    public String suqian(){
        return "宿迁";
    }

    // 该请求，必须要传递username和password参数
    // 比如：huaian?username=abc&password=123
    @RequestMapping(value = "/huaian",params = {"username","password"})
    public String huaian(@RequestParam String username,@RequestParam("password") String pwd){
        // 通过给方法参数设置@RequestParam注解来接收传递参数
        // 如果方法的形参跟url参数同名，它会直接映射
        // 如果方法的形参跟url参数不同名，就需要在@RequestParam注解中指定url参数的名称
        System.out.println(username+" - "+pwd);
        return "淮安";
    }

    // 该请求，必须不能携带username参数
    @RequestMapping(value = "/yancheng",params = {"!username","password"})
    public String yancheng(){
        return "盐城";
    }

    // 设置username参数不能为abc，设置password参数只能为123
    // 比如：登录名账号和密码是固定值的情况下，就可以这样设置参数值
    @RequestMapping(value = "/yangzhou",params = {"username!=abc","password=123"})
    public String yangzhou(){
        return "扬州";
    }

    // params：设置请求参数
    // headers：设置请求头
    @RequestMapping(value = "/taizhou",headers = {"username","password"})
    public String taizhou(@RequestHeader String username,@RequestHeader("password") String pwd){
        // @RequestHeader注解去拿到指定的请求头信息
        System.out.println(username +" - "+pwd);
        return "泰州";
    }

    //produces：指定返回的内容类型
    //设置produces = "text/html;charset=UTF-8"，表示响应的内容是文本html格式，字符编码为utf-8
    //consumes：指定处理请求的提交内容类型（请求体的类型）
    //设置consumes = "application/json"，表示请求体只支持json格式
    @RequestMapping(value = "/nantong",produces = "text/html;charset=UTF-8",
    consumes = "application/json")
    public String nantong(){
        return "<h2>南通</h2>";
    }

    @RequestMapping("/nanjing")
    //使用了@RequestParam注解后，必须要传递对应的参数
    //value属性设置参数的名称，当参数名称跟方法形参不同名时设置
    //required属性设置参数是否为必传，默认值是true
    //defaultValue属性设置参数的默认值
    public String nanjing(@RequestParam(value = "username",required = false,defaultValue = "强哥") String username){
        System.out.println(username);
        return "南京";
    }

    @RequestMapping("/zhenjiang")
    // 在控制器中的请求方法取代的是过去的Servlet
    // 如果需要使用过去Servlet中的用法，
    // 可以直接在请求方法中设置HttpServletRequest类型的参数 和 HttpServletResponse类型的参数
    public void zhenjiang(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        System.out.println(username);
        response.getWriter().write("镇江");
    }

    @RequestMapping("/changzhou")
    // 通过当前请求方法的形参，定义HttpSession类型，就可以拿到当前Session
    // 每个Session对象对应的是每个前端会话，可以理解成为每一个前端在服务器端上面存储的一份数据
    public String changzhou(HttpSession session){
        session.setAttribute("food","常州的糕点很好吃！");
        return "常州";
    }

    @RequestMapping("/changzhou2")
    // 访问上面/changzhou请求时，会在Session中存储一份数据（Session默认的存储时间是30分钟）
    // 访问当前/changzhou2请求时，在从Session中拿到之前存储的数据
    public String changzhou2(HttpSession session){
        String food = (String)session.getAttribute("food");
        return food;
    }

    @RequestMapping("/changzhou3")
    public String changzhou3(@SessionAttribute(value = "food",required = false) String food){
        // 通过@SessionAttribute注解，直接拿到Session中存储的数据
        return food;
    }

    @RequestMapping("/wuxi")
    public String wuxi(HttpServletResponse response){
        // 向浏览器端存储一份Cookie，之后浏览器端的每次请求都会携带这份Cookie
        response.addCookie(new Cookie("test","HelloWorld"));
        return "无锡";
    }

    @RequestMapping("/wuxi2")
    public String wuxi2(@CookieValue(value="test",required = false,defaultValue = "暂无数据") String test){
        // 获取前端浏览器中存储的Cookie，这这里有两种方式：
        // 1.通过HttpServletRequest对象的getCookies方法获取
        // 2.通过@CookieValue注解获取
        // @CookieValue，通过value属性设置Cookie名称，required属性设置是必须，defaultValue属性设置默认值
        return test;
    }

}
