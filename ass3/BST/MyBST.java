package Ass3.BST;

import java.util.Iterator;


public class MyBST<K extends Comparable<K>, V> implements Iterable<K>{

    private MyBSTNode<K, V> root;


    public void put(K key, V value) {
        MyBSTNode<K, V> newNode = new MyBSTNode<>(key, value);
        if (root == null) {
            root = newNode;
        } else {
            MyBSTNode<K, V> r = root;
            while (r != null) { // r никогда не null
                // Что на счет случая, если key==r.key? Вставляем справа
                if (key.compareTo(r.key) < 0) {
                    if (r.left == null) {
                        r.left = newNode;
                        break;
                    } else {
                        r = r.left;
                    }
                } else {
                    if (r.right == null) {
                        r.right = newNode;
                        break;
                    } else {
                        r = r.right;
                    }
                }
            }
        }
    }


    public V get(K key){
        MyBSTNode<K, V> node = getNode(key);
        return node != null ? node.value : null;
    }

    private MyBSTNode<K, V> getNode(K key){
        if (root == null) {
            System.out.println("BST is empty");
        }
        else {
            MyBSTNode<K, V> r = root;
            while (r != null) {
                if(r.key.equals(key))
                    return r;
                r = key.compareTo(r.key) < 0 ? r.left : r.right;
            }
        }
        return null;
    }


    public boolean delete(K key) {
        if (root == null) {
            System.out.println("BST is empty");
            return false;
        }

        MyBSTNode<K, V> parent = null, node = null;

        MyBSTNode<K, V> r = root;
        while (r != null) {
            if (r.key.equals(key)) {
                node = r;
                break;
            }
            parent = r;
            r = key.compareTo(r.key) < 0 ? r.left : r.right;
        }

        if (node == null) {
            System.out.println("No such key " + key);
            return false;
        }
        else if (parent == null) {
            deleteRoot();
        }
        // Если два чилда = нул
        else if (node.left == null && node.right == null) {
            parent.swapChild(key, null);
        }
        // Если один из чилдов = нул
        else if (node.left == null) {
            parent.swapChild(key, node.right);
        }
        else if (node.right == null) {
            parent.swapChild(key, node.left);
        }
        else { // оба есть
            MyBSTNode<K, V> lm = getLeftmost(node.right);

            parent.swapChild(key, lm);

            lm.left = node.left;
            if (lm != node.right) {
                node.right.left = lm.right;
                lm.right = node.right;
            }
        }

        return true;
    }

    private void deleteRoot(){
        if(root.left == null && root.right == null){
            root = null;
        }
        // Если один из чилдов = нул
        else if(root.left == null){
            root = root.right;
        }
        else if(root.right == null) {
            root = root.left;
        }
        else{ // оба есть
            MyBSTNode<K, V> lm = getLeftmost(root.right);

            lm.left = root.left;
            if(lm != root.right) {
                root.right.left = lm.right;
                lm.right = root.right;
            }

            root = lm;
        }
    }


    private MyBSTNode<K, V> getLeftmost(MyBSTNode<K, V> root_node){
        MyBSTNode<K, V> res = root_node;
        while(res.left != null){
            res = res.left;
        }
        return res;
    }
    private MyBSTNode<K, V> getRightmost(MyBSTNode<K, V> root_node){
        MyBSTNode<K, V> res = root_node;
        while(res.right != null){
            res = res.right;
        }
        return res;
    }

    public V getMin(){
        if(root==null) return null;
        return getLeftmost(root).value;
    }
    public V getMax(){
        if(root==null) return null;
        return getRightmost(root).value;
    }


    @Override
    public String toString(){
        if(root == null)
            return "BST is empty";
        return draw(root, 1);
    }

    public String draw(MyBSTNode<K, V> node, int order){
        String res = "";
        String indent = "";
        for(int i=0; i<order; i++) indent += "|    ";

        res += node.toString() + "\n";

        if(node.right != null)
            res += indent +"r"+ draw(node.right, order+1) ;

        if(node.left != null)
            res += indent +"l"+ draw(node.left, order+1) ;

        return res;
    }

    @Override
    public Iterator<K> iterator() {
        return new MyBSTIterator(root);
    }
}
