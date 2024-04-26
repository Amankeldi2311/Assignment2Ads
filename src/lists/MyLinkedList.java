package lists;

import java.util.Iterator;

public class MyLinkedList<T extends Object & Comparable<T>> implements MyList<T> {
    //The number of elements in the list
    private int size;
    //  The head node of the list
    private Node<T> head;
    //  The tail node of the list
    private Node<T> tail;

    //    Constructor to initialize the list
    public MyLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    // Adds am elemet to the end of the list
    @Override
    public void add(T item) {
        Node<T> newNode = new Node<>(item);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;


    }

    // sets the element at a given index
    @Override
    public void set(int index, T item) {
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.data = item;

    }

    // Adds an element at a given index
    @Override
    public void add(int index, T item) {
        Node<T> newNode = new Node<>(item);
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next.prev = newNode;
        current.next = newNode;
        newNode.prev = current;
        size++;


    }

    // Adds an element to the beginning of the list
    @Override
    public void addFirst(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        size++;

    }

    // Adds an element to the end of the list
    @Override
    public void addLast(T item) {
        Node<T> newNode = new Node<>(item);
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        size++;

    }

    //    Gets the element at a given index
    @Override
    public T get(int index) {
        checkIndex(index);
        Node<T> node = head;
        while (--index != 0 && node.next != null)
            node = node.next;
        return node.data;
    }


    @Override
    public T getFirst() {
        return head.data;
    }

    @Override
    public T getLast() {
        return tail.data;
    }

    //    Removes the element at a given index and shifts the elements to the left
    @Override
    public void remove(int index) {
        checkIndex(index);
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.prev.next = current.next;
        current.next.prev = current.prev;
        size--;

    }

    //    Removes the first element in the list
    @Override
    public void removeFirst() {
        head = head.next;
        head.prev = null;
        size--;

    }

    //    Removes the last element in the list
    @Override
    public void removeLast() {
        tail = tail.prev;
        tail.next = null;
        size--;

    }

    //   Sorts the list in ascending order
    @Override
    public void sort() {
        for (int i = 0; i < size; i++) {
            Node<T> current = head;
            for (int j = 0; j < size - 1; j++) {
                if (current.data.compareTo(current.next.data) > 0) {
                    T temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                }
                current = current.next;
            }
        }

    }

    //    Returns the index of the first occurrence of the element in the list
    @Override
    public int indexOf(T item) {
        Node<T> current = head;
        for (int i = 0; i < size; i++) {
            if (current.data.equals(item)) return i;
            current = current.next;
        }
        return -1;
    }

    //    Returns the index of the last occurrence of the element in the list
    @Override
    public int lastIndexOf(T item) {
        Node<T> current = tail;
        for (int i = size - 1; i >= 0; i--) {
            if (current.data.equals(item)) return i;
            current = current.prev;
        }
        return -1;
    }

    @Override
    public boolean exists(T item) {
        return indexOf(item) != -1;
    }

    //    Returns the list as an array
    @Override
    public T[] toArray() {
        T[] arr = (T[]) new Object[size];
        Node<T> current = head;
        for (int i = 0; i < size; i++) {
            arr[i] = current.data;
            current = current.next;
        }
        return arr;
    }

    //    Clears the list
    @Override
    public void clear() {
        size = 0;
        head = null;
        tail = null;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iter<>(head);
    }

    //    Node class to represent the elements in the list
    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    //    Iterator class to iterate over the elements of the list
    public static class Iter<T> implements Iterator<T> {
        private Node<T> current;

        //        Constructor to initialize the iterator
        public Iter(Node<T> head) {
            current = head;
        }

        //        Checks if there is a next element in the list
        public boolean hasNext() {
            return current != null;
        }

        //        Returns the next element in the list
        public T next() {
            T data = current.data;
            current = current.next;
            return data;
        }
    }

    //    Checks if the index is within the bounds of the list
    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index must be between 0 and " + size);
    }
}