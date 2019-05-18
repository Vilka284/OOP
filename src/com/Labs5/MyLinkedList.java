package com.Labs5;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements Iterable<T> , Serializable {
    public Node head;
    public Node tail;
    public int size = 0;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(T item){
        if (item == null) {
            throw new NullPointerException("The first argument for addLast() is null.");
        }
        if (!isEmpty()) {
            Node prev = tail;
            tail = new Node(item, null);
            prev.next = tail;
        }
        else {
            tail = new Node(item, null);
            head = tail;
        }
        size++;
    }

    public boolean remove(String name) {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot remove: list are empty.");
        }
        boolean result = false;
        Node prev = head;
        Node curr = head;
        while (curr.next != null || curr == tail) {
            if (((Book)curr.getData()).getName().equals(name)) {
                if (size == 1) {
                    head = null;
                    tail = null;
                }else if ((((Book)curr.getData()).getName()).equals(((Book) head.getData()).getName())) {
                    head = head.getNext();
                }else if ((((Book)curr.getData()).getName()).equals(((Book) tail.getData()).getName())) {
                    head = prev;
                    head.setNext(null);
                }else {
                    prev.setNext(curr.getNext());
                }
                size--;
                result = true;
                break;
            }
            prev = curr;
            curr = prev.getNext();
        }
        return result;
    }

    public boolean deleteAll(){
        Node n = head;
        while(n != null){
            head = n.getNext();
            n.setNext(n.getNext());
            n = null;
            size--;
        }
        head = null;
        tail = null;
        return true;
    }

    public Book[] toArray(){
        Book[] array = new Book[size];
        Node n = head;
        for (int i=0;n != null;i++){
            array[i] = (Book) n.getData();
            n = n.getNext();
        }
        return array;
    }

    public boolean contain(String name){
        Node n = head;
        while(n != null){
            Book p = (Book) n.getData();
            if (p.getName().equals(name)){
                return true;
            }
            n = n.getNext();
        }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Iterator<T> iterator() {
        return new MyLinkedListIterator();
    }


    private class MyLinkedListIterator implements Iterator<T> {
        private Node current = head;

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T item = (T) current.getData();
            current = current.getNext();
            return item;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }


}
