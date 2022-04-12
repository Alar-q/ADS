package Ass1;

import java.util.Arrays;

public class MyArrayList<T> implements MyList<T> {

    private static final int INCREASE_FACTOR = 2;
    private static final int INITIAL_CAPACITY = 3;

    private Object[] array;
    private int size = 0;
    private int capacity = INITIAL_CAPACITY;

    public MyArrayList() {
        array = new Object[capacity];
    }

    @Override
    public int size() {
        return size;
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
        if (size == capacity)
            increaseCapacity();
        array[size++] = item;
    }

    public void increaseCapacity() {
        capacity *= INCREASE_FACTOR;
        Object[] buf = new Object[capacity];
        System.arraycopy(array, 0, buf, 0, array.length);
        array = buf;
    }

    @Override
    public void add(T item, int index) {
        if (size == capacity)
            increaseCapacity();

        Object[] buf = new Object[size + 1];

        for (int i = 0, j = 0; i < size; i++) {
            if (i == index) {
                j = 1;
                buf[i] = item;
            }
            buf[i + j] = array[i];
        }
        size += 1;
        array = buf;
    }

    @Override
    public boolean removeItem(T item) {
        int index = -1;

        for (int i = 0; i < size; i++) {
            if (array[i] == item) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            remove(index);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public T remove(int index) {
        Object[] res = new Object[size];
        Object ob = null;

        for (int i = 0, was = 0; i < size; i++) {
            if (i == index) {
                was = 1;
                ob = array[i];
                continue;
            }
            res[i - was] = array[i];
        }

        size -= 1;
        array = res;
        return (T) ob;
    }

    @Override
    public void clear() {
        size = 0;
        capacity = INITIAL_CAPACITY;
        array = new Object[capacity];
    }

    @Override
    public T get(int index) {
        return (T) array[index];
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++)
            if (array[i] == o)
                return i;
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int lastIndex = -1;
        for (int i = 0; i < size; i++)
            if (array[i] == o)
                lastIndex = i;
        return lastIndex;
    }

    @Override
    public void sort() {
        // comparing of generics throws an exception, idk
        // boolean b = (T) array[0] > (T) array[1];
        Arrays.sort(array);
    }

    private int[] bubbleSort(int arr[]) {
//        int[] res = new int[arr.length];z
        int n = arr.length;
        for (int i = 0; i < n - 1; i++){
            for (int j = 0; j < n - i - 1; j++){
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

}
