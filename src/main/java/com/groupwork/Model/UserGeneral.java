package com.groupwork.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by sangzhe on 2018/4/5.
 */
public class UserGeneral implements Serializable{
    private int Id;
    private String Gender;
    private String LastName;
    private String FirstName;
    private Date Birth;

    public UserGeneral(int id) {
        Id = id;
    }

    public UserGeneral(int id, String gender, String lastName, String firstName, Date birth) {
        Id = id;
        Gender = gender;
        LastName = lastName;
        FirstName = firstName;
        Birth = birth;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
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

    public Date getBirth() {
        return Birth;
    }

    public void setBirth(Date birth) {
        Birth = birth;
    }
}
