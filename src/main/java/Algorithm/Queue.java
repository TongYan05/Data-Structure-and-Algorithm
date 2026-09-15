package Algorithm;

import javax.swing.text.StyledEditorKit;

public interface Queue<E> {

    // 向队尾插入值
    // Params: value - 待插入值
    // Returns: 插入成功返回 true, 插入失败返回 false
    boolean offer(E value);

    // 从对头获取值, 并移除
    // Returns: 如果队列非空返回对头值, 否则返回 null
    E poll();

    // 从对头获取值, 不移除
    // Returns: 如果队列非空返回对头值, 否则返回 null
    E peek();

    // 队列是否为空
    // Returns: 空返回 true, 否则返回 false
    boolean isEmpty();

    boolean Full();
}
