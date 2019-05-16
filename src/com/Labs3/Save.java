package com.Labs3;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

public class Save {
    public void write(MyArrayList<Book> list, String way){
        XMLEncoder encoder = null;
        try {
            encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(way)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        encoder.writeObject(list);
        encoder.close();
    }
    public MyArrayList<Book> read(String way){
        XMLDecoder decoder = null;
        try {
            decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(way)));
            return  (MyArrayList<Book>) decoder.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return  new MyArrayList<Book>();


    }
}
