package Ass3.HashTable;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        MyHashTable<Integer, Integer> table = new MyHashTable<>(2);
        /* Test just put */
        table.put(1, 1);
        table.put(1, 11);
        table.put(2, 2);
        table.put(3, 3);
        System.out.println("size: " + Arrays.toString(table.sizes()));
        System.out.println(table);

        /* Test increase M and remove one key */
        table.put(4, 4);
        table.put(5, 5);
        table.put(6, 6);
        table.remove(6);
        System.out.println("size: " + Arrays.toString(table.sizes()));
        System.out.println(table);

        /* Test with biger numbers */
        for(int i=0; i<1000; i++)
            table.put(i, i);
        System.out.println("size: " + Arrays.toString(table.sizes()));
        System.out.println(table);

        for(int i=0; i<500; i++)
            table.remove(i);
        System.out.println("size: " + Arrays.toString(table.sizes()));
        System.out.println(table);
    }
}
