package Ass3.BST;

class Test {
    public static void main(String[] args) {
        MyBST<Double, Integer> bst = new MyBST<>();
        bst.put(5d, 5);
        bst.put(6d, 6);
        bst.put(4d, 4);
        bst.put(3d, 3);
        bst.put(7d, 7);
        bst.put(5.5d, 55);
        bst.put(6.5d, 65);
        bst.put(6.8d, 68);
        bst.put(4.5d, 45);

//        bst.put(3d, 3);
//        bst.put(4d, 4);
//        bst.put(4.5d, 45);
//        bst.put(5d, 5);
//        bst.put(5.5d, 55);
//        bst.put(6d, 6);
//        bst.put(6.5d, 65);
//        bst.put(6.8d, 68);
//        bst.put(7d, 7);

        System.out.println(bst);
        System.out.println();

//        bst.delete(4.5d);
//        bst.delete(3d);
//        bst.delete(4d);
//        bst.delete(6d);
        bst.delete(5d);
//        bst.delete(6.5d);
//        bst.delete(6.8d);
//        bst.delete(7d);
//        bst.delete(5.5d);

//        MyQueue<MyBST.MyBSTNode<Double, Integer>> queue = bst.BST2Queue();
//        int n = queue.size();
//        for(int i=0; i<n; i++)
//            System.out.println(queue.dequeue());
        System.out.println(bst);

//        for(double d: bst){
//            System.out.println(d);
//        }

        System.out.println(bst.get(5d));
        System.out.println(bst.get(5.5d));
//        System.out.println(bst.get(2d));

//        System.out.println(bst);


    }
}
