package com.Labs;

import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Menu {

    public static String input(String str) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input text:");
        str = in.nextLine();
        return str;
    }

    public static void show(String str) {
        if (str != null)
            System.out.println("Your input:\n" + str);
        else
            System.out.println("Error! Input empty");
    }

    //
    //CALCULATE
    //
    public static Map<String, Integer> calculate(String str, List<String> words, Map<String, Integer> counterMap) {
        if (str != null) {
            words = Split.splitEx(str, " ");
            /*for (String word :
                 str1) {1
                words.add(word);
            }*/
            for (String word :
                    words) {
                if (!word.isEmpty()) {
                    Integer count = counterMap.get(word);
                    if (count == null)
                        count = 0;
                    counterMap.put(word, ++count);
                }
            }
        } else {
            System.out.println("Error! Input empty");
        }
        return counterMap;
    }

    //
    //RESULT
    //
    public static void result(Map<String, Integer> counterMap) {
        if (!counterMap.isEmpty()) {
            for(String word : counterMap.keySet()) {
                System.out.println(word + ": " + counterMap.get(word));
            }
        } else {
            System.out.println("Error! Calculate first");
        }
    }

    public static void exit() {
        System.out.println("That's all folks!");
        System.exit(0);
    }
}
