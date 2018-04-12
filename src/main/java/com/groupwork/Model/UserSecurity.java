package com.groupwork.Model;

import java.io.Serializable;

import java.util.UUID;

/**
 * Created by sangzhe on 2018/4/5.
 */
public class UserSecurity implements Serializable {
    private String UserId;
    private String Email;
    private  String Password;
    private String roles="User";

    public UserSecurity(String userID, String email, String password) {
        UserId = userID;
        Email = email;
        this.Password = password;
    }

    public UserSecurity(String email, String password) {
        UserId = UUID.randomUUID().toString();
        Email = email;
        this.Password = password;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserID(String userID) {
        UserId = userID;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
