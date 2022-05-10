package Ass3.DataStruct;

import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<T extends Comparable<T>> implements MyList<T>, Iterable<T> {

    private static final int INCREASE_FACTOR = 2;
    private static final int INITIAL_CAPACITY = 3;

    private Object[] array;
    private int length = 0;
    private int capacity = INITIAL_CAPACITY;

    public MyArrayList() {
        array = new Object[capacity];
    }
    public MyArrayList(T[] arr) {
        array = arr;
        length = arr.length;
        capacity = length;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean contains(Object o) {
        for (Object ob : array)
            if (ob == o)
                return true;
        return false;
    }

    @Override
    public void add(T item) {
        if (length == capacity)
            increaseCapacity();
        array[length++] = item;
    }

    public void increaseCapacity() {
        capacity *= INCREASE_FACTOR;
        Object[] buf = new Object[capacity];
        System.arraycopy(array, 0, buf, 0, array.length);
        array = buf;
    }

    @Override
    public void add(T item, int index) {
        if(index < length){
            array[index] = item;
        }
        else if(index == length){
            this.add(item);
        }
        else{
            while (index >= capacity)
                increaseCapacity();
            Object[] buf = new Object[capacity];
            System.arraycopy(array, 0, buf, 0, length);

            for(int i=length; i<index; i++)
                buf[length + i] = null;
            buf[index] = item;

            length = index+1;
            array = buf;
        }
    }

    @Override
    public boolean removeItem(T item) {
        int index = -1;

        for (int i = 0; i < length; i++) {
            if (array[i] == item) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            removeAt(index);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public T removeAt(int index) {
        Object[] res = new Object[capacity];
        Object ob = null;

        for (int i = 0, was = 0; i < length; i++) {
            if (i == index) {
                was = 1;
                ob = array[i];
                continue;
            }
            res[i - was] = array[i];
        }

        length -= 1;
        array = res;
        return (T) ob;
    }

    @Override
    public void clear() {
        length = 0;
        capacity = INITIAL_CAPACITY;
        array = new Object[capacity];
    }

    @Override
    public T get(int index) {
        return (T) array[index];
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < length; i++)
            if (array[i] == o)
                return i;
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int lastIndex = -1;
        for (int i = 0; i < length; i++)
            if (array[i] == o)
                lastIndex = i;
        return lastIndex;
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

    public void swap(int i, int j){
        Object ob = array[j];
        array[j] = array[i];
        array[i] = ob;
    }


    @Override
    public String toString(){
        return Arrays.toString(array);
    }

}
