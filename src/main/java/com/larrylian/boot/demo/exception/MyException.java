package com.larrylian.boot.demo.exception;

/**
 * Created by Larry 06/09/2017
 */
public class MyException extends Exception {
    private String code;

    public MyException(String code, String msg) {
        super(msg);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
