package com.Labs6;

public class Container {
    public final int INIT_SIZE = 16;
    public final int CUT_RATE = 4;
    public String[] array = new String[INIT_SIZE];
    public int pointer = 0;


    public void add(String item) {
        if(pointer == array.length-1)
            resize(array.length*2);
        array[pointer++] = item;
    }

    public String get(int index) {
        //System.out.println(array[0]);
        return  array[index];
    }

    public boolean clearall(){
        String[] array = new String[INIT_SIZE];
        this.array = array;
        pointer=0;
        if (size()==0){
            return true;
        }
        return false;
    }


    public void remove(int index) {
        for (int i = index; i<pointer; i++) {
            array[i] = array[i + 1];
        }
        array[pointer] = null;
        pointer--;
        if (array.length > INIT_SIZE && pointer < array.length / CUT_RATE) {
            resize(array.length / 2);
        }
    }

    public int size() {
        return pointer;
    }

    private void resize(int newLength) {
        String[] newArray = new String[newLength];
        System.arraycopy(array, 0, newArray, 0, pointer);
        array = newArray;
    }



}