package com.Labs3;

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;

public class SerializeToXML {

    public static void serializeToXML (ArrayList<Book> booksToSerialize) throws IOException
    {
        XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("D:\\Андрiй\\OOP\\src\\com\\Labs3\\Books.xml")));
            Integer size = booksToSerialize.size();
            encoder.writeObject(size);
            for (Book i : booksToSerialize) {
                encoder.writeObject(i);
            }
            encoder.close();
    }

    public static ArrayList<Book> deserializeFromXML() throws IOException {
        XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("D:\\Андрiй\\OOP\\src\\com\\Labs3\\Books.xml")));
            Integer size = (Integer) decoder.readObject();
            ArrayList<Book> books = new ArrayList<>() ;
            for (int i = 0; i < size; i++) {
                books.add((Book) decoder.readObject());
            }
            decoder.close();
            return books;
    }
}
