package com.bing.test08;

public class UpdateTest {
    public static void main(String[] args) {
        // 创建BaseDao
        BaseDao dao = new BaseDao();
        // 定义sql语句
        String sql = "update subject set subjectName=? where subjectId=?";
        // 定义参数数组
        Object[] params = {"呵呵呵呵呵呵",16};
        // 执行sql语句，传递参数
        int rows = dao.executeUpdate(sql,params);
        if(rows>0){
            System.out.println("修改成功！");
        }else{
            System.out.println("修改失败！");
        }
    }
}
