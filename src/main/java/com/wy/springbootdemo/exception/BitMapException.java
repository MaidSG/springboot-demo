package com.wy.springbootdemo.exception;

public class BitMapException extends RuntimeException{
    private String message;

    public BitMapException(){
        super();
    }

    public BitMapException(String message){
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
