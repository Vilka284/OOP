package com.Labs;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class Main {
    //data
    static String str = null;
    static ArrayList<String> words = new ArrayList<String>();
    static Map<String, Integer> counterMap = new HashMap<>();
    static int choice = 0;
    //debuger
    static void state(String str, Map<String, Integer> counterMap) {
        System.out.println("_._._._._._._._._");
        System.out.println("debug main variables");
        System.out.println("text:");
        System.out.println(str);
        System.out.println("table:");
        for (String word : counterMap.keySet()) {
            System.out.println(word + ": " + counterMap.get(word));
        }
        System.out.println("_._._._._._._._._");
    }
    //helper
    static void helper(boolean help) {
        if (help) {
            System.out.println("_______________");
            System.out.println("Andrew Syd | KN - 111 | Lab 1 #9");
            System.out.println("_______________");
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean debug = false;
        boolean help = false;
        if (args != null) {
            for ( String i:
                 args) {
                if (i.equals("-h") || i.equals("-help")) {
                    help = true;
                }
                if (i.equals("-d") || i.equals("-debug")) {
                    debug = true;
                }
            }
        }
        if (help)
            helper(help);
        while (true) {
            System.out.println("______________");
            System.out.println("1 - input");
            System.out.println("2 - show input");
            System.out.println("3 - calculate result");
            System.out.println("4 - show result");
            System.out.println("5 - exit");
            System.out.println("______________");
            choice = in.nextInt();
            switch (choice){
                case 1:  //INPUT
                    str = Menu.input(str);
                    break;
                case 2:  //SHOW I
                    Menu.show(str);
                    break;
                case 3:  //CALCULATE R
                    Menu.calculate(str, words, counterMap);
                    break;
                case 4:  //SHOW R
                    Menu.result(counterMap);
                    break;
                case 5:  //EXIT
                    Menu.exit();
                    break;
                default:
                    System.out.println("Unknown command");
                    break;
            }
            if (debug)
                state(str, counterMap);
        }
    }
}
