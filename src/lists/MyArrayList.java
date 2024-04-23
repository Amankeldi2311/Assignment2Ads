package lists;

import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {
    private int size;
    private T[] arr;

    public MyArrayList(int size) {
        arr = (T[]) new Object[size];
        this.size = 0;
    }

    public MyArrayList() {
        this(10);
    }

    @Override
    public void add(T item) {
        if (size == arr.length) {
            increaseSize();
        }
        arr[size++] = item;


    }

    @Override
    public void set(int index, T item) {
        checkIndex(index);
        arr[index] = item;


    }

    @Override
    public void add(int index, T item) {
        checkIndex(index);
        if (size == arr.length) {
            increaseSize();
        }
        for (int i = size; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = item;
        size++;

    }

    @Override
    public void addFirst(T item) {
        add(0, item);

    }

    @Override
    public void addLast(T item) {
        add(size - 1, item);

    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return arr[index];
    }

    @Override
    public T getFirst() {
        return arr[0];
    }

    @Override
    public T getLast() {
        return arr[size - 1];
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;

    }

    @Override
    public void removeFirst() {
        remove(0);

    }

    @Override
    public void removeLast() {
        remove(size - 1);

    }

    @Override
    public void sort() {

    }

    @Override
    public int indexOf(T item) {
        for (int i = 0; i < size; i++)
            if (item.equals(arr[i]))
                return i;
        return -1;
    }

    @Override
    public int lastIndexOf(T item) {
        for (int i = size - 1; i >= 0; i--)
            if (item.equals(arr[i]))
                return i;
        return -1;
    }

    @Override
    public boolean exists(T item) {
        return indexOf(item) != -1;
    }

    @Override
    public T[] toArray() {
        T[] newArr = (T[]) new Object[size];
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    @Override
    public void clear() {
        size = 0;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr(0);
    }

    private class Itr implements Iterator<T> {
        int cursor;

        public Itr(int cursor) {
            this.cursor = cursor;
        }

        @Override
        public boolean hasNext() {
            return size > cursor;
        }

        @Override
        public T next() {
            return arr[cursor++];
        }
    }

    private void increaseSize() {
        T[] newArr = (T[]) new Object[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;


    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }
}
