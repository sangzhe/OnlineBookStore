package com.groupwork.Model;

/**
 * Created by sangzhe on 2018/4/8.
 */
public class Token {
    private String Email;
    private String token;

    public Token(String email, String token) {
        Email = email;
        this.token = token;
    }

    public String getEmail() {
        return Email;
    }

    public String getToken() {
        return token;
    }
}
