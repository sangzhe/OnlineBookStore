package com.groupwork.Model;

import java.io.Serializable;

/**
 * Created by sangzhe on 2018/4/8.
 */
public class Result implements Serializable{
    private String message;
    private int code;
    private Token token;

    public Result(String message, int code, Token token) {
        this.message = message;
        this.code = code;
        this.token = token;
    }

    public Result(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public static Result success(Token token){
        return new Result("Success",100,token);
    }

    public static Result fail(String message,int code){
        return new Result(message,code);
    }

}
