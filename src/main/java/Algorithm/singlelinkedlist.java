package Algorithm;

import java.util.Iterator;
import java.util.function.Consumer;

public class singlelinkedlist implements Iterable<Integer> {
    @Override
    public Iterator<Integer> iterator() {
        Iterator iterator = new Iterator() {
            Node node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public Object next() {
                int value = node.nodevalue;
                node = node.nextnode;
                return value;
            }
        };
        return iterator;
    }
    /*
    链表是元素的线性集合，每一个元素都指向下一个元素，数组中的元素是连续存储的，但是链表中的元素不是连续存储的
    单向链表：每个元素只知道下一个元素是什么，最后一个指向null
    双向链表：每个元素直到上一个和下一个元素是什么，第一个最后一个有一个指向null
    循环链表：跟单向链表一样，不同的是最后一个指向第一个，不指向null
    head-> 1->3 ->......->100->tail： 这是链表中的哨兵节点，不存储数据，通常用作头尾

    链表的元素不知道自己的index，只能从头向后数，才能直到某个节点的index，时间复杂度为O(n)
      x
      /\
   1-2  3-4-5-6

     */


    //create a single node
    private static class Node {
        private int nodevalue;
        private Node nextnode;

        Node(int nodevalue, Node nextnode) {
            this.nextnode = nextnode;
            this.nodevalue = nodevalue;
        }
    }

    private Node head = null;

    public void addfirst(int value) {
        Node n = new Node(value, head);
        head = n;
    }

    //iterator linkedlist
    public void iteratelinkedlist(Consumer<Integer> consumer) {
        Node pointer = head;
        while (pointer != null) {
//            System.out.println(pointer.nodevalue);
//            pointer = pointer.nextnode;
            consumer.accept(pointer.nodevalue);
            pointer = pointer.nextnode;
        }
    }

    public void forloop() {
        for (Node node = head; node != null; node = node.nextnode) {
            System.out.print(node.nodevalue + " ");
        }
    }


    //addlast
    public void addlast(int value) {
        Node node = head;
        if (head == null) {
            addfirst(value);
        } else {
            while (true) {
                if (node.nextnode != null) {
                    node = node.nextnode;
                } else {
                    Node nodelast = new Node(value, null);
                    node.nextnode = nodelast;
                    break;
                }
            }
        }
    }


    public int get(int index) throws IllegalAccessException {
        int i = 0;
        for (Node node = head; node != null; node = node.nextnode) {
            if (i != index) {
                i++;
            } else {
                return node.nodevalue;
            }
        }
        throw new IllegalAccessException(String.format("index: %d", index, "is illegal!"));
    }


    public void insert(int index, int value) throws IllegalAccessException {
        Node node = head;
        int i = 0;
        if (index == 0) {
            Node newnode = new Node(value, head);
            head = newnode;
        } else {
            for (node = head; node != null; node = node.nextnode) {
                if (i == index - 1) {
                    Node newnode = new Node(value, null);
                    Node node1 = node.nextnode;
                    node.nextnode = newnode;
                    newnode.nextnode = node1;
                    return;
                } else {
                    i++;
                }
            }
            throw new IllegalAccessException(String.format("index is out of bound"));
        }
    }


    public void removeFirst() throws IllegalAccessException {
        if (head == null) {
            throw new IllegalAccessException(String.format("the linkedlist is null"));
        } else {
            Node node = head.nextnode;
            head = node;
        }
    }


    //must rewrite to find the bug
    public void removeindex(int index) throws IllegalAccessException {
        Node node = head;
        if (node == null) {
            throw new IllegalAccessException(String.format("this is a null"));
        } else {
            if (index == 0) {
                removeFirst();
                return;
            }
            int i = 0;
            while (node != null) {
                if (i == index - 1) {
                    Node node1 = node.nextnode;// should be deleted
                    if (node1.nextnode == null) {
                        node.nextnode = null;
                        return;
                    } else {
                        Node node2 = node1.nextnode;//should be connected
                        node1.nextnode = null;
                        node.nextnode = node2;
                        return;
                    }
                } else {
                    i++;
                }
                node = node.nextnode;
            }
            throw new IllegalAccessException(String.format("index %d out of bound", index));
        }
    }


    //leetcode-> search for the middle node in a linkedlist
    public Node searchMiddleNode(Node node) {
        if (node == null) {
            return node;
        }
        Node front = node;
        Node aft = node;
        while (aft != null&&aft.nextnode!=null) {
            aft = aft.nextnode;
            aft = aft.nextnode;
            front=front.nextnode;
        }
        return front;
    }




}
