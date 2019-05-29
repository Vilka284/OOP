package com.Labs7;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;

public class Save {
    public void standartWrite(ArrayList<Book> list, String way){
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(way))){
            objectOutputStream.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public ArrayList<Book> standartRead(String way){
        ArrayList<Book> list;
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(way)))
        {
            list = (ArrayList<Book>) objectInputStream.readObject();
            return list;
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return new ArrayList<Book>();
    }

    public void writeToXML(ArrayList<Book> list, String way){
        XMLEncoder encoder = null;
        try {
            encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(way)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        encoder.writeObject(list);
        encoder.close();
    }

    public ArrayList<Book> readFromXML(String way){
        XMLDecoder decoder = null;
        try {
            decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(way)));
            return  (ArrayList<Book>) decoder.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return  new ArrayList<Book>();
    }
}
