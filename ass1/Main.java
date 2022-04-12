package Ass1;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.add(3);
        list.add(2);
        list.add(1);

        System.out.println(list.remove(1));

        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }

    }
}
