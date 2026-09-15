package Algorithm;

import java.util.Iterator;

public class LinkedListQueue<E> implements Queue<E>, Iterable<E> {

    @Override
    public Iterator<E> iterator() {
        Iterator<E> iterator = new Iterator<E>() {
            Node<E> pointer = head.next;

            @Override
            public boolean hasNext() {
                return pointer != head;
            }

            @Override
            public E next() {
                E value = pointer.value;
                pointer = pointer.next;
                return value;
            }
        };
        return iterator;
    }

    private static class Node<E> {
        E value;
        Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node<E> head = new Node<>(null, null);
    private Node<E> tail = head;
    private int size;
    private int capacity;


    public LinkedListQueue(int capacity) {
        this.capacity = capacity;
        tail.next = head;
    }

    public LinkedListQueue() {
        tail.next = head;
    }

    @Override
    public boolean offer(E value) {
        if(Full()){
            return false;
        }
        Node<E> added = new Node<>(value, head);
        tail.next = added; // tail added head(null)
        tail = added;// added head
        size++;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        } else {
            Node<E> first = head.next;
            head.next = first.next;
            if (head.next == tail) {
                head.next = tail;
            }
            size--;
            return first.value;
        }
    }

    @Override
    public E peek() {// get the first element's value
        if (isEmpty()) {
            return null;
        } else {
            return head.next.value;
        }
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean Full() {
        return size==capacity;
    }
}
