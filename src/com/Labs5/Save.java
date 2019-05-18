package com.Labs5;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

public class Save {
    public void standartWrite(MyLinkedList<Book> list, String way){
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(way))){
            objectOutputStream.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public MyLinkedList<Book> standartRead(String way){
        MyLinkedList<Book> list;
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(way)))
        {
            list = (MyLinkedList<Book>) objectInputStream.readObject();
            return list;
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return new MyLinkedList<Book>();
    }

    public void writeToXML(MyLinkedList<Book> list, String way){
        XMLEncoder encoder = null;
        try {
            encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(way)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        encoder.writeObject(list);
        encoder.close();
    }

    public MyLinkedList<Book> readFromXML(String way){
        XMLDecoder decoder = null;
        try {
            decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(way)));
            return  (MyLinkedList<Book>) decoder.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return  new MyLinkedList<Book>();
    }
}
