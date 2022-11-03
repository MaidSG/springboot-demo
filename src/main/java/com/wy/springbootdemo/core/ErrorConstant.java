package com.wy.springbootdemo.core;

import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

/**
 * 记录异常的唯一标识，HTTP状态码以及错误信息
 */
@Getter
@ToString
public enum ErrorConstant {
    ERROR_CONSTANT(0,HttpStatus.BAD_REQUEST,"未找到资源"),
    ERROR_BITMAP_Execption(909,HttpStatus.BAD_REQUEST,"位图参数错误")
    ;
    private final int code;

    private final HttpStatus status;

    private final String message;

    ErrorConstant(int code, HttpStatus status, String message) {
        this.code = code;
        this.status = status;
        this.message = message;
    }
}
