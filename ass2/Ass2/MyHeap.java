package Ass2;

import Ass1.MyArrayList;

public class MyHeap<T extends Comparable<T>> {
    boolean isMinHeap;
    private MyArrayList<T> list;

    public MyHeap(boolean isMinHeap){
        this.isMinHeap = isMinHeap;
        this.list = new MyArrayList<>();
    }
    public MyHeap(boolean isMinHeap, T[] arr){
        this.isMinHeap = isMinHeap;
        this.list = new MyArrayList<>(arr);
        heapify();
    }

    public void add(T item){
        list.add(item);

        if(empty())
            return;

        heapify();
    }

    public void setList(MyArrayList<T> list){
        this.list = list;
    }

    public T removeRoot(){
        return this.removeAt(0);
    }

    public boolean removeItem(T item){
        T ob = removeAt(indexOf(item));
        return ob != null;
    }
    public T removeAt(int i){
        if(i < list.size()){
            T t = list.get(i);
            list.swap(i, list.size()-1);
            list.removeAt(list.size()-1);
            heapify();
            return t;
        }
        else return null;
    }

    public int indexOf(T item){
        return list.indexOf(item);
    }

    private void heapify(){
        // количество деревьев всегда больше или равно size / 2
        for (int i = (this.size() / 2); i >= 0; i--) {
            heapify(i);
        }
    }

    private void heapify(int top){
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
            list.swap(minmax, top);
            heapify(minmax);
        }
    }

    public T get(int index){
        return list.get(index);
    }

    private int leftChild(int index){
        // same approach
        // return (2 * (index + 1)) - 1; // -1 - преобразуем обратно в [0, inf)
        return 2 * index + 1;
    }
    private int rightChild(int index){
        // same approach
        // return (2 * (index + 1)) *//* + 1 - 1 *//*;
        return 2 *index + 2;
    }
    private int parent(int index){
        // return ((index + 1) / 2) - 1;
        return (index - 1) / 2;
    }

    public int size(){
        return list.size();
    }

    public void clear(){
        this.list = new MyArrayList<>();
    }

    public boolean empty(){
        return list.size() == 0;
    }
}
