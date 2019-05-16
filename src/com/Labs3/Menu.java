package com.Labs3;

import java.lang.reflect.Array;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Menu {
    private int s;
    //MyArrayList<Book> card = Main.list;
    Scanner scanner = new Scanner(System.in);
    public void print_menu(){
        System.out.println("==============================");
        System.out.println("|             MENU           |");
        System.out.println("==============================");
        System.out.println("| Options:                   |");
        System.out.println("   1. Add new book");
        System.out.println("   2. Delete book");
        System.out.println("   3. Delete all books");
        System.out.println("   4. View all books");
        System.out.println("   5. Write in file");
        System.out.println("   6. Read from file");
        System.out.println("   7. Exit");
        System.out.println("===============================");
        System.out.println("Select option: ");
        s=scanner.nextInt();
        options(s);

    }
    private void options(int s){
        Scanner scanner1 = new Scanner(System.in);
        switch (s) {
            case 1:
                Book book = new Book();
                System.out.println("Enter name");
                book.setName(scanner1.nextLine());
                System.out.println("Enter ISBN");
                book.setISBN(scanner1.nextLine());
                System.out.println("Add book info? Y/N");
                String str = scanner1.next();
                if (str.equals("Y")) {
                    BookInfo bookInfo = new BookInfo();
                    System.out.println("Publication:");
                    bookInfo.setPublication(scanner1.nextLine());
                    System.out.println("Genre: ");
                    bookInfo.setGenre(scanner1.nextLine());
                    System.out.println("Authors: ");
                    bookInfo.setAuthors(scanner1.nextLine());
                    book.setBookInfo(bookInfo);
                }
                Main.list.add(book);
                break;
            case 2:
                for (int i=0;i<Main.list.size();i++){
                    System.out.println(Main.list.get(i).toString());
                }
                System.out.println("Number of book you want remove: ");
                int n = scanner1.nextInt();
                Main.list.remove(n);
                break;
            case 3:
                if (Main.list.clearall()){
                    System.out.println("DONE");
                }else{
                    System.out.println("ERROR");
                }
                break;
            case 4:
                for (int i=0;i<Main.list.size();i++){
                    System.out.println(Main.list.get(i).toString());
                }
                break;
            case 5:
                try {
                    Path p1 = PathGetter.getPath(Pattern.compile(".+\\.xml$"));
                    System.out.println(p1.toString());
                    Save save1 = new Save();
                    Main.list = save1.read(p1.toString());
                }catch (NullPointerException e) {
                    System.err.println("path not found");
                    break;
                }
                break;
            case 6:
                Save save = new Save();
                try {
                    Path p = PathGetter.getPath(Pattern.compile(".+\\.xml$"));
                    if (p == null) throw new NullPointerException();
                    save.write(Main.list, p.toString());
                } catch (NullPointerException e) {
                    System.err.println("path not found");
                    break;
                }
            case 7:
                System.exit(0);
            default:
                print_menu();
        }
    }
}
