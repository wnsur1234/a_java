package com.grepp.library.c_collection.c_set.grepp;

public class _HashSet<E> {

    private static final int DEFAULT_CAPACITY= 10;
    private int arraySize = 10;
    private Object[] elementData;
    private int size;

    public _HashSet() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }
}
