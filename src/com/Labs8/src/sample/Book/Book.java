package sample.Book;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

public class Book implements Serializable {

    public String Name;
    public String ISBN;

    public ArrayList<BookInfo> characteristic = new ArrayList<>();


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

    public ArrayList<BookInfo> getBookInfo() {
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

    public static Comparator<Book> Comparename = new Comparator<Book>() {
        @Override
        public int compare(Book o1, Book o2) {
            return o1.Name.compareTo(o2.Name);
        }
    };
}
