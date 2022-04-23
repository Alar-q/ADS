package Ass1;

import Ass2.MyMinHeap;

public class Main {
    public static void main(String[] args) {
        MyMinHeap<Integer> heap = new MyMinHeap<>();

        heap.add(5);
        heap.add(3);
        heap.add(0);
        heap.add(2);
        heap.add(0);
        heap.add(1);
        heap.add(7);

        heap.removeRoot();

        int n = heap.size();
        for(int i=0; i < n; i++){
            System.out.println(heap.get(i));
        }
    }
}
