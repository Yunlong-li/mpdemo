package com.example.mpdemo.util;

import lombok.Builder;
import lombok.Data;

/**
 * @author 刘伟
 * @program: mpdemo
 * @description: http响应工具类
 * @date 2023-05-11 13:57:18
 */

@Data
@Builder
public class ResponseData {

    private String code;

    private Object result;

    private String message;

    public static ResponseData success(){
        return ResponseData.builder()
                .code("200")
                .result(null)
                .message("success")
                .build();
    }

    public static ResponseData success(String message){
        return ResponseData.builder()
                .code("200")
                .result(null)
                .message(message)
                .build();
    }

    public static ResponseData success(Object data){
        return ResponseData.builder()
                .code("200")
                .result(data)
                .message("success")
                .build();
    }

    public static ResponseData success(Object data, String message){
        return ResponseData.builder()
                .code("200")
                .result(data)
                .message(message)
                .build();

    }

    public static ResponseData error(){
        return ResponseData.builder()
                .code("500")
                .result(null)
                .message("error")
                .build();

    }

    public static ResponseData error(String message){
        return ResponseData.builder()
                .code("500")
                .result(null)
                .message(message)
                .build();

    }

}
