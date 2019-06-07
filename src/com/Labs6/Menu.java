package com.Labs6;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public void ptintMainMenu() throws Exception {
        System.out.println("==============================");
        System.out.println("|             MENU           |");
        System.out.println("==============================");
        System.out.println(" 1 - Read from ");
        System.out.println(" 4 - Processing");
        System.out.println(" 5 - Exit");
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        switch (t) {
            case 1:
                FileReader fileReader = new FileReader("D:\\Андрiй\\OOP\\src\\com\\Labs6\\test.txt");
                Scanner sc = new Scanner(fileReader);
                while (sc.hasNextLine()) {
                    Main.container.add(sc.nextLine());
                }
                fileReader.close();
                break;

            case 4:
                printSecondMenu();
                break;
            case 5:
                System.exit(0);
        }
    }

    private void printSecondMenu() {
        Funcs f1 = new Funcs(0);
        Funcs f2 = new Funcs(1);
        Funcs f3 = new Funcs(2);
        Funcs f4 = new Funcs(3);
        Thread thread1 = new Thread(f1);
        Thread thread2 = new Thread(f2);
        Thread thread3 = new Thread(f3);
        Thread thread4 = new Thread(f4);
        Thread thread11 = new Thread(f1);
        Thread thread22 = new Thread(f2);
        Thread thread33 = new Thread(f3);
        Thread thread44 = new Thread(f4);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input time limit: ");
        double time_limit = scanner.nextDouble();
        Long time;
        time = System.currentTimeMillis();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();


                if (time_limit < System.currentTimeMillis() - time) {
                    thread1.stop();
                    thread2.stop();
                    thread3.stop();
                    thread4.stop();
                }

        System.out.println("Паралельний: " + (System.currentTimeMillis() - time));

        time = System.currentTimeMillis();

        thread11.start();
        thread22.start();
        thread33.start();
        thread44.start();
        try{
            thread11.join();
            thread22.join();
            thread33.join();
            thread44.join();
        }
        catch(InterruptedException e){

            System.out.printf("smth goes wrong");
        }
        System.out.println("Послідовно: " + (System.currentTimeMillis() - time));


    }
}
