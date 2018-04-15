package com.groupwork.Model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sangzhe on 2018/4/5.
 */
public class UserAddress implements Serializable {
    private UserGeneral User;
    private List<Address> Addresses;
    private boolean IsInUse;


    public UserGeneral getUser() {
        return User;
    }

    public void setUser(UserGeneral user) {
        User = user;
    }

    public List<Address> getAddresses() {
        return Addresses;
    }

    public void setAddresses(List<Address> addresses) {
        Addresses = addresses;
    }

    public boolean isInUse() {
        return IsInUse;
    }

    public void setInUse(boolean inUse) {
        IsInUse = inUse;
    }
}
