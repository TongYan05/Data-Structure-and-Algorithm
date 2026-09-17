package Algorithm;

import java.util.*;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;

public class Stack_Queue_LinkedList {


    /*
| 数据结构 | 推荐创建方式 | 说明 |
| Stack (栈) | `Deque<Integer> stack = new ArrayDeque<>();` | 推荐用 `ArrayDeque` 模拟栈，效率高于 `Stack` 类 |
| Queue (队列) | `Queue<Integer> queue = new LinkedList<>();` | 标准队列，FIFO（先进先出） |
| Deque (双端队列) | `Deque<Integer> deque = new ArrayDeque<>();` | 队头队尾都能操作，常用于单调队列或滑动窗口 |
| Linked List (链表) | `ListNode head = new ListNode(0);` | 需自定义节点类，面试常考反转、合并等操作 |

    for Queue
    //toArray(),size(),equal(),remove(),remove(Object c),removeAll(Collection c),addAll(Collection c)
    //isEmpty(),peek(),poll(),retainAll(Collection c),add(element),containsAll(Collection c),offer(element),contains(element),clear()

    for Stack
    //poll(),peek(),remove(),offer(),getFirst(),getLast(),add(),addAll(Collection c),removeAll(Collection c),retainAll(Collection c)
    //containsAll(Collection c),size(),isEmpty(),toArray(),constainsAll(Collection c)
     */




//    static void main(String[] args) {
//        Deque<String> deque1 = new ArrayDeque<>();
//
//
//        Queue<String> queue = new LinkedList<>();//toArray(),size(),equal(),remove(),remove(Object c),removeAll(Collection c),addAll(Collection c)
//        //isEmpty(),peek(),poll(),retainAll(Collection c),add(element),containsAll(Collection c),offer(element),contains(element),clear()
//        System.out.println(queue.size()+" "+queue.isEmpty());
//        System.out.println(queue.add("java")+" "+queue.add("python")+" "+queue.add("julia")+" "+queue.add("TypeSript"));//add return the boolean
//        System.out.println(queue);
//        System.out.println(queue.remove("python"));// remove can remove any elements do not care their position in the queue
//        System.out.println(queue);
//        System.out.println(queue.toArray());
//        System.out.println(Arrays.toString(queue.toArray()));
//        System.out.println(queue.contains("julia")+" "+queue.contains("python"));
//        List<String> list=new LinkedList<>();
//        list.add("java");list.add("TypeSript");list.add("julia");
//        System.out.println(queue.containsAll(list));
//        List<String> list1=new LinkedList<>();
//        list1.add("javaaaaaaaaa");list1.add("TypeSriptttttttttt");
//        System.out.println(queue.addAll(list1));
//        System.out.println(queue);
//        System.out.println(queue.removeAll(list1));
//        System.out.println(queue);
////        System.out.println(queue.retainAll(list1));
////        System.out.println(queue);
////        queue.clear();
////        System.out.println("after clear: "+queue);
//        System.out.println(queue.equals(list));// the order should be the same while compare!!
//        System.out.println(queue);
//        System.out.println(queue.offer("yan tong"));
//        System.out.println(queue);
//        System.out.println(queue.remove());// remove the first element
//        System.out.println(queue);
//        System.out.println(queue.peek());
//        System.out.println(queue);
//        System.out.println(queue.poll());// compared to remove() -> poll will return the value it removed
//        System.out.println(queue);
//    }

    Queue<String> queue1 = new Queue<>() {
        @Override
        public int size() {return 0;}
        @Override
        public boolean isEmpty() {return false;}
        @Override
        public boolean contains(Object o) {return false;}
        @Override
        public Iterator<String> iterator() { return null;}////////////
        @Override
        public Object[] toArray() {return new Object[0];}
        @Override
        public <T> T[] toArray(T[] a) {return null;}//////////////
        @Override
        public boolean add(String string) {return false;}
        @Override
        public boolean remove(Object o) {return false;}
        @Override
        public boolean containsAll(Collection<?> c) {return false;}
        @Override
        public boolean addAll(Collection<? extends String> c) {return false;}
        @Override
        public boolean removeAll(Collection<?> c) { return false;}
        @Override
        public boolean retainAll(Collection<?> c) {return false;}
        @Override
        public void clear() {}
        @Override
        public boolean equals(Object o) {return false;}
        @Override
        public int hashCode() {  return 0;}////////////////
        @Override
        public boolean offer(String string) { return false;}
        @Override
        public String remove() { return "";}
        @Override
        public String poll() {     return "";}
        @Override
        public String element() {   return "";}///////////////////
        @Override
        public String peek() { return "";}
    };
//
//    static void main(String[] args) {
//        Deque<Integer> deque=new ArrayDeque<>();
//        deque.add(1);deque.add(2);deque.add(3);deque.add(4);
//        deque.offer(5);deque.offer(6);deque.offer(7);deque.offer(8);
//        deque.addFirst(0);deque.addFirst(-1);
//        deque.addLast(9);deque.addLast(10);
//        System.out.println(deque.remove(1)+" "+deque.removeFirst()+" "+deque.removeLast());
//        System.out.println(deque.add(11));
//        System.out.println(deque);
//        System.out.println(deque.offerFirst(0)+" "+deque.offerLast(12));
//        System.out.println(deque);
//        System.out.println(deque.offer(13)+" "+deque.offerLast(14)+" "+deque.offerFirst(-1));
//        System.out.println(deque);
//        System.out.println(deque.getFirst()+" "+deque.getLast()+" "+deque.peek()+" "+deque.peekFirst()+" "+" "+deque.peekLast()+" ");
//        System.out.println(deque);
//        System.out.println(deque.poll()+" "+deque.pollFirst()+" "+deque.pollLast());
//        System.out.println(deque);
//    }




