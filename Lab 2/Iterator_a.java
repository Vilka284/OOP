package com.Labs2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Iterator_a<T> implements Iterator<T> {
    private ArrayList data;
    private int current = 0;
    private int stop;

    Iterator_a(String data[], int length) {
        this.data = new ArrayList<>(Arrays.asList(data));
        stop = length - 1;
    }

    @Override
    public boolean hasNext() {
        return (current <= stop);
    }

    @Override
    public T next() {
        return (T) data.get(current++);
    }

    @Override
    public void remove() {
        data.remove(--current);
    }
}
