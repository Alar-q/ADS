package Ass3.DataStruct;

public class MyStack<T extends Comparable<T>> {
    private MyLinkedList<T> list;

    public MyStack(){
        list = new MyLinkedList<>();
    }

    public int size(){
        return list.size();
    }

    public boolean empty(){
        return size() == 0;
    }

    public T peek(){
        return list.get(size()-1);
    }
    public T enqueue(T ob){
        list.add(ob);
        return ob;
    }
    public T dequeue(){
        T ob = peek();
        list.removeLast();
        return ob;
    }
}
