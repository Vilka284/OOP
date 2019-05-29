package com.Labs6;

public class Main {
    public static Container container = new Container();
    public static void main(String args[]){

        Menu menu = new Menu();
        while (true){
            try {
                menu.ptintMainMenu();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
