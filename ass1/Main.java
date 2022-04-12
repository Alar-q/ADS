package Ass1;

public class Main {
    public static void main(String[] args) {
//        MyLinkedList<Integer> list = new MyLinkedList<>();
        MyArrayList<Integer> list = new MyArrayList<>();

        list.add(3);
        list.add(2);
        list.add(1, 2);

        list.sort();

        for(int i=0; i<list.size(); i++){
            System.out.println(i + " " + list.get(i));
        }

    }
}
