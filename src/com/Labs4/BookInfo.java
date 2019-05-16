package com.Labs4;

import java.io.Serializable;

public class BookInfo implements Serializable {
    public String publication;
    public String genre;
    public String authors;

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return  ("publication=" + publication + '\n' +
                "genre='" + genre + '\n' +
                "authors=" + authors) ;
    }
}