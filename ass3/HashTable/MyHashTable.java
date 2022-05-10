package Ass3.HashTable;

import Ass3.DataStruct.MyList;

import java.util.Iterator;

/**
 *  Не обрабатывает повторяющиеся ключи
 * */

public class MyHashTable<K extends Comparable<K>, V extends Comparable<V>>{
    private static class MyHashNode<K, V>{
        public K key;
        public V value;
        public MyHashNode<K, V> next;

        public MyHashNode(K key, V value){
            this.key = key;
            this.value = value;
        }
        @Override
        public String toString(){
            return "{" + key + ", " + value + "}";
        }
    }


    private MyHashNode<K, V>[] chainArray;
    private int M = 11;
    private int size = 0;


    public MyHashTable(){
        this(11);
    }
    public MyHashTable(int M){
        this.M = M;
        this.chainArray = new MyHashNode[M];
    }


    public void put(K key, V value){
        MyHashNode<K, V> newNode = new MyHashNode<>(key, value);

        int hash = hash(key);
        MyHashNode<K, V> head = chainArray[hash];

        newNode.next = head; // Ничего если head = null
        chainArray[hash] = newNode;

        size++;
    }


    public V get(K key){
        int hash = hash(key);
        MyHashNode<K, V> head = chainArray[hash];
        while(head != null){
            // базовый случай прерывания - прошли по всем node-ам
            if(head.key.equals(key)){
                // цикл прерывается из-за совпадения ключей. !head не null!
                break;
            }
            // Здесь head больше не head
            head = head.next;
        }
        return head != null ? head.value : null;
    }


    public V remove(K key){
        int hash = hash(key);
        MyHashNode<K, V> head = chainArray[hash];
        V removed = null;

        if(head == null){}
        else if(head.key.equals(key)){
            removed = head.value;
            chainArray[hash] = head.next;
        }
        else {
            // У нас нет prev, приходится использовать node.next.next
            // head = prev
            while (head.next != null) {
                // head -> head.next -> head.next.next
                if (head.next.key.equals(key)) {
                    removed = head.next.value;
                    head.next = head.next.next;
                    break;
                }
                head = head.next;
            }
        }

        if(removed != null) size--;

        return removed;
    }

    /** Разными способами написал contains*/

    public boolean containsV(V value){
        for (int i = 0; i < M; i++) {
            MyHashNode<K, V> head = chainArray[i];
            while(head != null){
                if(head.value.equals(value)){
                    return true;
                }
                head = head.next;
            }
        }
        return false;
    }

    public boolean containsK(K key){
        for (int i = 0; i < M; i++)
//            MyHashNode<K, V> head = chainArray[i];
            for(MyHashNode<K, V> head = chainArray[i]; head != null; head = head.next)
                if(head.key.equals(key))
                    return true;
        return false;
    }


    public K getKey(V value) {
        K key = null;
        for (int i = 0; i < M; i++) {
            MyHashNode<K, V> head = chainArray[i];
            while(head != null){
                if(head.value.equals(value)){
                    key = head.key;
                    break;
                }
                head = head.next;
            }
        }
        return key;
    }


    private int hash(K key){
        return (key.hashCode() & 0x7fffffff) % M;
    }


    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            sb.append(i).append(":");
            MyHashNode<K, V> head = chainArray[i];
            while(head != null){
                sb.append(head).append(", ");
                head = head.next;
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
