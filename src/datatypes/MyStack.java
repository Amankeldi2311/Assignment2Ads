package datatypes;

import lists.MyList;

public class MyStack<T extends Comparable<T>> {
    // The MyStack class should have a single field of type MyList<T> called list.
    private final MyList<T> list;

    public MyStack(MyList<T> list) {
        this.list = list;
    }

    public void push(T element) {
        list.addLast(element);
    }

    public T pop() {
        T element = list.getLast();
        list.removeLast();
        return element;
    }

    public T get() {
        return list.getLast();
    }

    public int size() {
        return list.size();
    }
}
