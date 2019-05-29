package com.Labs7;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Menu {
    public void print_menu(ArrayList<Book> list){
        System.out.println("==============================");
        System.out.println("|             MENU           |");
        System.out.println("==============================");
        System.out.println("| Options:                   |");
        System.out.println("   1. Add new book");
        System.out.println("   2. Delete book");
        System.out.println("   3. Delete all books");
        System.out.println("   4. View list of books");
        System.out.println("   5. Contains ");
        System.out.println("   6. Save file");
        System.out.println("   7. Save to XML");
        System.out.println("   8. Read from file ");
        System.out.println("   9. Read from XML ");
        System.out.println("   10. Collections sort");
        System.out.println("   11. Exit");
        System.out.println("===============================");
        System.out.println("Select option: ");
        Scanner scanner = new Scanner(System.in);
        options(scanner.nextInt(), list);

    }
    public void options(int t, ArrayList<Book> list){
        Scanner scanner = new Scanner(System.in);
        Save save = new Save();
        Main main = new Main();
        switch (t){
            case 1:
                Book book = new Book();
                System.out.println("Enter name");
                book.setName(scanner.nextLine());
                System.out.println("Enter ISBN");
                book.setISBN(scanner.nextLine());
                System.out.println("Add book info? Y/N");
                String str = scanner.next();
                if (str.equals("Y")) {
                    BookInfo bookInfo = new BookInfo();
                    System.out.println("Publication:");
                    bookInfo.setPublication(scanner.nextLine());
                    System.out.println("Genre: ");
                    bookInfo.setGenre(scanner.nextLine());
                    System.out.println("Authors: ");
                    bookInfo.setAuthors(scanner.nextLine());
                    book.setBookInfo(bookInfo);
                }
                Main.list.add(book);
                break;
            case 2:
                System.out.println("Name: ");
                String name = scanner.nextLine();

                boolean i = false;
                for (Book b:
                        list){
                    if (b.Name.equals(name)){
                        list.remove(b);
                        i=true;
                        break;
                    }
                }
                if (i){
                    System.out.println("Done!!!");
                }
                break;
            case 3:
                list.clear();
                main.setList(list);
                System.out.println("Done. List are empty");
                break;
            case 4:
                for (Book b :
                        list){
                    System.out.println(b.toString());
                }
                break;
            case 5:
                System.out.println("Name: ");
                String name1 = scanner.next();

                if (list.contains(name1)){
                    System.out.println("Contains");
                }else{
                    System.out.println("Dont contains");
                }
                break;
            case 6:
                try {
                    Path p = PathGetter.getPath(Pattern.compile(".+\\.txt$"));
                    save.standartWrite(list, p.toString());
                }catch (NullPointerException e) {
                    System.err.println("path not found");
                    break;
                }
                break;
            case 7:
                try {
                    Path p1 = PathGetter.getPath(Pattern.compile(".+\\.xml$"));
                    save.writeToXML(list, p1.toString());
                }catch (NullPointerException e) {
                    System.err.println("path not found");
                    break;
                }
                break;
            case 8:
                try {
                    Path p2 = PathGetter.getPath(Pattern.compile(".+\\.txt$"));
                    main.setList(save.standartRead(p2.toString()));
                }catch (NullPointerException e) {
                    System.err.println("path not found");
                    break;
                }
                break;
            case 9:
                try {
                    Path p3 = PathGetter.getPath(Pattern.compile(".+\\.xml$"));
                    main.setList(save.readFromXML(p3.toString()));
                }catch (NullPointerException e) {
                    System.err.println("path not found");
                    break;
                }
                break;
            case 10:
                Collections.sort(list, Book.Comparename);
                break;
            case 11:
                System.exit(0);
                break;
            default:
                print_menu(list);
        }
    }
}
