package com.Labs3;

import java.io.Serializable;
import java.util.ArrayList;

public class BookInfo implements Serializable {
    private String date;
    private String genre;
    private String publication;
    private ArrayList<String> authors;

    {
        date = new String();
        genre = new String();
        publication = new String();
        authors = new ArrayList<>();
    }

    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append(String.format("| %s | %s | %s | ", date, genre, publication));
        for ( String i :
                authors)
            result.append(i + " ");
        result.append(String.format("%n"));
        result.append(" |");
        return new String(result);
    }

    public void setDate(String date){
        this.date = date;
    }

    public String getDate(){
        return date;
    }

    public void setGenre(String genre){
        this.genre = genre;
    }

    public String getGenre(){
        return genre;
    }

    public void setPublication(String publication){
        this.publication = publication;
    }

    public String getPublication(){
        return publication;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }

    private ArrayList<String> getAuthors(){
        return authors;
    }
}
