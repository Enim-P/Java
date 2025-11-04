package com.bing.schoolmanager.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 封装一个返回结果对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReturnData {
    private int code;
    private String message;
    private Object data;


    // 返回成功结果
    public static ReturnData success(String message, Object data){
        return new ReturnData(1,message,data);
    }

    // 返回错误结果
    public static  ReturnData error(String message){
        return new ReturnData(0,message,null);
    }
}
