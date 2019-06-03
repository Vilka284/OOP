package sample;


import sample.Book.Book;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;

public class Save {
    public void standartWrite(ArrayList<Book> list, String directory){
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(directory+"\\standartsave.lst"))){
            objectOutputStream.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public ArrayList<Book> standartRead(File file){
        ArrayList<Book> list;
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file)))
        {
            list= (ArrayList<Book>) objectInputStream.readObject();
            return list;
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return new ArrayList<>();
    }

    public void writeToXML(ArrayList<Book> list,String directory){
        XMLEncoder encoder = null;
        try {
            encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(directory+"\\save.xml")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        encoder.writeObject(list);
        encoder.close();
    }
    public ArrayList<Book> readFromXML(File file){
        XMLDecoder decoder = null;
        try {
            decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(file)));
            return  (ArrayList<Book>) decoder.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
