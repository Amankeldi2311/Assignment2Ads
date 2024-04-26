package datatypes;

import lists.MyList;

public class MyQueue<T> {
    private final MyList<T> list;

    public MyQueue(MyList<T> list) {
        this.list = list;
    }

    public void push(T element) {
        list.addFirst(element);
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
