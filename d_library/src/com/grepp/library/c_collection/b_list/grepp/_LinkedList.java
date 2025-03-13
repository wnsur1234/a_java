package com.grepp.library.c_collection.b_list.grepp;

import com.grepp.library.c_collection.z_domain.Node;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class _LinkedList<E> implements _List<E>{

    private Node<E> head;
    private int pointer;

    public int size(){
        return pointer;
    }

    public boolean isEmpty(){
        return pointer == 0;
    }

    public boolean add(E e){
        Node<E> current = new Node<>(e);

        if(pointer == 0){
            head = current;
            pointer++;
            return true;
        }

        Node<E> link = head;
        while(link.next() != null){
            link = link.next();
        }

        link.setNext(current);
        pointer++;
        return true;
    }

    public E get(int index){
        if(index < 0 || index >= pointer) throw new IndexOutOfBoundsException();

        Node<E> link = head;
        for (int i = 0; i < index; i++) {
            link = link.next();
        }

        return link.data();
    }

    public E set(int index, E e){
        if(index < 0 || index >= pointer) throw new IndexOutOfBoundsException();

        Node<E> link = head;

        for (int i = 0; i < index; i++) {
            link = link.next();
        }

        E modified = link.data();
        link.setData(e);
        return modified;
    }

    public E remove(int index){
        if(index < 0 || index >= pointer) throw new IndexOutOfBoundsException();

        Node<E> link = head;
        Node<E> prevNode = head;

        if(index == 0){
            head = head.next();
            pointer--;
            return prevNode.data();
        }

        for(int i = 0; i < index; i++){
            prevNode = link;
            link = link.next();
        }

        prevNode.setNext(link.next());
        pointer--;
        return link.data();
    }
    
    // todo contains 메서드 구현
    public boolean contains(E e){
        Node<E> link = head;
        while(link != null){
            if(link.data().equals(e)){
                return true;
            }
            link = link.next();
        }

        return false;
    }


    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int pointer;

            @Override
            public boolean hasNext() {
                return pointer < size();
            }

            @Override
            public E next() {
                if(pointer >= size()) throw new NoSuchElementException();
                E e = get(pointer);
                pointer++;
                return e;
            }
        };
    }
 }
