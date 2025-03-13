package com.grepp.library.c_collection.d_map.grepp;

import com.grepp.library.c_collection.b_list.grepp._LinkedList;
import com.grepp.library.c_collection.c_set.grepp._HashSet;

@SuppressWarnings("unchecked")
public class _EntrySet<E> extends _HashSet<E> {

    _EntrySet() {
    }

    @Override
    public boolean add(E e) {
        if(get(e) != null){
            super.remove(e);
        }

        return super.add(e);
    }

    public E get(E e){
        int index = hash(e);
        _LinkedList<E> row = (_LinkedList<E>)super.elementData[index];

        if(row == null) return null;

        for(E data : row){
            if(data.equals(e)){
                return data;
            }
        }

        return null;
    }

}
