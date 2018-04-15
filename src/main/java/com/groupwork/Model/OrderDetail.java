package com.groupwork.Model;

import java.io.Serializable;

/**
 * Created by sangzhe on 2018/4/5.
 */
public class OrderDetail implements Serializable {
    private String Id;
    private Book Book;
    private int BookAmount;

//    public OrderDetail(String id, com.groupwork.Model.Book book, int bookAmount) {
//        Id = id;
//        Book = book;
//        BookAmount = bookAmount;
//    }
//
//    public OrderDetail(com.groupwork.Model.Book book, int bookAmount) {
//        Id = UUID.randomUUID().toString();
//        Book = book;
//        BookAmount = bookAmount;
//    }

    public void setId(String id) {
        Id = id;
    }

    public String getId() {
        return Id;
    }

    public com.groupwork.Model.Book getBook() {
        return Book;
    }

    public void setBook(com.groupwork.Model.Book book) {
        Book = book;
    }

//    public com.groupwork.Model.Book getBook() {
//        return Book;
//    }
//
//    public void setBook(com.groupwork.Model.Book book) {
//        Book = book;
//    }

    public int getBookAmount() {
        return BookAmount;
    }

    public void setBookAmount(int bookAmount) {
        BookAmount = bookAmount;
    }
}
