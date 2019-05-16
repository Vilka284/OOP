package com.Labs4;

public class Main {

    static MyLinkedList<Book> list = new MyLinkedList<>();
    public static void main(String[] args) {

        Menu menu = new Menu();
        if (args.length!=0){
            if (args[0].equals("-auto")) {
                Save save = new Save();
                list = save.standartRead("D:\\Андрiй\\OOP\\src\\com\\Labs4\\test.txt");
                menu.options(4, list);
                System.exit(0);
            }
        }else {
            while (true) {
                menu.print_menu(list);
            }
        }

    }
    public void setList(MyLinkedList<Book> list){
        this.list = list;
    }
}
