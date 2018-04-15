package com.groupwork.Model;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by sangzhe on 2018/4/5.
 */
public class Payment implements Serializable{
    private String Id;
    private int CardNumber;
    private String LastName;
    private String FirstName;
    private int SecurityNumber;
    private String Expire;
    private int Zipcode;

    public Payment() {
    }

    public Payment(String id, int cardNumber, String lastName, String firstName, int securityNumber, String expire, int zipcode) {
        Id = id;
        CardNumber = cardNumber;
        LastName = lastName;
        FirstName = firstName;
        SecurityNumber = securityNumber;
        Expire = expire;
        Zipcode = zipcode;
    }

    public Payment(int cardNumber, String lastName, String firstName, int securityNumber, String expire, int zipcode) {
        Id = UUID.randomUUID().toString();
        CardNumber = cardNumber;
        LastName = lastName;
        FirstName = firstName;
        SecurityNumber = securityNumber;
        Expire = expire;
        Zipcode = zipcode;
    }

    public boolean check(){
        return true;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public int getCardNumber() {
        return CardNumber;
    }

    public void setCardNumber(int cardNumber) {
        CardNumber = cardNumber;
    }


    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public int getSecurityNumber() {
        return SecurityNumber;
    }

    public void setSecurityNumber(int securityNumber) {
        SecurityNumber = securityNumber;
    }

    public String getExpire() {
        return Expire;
    }

    public void setExpire(String expire) {
        Expire = expire;
    }

    public int getZipcode() {
        return Zipcode;
    }

    public void setZipcode(int zipcode) {
        Zipcode = zipcode;
    }
}
