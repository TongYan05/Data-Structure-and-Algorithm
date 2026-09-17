package Algorithm;

import java.util.Iterator;
// have problem!!!!
public class ArrayQueue<E> implements Queue<E>, Iterable<E> {

    private E[] array;
    private int head = 0;
    private int tail = 0;

    ArrayQueue() {
        int capacity = 0;
        array = (E[]) new Object[capacity + 1];
    }


    @Override
    public boolean offer(E value) {
        if (isEmpty()) {
            return false;
        }
        array[tail] = value;
        tail = (tail + 1) % array.length;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E value = array[head];
        head = (1 + head) % array.length;
        return value;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return array[head];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean Full() {
        return (tail + 1) % array.length == head;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> iterator = new Iterator<E>() {
            int pointer = head;

            @Override
            public boolean hasNext() {
                return pointer != tail;
            }

            @Override
            public E next() {
                E v = array[pointer];
                pointer = (1 + pointer) % array.length;
                return v;
            }
        };
        return iterator;
    }
}
