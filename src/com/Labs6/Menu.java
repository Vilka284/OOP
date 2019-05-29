package com.Labs6;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
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
        switch (t){
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
    private void printSecondMenu(){
        Funcs f1 = new Funcs(0);
        Funcs f2 = new Funcs(1);
        Funcs f3 = new Funcs(2);
        Funcs f4 = new Funcs(3);
        Thread thread1 = new Thread(f1);
        Thread thread2 = new Thread(f2);
        Thread thread3 = new Thread(f3);
        Thread thread4 = new Thread(f4);

        System.out.println(" 0 - minWord");
        System.out.println(" 1 - maxWord");
        System.out.println(" 2 - wordWithMaxConstants");
        System.out.println(" 3 - wordWithMaxVovels");
        Scanner scanner = new Scanner(System.in);
        char[] t = scanner.nextLine().toCharArray();
        System.out.println("Input time limit: ");
        double time_limit = scanner.nextDouble();
        Long time;
        time = System.currentTimeMillis();
        if (Arrays.binarySearch(t, '0')>=0){
            thread1.start();
        }
        if (Arrays.binarySearch(t, '1')>=0){
            thread2.start();
        }
        if (Arrays.binarySearch(t, '2')>=0){
            thread3.start();
        }
        if (Arrays.binarySearch(t, '3')>=0){
            thread4.start();
        }

        if (time_limit==0){
            while (thread1.isAlive() || thread2.isAlive() || thread3.isAlive() || thread4.isAlive()){

            }
        }else {
            while (true){
                if (!thread1.isAlive() && !thread2.isAlive() && !thread3.isAlive() && !thread4.isAlive()){
                    break;
                }
                if (time_limit<System.currentTimeMillis()-time){
                    thread1.stop();
                    thread2.stop();
                    thread3.stop();
                    thread4.stop();
                    break;
                }
            }
        }
        System.out.println("Paralel: " + (System.currentTimeMillis()-time));

        time = System.currentTimeMillis();
        for (int i=0;i<t.length;i++){
            Funcs f = new Funcs();
            switch (Character.getNumericValue(t[i])){
                case 0:
                    f.getMinWord();
                    break;
                case 1:
                    f.getMaxWord();
                    break;
                case 2:
                    f.wordWithMaxConstants();
                    break;
                case 3:
                    f.wordWithMaxvovels();
                    break;
                default:
                    break;
            }
        }
        System.out.println("Послідовно" + (System.currentTimeMillis()-time));
    }
}
