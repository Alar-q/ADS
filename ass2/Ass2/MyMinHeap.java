package Ass2;

import Ass1.MyArrayList;

public class MyMinHeap<T extends Comparable<T>> extends MyHeap<T>{
    public MyMinHeap() {
        super(true);
    }
    public MyMinHeap(T[] arr) {
        super(true, arr);
    }
}
