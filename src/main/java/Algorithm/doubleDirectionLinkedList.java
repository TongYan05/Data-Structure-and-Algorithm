package Algorithm;

import com.sun.jdi.Value;
import com.sun.source.tree.WhileLoopTree;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.lang.classfile.Attribute;
import java.nio.channels.UnsupportedAddressTypeException;
import java.time.Year;
import java.util.HexFormat;
import java.util.Iterator;
import java.util.Map;

public class doubleDirectionLinkedList implements Iterable<Integer> {

    @Override
    public Iterator<Integer> iterator() {
        Iterator iterator = new Iterator() {
            Node target = head.nextNode;

            @Override
            public boolean hasNext() {
                return target != tail;
            }

            @Override
            public Object next() {
                int value = target.value;
                target = target.nextNode;
                return value;
            }
        };
        return iterator;
    }

    private static class Node {
        private Node previousNode;
        private int value;
        private Node nextNode;

        Node(Node previousNode, int value, Node nextNode) {
            this.previousNode = previousNode;
            this.value = value;
            this.nextNode = nextNode;
        }
    }

    private Node head;
    private Node tail;


    //构造方法，创建实例的时候自动生成了Node构造器
    public doubleDirectionLinkedList() {
        head = new Node(null, 111, null);
        tail = new Node(null, 222, null);
        head.nextNode = tail;
        tail.previousNode = head;
    }


    //start writing a series of methods below

    private Node findNode(int index) {
        int i = -1;
        Node node = head;
        while (node != null) {
            if (i == index) {
                return node;
            }
            i++;
            node = node.nextNode;
        }
        return null;
    }

    public void addFirst(int value) throws IllegalAccessException {
        insert(value, 0);
    }

    public void insert(int value, int index) throws IllegalAccessException {
        Node aft = findNode(index);
        if (aft == null) {
            throw new IllegalAccessException(String.format("插入位置越界：index 非法"));
        }else {
            Node pre = aft.previousNode;
            if(pre==null){
                throw new IllegalAccessException(String.format("插入位置越界：index 非法"));
            }else {
                Node node = new Node(null, value, null);
                pre.nextNode = node;
                node.previousNode = pre;
                aft.previousNode = node;
                node.nextNode = aft;
            }
        }
    }


    public void removeFirst() throws IllegalAccessException {
        remove(0);
    }

    public void remove(int index) throws IllegalAccessException {
        Node pre = findNode(index - 1);
        Node target = findNode(index);
        Node aft = findNode(index + 1);
        if (pre == null || aft == null) {
            throw new IllegalAccessException(String.format("it is null"));
        } else {
            pre.nextNode = aft;
            aft.previousNode = pre;
            target.previousNode = null;
            target.nextNode = null;
        }
    }


    public void addLast(int value) {
        Node inserted = new Node(null, value, null);
        Node pre = tail.previousNode;
        pre.nextNode = inserted;
        inserted.previousNode = pre;
        inserted.nextNode = tail;
        tail.previousNode = inserted;
    }

    public void removeLast() throws IllegalAccessException {
        Node removed = tail.previousNode;
        if (removed == head) {
            throw new IllegalAccessException(String.format("it is null"));
        }
        Node pre = removed.previousNode;
        removed.previousNode = null;
        removed.nextNode = null;
        pre.nextNode = tail;
        tail.previousNode = pre;
    }


    public void removeindex(int index) throws IllegalAccessException {
        Node removed = findNode(index);
        Node pre = removed.previousNode;
        Node aft = removed.nextNode;
        if (removed == head || removed == tail) {
            throw new IllegalAccessException(String.format("it is illegal!!"));
        } else {
            removed.previousNode = null;
            removed.nextNode = null;
            pre.nextNode = aft;
            aft.previousNode = pre;
        }
    }


}
