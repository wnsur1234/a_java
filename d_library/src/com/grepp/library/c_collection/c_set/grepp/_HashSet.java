package com.grepp.library.c_collection.c_set.grepp;

import com.grepp.library.c_collection.b_list.grepp._LinkedList;
import java.util.Iterator;

@SuppressWarnings("unchecked")
public class _HashSet<E> implements Iterable<E>{

    protected int arraySize = 17;
    protected Object[] elementData;
    protected int size = 0;

    public _HashSet() {
        this.elementData = new Object[arraySize];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    protected int hash(E data){
        int hashCode = Math.abs(data.hashCode());
        return hashCode % arraySize;
    }

    private void resize() {
        arraySize *= 2;
        Object[] temp = new Object[arraySize];

        for(int i = 0; i < elementData.length; i++){
            if(elementData[i] == null) continue;
            _LinkedList<E> row = (_LinkedList<E>) elementData[i];
            int index = hash(row.get(0));
            temp[index] = row;
        }

        elementData = temp;
    }

    public boolean add(E data) {

        if (size == arraySize - 1) {
            resize();
        }

        int index = hash(data);
        _LinkedList<E> row = (_LinkedList<E>) elementData[index];

        if (row == null) {
            createRow(data, index);
            size++;
            return true;
        }

        if (row.contains(data)) return false;
        row.add(data);
        size++;
        return true;

    }

    private void createRow(E data, int index) {
        _LinkedList<E> newRow = new _LinkedList<>();
        newRow.add(data);
        elementData[index] = newRow;
    }

    public boolean remove(E data){
        int index = hash(data);
        _LinkedList<E> row = (_LinkedList<E>) elementData[index];

        if(row == null){
            return false;
        }

        for (int i = 0; i < row.size(); i++) {
            if(row.get(i).equals(data)){
                row.remove(i);
                size--;

                if(row.isEmpty()){
                    elementData[index] = null;
                }
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");

        for(int i = 0; i < elementData.length; i++){
            if(elementData[i] == null) continue;
            _LinkedList<E> row = (_LinkedList<E>) elementData[i];
            for (E e : row) {
                sb.append(e).append(", ");
            }
        }

        sb.append("]");
        return sb.toString();
    }


    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private int cnt;
            private int pointer = -1;
            private _LinkedList<E> row = new _LinkedList<>();
            private Iterator<E> rowIterator = row.iterator();

            @Override
            public boolean hasNext() {
                return cnt < size;
            }

            @Override
            public E next() {
                if(rowIterator.hasNext()){
                    cnt++;
                    return rowIterator.next();
                }

                do {
                    pointer++;
                } while (elementData[pointer] == null);

                row = (_LinkedList<E>) elementData[pointer];
                rowIterator = row.iterator();
                cnt++;
                return rowIterator.next();
            }
        };
    }
}
