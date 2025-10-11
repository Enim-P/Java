package com.bing.p10;

import java.lang.reflect.Field;

public class ORM {
    // 返回查询sql语句
    public String select(Object o){
        // 这里可以拿到所有的字段信息
        Field[] fields = o.getClass().getFields();
        String sql = "select ";
        for(Field field : fields){
            sql += field.getName()+",";
        }
        sql = sql.substring(0,sql.lastIndexOf(","));
        sql += " from " + o.getClass().getSimpleName();
        return sql;
    }


    // 返回新增的sql语句
    public String insert(Object o) throws IllegalAccessException {
        Field[] fields = o.getClass().getFields();
        String sql = "insert into "+ o.getClass().getSimpleName()+"(";
        for (Field field : fields){
            sql += field.getName()+",";
        }
        sql = sql.substring(0,sql.lastIndexOf(","));
        sql += ") values(";
        for (Field field : fields){
            sql += "'"+ field.get(o) +"',";
        }
        sql = sql.substring(0,sql.lastIndexOf(","));
        sql += ")";
        return sql;
    }

    // 返回修改的sql语句
    public String update(Object o) throws IllegalAccessException {
        Field[] fields = o.getClass().getFields();
        Field keyField = null;
        String sql = "update "+o.getClass().getSimpleName()+" set ";
        for(Field field : fields){
            // 判断字段中有没有使用@Key注解
            Key key = field.getAnnotation(Key.class);
            if(key==null){
                sql+=field.getName()+"='"+field.get(o)+"',";
            }else{
                keyField = field;
            }
        }
        sql = sql.substring(0,sql.lastIndexOf(","));
        sql += " where "+keyField.getName()+"='"+ keyField.get(o) +"'";
        return sql;
    }

    // 返回删除的sql语句
    public String delete(Object o) throws IllegalAccessException {
        String sql = "delete from "+o.getClass().getSimpleName()+" where ";
        Field[] fields = o.getClass().getFields();
        for(Field field : fields){
            // 判断字段中有没有使用@Key注解
            Key key = field.getAnnotation(Key.class);
            if(key!=null){
                sql+=field.getName()+"='"+field.get(o)+"'";
            }
        }
        return sql;
    }
}
