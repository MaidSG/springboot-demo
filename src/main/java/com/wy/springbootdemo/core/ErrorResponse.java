package com.wy.springbootdemo.core;


import com.wy.springbootdemo.exception.BaseException;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;
import java.util.HashMap;

// 异常信息实体类,包装异常信息
@Getter
@Setter
@ToString
public class ErrorResponse {
    private int code;
    private int status;
    private Instant timestamp;
    private String message;
    private String errorTypeName;
    private HashMap<String,Object> data = new HashMap<String,Object>();

    public ErrorResponse() {
    }



    public ErrorResponse(Exception e) {
        this(e.getClass().getName(), e.getMessage());
    }

    public ErrorResponse(String errorTypeName, String message) {
        this.errorTypeName = errorTypeName;
        this.message = message;
    }

    public ErrorResponse(BaseException ex, String errorTypeName) {
        this(ex.getErrorConstant().getCode(), ex.getErrorConstant().getStatus().value(), ex.getErrorConstant().getMessage(), errorTypeName, ex.getData());
    }


    public ErrorResponse(int code, int status,  String message, String errorTypeName, HashMap<String, Object> data) {
        this.code = code;
        this.status = status;
        this.timestamp = Instant.now();
        this.message = message;
        this.errorTypeName = errorTypeName;
        this.data = data;
    }
}
