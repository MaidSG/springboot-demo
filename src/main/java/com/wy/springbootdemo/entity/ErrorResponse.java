package com.wy.springbootdemo.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// 异常信息实体类,包装异常信息
@Getter
@Setter
@ToString
public class ErrorResponse {
    private String message;
    private String errorTypeName;

    public ErrorResponse(Exception e) {
        this(e.getClass().getName(), e.getMessage());
    }

    public ErrorResponse(String errorTypeName, String message) {
        this.errorTypeName = errorTypeName;
        this.message = message;
    }

}
