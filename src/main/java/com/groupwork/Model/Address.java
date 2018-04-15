package com.groupwork.Model;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by sangzhe on 2018/4/5.
 */
public class Address implements Serializable {
    private String Id;
    private String Street;
    private String Street2;
    private String City;
    private String State;
    private int Zipcode;

    public Address() {
    }

    public Address(String id, String street, String street2, String city, String state, int zipcode) {
        Id = id;
        Street = street;
        Street2 = street2;
        City = city;
        State = state;
        Zipcode = zipcode;
    }

    public Address(String street, String street2, String city, String state, int zipcode) {
        Id = UUID.randomUUID().toString();
        Street = street;
        Street2 = street2;
        City = city;
        State = state;
        Zipcode = zipcode;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getStreet2() {
        return Street2;
    }

    public void setStreet2(String street2) {
        Street2 = street2;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public int getZipcode() {
        return Zipcode;
    }

    public void setZipcode(int zipcode) {
        Zipcode = zipcode;
    }
}

