import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName QueueToStack
 * @Description TODO 用队列实现栈    ---->>>>>   这个需要学习完06-Queue队列后来实现这个
 * @Author wangyi
 * @Date 2020/12/10 19:24
 * @Version 1.0.0
 **/
public class QueueToStack {

    private Queue<Integer> queue;

    /** Initialize your data structure here. */
    public QueueToStack() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        // 创建另外一个队列 q2
        Queue<Integer> q2 = new LinkedList<>();

        // 除了最后一个元素，将 q 中的所有元素放入 q2
        while (queue.size() > 1) {
            q2.add(queue.remove());
        }

        // q 中剩下的最后一个元素就是“栈顶”元素
        int ret = queue.remove();

        // 此时 q2 是整个数据结构存储的所有其他数据，赋值给 q
        queue = q2;

        // 返回“栈顶元素”
        return ret;
    }

    /** Get the top element. */
    public int top() {
        //一旦我们实现了 pop，实现 top 就简单了。我们可以复用我们已经实现的 pop，将栈顶元素拿出来，记录下来，作为返回值。然后因为 top 不会删除元素，我们再将这个值放进队列就好了。
        int ret = pop();
        push(ret);
        return ret;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }

}
