package com.groupwork.Model;

import java.io.Serializable;

/**
 * Created by sangzhe on 2018/4/5.
 */
public class OrderDetail implements Serializable {
    private int Id;
    private Book Book;
    private int BookNumber;

    public OrderDetail(int id, com.groupwork.Model.Book book, int bookNumber) {
        Id = id;
        Book = book;
        BookNumber = bookNumber;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public com.groupwork.Model.Book getBook() {
        return Book;
    }

    public void setBook(com.groupwork.Model.Book book) {
        Book = book;
    }

    public int getBookNumber() {
        return BookNumber;
    }

    public void setBookNumber(int bookNumber) {
        BookNumber = bookNumber;
    }
}
