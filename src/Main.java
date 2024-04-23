

import lists.MyArrayList;
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
}