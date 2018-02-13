package com.groupwork.Model;

import java.io.Serializable;

/**
 * Created by sangzhe on 2018/4/5.
 */
public class UserAddress implements Serializable {
    private UserGeneral User;
    private Address Address;

    public UserAddress(UserGeneral user, com.groupwork.Model.Address address) {
        User = user;
        Address = address;
    }

    public UserGeneral getUser() {
        return User;
    }

    public void setUser(UserGeneral user) {
        User = user;
    }

    public com.groupwork.Model.Address getAddress() {
        return Address;
    }

    public void setAddress(com.groupwork.Model.Address address) {
        Address = address;
    }
}
