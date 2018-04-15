package com.groupwork.Model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sangzhe on 2018/4/5.
 */
public class UserPayment implements Serializable {
    private UserGeneral User;
    private List<Payment> Payments;
    private boolean IsInUse;

    public UserGeneral getUser() {
        return User;
    }

    public void setUser(UserGeneral user) {
        User = user;
    }

    public List<Payment> getPayments() {
        return Payments;
    }

    public void setPayments(List<Payment> payments) {
        Payments = payments;
    }

    public boolean isInUse() {
        return IsInUse;
    }

    public void setInUse(boolean inUse) {
        IsInUse = inUse;
    }
}
