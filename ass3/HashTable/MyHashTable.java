package Ass3.HashTable;

/**
 *  Не обрабатывает повторяющиеся ключи
 * */

public class MyHashTable<K extends Comparable<K>, V extends Comparable<V>> {
    private static class MyHashNode<K, V> {
        public K key;
        public V value;
        public MyHashNode<K, V> next;

        public MyHashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + ", " + value + "}";
        }
    }


    private MyHashNode<K, V>[] chainArray;
    private int M = 11;
    /**
     *  Store the size of each "linkedlist" in an array. 
     *  This is more convenient to change the longest "linkedlist" when deleting an element
     *  than storing only the length of the longest 
     *  and does not take up much space. 
     *  */
    private int sizes[];


    public MyHashTable() {
        this(11);
    }

    public MyHashTable(int M) {
        this.M = M;
        this.chainArray = new MyHashNode[M];
        this.sizes = new int[M];
    }


    public void put(K key, V value) {
        increaseLogic();

        int hash = hash(key);
        MyHashNode<K, V> head = chainArray[hash];

        boolean isKeyExist = false;
        for (MyHashNode<K, V> n = head; n != null; n = n.next) {
            if (n.key.equals(key)) {
                isKeyExist = true;
                n.value = value;
                break;
            }
        }

        if (!isKeyExist)
            add_verified_node(key, value);
    }

    private void add_verified_node(K key, V value){
        MyHashNode<K, V> newNode = new MyHashNode<>(key, value);
        int hash = hash(newNode.key);
        newNode.next = chainArray[hash]; // Ничего если head = null
        chainArray[hash] = newNode;
        sizes[hash]++;
    }

    public void increaseLogic(){
        int max = Integer.MIN_VALUE;
        for(int i: sizes)
            if(i > max) max = i;

        if(max > M){ // Такой себе квадрат
            int prevM = M;
            MyHashNode<K, V>[] prevChainArray = chainArray;

            M = (int) (M * 1.5d);
            // Why we should use only odd M?
            if(M % 2 == 0) M++; 

            sizes = new int[M];

            chainArray = new MyHashNode[M];

            for(int k=0; k < prevM; k++)
                for(MyHashNode<K, V> n = prevChainArray[k]; n != null; n = n.next)
                    add_verified_node(n.key, n.value);
        }
    }

    public V get(K key) {
        int hash = hash(key);
        MyHashNode<K, V> head = chainArray[hash];
        while (head != null) {
            // базовый случай прерывания - прошли по всем node-ам
            if (head.key.equals(key)) {
                // цикл прерывается из-за совпадения ключей. !head не null!
                break;
            }
            // Здесь head больше не head
            head = head.next;
        }
        return head != null ? head.value : null;
    }


    public V remove(K key) {
        int hash = hash(key);
        MyHashNode<K, V> head = chainArray[hash];
        V removed = null;

        if (head == null) {
            System.out.println("List is empty. No such key.");
        } 
        else if (head.key.equals(key)) {
            removed = head.value;
            chainArray[hash] = head.next;
        } 
        else { 
            // У нас нет prev, приходится использовать node.next.next
            // head = prev
            while (head.next != null) {
                // Сложноватая логика
                // head -> head.next -> head.next.next
                if (head.next.key.equals(key)) {
                    removed = head.next.value;
                    head.next = head.next.next;
                    break;
                }
                head = head.next;
            }
        }

        if (removed != null)
            sizes[hash]--;

        return removed;
    }

    /**
     * Разными способами написал contains
     */

    public boolean containsV(V value) {
        for (int i = 0; i < M; i++) {
            MyHashNode<K, V> head = chainArray[i];
            while (head != null) {
                if (head.value.equals(value)) {
                    return true;
                }
                head = head.next;
            }
        }
        return false;
    }

    public boolean containsK(K key) {
        for (int i = 0; i < M; i++)
            for (MyHashNode<K, V> head = chainArray[i]; head != null; head = head.next)
                if (head.key.equals(key))
                    return true;
        return false;
    }


    public K getKey(V value) {
        K key = null;
        for (int i = 0; i < M; i++) {
            MyHashNode<K, V> head = chainArray[i];
            while (head != null) {
                if (head.value.equals(value)) {
                    key = head.key;
                    break;
                }
                head = head.next;
            }
        }
        return key;
    }


    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            sb.append(i).append(":");
            MyHashNode<K, V> head = chainArray[i];
            while (head != null) {
                sb.append(head).append(", ");
                head = head.next;
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public int[] sizes() {
        return sizes;
    }
}