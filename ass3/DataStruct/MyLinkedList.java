package Ass3.DataStruct;

import java.util.Iterator;

public class MyLinkedList<T extends Comparable<T>> implements MyList<T>, Iterable<T> {
    private static class MyNode<T>{
        T data;
        MyNode<T> next, prev;

        MyNode(T data) {
            this.data = data;
        }
    }

    private int length = 0;
    private MyNode<T> head, tail;

    public MyLinkedList() {

    }

    @Override
    public void add(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        if (head == null) {
            head = tail = newNode;
        }
        else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    @Override
    public void add(T item, int index) {
        if (index < 0) {
            System.out.println("index should be positive");
        }
        else if(index >= length){
            // Idk how correct its to fill in the gaps with null values
            for(int i = 0; i < (index-length); i++)
                this.add(null);
            this.add(item);
        }
        else { // Замена значения, лучше назвать "set"
            getNodeAt(index).data = item;
        }
    }

    private void deleteNode(MyNode<T> node){
        if(node == null){
            System.out.println("node is null");
            return;
        }

        /* prevNode - node - nextNode */
        MyNode<T> nextNode = node.next;
        MyNode<T> prevNode = node.prev;
        if(prevNode == null) { //node - head
            removeFirst();
        }else if(nextNode == null) { //node - tail
            removeLast();
        }else {
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            length--;
        }
    }

    public T removeFirst(){
        if(head == null){
            throw new IndexOutOfBoundsException("Linked list is empty");
        }
        T removed = head.data;

        if(head == tail){
            head = tail = null;
        }else{
            head = head.next;
        }
        length--;

        return removed;
    }

    public T removeLast(){
        if(head == null){
            throw new IndexOutOfBoundsException("Linked list is empty");
        }
        T removed = tail.data;
        if(head == tail) {
            head = tail = null;
        }else{
            tail = tail.prev;
            tail.next = null;
        }
        length--;
        return removed;
    }

    @Override
    public boolean removeItem(T item) {
        if(head == null) {
            System.out.println("list is empty");
            return false;
        }

        for(MyNode<T> node=head; node!=null; node=node.next) {
            if (node.data == item) {
                deleteNode(node);
                return true;
            }
        }
        return false;
    }

    @Override
    public T removeAt(int index) {
        if(head == null) {
            System.out.println("list is empty");
            return null;
        }

        MyNode<T> temp = getNodeAt(index);
        T data = temp.data;

        deleteNode(temp);

        return data;
    }

    @Override
    public T get(int index) {
        MyNode<T> node = getNodeAt(index);
        return node.data;
    }

    @Override
    public int indexOf(Object o) {
        int i = 0;
        for(MyNode<T> node=head; node!=null; node=node.next, i++)
            if(node.data == o)
                return i;
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int res = -1;
        int i = 0;
        for(MyNode<T> node=head; node!=null; node=node.next, i++)
            if (node.data == o)
                res = i;
        return res;
    }

    @Override
    public void sort() {
        // bubble
        for (int i = 0; i < length - 1; i++){
            for (int j = 0; j < length - i - 1; j++){
                T a = this.get(j);
                T b = this.get(j + 1);
                if (first_greater(a, b)) {
                    // swap arr[j+1] and arr[j]
                    this.add(b, j);
                    this.add(a,j+1);
                }
            }
        }
    }

    private boolean first_greater(T ob, T ob2){
        return ob.compareTo(ob2) > 0;
    }

    @Override
    public boolean contains(Object ob) {
        for(MyNode<T> i=head; i.next!=null; i=i.next)
            if(i.data == ob)
                return true;
        return false;
    }

    @Override
    public void clear(){
        length = 0;
        head = tail = null;
    }

    @Override
    public int size() {
        return length;
    }


    private MyNode<T> getNodeAt(int index){
        if (index >= length || index < 0)
            throw new IndexOutOfBoundsException("index should be positive and less than size");
        if(head == null)
            throw new IndexOutOfBoundsException("Linked list is empty");
        MyNode<T> temp = head;
        for(int i=index; i>0; i--)
            temp = temp.next;
        return temp;
    }


    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T>{
        int cursor = 0;
        @Override
        public boolean hasNext() {
            return cursor != size();
        }

        @Override
        public T next() {
            T nextItem = get(cursor);
            cursor++;
            return nextItem;
        }
    }
}

