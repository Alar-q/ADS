package Ass2;

import Ass1.MyLinkedList;

public class MyQueue<T extends Comparable<T>> {
    private MyLinkedList<T> list;

    public MyQueue(){
        list = new MyLinkedList<>();
    }

    public int size(){
        return list.size();
    }

    public boolean empty(){
        return size() == 0;
    }

    public T peek(){
        return list.get(0);
    }
    public T enqueue(T ob){
        list.add(ob);
        return ob;
    }
    public T dequeue(){
        T ob = peek();
        list.removeFirst();
        return ob;
    }
}
