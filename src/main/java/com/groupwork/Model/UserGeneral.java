package com.groupwork.Model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by sangzhe on 2018/4/5.
 */
public class UserGeneral implements Serializable{
    private String Id;
    private String Gender;
    private String LastName;
    private String FirstName;
    private Date Birth;
    private Timestamp CreateDate;


    public UserGeneral(String id, String gender, String lastName, String firstName, Date birth, Timestamp createDate) {
        Id = id;
        Gender = gender;
        LastName = lastName;
        FirstName = firstName;
        Birth = birth;
        CreateDate = createDate;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
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

    public Timestamp getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Timestamp createDate) {
        CreateDate = createDate;
    }

    @Override
    public String toString() {
        return "UserGeneral{" +
                "Id='" + Id + '\'' +
                ", Gender='" + Gender + '\'' +
                ", LastName='" + LastName + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", Birth=" + Birth +
                ", CreateDate=" + CreateDate +
                '}';
    }
}
