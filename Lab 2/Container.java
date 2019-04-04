package com.Labs2;

import java.io.*;
import java.util.Iterator;

public class Container implements Iterable<String>, Serializable {
    private String[] data;
    private int curLength = 0;

    @Override
    public Iterator<String> iterator() {
        return new Iterator_a(data, curLength);
    }

    /*
     * serialize
     * deserialize
     */
    boolean serialize(String file) {
        FileOutputStream FileOS;
        try {
            FileOS = new FileOutputStream(file);
        } catch (FileNotFoundException error) {
            System.out.println("File not found");
            return false;
        }
        try {
            ObjectOutputStream ObjectOS = new ObjectOutputStream(FileOS);
            ObjectOS.writeObject(this);
            ObjectOS.flush();
            ObjectOS.close();
            FileOS.close();
            return true;
        } catch (IOException error) {
            System.out.println("IO works wrong");
            return false;
        }
    }

    boolean deserialize(String file) {
        FileInputStream FileIS;
        try {
            FileIS = new FileInputStream(file);
        } catch (FileNotFoundException error) {
            System.out.println("File not found");
            return false;
        }
        try {
            ObjectInputStream ObjectIS = new ObjectInputStream(FileIS);
            Container buffer = (Container) ObjectIS.readObject();
            if (buffer.curLength > data.length) {
                System.out.println("'It's so big!'");
                return false;
            }
            this.data = buffer.data;
            this.curLength = buffer.curLength;
            return true;
        } catch (IOException error) {
            System.out.println("Something goes wrong with IO");
            return false;
        } catch (ClassNotFoundException error) {
            System.out.println("Wrong file format");
            return false;
        }
    }

    //initializing of container
    Container(int length) {
        if (length > 0) {
            data = new String[length];
        } else {
            throw new ExceptionInInitializerError("This number is less or equal to 0");
        }
    }

    //add data to container
    public void add(String s) {
        data[curLength++] = s;
    }

    //toString
    public String toStr() {
        if (curLength == 0)
            return null;
        StringBuilder result = new StringBuilder();
        result.append('[');
        for (int i = 0; i < curLength - 1; i++) {
            result.append(data[i]);
            result.append("; ");
        }
        result.append(data[curLength-1]);
        result.append(']');
        return new String(result);
    }

    //clear container
    void clear() {
        for (int i = 0; i < curLength; i++)
            data[i] = null;
        curLength = 0;
    }

    //remove first String s finded in container
    boolean remove(String s) {
        for (int i = 0; i < curLength; i++) {
            if (s.equals(data[i])) {
                curLength--;
                if (curLength - i >= 0)
                    System.arraycopy(data, i + 1, data, i, curLength - i);
                data[curLength] = null;
                return true;
            }
        }
        return false;
    }

    //return array
    String[] toArr() {
        String[] result = new String[curLength];
        System.arraycopy(data, 0, result, 0, curLength);
        return result;
    }

    //return size
    int size() {
        return curLength;
    }

    //check if container contains String s
    boolean contains(String s) {
        for (int i = 0; i < curLength; i++)
            if (s.equals(data[i]))
                return true;
        return false;
    }

    //check if container contains all of elements
    boolean containsAll(Container container) {
        boolean found = false;
        for (String i : container) {
            for (int j = 0; j < curLength; j++) {
                if (i.equals(data[j])) {
                    found = true;
                    break;
                }
            }
            if (!found)
                return false;
            found = false;
        }
        return true;
    }

    //get element by index
    String get(int index) {
        if (index >= curLength)
            return null;
        else
            return data[index];
    }

    //get index of element
    int indexOf(String s) {
        for (int i = 0; i < curLength; i++) {
            if (s.equals(data[i]))
                return i;
        }
        return -1;
    }

    void sort() {
        quicksort(data, 0, curLength-1);
    }

    int maxSize() {
        return data.length;
    }

    private int elementCompare(int index1, int index2) {
        String str1 = data[index1];
        String str2 = data[index2];
        int length1 = str1.length();
        int length2 = str2.length();
        for (int i = 0; i < length1 && i < length2; i++) {
            int str1_char_index = (int) str1.charAt(i);
            int str2_char_index = (int) str2.charAt(i);
            if (str1_char_index != str2_char_index)
                return str1_char_index - str2_char_index;
        }
        if (length1 != length2)
            return length1 - length2;
        else
            return 0;
    }
    private void quicksort(String arr[], int first, int last) {
        int i = first, j = last;
        int m = (first + last) / 2;
        String swap;
        do {
            while (elementCompare(i, m) > 0) i++;
            while (elementCompare(j, m) < 0) j--;
            if(i <= j) {
                if (i < j) {
                    swap = arr[i];
                    arr[i] = arr[j];
                    arr[j] = swap;
                }
                i++;
                j--;
            }
        } while (i <= j);
        if (i < last)
            quicksort(arr, i, last);
        if (first < j)
            quicksort(arr, first,j);
    }

}
