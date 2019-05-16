package com.Labs4;

import java.io.Serializable;

public class Node<T> implements Serializable {
    public Node next;
    public T data;

    public Node(){}

    public Node(T data, Node next){
        this.data = data;
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}