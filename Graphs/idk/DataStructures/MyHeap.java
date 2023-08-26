package DataStructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Shit-Heap */
public class MyHeap<T extends Comparable<T>>{
    private final boolean isMinHeap;
    private ArrayList<T> list;

    public MyHeap(boolean isMinHeap){
        this.isMinHeap = isMinHeap;
        this.list = new ArrayList<>();
    }
    public MyHeap(){
        this(true);
    }

    public void add(T item){
        list.add(item);
        if(size() == 1){
            return;
        }
        heapify(parent(size() - 1));
    }

    private void heapify(int top){
        if(top < 0){
            return;
        }

        int minmax = top;
        int l = leftChild(top);
        int r = rightChild(top);

        if(isMinHeap) {
//            System.out.println(top +" "+ list.get(top));
            if (l < this.size() && list.get(top).compareTo(list.get(l)) > 0)
                minmax = l;
            if (r < this.size() && list.get(minmax).compareTo(list.get(r)) > 0)
                minmax = r;
        }else{
            if (l < this.size() && list.get(top).compareTo(list.get(l)) < 0)
                minmax = l;
            if (r < this.size() && list.get(minmax).compareTo(list.get(r)) < 0)
                minmax = r;
        }

        if(minmax != top){
            swap(minmax, top);
            top = minmax;
        }

        heapify(parent(top));
    }

    public void heapify(){ // O(logn)
        for(int i = size() / 2 ; i >= 0; i--){
            heapifyOne(i);
        }
    }
    private void heapifyOne(int top){
        int minmax = top;
        int l = leftChild(top);
        int r = rightChild(top);

        if(isMinHeap) {
//            System.out.println(top +" "+ list.get(top));
            if (l < this.size() && list.get(top).compareTo(list.get(l)) > 0)
                minmax = l;
            if (r < this.size() && list.get(minmax).compareTo(list.get(r)) > 0)
                minmax = r;
        }else{
            if (l < this.size() && list.get(top).compareTo(list.get(l)) < 0)
                minmax = l;
            if (r < this.size() && list.get(minmax).compareTo(list.get(r)) < 0)
                minmax = r;
        }

        if(minmax != top){
            swap(minmax, top);
        }
    }

    private void swap(int a, int b){
        T temp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, temp);
    }

    public boolean isEmpty(){
        return list.size() == 0;
    }

    private int size(){
        return list.size();
    }

    private int leftChild(int index){
        return (2 * (index + 1)) - 1; // -1 - преобразуем обратно в [0, inf)
    }
    private int rightChild(int index){
        return (2 * (index + 1)) /* + 1 - 1 */;
    }
    private int parent(int index){
        return ((index + 1) / 2) - 1;
    }

    @Override
    public String toString(){
        return list.toString();
    }
}
