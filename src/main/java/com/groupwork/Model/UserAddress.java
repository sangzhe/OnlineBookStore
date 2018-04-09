package com.groupwork.Model;

import java.io.Serializable;

/**
 * Created by sangzhe on 2018/4/5.
 */
public class UserAddress implements Serializable {
    private UserGeneral User;
    private Address Address;
    private boolean IsInUse;

    public UserAddress(UserGeneral user, com.groupwork.Model.Address address, boolean isInUse) {
        User = user;
        Address = address;
        IsInUse = isInUse;
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

    public boolean isInUse() {
        return IsInUse;
    }

    public void setInUse(boolean inUse) {
        IsInUse = inUse;
    }
}
