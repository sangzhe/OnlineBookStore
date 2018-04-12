package com.groupwork.Model;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by sangzhe on 2018/4/5.
 */
public class Book implements Serializable {
    private int Id;
    private String Name;
    private String Category;
    private String Author;
    private Date PubDate;
    private String Press;
    private float Price;
    private int TotalComments;
    private float Rate;
    private String Description;
    private String PicUrl;
    private int ISBN;

    public Book(int id, String name, String category, String author, Date pubDate, String press, float price, int totalComments, float rate, String description, String picUrl, int ISBN) {
        Id = id;
        Name = name;
        Category = category;
        Author = author;
        PubDate = pubDate;
        Press = press;
        Price = price;
        TotalComments = totalComments;
        Rate = rate;
        Description = description;
        PicUrl = picUrl;
        this.ISBN = ISBN;
    }

    public Book(int id, String name, String author, float price, String picUrl) {
        Id = id;
        Name = name;
        Author = author;
        Price = price;
        PicUrl = picUrl;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public Date getPubDate() {
        return PubDate;
    }

    public void setPubDate(Date pubDate) {
        PubDate = pubDate;
    }

    public String getPress() {
        return Press;
    }

    public void setPress(String press) {
        Press = press;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }

    public int getTotalComments() {
        return TotalComments;
    }

    public void setTotalComments(int totalComments) {
        TotalComments = totalComments;
    }

    public float getRate() {
        return Rate;
    }

    public void setRate(float rate) {
        Rate = rate;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public String toString() {
        return "Book{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Category='" + Category + '\'' +
                ", Author='" + Author + '\'' +
                ", PubDate=" + PubDate +
                ", Press='" + Press + '\'' +
                ", Price=" + Price +
                ", TotalComments=" + TotalComments +
                ", Rate=" + Rate +
                ", Description='" + Description + '\'' +
                ", PicUrl='" + PicUrl + '\'' +
                ", ISBN=" + ISBN +
                '}';
    }
}
