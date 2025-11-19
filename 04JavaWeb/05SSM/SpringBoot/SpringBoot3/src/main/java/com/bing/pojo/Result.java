package com.bing.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一结果集
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Integer code;   //响应码，1表示成功，0表示失败
    private String msg;     //响应信息
    private Object data;    //响应的数据

    // 增删改成功，不需要返回响应结果
    public static Result success(){
        return new Result(1,"success",null);
    }

    // 查询成功，需要返回响应结果
    public static Result success(Object data){
        return new Result(1,"success",data);
    }

    // 操作失败，需要返回响应信息，不需要返回响应结果
    public static Result error(String msg){
        return new Result(0,msg,null);
    }
}
