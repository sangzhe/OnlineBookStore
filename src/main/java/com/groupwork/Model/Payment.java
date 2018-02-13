package com.groupwork.Model;

import java.io.Serializable;

/**
 * Created by sangzhe on 2018/4/5.
 */
public class Payment implements Serializable{
    private int Id;
    private int CardNumber;
    private String password;

    public Payment(int id, int cardNumber, String password) {
        Id = id;
        CardNumber = cardNumber;
        this.password = password;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setCardNumber(int cardNumber) {
        CardNumber = cardNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
