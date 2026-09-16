package Algorithm;                      // 声明本类所在的包，与目录结构对应

import java.util.Iterator;              // 导入 JDK 的迭代器接口，供 iterator() 使用

// 基于链表实现的泛型队列：同时实现自定义 Queue 接口和 Iterable 接口（支持 for-each 遍历）
public class LinkedListQueue<E> implements Queue<E>, Iterable<E> {

    // 实现 Iterable 接口：返回一个能按"队头 -> 队尾"顺序遍历元素的迭代器
    @Override
    public Iterator<E> iterator() {
        // 用匿名内部类创建一个迭代器对象
        Iterator<E> iterator = new Iterator<E>() {
            // 游标 pointer 从哨兵节点的下一个（即第一个真实元素）开始
            Node<E> pointer = head.next;

            // 判断是否还有下一个元素：游标没绕回哨兵 head 就说明还没遍历完
            @Override
            public boolean hasNext() {
                return pointer != head;   // 尾节点的 next 指回 head，形成环，绕回即结束
            }

            // 取当前元素并把游标后移一位
            @Override
            public E next() {
                E value = pointer.value;  // 先记下当前节点存的元素值
                pointer = pointer.next;   // 游标移动到下一个节点
                return value;             // 返回刚才记下的值
            }
        };
        return iterator;                  // 把创建好的迭代器交给调用方
    }

    // 链表节点的内部类：每个节点存一个元素值和一条指向下一节点的链接
    private static class Node<E> {
        E value;                          // 节点承载的数据（泛型 E）
        Node<E> next;                     // 指向链表中下一个节点的引用

        // 构造方法：一次性指定节点的值和后继指针
        public Node(E value, Node<E> next) {
            this.value = value;           // 把传入的值赋给本节点
            this.next = next;             // 把传入的后继节点赋给 next 指针
        }
    }

    // ---------- 队列的核心字段 ----------
    private Node<E> head = new Node<>(null, null);
                                        // 哨兵节点（哑节点）：本身不存有效数据(value=null)
                                        // head.next 永远指向队头元素
    private Node<E> tail = head;        // tail 指向队尾元素；初始时队列为空，tail 指回 head
    private int size;                   // 当前队列中元素的个数，默认 0
    private int capacity;               // 队列最大容量，超过则无法再入队


    // 带容量参数的构造方法：创建一个指定容量的空队列
    public LinkedListQueue(int capacity) {
        this.capacity = capacity;       // 记录容量上限
        tail.next = head;               // 关键：让哨兵自己的 next 指回自己，形成环，
                                        // 这样空队列时尾节点也能绕回 head（迭代器靠它判断结束）
    }

    // 无参构造方法：默认容量设为 int 的最大值，相当于"无限容量"
    public LinkedListQueue() {
        this(Integer.MAX_VALUE);        // 调用上面的有参构造，避免漏写 capacity 初始化（此前 bug 根源）
    }

    // 入队：把元素插到队尾，成功返回 true，队满返回 false
    @Override
    public boolean offer(E value) {
        if(Full()){                     // 先检查队列是否已满
            return false;               // 满了就拒绝插入，返回失败
        }
        Node<E> added = new Node<>(value, head);
                                        // 新建节点：值为 value，next 指向哨兵 head
                                        // （保证新尾节点的 next 永远绕回 head，维持环形）
        tail.next = added;              // 把原尾节点的 next 由 head 改指向新节点，新节点正式接入链表
        tail = added;                   // 更新队尾指针：新节点成为新的 tail
        size++;                         // 元素个数加一
        return true;                    // 返回入队成功
    }

    // 出队：移除并返回队头元素，队空时返回 null
    @Override
    public E poll() {
        if (isEmpty()) {                // 先判断队列是否为空
            return null;                // 空队列没有元素可取，返回 null
        } else {
            Node<E> first = head.next;  // first 指向真正的队头节点（哨兵的下一个）
            head.next = first.next;     // 让哨兵跳过 first，直接指向第二个节点，first 即被移出链表
            if (first == tail) {        // 如果弹出的是队列里最后一个元素
                tail = head;            // 队列变空，必须把 tail 退回哨兵，
                                        // 否则 isEmpty() 会永远为 false（此前 bug 之二）
            }
            size--;                     // 元素个数减一
            return first.value;         // 返回被移除节点存储的值
        }
    }

    // 队头查询：只看不取，返回队头元素但不移除
    @Override
    public E peek() {
        if (isEmpty()) {                // 队列为空
            return null;                // 没有队头，返回 null
        } else {
            return head.next.value;     // 返回哨兵下一个节点（即队头）的值，不改动任何指针
        }
    }

    // 判空：哨兵和队尾指向同一个节点，说明中间没有任何真实元素，队列为空
    @Override
    public boolean isEmpty() {
        return head == tail;            // 注意比较的是引用（节点对象），不是值
    }

    // 判满：元素个数达到容量上限即视为满
    @Override
    public boolean Full() {
        return size==capacity;          // size 与 capacity 相等时返回 true
    }
}
