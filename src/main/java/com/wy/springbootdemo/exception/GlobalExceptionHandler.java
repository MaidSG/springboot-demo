package com.wy.springbootdemo.exception;

import com.wy.springbootdemo.entity.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

// 设置全局异常处理类 可以设置 assignableTypes = { Object.class....}指定处理类只处理特定的类抛出的异常
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
        ErrorResponse bitmapResponse =  new ErrorResponse(new BitMapException("位图错误！！"));


        //指定拦截
        @ExceptionHandler(value = BitMapException.class)
        public ResponseEntity<ErrorResponse> exceptionHandler(Exception e){
            if (e instanceof BitMapException)
                return ResponseEntity.status(400).body(bitmapResponse);
            return null;
        }
}
