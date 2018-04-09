package com.groupwork.Model;

import java.io.Serializable;

/**
 * Created by sangzhe on 2018/4/5.
 */
public class UserPayment implements Serializable {
    private UserGeneral User;
    private Payment Payment;
    private boolean IsInUse;


    public UserPayment(UserGeneral user, com.groupwork.Model.Payment payment, boolean isInUse) {
        User = user;
        Payment = payment;
        IsInUse = isInUse;
    }

    public UserGeneral getUser() {
        return User;
    }

    public void setUser(UserGeneral user) {
        User = user;
    }

    public com.groupwork.Model.Payment getPayment() {
        return Payment;
    }

    public void setPayment(com.groupwork.Model.Payment payment) {
        Payment = payment;
    }

    public boolean isInUse() {
        return IsInUse;
    }

    public void setInUse(boolean inUse) {
        IsInUse = inUse;
    }
}
