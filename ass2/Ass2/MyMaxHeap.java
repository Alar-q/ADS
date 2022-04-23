package Ass2;

public class MyMaxHeap<T extends Comparable<T>> extends MyHeap<T>{
    public MyMaxHeap() {
        super(false);
    }
    public MyMaxHeap(T[] arr) {
        super(false, arr);
    }
}
