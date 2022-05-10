package Ass3.BST;

class MyBSTNode<K extends Comparable<K>, V> implements Comparable<MyBSTNode<K, V>> {
    protected K key;
    protected V value;

    protected MyBSTNode<K, V> left, right;

    protected MyBSTNode(K key, V value){
        this.key = key;
        this.value = value;
    }

    protected void swapChild(K childskey, MyBSTNode<K, V> node){
        if(left != null && left.key.equals(childskey))
            left = node;
        else if(right != null && right.key.equals(childskey))
            right = node;
        else System.out.println("No child with that key " + childskey);
    }

    @Override
    public String toString(){
        return "{" + key + ", " + value +  "}";
    }

    @Override
    public int compareTo(MyBSTNode<K, V> o) {
        return key.compareTo(o.key);
    }
}