    Deque<String> deque = new Deque<>() {
            @Override public void addFirst(String string) {}
            @Override public void addLast(String string) {}
            @Override public boolean offerFirst(String string) { return false; }
            @Override public boolean offerLast(String string) { return false; }
            @Override public String removeFirst() { return ""; }
            @Override public String removeLast() { return ""; }
            @Override public String pollFirst() { return ""; }
            @Override public String pollLast() { return ""; }
            @Override public String getFirst() { return ""; }
            @Override public String getLast() { return ""; }
            @Override public String peekFirst() { return ""; }
            @Override public String peekLast() { return ""; }
            @Override public boolean removeFirstOccurrence(Object o) { return false; }
            @Override public boolean removeLastOccurrence(Object o) { return false; }
            @Override public boolean add(String string) { return false; }
            @Override public boolean offer(String string) { return false; }
            @Override public String remove() { return ""; }
            @Override public String poll() { return ""; }
            @Override public String element() { return ""; }/////////////
            @Override public String peek() { return ""; }
            @Override public boolean addAll(Collection<? extends String> c) { return false; }
            @Override public boolean removeAll(Collection<?> c) { return false; }
            @Override public boolean retainAll(Collection<?> c) { return false; }
            @Override public void clear() {}
            @Override public boolean equals(Object o) { return false; }
            @Override public int hashCode() { return 0; }
            @Override public void push(String string) {}
            @Override public String pop() { return ""; }
            @Override public boolean remove(Object o) { return false; }
            @Override public boolean containsAll(Collection<?> c) { return false; }
            @Override public boolean contains(Object o) { return false; }
            @Override public int size() { return 0; }
            @Override public boolean isEmpty() { return false; }
            @Override public Iterator<String> iterator() { return null; }
            @Override public Object[] toArray() { return new Object[0]; }
            @Override public <T> T[] toArray(T[] a) { return null; }
            @Override public Iterator<String> descendingIterator() { return null; }
        };


    static void main(String[] args) {
        PriorityQueue<String> p=new PriorityQueue<>();
        List<String> list=new ArrayList<>();
        list.add("d");list.add("e");list.add("f");list.add("g");
        p.add("c");p.add("b");p.add("a");
        System.out.println(p.poll());
        System.out.println(p.poll());
        System.out.println(p.poll());
//        System.out.println(p.addAll(list) );
//        System.out.println(p);
//        System.out.println(p.offer("f"));
//        System.out.println(p.peek()+" "+p.poll());
//        System.out.println(p);
//        System.out.println(p.contains("c")+" "+p.containsAll(list)+" "+p.retainAll(list));
//        System.out.println(p);
//        System.out.println(p.removeAll(list));
//        System.out.println(p);

    }

    PriorityQueue<String> pq = new PriorityQueue<>() {
        @Override public boolean add(String string) { return false; }
        @Override public boolean offer(String string) { return false; }
        @Override public String remove() { return ""; }
        @Override public String poll() { return ""; }
        @Override public String element() { return ""; }
        @Override public String peek() { return ""; }
        @Override public boolean remove(Object o) { return false; }
        @Override public void clear() {}
        @Override public boolean contains(Object o) { return false; }
        @Override public int size() { return 0; }
        @Override public boolean isEmpty() { return false; }
        @Override public Iterator<String> iterator() { return null; }
        @Override public Object[] toArray() { return new Object[0]; }
        @Override public <T> T[] toArray(T[] a) { return null; }
        @Override public boolean addAll(Collection<? extends String> c) { return false; }
        @Override public boolean containsAll(Collection<?> c) { return false; }
        @Override public boolean removeAll(Collection<?> c) { return false; }
        @Override public boolean retainAll(Collection<?> c) { return false; }
        @Override public boolean equals(Object o) { return false; }
        @Override public int hashCode() { return 0; }
        @Override public Comparator<? super String> comparator() { return null; }
    };











}
