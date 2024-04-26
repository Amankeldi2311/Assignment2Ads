

import lists.MyArrayList;
import lists.MyLinkedList;
import lists.MyList;

public class Main {

    public static void main(String[] args) {
        MyList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
        myArrayList.add(5);
        myArrayList.add(6);
        System.out.println("Value at index 3: " + myArrayList.get(3));
    }
    public static void test() {
        MyList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(4);
        myLinkedList.add(8);
        myLinkedList.add(9);
        myLinkedList.add(12);
        System.out.println("Value at index 4: " + myLinkedList.get(4));
    }
}
