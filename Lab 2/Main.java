package com.Labs2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("______________________________");
            System.out.println("1 - input data in container");
            System.out.println("2 - show data in container");
            System.out.println("3 - clear data from container");
            System.out.println("4 - container menu");
            System.out.println("5 - exit");
            System.out.println("______________________________");
            int choice = in.nextInt();
            switch (choice){
                case 1:
                    Menu.input();
                    break;
                case 2:
                    Menu.show();
                    break;
                case 3:
                    Menu.clear();
                    break;
                case 4:
                    Menu.menu();
                    break;
                case 5:
                    Menu.exit();
                    break;
                default:
                    System.out.println("Unknown command");
                    break;
            }
        }
    }
}
