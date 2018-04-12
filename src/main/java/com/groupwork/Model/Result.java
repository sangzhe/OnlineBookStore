package com.groupwork.Model;

import java.io.Serializable;

/**
 * Created by sangzhe on 2018/4/8.
 */
public class Result<T> implements Serializable{
    private String message;
    private int code;
    private T data;

    public Result(String message, int code, T t) {
        this.message = message;
        this.code = code;
        data = t;
    }

    public Result(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public static <T>Result success(T t){
        return new Result("Success",100,t);
    }

    public static Result fail(String message,int code){
        return new Result(message,code);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getModel() {
        return data;
    }

    public void setToken(T t) {
        this.data = t;
    }
}
