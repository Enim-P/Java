<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
    <!--
        在javaweb中，之前我们采用的方式是在html文件中向servlet发生请求，
        然后在servlet中处理所有的业务逻辑，再将结果发送给html
        其实javaweb还提供了另外一种处理方式：jsp（java server page）
        就是我们可以直接在页面中处理所有的业务逻辑
    -->
    <h1>Hello JSP</h1>
    <%
        // 在这里定义java的逻辑代码
        System.out.println("Hello JSP");
        for(int i=1;i<=5;i++){
            System.out.println("Hello JSP");
        }
        class Student{
            private String name;
            private int age;

            public Student() {
            }

            public Student(String name, int age) {
                this.name = name;
                this.age = age;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getAge() {
                return age;
            }

            public void setAge(int age) {
                this.age = age;
            }

            @Override
            public String toString() {
                return "Student{" +
                        "name='" + name + '\'' +
                        ", age='" + age + '\'' +
                        '}';
            }
        }

        List<Student> list = new ArrayList();
        Student s1 = new Student("张三",20);
        Student s2 = new Student("李四",30);

        Date date = new Date();
    %>

    <!--调用表达式-->
    <h2><%=date %></h2>
    <h2><%=s1 %></h2>
</body>
</html>