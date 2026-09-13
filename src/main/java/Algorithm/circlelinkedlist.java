package Algorithm;

import java.lang.foreign.AddressLayout;
import java.util.Iterator;

public class circlelinkedlist implements Iterable<Integer> {


    @Override
    public Iterator<Integer> iterator() {
        Iterator iterator = new Iterator() {
            Node pointer = sentinel.nextNode;

            @Override
            public boolean hasNext() {
                return pointer != sentinel;
            }

            @Override
            public Object next() {
                int value = pointer.value;
                pointer = pointer.nextNode;
                return value;
            }
        };
        return iterator;
    }


    private class Node {
        private Node previousNode;
        private int value;
        private Node nextNode;

        Node(Node previousNode, int value, Node nextNode) {
            this.previousNode = previousNode;
            this.value = value;
            this.nextNode = nextNode;
        }
    }

    private Node sentinel = new Node(null, 111, null);

    public Node getSentinel() {
        return sentinel;
    }
    public Node getSentinelNext() {
        return sentinel.nextNode;
    }

    public circlelinkedlist() {
        sentinel.previousNode = sentinel;
        sentinel.nextNode = sentinel;
    }


    public void addFirst(int value) {
        Node aft = sentinel.nextNode;// when there is no element except sentinel, then aft=sentinel
        Node inseted = new Node(sentinel, value, aft);
        sentinel.nextNode = inseted;
        aft.previousNode = inseted;
    }

    public void addLast(int value) {
        Node pre = sentinel.previousNode;
        Node inseted = new Node(pre, value, sentinel);
        sentinel.previousNode = inseted;
        pre.nextNode = inseted;
    }

    public void removeFirst() throws IllegalAccessException {
        Node removed = sentinel.nextNode;
        if (removed == sentinel) {
            throw new IllegalAccessException(String.format("illegal!"));
        } else {
            Node realNext = removed.nextNode;
            sentinel.nextNode = realNext;
            realNext.previousNode = sentinel;
            removed.previousNode = null;
            removed.nextNode = null;
        }
    }

    public void removeLast() throws IllegalAccessException {
        Node removed = sentinel.previousNode;
        if (removed == sentinel) {
            throw new IllegalAccessException(String.format("illegal!"));
        } else {
            Node realprevious = removed.previousNode;
            sentinel.previousNode = realprevious;
            realprevious.nextNode = sentinel;
            removed.previousNode = null;
            removed.nextNode = null;
        }
    }

    public void removeByValue(int value) throws IllegalAccessException {
        Node pointer = sentinel.nextNode;
        if (pointer == sentinel) {//pointer will never be null, because it is circlelinkedlist
            throw new IllegalAccessException(String.format("illegal!!"));
        }
        for (pointer = sentinel.nextNode; pointer != sentinel; pointer = pointer.nextNode) {
            if (pointer.value == value) {
                Node pre = pointer.previousNode;
                Node aft = pointer.nextNode;
                pointer.nextNode = null;
                pointer.previousNode = null;
                pre.nextNode = aft;
                aft.previousNode = pre;
                return;
            }
        }
    }

    public Node findByValue(int value) throws IllegalAccessException {
        Node pointer = sentinel.nextNode;
        if (pointer == sentinel) {
            return null;
        }
        for (pointer = sentinel.nextNode; pointer != sentinel; pointer = pointer.nextNode) {
            if (pointer.value == value) {
                return pointer;
            }
        }
        return null;
    }


    public void recursion(Node node) {
        if (node == sentinel) return;
        System.out.print(node.value+" ");
        recursion(node.nextNode);
    }


}
