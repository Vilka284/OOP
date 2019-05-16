package com.Labs4;

import java.io.Serializable;

public class MyArrayList<T> implements Serializable {
    public final int INIT_SIZE = 16;
    public final int CUT_RATE = 4;
    public Object[] array = new Object[INIT_SIZE];
    public int pointer = 0;


    public void add(T item) {
        if(pointer == array.length-1)
            resize(array.length*2);
        array[pointer++] = item;
    }

    public T get(int index) {
        return (T) array[index];
    }

    public boolean clearall(){
        Object[] array = new Object[INIT_SIZE];
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
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, pointer);
        array = newArray;
    }
}
