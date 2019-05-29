package com.Labs7;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Book> list = new ArrayList<>();
    public static void main(String[] args) {
        Menu menu = new Menu();
        if (args.length!=0){
            if (args[0].equals("-auto")) {
                try (FileReader reader = new FileReader("D:\\Андрiй\\OOP\\src\\com\\Labs7\\test.txt")){
                    Scanner fileIn = new Scanner(reader);
                    while (fileIn.hasNextLine()){
                        Book p = new Book();
                        p.setName(fileIn.nextLine());
                        p.setISBN(fileIn.nextLine());
                        list.add(p);
                    }
                }catch (IOException ex){
                    System.out.println(ex.getMessage());
                }
            }
        }
        while (true) {
            menu.print_menu(list);
            for (Book book:
                 list) {
                    if(!Book.validate(book))
                    list.remove(book.getName());
            }
        }

    }
    public void setList(ArrayList<Book> list){
        this.list = list;
    }
}
