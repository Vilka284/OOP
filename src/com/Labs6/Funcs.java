package com.Labs6;

import java.util.Arrays;

public class Funcs extends Thread{

    Container container = Main.container;
    int z=0;
    Funcs(int z){
        this.z = z;
    }
    Funcs(){}

    public void run(){
        if (z==0){
            getMinWord();
        }else if (z==1){
            getMaxWord();
        }else if (z==2){
            wordWithMaxConstants();
        }else if (z==3){
            wordWithMaxvovels();
        }
    }

    public void getMinWord(){
        String s = null;
        int l=1000;
        for (int i=0;i<container.size();i++){
            String wrd = container.get(i);
            if (wrd.length()<l){
                l=wrd.length();
                s=wrd;
            }
        }
        System.out.println("Min word: "+s);
    }
    public  void getMaxWord() {
        String s = null;
        int l=0;
        for (int i=0;i<container.size();i++){
            String wrd = container.get(i);
            if (wrd.length()>l){
                l=wrd.length();
                s=wrd;
            }
        }
        System.out.println("Max len word: "+s);
    }
    private char[] consonants =  {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm'
            , 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'z'};
    private char[] vowel = {'a', 'e', 'i', 'o', 'u'};

    public void wordWithMaxvovels() {
        String res=null;
        int con=0;
        for (int i=0;i<container.size();i++){
            char[] word = container.get(i).toCharArray();
            int c=0;
            for (int j=0;j<word.length;j++){
                if (Arrays.binarySearch(vowel, word[j])>=0 || Arrays.binarySearch(vowel, (char)(word[j]+32))>=0){
                    c++;
                }
            }

            if (c>con){
                res = String.valueOf(word);
                con = c;
            }
        }
        System.out.println("Max vovels in :" + res);
    }
    public void wordWithMaxConstants(){
        String res=null;
        int con=0;
        for (int i=0;i<container.size();i++){
            char[] word = container.get(i).toCharArray();
            int c=0;
            for (int j=0;j<word.length;j++){
                if (Arrays.binarySearch(consonants, word[j])>=0 || Arrays.binarySearch(consonants, (char)(word[j]+32))>=0){
                    c++;
                }
            }

            if (c>con){
                res = String.valueOf(word);
                con = c;
            }
        }
        System.out.println("Max constants in :" + res);
    }
}
