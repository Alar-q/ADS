package Ass1;

public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {
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
        else if(index > length){
            // Idk how correct its to fill in the gaps with null values
            int n = index - length;
            for(int i=0; i<n; i++)
                this.add(null);
            this.add(item);
        }
        else if(index == length){
            this.add(item);
        }
        else {
            MyNode<T> temp = head;
            for(int i=0; i<index; i++){
                temp = temp.next;
            }
            temp.data = item;
        }
    }

    private void deleteNode(MyNode<T> node){
        MyNode<T> nextNode = node.next;
        MyNode<T> prevNode = node.prev;
        if(prevNode == null)
            head = nextNode;
        else if(nextNode == null)
            tail = node.prev;
        else {
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }
        length--;
    }

    @Override
    public boolean removeItem(T item) {
        for(MyNode<T> node=head; node!=null; node=node.next) {
            if (node.data == item) {
                deleteNode(node);
                return true;
            }
        }
        return false;
    }

    @Override
    public T remove(int index) {
        MyNode<T> temp = head;
        for(int i=0; i<index; i++){
            temp = temp.next;
        }
        T res = temp.data;
        deleteNode(temp);
        return res;
    }

    @Override
    public T get(int index) {
        if (index >= length || index < 0)
            throw new IndexOutOfBoundsException("index should be positive and less than size");

        MyNode<T> temp = head;

        while (index != 0) {
            temp = temp.next;
            index--;
        }

        return temp.data;
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
        head = null;
        tail = null;
    }

    @Override
    public int size() {
        return length;
    }
}

