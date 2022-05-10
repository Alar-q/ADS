package Ass3.BST;

import Ass3.DataStruct.MyQueue;
import java.util.Iterator;

class MyBSTIterator<K extends Comparable<K>, V> implements Iterator<K> {

    private MyQueue<MyBSTNode<K, V>> queue;
    private MyBSTNode<K, V> root;

    protected MyBSTIterator(MyBSTNode<K, V> root){
        this.root = root;
        queue = BST2Queue();
    }

    @Override
    public boolean hasNext() {
        return queue.size() > 0;
    }

    @Override
    public K next() {
        return queue.dequeue().key;
    }

    private MyQueue<MyBSTNode<K, V>> BST2Queue(){
        MyQueue<MyBSTNode<K, V>> q = new MyQueue<>();
        inorder(root, q);
        return q;
    }

    private void inorder(MyBSTNode<K, V> n, MyQueue<MyBSTNode<K, V>> q) {
        if (n == null)
            return;
        inorder(n.left, q);
        q.enqueue(n);
        inorder(n.right, q);
    }
}
