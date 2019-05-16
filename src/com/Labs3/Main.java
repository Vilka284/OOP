package com.Labs3;

public class Main {

    public static MyArrayList<Book> list = new MyArrayList<>();

    public static void main(String[] args) {

        Menu menu = new Menu();
        while (true){
            menu.print_menu();
        }
    }
}
