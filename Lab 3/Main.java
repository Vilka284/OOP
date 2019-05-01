package com.Labs3;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(new Locale("ukrainian", "UA"));
        Scanner in = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();
        BookInfo bookInfoBuffer = new BookInfo();
        while(true){
            System.out.println("\n1 - book menu");
            System.out.println("2 - books list");
            System.out.println("3 - add new book");
            System.out.println("4 - delete book");
            System.out.println("5 - serialize");
            System.out.println("6 - deserialize");
            System.out.println("7 - exit");
            int choice = in.nextInt();
            switch(choice) {
                case 1:
                    System.out.println("Enter name:");
                    String name = in.nextLine();
                    int choiceMenu = 0;
                    for (Book i :
                            books) {
                        if (i.getName() == name)
                            choiceMenu = books.indexOf(i);
                    }
                    int menuIndex = -1;
                    for (int i = 0; i < books.size(); i++) {
                        if (books.get(i).getISBN() == choiceMenu) {
                            menuIndex = i;
                            break;
                        }
                    }
                    if (menuIndex != -1) {
                        Book bookMenu = books.get(menuIndex);
                        boolean exitFromBookMenu = false;
                        while (!exitFromBookMenu) {
                            System.out.printf("| menu of %s book |\n", name);
                            System.out.println("1 - info");
                            System.out.println("2 - set ISBN");
                            System.out.println("3 - set name");
                            System.out.println("4 - edit info");
                            System.out.println("5 - show info");
                            System.out.println("6 - return");
                            int choice1 = in.nextInt();
                            switch (choice1) {
                                case 1:
                                    System.out.println(bookMenu);
                                    break;
                                case 2:
                                    System.out.println("Enter new ISBN:");
                                    bookMenu.setISBN(in.nextInt());
                                    break;
                                case 3:
                                    System.out.println("Enter new name:");
                                    in.nextLine();
                                    bookMenu.setName((in.nextLine()));
                                    break;
                                case 4:
                                    ArrayList<String> authors = new ArrayList<>();
                                    String date;
                                    String genre;
                                    String publication;
                                    boolean exitFromBookInfoEditing = false;
                                    while (!exitFromBookInfoEditing) {
                                        System.out.println("1 - set author");
                                        System.out.println("2 - set genre");
                                        System.out.println("3 - set publication");
                                        System.out.println("4 - set date");
                                        System.out.println("5 - return");
                                        int choice2 = in.nextInt();
                                        switch (choice2) {
                                            case 1:
                                                System.out.println("How many authors:");
                                                int n = in.nextInt();
                                                System.out.println("Enter authors one-by-one:");
                                                in.nextLine();
                                                for (int i = 0; i < n; i++)
                                                    authors.add(in.nextLine());
                                                bookInfoBuffer.setAuthors(authors);
                                                break;
                                            case 2:
                                                System.out.println("Input genre:");
                                                in.nextLine();
                                                genre = in.nextLine();
                                                bookInfoBuffer.setGenre(genre);
                                                break;
                                            case 3:
                                                System.out.println("Input publication:");
                                                in.nextLine();
                                                publication = in.nextLine();
                                                bookInfoBuffer.setPublication(publication);
                                                break;
                                            case 4:
                                                System.out.println("Input date:");
                                                in.nextLine();
                                                date = in.nextLine();
                                                bookInfoBuffer.setDate(date);
                                                break;
                                            case 5:
                                                exitFromBookInfoEditing = true;
                                            default:
                                                System.out.println("Unkonown command");
                                                break;
                                        }
                                    }
                                    System.out.println(bookInfoBuffer);
                                    bookMenu.SetInfo(bookInfoBuffer);
                                case 5:
                                case 6:
                                    exitFromBookMenu = true;
                                default:
                                    System.out.println("Unknown command");
                            }
                        }
                    }
                case 2:
                    if (books.size() == 0) {
                        System.err.println("list is empty");
                        break;
                    }
                    for (int i = 0; i < books.size(); i++) {
                        System.out.printf("#%d | %s | ISBN - %s | %s",
                                i, books.get(i).getName(), books.get(i).getISBN(), books.get(i).getInfo());
                    }
                    break;
                case 3:
                    System.out.println("Enter book name:");
                    in.nextLine();
                    books.add(new Book());
                    books.get(books.size() - 1).setName(in.nextLine());
                    System.out.println("book added!");
                    break;
                case 4:
                    System.out.println("enter book name you want to delete:");
                    in.nextLine();
                    String deleteBook = in.nextLine();
                    boolean removed = false;
                    for (int i = 0; i < books.size(); i++) {
                        if (books.get(i).getName() == deleteBook) {
                            books.remove(i);
                            removed = true;
                            break;
                        }
                    }
                    if (!removed)
                        System.err.println("not found");
                    break;
                case 5:
                    if (books.isEmpty()){
                        System.out.println("List is empty");
                        break;
                    }
                    try {
                        SerializeToXML.serializeToXML(books);
                        System.out.println("Done!");
                    } catch (IOException e){
                        System.err.println(":(" + e.toString());
                        break;
                    }
                    break;
                case 6:
                    try {
                        books = SerializeToXML.deserializeFromXML();
                    } catch (IOException e) {
                        System.err.println(":(" + e.toString());
                        break;
                    }
                        break;
                case 7:
                    System.out.println("That's all folks!");
                    System.exit(0);
                default:
                    System.out.println("Unknown command");
            }
        }
    }
}
