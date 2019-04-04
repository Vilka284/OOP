package com.Labs2;

import java.util.Scanner;
import java.util.ArrayList;

public class Menu {
    static Scanner in = new Scanner(System.in);
    static ArrayList<Container> listOfContainers = new ArrayList<>();

    public static void input() {
        System.out.print("Enter length: ");
        listOfContainers.add(new Container(in.nextInt()));
        System.out.print("Enter container's index: ");
        int index = in.nextInt();
        if (index > listOfContainers.size() || index < 0)
            System.out.println("index not found");
        System.out.println("Enter " + listOfContainers.get(index-1).maxSize() + " strings one by one:");
        in.nextLine();
        for (int i = 0, n = listOfContainers.get(index-1).maxSize(); i < n; i++) {
            listOfContainers.get(index-1).add(in.nextLine());
        }
    }

    public static void show() {
        System.out.print("Enter container's index: ");
        int showIndex = in.nextInt();
        if (showIndex > listOfContainers.size() || showIndex < 1)
            System.out.println("index not found");
        System.out.println(listOfContainers.get(showIndex-1).toString());
    }

    public static void clear() {
        System.out.print("Enter container's index: ");
        int delIndex = in.nextInt();
        if (delIndex > listOfContainers.size() || delIndex < 1) {
            System.out.println("Error! not found");
        }
        listOfContainers.get(delIndex-1).clear();
    }

    public static void menu() {
        while(true) {
            System.out.print("Enter container's index: ");
            int menuIndex = in.nextInt();
            if (menuIndex > listOfContainers.size() || menuIndex < 1) {
                System.out.println("not found");
                break;
            }
            System.out.println("||||||||||||||||||||||||||||||||||||||||||");
            System.out.println("1 - Add element");
            System.out.println("2 - Remove element");
            System.out.println("3 - Return Array");
            System.out.println("4 - Size of Container");
            System.out.println("5 - Check string");
            System.out.println("6 - Check sub container");
            System.out.println("7 - Serialize");
            System.out.println("8 - Deserialize");
            System.out.println("9 - Get element by index");
            System.out.println("10 - Get index of element");
            System.out.println("11 - Sort");
            System.out.println("12 - Iterate container (foreach)");
            System.out.println("13 - Iterate container (while)");
            System.out.println("14 - Exit");
            System.out.println("||||||||||||||||||||||||||||||||||||||||||");
            int choice = in.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Input element: ");
                    in.nextLine();
                    listOfContainers.get(menuIndex - 1).add(in.nextLine());
                    break;
                case 2:
                    System.out.println("Input element: ");
                    in.nextLine();
                    listOfContainers.get(menuIndex - 1).remove(in.nextLine());
                    break;
                case 3:
                    for (String i:
                         listOfContainers.get(menuIndex-1).toArr()) {
                        System.out.println(i);
                    }
                    break;
                case 4:
                    System.out.println(listOfContainers.get(menuIndex-1).size());
                    break;
                case 5:
                    System.out.println("enter string to check if it exist in container:");
                    in.nextLine();
                    System.out.println(listOfContainers.get(menuIndex-1).contains(in.nextLine()));
                    break;
                case 6:
                    System.out.println("Enter string to check if it exist in container:");
                    in.nextLine();
                    System.out.println(listOfContainers.get(menuIndex-1).contains(in.nextLine()));
                    break;
                case 7:
                    System.out.println("Enter file name(name.format): ");
                    in.nextLine();
                    listOfContainers.get(menuIndex-1).serialize(in.nextLine());
                    break;
                case 8:
                    System.out.println("Enter file name(name.format): ");
                    in.nextLine();
                    listOfContainers.get(menuIndex-1).deserialize(in.nextLine());
                    break;
                case 9:
                    System.out.print("Enter index: ");
                    listOfContainers.get(menuIndex-1).get(in.nextInt());
                    break;
                case 10:
                    System.out.println("Enter element:");
                    in.nextLine();
                    listOfContainers.get(menuIndex-1).indexOf(in.nextLine());
                    break;
                case 11:
                    listOfContainers.get(menuIndex-1).sort();
                    System.out.println("done!");
                    break;
                case 12:
                    for (String i:
                            listOfContainers.get(menuIndex-1)) {
                        System.out.println(i);
                    }
                    break;
                case 13:
                    Iterator_a i = (Iterator_a) listOfContainers.get(menuIndex-1).iterator();
                    while (i.hasNext()) {
                        System.out.println(i.next());
                    }
                    break;
                case 14:
                    break;
                default:
                    System.out.println("Unknown command");
            }
        }
    }

    public static void exit() {
        System.out.println("That's all folks!");
        System.exit(0);
    }
}
