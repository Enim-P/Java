package com.bing.controller;

import com.bing.pojo.Employee;
import com.bing.pojo.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
public class Controller1 {
    // 控制器最主要的功能就是实现web项目的请求和响应
    // 请求对象HttpServletRequest
    // 响应对象HttpServletRespost

    @RequestMapping("/param1")
    public String param1(HttpServletRequest request){
        // 通过HttpServletRequest就可以拿到请求参数
        String name = request.getParameter("name");
        String ageStr = request.getParameter("age");
        int age = Integer.valueOf(ageStr);
        System.out.println("姓名："+name+",年龄："+age);
        return "ok";
    }

    @RequestMapping("/param2")
    public String param2(String name,Integer age){
        // 设置控制器方法的形参跟请求的参数同名，可以直接拿到请求参数
        System.out.println("姓名："+name+",年龄："+age);
        return "ok";
    }

    @RequestMapping("/param3")
    public String param3(@RequestParam("name") String xm, @RequestParam("age") Integer nl){
        // 如果控制方法的形参跟请求的参数名不同，可以通过@RequestParam注解指定请求的参数名
        System.out.println("姓名："+xm+",年龄："+nl);
        return "ok";
    }

    @RequestMapping("/param4")
    public String param4(@RequestParam(value = "name",required = false) String name,
                         @RequestParam(value = "age",required = true,defaultValue = "100") Integer age){
        // @RequestParam设置的参数默认是必须传的
        // 通过required属性可以设置是否为必传
        // 通过defaultValue属性可以设置参数的默认值，当必传参数在没有传值时生效
        System.out.println("姓名："+name+",年龄："+age);
        return "ok";
    }

    @RequestMapping("/param5")
    public String param5(User user){
        // 当请求的参数名跟简单实体对象的属性名相同时，自动映射
        // 何为简单对象：当一个对象的所有属性都是基本类型，这样的对象就是一个简单对象
        System.out.println("姓名："+user.getName()+",年龄："+user.getAge());
        return "ok";
    }

    @RequestMapping("/param6")
    public String param6(Employee employee){
        // 嵌套对象的参数要这样传：
        // http://localhost:8080/param6?name=张三&age=100&address.province=江苏省&address.city=南京市
        System.out.println("姓名："+employee.getName()+",年龄："+employee.getAge()+",地址："+
                employee.getAddress().getProvince()+"."+employee.getAddress().getCity());
        return "ok";
    }

    @RequestMapping("/param7")
    public String param7(String[] hobby){
        // 数组形参的参数要这样传：
        // http://localhost:8080/param7?hobby=跑步&hobby=游泳
        System.out.println(Arrays.toString(hobby));
        return "ok";
    }

    @RequestMapping("/param8")
    public String param8(@RequestParam List<String> hobby){
        // 集合类型需要添加@RequestParam注解
        System.out.println(hobby);
        return "ok";
    }

    @RequestMapping("/param9")
    public String param9(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime updateTime){
        // 日期参数需要使用@DateTimeFormat注释，指定日期的格式
        System.out.println(updateTime);
        return "ok";
    }

    // 上面所有的请求都是通过请求参数的方式向控制器发送数据
    // 请求参数会拼接在请求地址中，如果参数不是很多的话，可以这样传，但是如果参数很多请求地址就会显得非常长
    // 首先是不够美观，然后就是大量的数据拼接在URL地址上也不安全，再有就是通过URL传值的大小也是有限的
    // 这个时候就需要使用请求体的方式向控制器发送数据

    // 注意1：只有POST获PUT请求才可以使用请求体传值
    // 注意2：POST和PUT也可以通过请求参数传值
    // @RequestMapping(value = "/param10",method = RequestMethod.POST)
    @PostMapping("/param10")  //使用@PostMapping注解，简化@RequestMapping注解定义Post请求
    public String param10(@RequestBody Employee employee){
        // @RequestBody注解：用于定义请求体参数
        /*
            前端需要只需要通过请求体传递一个JSON格式的对象字符串
            {
                "name":"张三",
                "age":100,
                "address":{
                    "province":"江苏省",
                    "city":"南京市"
                }
            }
        */
        System.out.println("姓名："+employee.getName()+",年龄："+employee.getAge()+",地址："+
                employee.getAddress().getProvince()+"."+employee.getAddress().getCity());
        return "ok";
    }

    // 当请求的参数的数量不固定，名称不固定的时候，就需要使用Map类型接收参数
    // 注意：必须添加@RequestParam注解
    @GetMapping("/param11")
    public String param11(@RequestParam Map<String,Object> map){
        System.out.println(map);
        // 由于map里面的key具体有哪些是不确定的，所以要先判断有没有指定的key，再根据该key去做查询
        if(map.containsKey("name")){
            System.out.println("姓名："+map.get("name"));
        }
        return "ok";
    }

    // 如果是Post请求，将@RequestParam替换成@RequestBody
    @PostMapping("/param12")
    public String param12(@RequestBody Map<String,Object> map){
        System.out.println(map);
        // 由于map里面的key具体有哪些是不确定的，所以要先判断有没有指定的key，再根据该key去做查询
        if(map.containsKey("name")){
            System.out.println("姓名："+map.get("name"));
        }
        return "ok";
    }

    // 通过路径传参，方式通过：{参数名}，此时参数也是路径的一部分，必须传值
    // 只要参数超过两个，这种方式就不要用，比如根据指定的id查询数据，这样的请求可以使用路径参数
    @GetMapping("/param13/{name}/{age}")
    public String param13(@PathVariable("name") String xm,@PathVariable Integer age){
        // 需要给方法的形参添加@PathVariable注解，表示它是一个路径参数
        // @PathVariable注解也可以传递一个具体的参数，当形参和参数名称不同时指定
        System.out.println("姓名："+xm+",年龄："+age);
        return "ok";
    }

}
