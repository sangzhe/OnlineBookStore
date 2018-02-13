package com.groupwork.Model;

import java.io.Serializable;

/**
 * Created by sangzhe on 2018/4/5.
 */
public class UserSecurity implements Serializable {
    private int UserGeneralId;
    private String Email;
    private  String password;

    public UserSecurity(int userGeneralId, String email, String password) {
        UserGeneralId = userGeneralId;
        Email = email;
        this.password = password;
    }

    public int getUserGeneralId() {
        return UserGeneralId;
    }

    public void setUserGeneralId(int userGeneralId) {
        UserGeneralId = userGeneralId;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
