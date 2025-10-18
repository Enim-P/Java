package com.bing.test08;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SelectTest {
    public static void main(String[] args) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入姓名：");
        String name = input.nextLine();
        String sql = "select * from student where studentName like concat('%',?,'%')";
        Object[] params = {name};
        BaseDao dao = new BaseDao();
        ResultSet set = dao.executeQuery(sql, params);
        while(set.next()){
            System.out.println(set.getString(1)+" "+set.getString(2)+
                    " "+set.getString(3));
        }
        // 拿到数据后，关闭数据库资源
        dao.closeResource();
    }
}
