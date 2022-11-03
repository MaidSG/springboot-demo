package com.wy.springbootdemo.exception;

import com.wy.springbootdemo.core.ErrorConstant;

import java.util.Map;

public class BitMapException extends BaseException{


    public BitMapException(Map<String,Object> data){
        super(ErrorConstant.ERROR_CONSTANT,data);
    }


}
