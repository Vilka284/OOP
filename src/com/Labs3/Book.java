package com.Labs3;

import java.io.Serializable;

public class Book implements Serializable {

    public String Name;
    public String ISBN;

    public MyArrayList<BookInfo> characteristic = new MyArrayList<>();


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public MyArrayList<BookInfo> getBookInfo() {
        return characteristic;
    }

    public void setBookInfo(BookInfo characteristic) {
        this.characteristic.add(characteristic);
    }
    public String toString(){
        String s = "Name: " + Name + "\n" +
                "ISBN: " + ISBN + "\n" +
                "Info:   " + "\n";
        for (int i=0;i<characteristic.size();i++){
            s += (i+1) + "." + characteristic.get(i).toString() + "\n";
        }
        return s;
    }
}
