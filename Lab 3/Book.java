package com.Labs3;

import java.io.Serializable;
import java.util.ArrayList;

public class Book implements Serializable {
    private int ISBN;
    private String name;
    private BookInfo bookInfo;

    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append(String.format("| #%3d | %s |%n", ISBN, name));
        result.append(bookInfo);
        return new String(result);
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void SetInfo(BookInfo bookInfo) {
        this.bookInfo = bookInfo;
    }

    public BookInfo getInfo() {
        return bookInfo;
    }

    public void setISBN(int ISBN){
        this.ISBN = ISBN;
    }

    public int getISBN(){
        return ISBN;
    }
}
