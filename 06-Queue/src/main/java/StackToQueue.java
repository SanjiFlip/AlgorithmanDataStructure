import java.util.Stack;

/**
 * @ClassName StackToQueue
 * @Description TODO 栈实现队列
 * @Author wangyi
 * @Date 2020/12/10 19:26
 * @Version 1.0.0
 **/
public class StackToQueue {

    private Stack<Integer> stack;

    /** Initialize your data structure here. */
    public StackToQueue() {
        stack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        // 创建一个新的 stack2
        Stack<Integer> stack2 = new Stack<>();

        // 将 stack 的元素暂存进 stack2
        while(!stack.empty()) {
            stack2.push(stack.pop());
        }

        // 在 stack 中添加新元素 x
        stack.push(x);

        // 把 stack2 中的元素放回 stack
        while(!stack2.isEmpty()) {
            stack.push(stack2.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack.pop();
    }

    /** Get the front element. */
    public int peek() {
        return stack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }

}
