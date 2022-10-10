package com.wy.springbootdemo.exception;

import com.wy.springbootdemo.core.ErrorConstant;
import lombok.Getter;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 系统中所有异常的基类，简化自定义异常的配置和编码
 */
@Getter
public abstract class BaseException extends RuntimeException{
    private final ErrorConstant errorConstant;
    private  final HashMap<String,Object> data = new HashMap<>();

    public BaseException(ErrorConstant errorConstant, Map<String,Object> data) {
        super(errorConstant.getMessage());
        this.errorConstant = errorConstant;
        if (!ObjectUtils.isEmpty(data)){
            this.data.putAll(data);
        }
    }

    protected BaseException(ErrorConstant error, Map<String, Object> data, Throwable cause) {
        super(error.getMessage(), cause);
        this.errorConstant = error;
        if (!ObjectUtils.isEmpty(data)) {
            this.data.putAll(data);
        }
    }


}
