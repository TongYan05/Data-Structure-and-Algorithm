package Algorithm;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueue {

        public static void main(String[] args) throws Exception {

            // 1. 创建一个容量为3的有界阻塞队列（基于数组实现）
            // 容量只有3，放第4个元素时就会触发"满队列"的阻塞逻辑
            java.util.concurrent.BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);

            // ==================== 插入操作（4种方式对比） ====================

            // 方式1：add() —— 队列满时直接抛异常
            queue.add("苹果");  // 成功，返回true（底层调用offer）
            queue.add("香蕉");  // 成功
            queue.add("橘子");  // 成功，此时队列已满 [苹果, 香蕉, 橘子]
            // queue.add("葡萄");  // 如果取消注释，会抛出 IllegalStateException: Queue full

            // 方式2：offer() —— 队列满时返回false，不抛异常
            boolean result = queue.offer("葡萄");  // 返回false，因为队列满了
            System.out.println("offer结果：" + result);  // 输出：false

            // 方式3：offer(e, timeout, unit) —— 超时阻塞，超时后返回false
            // 尝试放入"葡萄"，最多等2秒，2秒后还是没空位就放弃
            boolean timeoutResult = queue.offer("葡萄", 2, TimeUnit.SECONDS);
            System.out.println("超时offer结果：" + timeoutResult);  // 输出：false

            // 方式4：put() —— 队列满时无限阻塞，直到有空位（最常用）
            // 这里我们注释掉，后面用多线程演示

            // ==================== 取出操作（4种方式对比） ====================

            // 方式1：remove() —— 队列空时直接抛异常
            String r1 = queue.remove();  // 返回"苹果"，队列变为 [香蕉, 橘子]
            System.out.println("remove取出：" + r1);

            // 方式2：poll() —— 队列空时返回null，不抛异常
            String r2 = queue.poll();  // 返回"香蕉"
            System.out.println("poll取出：" + r2);
            queue.poll();  // 返回"橘子"，此时队列已空
            String r3 = queue.poll();  // 返回null，因为队列空了
            System.out.println("空队列poll结果：" + r3);  // 输出：null

            // 方式3：poll(timeout, unit) —— 超时阻塞，超时后返回null
            // 队列已空，尝试取元素，等2秒后还是没数据就放弃
            String r4 = queue.poll(2, TimeUnit.SECONDS);
            System.out.println("超时poll结果：" + r4);  // 输出：null

            // 方式4：take() —— 队列空时无限阻塞，直到有数据（最常用）
            // 这里我们也用多线程演示

            // ==================== 检查操作（2种方式） ====================
            queue.add("西瓜");
            queue.add("哈密瓜");

            // element() —— 只看队首不移除，队列空时抛异常
            String e1 = queue.element();  // 返回"西瓜"，队列不变
            System.out.println("element查看队首：" + e1);

            // peek() —— 只看队首不移除，队列空时返回null
            String e2 = queue.peek();  // 返回"西瓜"
            System.out.println("peek查看队首：" + e2);

            // ==================== 多线程演示 put() 和 take() 的阻塞效果 ====================
            System.out.println("\n===== 开始多线程演示 =====");
            java.util.concurrent.BlockingQueue<Integer> mq = new ArrayBlockingQueue<>(2);  // 容量为2

            // 生产者线程：不断往队列里放数据
            Thread producer = new Thread(() -> {
                for (int i = 1; i <= 5; i++) {
                    try {
                        System.out.println("生产者准备放入：" + i);
                        mq.put(i);  // 队列满时（超过2个），这里会阻塞等待消费者取走
                        System.out.println("生产者成功放入：" + i + "，当前队列大小：" + mq.size());
                        Thread.sleep(500);  // 模拟生产耗时
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "生产者");

            // 消费者线程：不断从队列里取数据
            Thread consumer = new Thread(() -> {
                for (int i = 1; i <= 5; i++) {
                    try {
                        Integer data = mq.take();  // 队列空时，这里会阻塞等待生产者放入
                        System.out.println("消费者成功取出：" + data + "，当前队列大小：" + mq.size());
                        Thread.sleep(1000);  // 模拟消费耗时（比生产慢，所以生产者会阻塞）
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "消费者");

            producer.start();
            consumer.start();

            // 等待两个线程执行完毕
            producer.join();
            consumer.join();
            System.out.println("===== 演示结束 =====");
        }



        java.util.concurrent.BlockingQueue<Integer> blockingQueue=new java.util.concurrent.BlockingQueue<Integer>() {
            @Override public boolean add(Integer i) { return false; }
            @Override public boolean offer(Integer i) { return false; }
            @Override public void put(Integer i) throws InterruptedException {}
            @Override public boolean offer(Integer i, long t, TimeUnit u) throws InterruptedException { return false; }
            @Override public Integer take() throws InterruptedException { return 0; }
            @Override public Integer poll(long t, TimeUnit u) throws InterruptedException { return 0; }
            @Override public int remainingCapacity() { return 0; }
            @Override public boolean remove(Object o) { return false; }
            @Override public boolean contains(Object o) { return false; }
            @Override public int drainTo(Collection<? super Integer> c) { return 0; }
            @Override public int drainTo(Collection<? super Integer> c, int m) { return 0; }
            @Override public Integer remove() { return 0; }
            @Override public Integer poll() { return 0; }
            @Override public Integer element() { return 0; }
            @Override public Integer peek() { return 0; }
            @Override public int size() { return 0; }
            @Override public boolean isEmpty() { return false; }
            @Override public Iterator<Integer> iterator() { return null; }
            @Override public Object[] toArray() { return new Object[0]; }
            @Override public <T> T[] toArray(T[] a) { return null; }
            @Override public boolean containsAll(Collection<?> c) { return false; }
            @Override public boolean addAll(Collection<? extends Integer> c) { return false; }
            @Override public boolean removeAll(Collection<?> c) { return false; }
            @Override public boolean retainAll(Collection<?> c) { return false; }
            @Override public void clear() {}
        };




}
