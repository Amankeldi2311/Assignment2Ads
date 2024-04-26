package lists;

import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {
    //   The number of elements in the list
    private int size;
    //    The array to store the elements
    private T[] arr;

    //    Constructor to initialize the array with a given size
    public MyArrayList(int size) {
        arr = (T[]) new Object[size];
        this.size = 0;
    }

    //    Default constructor to initialize the array with a default size of 10
    public MyArrayList() {
        this(10);
    }

    //    Add an element to the end of the list
    @Override
    public void add(T item) {
        if (size >= arr.length) {
            increaseSize();
        }
        arr[size++] = item;


    }

    //    Set the element at a given index
    @Override
    public void set(int index, T item) {
        checkIndex(index);
        arr[index] = item;
    }

    //   Add an element at a given index
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

    //    Add an element to the beginning of the list
    @Override
    public void addFirst(T item) {
        add(0, item);

    }

    //    Add an element to the end of the list
    @Override
    public void addLast(T item) {
        add(size - 1, item);

    }

    //    Gets the element at a given index
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

    //    Removes the element at a given index
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

    // it is a bubble sort algorithm
    @Override
    public void sort() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (((Comparable<T>) arr[j]).compareTo(arr[j + 1]) > 0) {
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

    }

    //    Returns the index of the first occurrence of the element in the list
    @Override
    public int indexOf(T item) {
        for (int i = 0; i < size; i++)
            if (item.equals(arr[i])) return i;
        return -1;
    }

    //    Returns the index of the last occurrence of the element in the list
    @Override
    public int lastIndexOf(T item) {
        for (int i = size - 1; i >= 0; i--)
            if (item.equals(arr[i])) return i;
        return -1;
    }

    @Override
    public boolean exists(T item) {
        return indexOf(item) != -1;
    }

    //    Returns an array representation of the list
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

    // Iterator to iterate over the elements of the list
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

