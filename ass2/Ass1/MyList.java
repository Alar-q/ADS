package Ass1;

public interface MyList <T> {
    int size();
    boolean contains(Object o);
    void add(T item);
    void add(T item, int index);
    boolean removeItem(T item);
    T removeAt(int index);
    void clear();
    T get(int index);
    int indexOf(Object o);
    int lastIndexOf(Object o);
    void sort();
}
