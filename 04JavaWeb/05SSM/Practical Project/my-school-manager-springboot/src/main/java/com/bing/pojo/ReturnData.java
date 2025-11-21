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
public class ReturnData<T> {
    private Integer code;    //响应码 1成功 0失败
    private String msg;      //响应信息
    private T data;          //响应数据

    // 增删改 响应成功的方法
    public static ReturnData success(){
        return new ReturnData(1,"success",null);
    }

    // 查询 响应成功的方法
    public static<T> ReturnData success(T data){
        return new ReturnData(1,"success",data);
    }

    // 响应失败的方法
    public static ReturnData error(String msg){
        return new ReturnData(0,msg,null);
    }
}
