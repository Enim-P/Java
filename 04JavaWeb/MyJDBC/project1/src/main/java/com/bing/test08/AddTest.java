package com.bing.test08;

public class AddTest {
    public static void main(String[] args) {
        // 创建BaseDao
        BaseDao dao = new BaseDao();
        // 定义sql语句
        String sql = "insert into subject(subjectName,classHour,gradeId)" +
                " values(?,?,?)";
        // 定义参数数组
        Object[] params = {"JDBC基础开发",128,3};
        // 执行sql语句，传递参数
        int rows = dao.executeUpdate(sql,params);
        if(rows>0){
            System.out.println("添加成功！");
        }else{
            System.out.println("添加失败！");
        }
    }
}
