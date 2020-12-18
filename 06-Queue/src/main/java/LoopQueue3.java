/**
 * @ClassName LoopQueue
 * @Description TODO 循环队列  没有size成员变量的循环队列
 * @Author wangyi
 * @Date 2020/12/8 19:41
 * @Version 1.0.0
 **/
public class LoopQueue3<E> implements Queue<E> {

    private E[] data;

    private int front, tail;

    public LoopQueue3(int capacity) {
        data = (E[]) new Object[capacity];
        front = 0;
        tail = 0;
    }

    public LoopQueue3() {
        this(10);
    }

    public int getCapacity() {
        // 因为循环队列需要浪费一个空间 （tail + 1）% capacity == front 队列满了
        return data.length - 1;
    }

    @Override
    public int getSize() {
        // 注意此时getSize的逻辑:
        // 如果tail >= front，非常简单，队列中的元素个数就是tail - front
        // 如果tail < front，说明我们的循环队列"循环"起来了，此时，队列中的元素个数为：
        // tail - front + data.length
        // 画画图，看能不能理解为什么？
        //
        // 也可以理解成，此时，data中没有元素的数目为front - tail,
        // 整体元素个数就是 data.length - (front - tail) = data.length + tail - front
        return tail >= front ? tail - front : tail - front + data.length;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    // 入队操作
    @Override
    public void enqueue(E e) {
        // 注意，我们不再使用front和tail之间的关系来判断队列是否为满，而直接使用size
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue form an empty queue.");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        // 判断容量是否需要缩容，判断容量不为空
        if (getSize() == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        return data[front];
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        int sz = getSize();
        for (int i = 0; i < sz; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = sz;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", getSize(), getCapacity()));
        res.append("front [");
        // 注意，我们的循环遍历打印队列的逻辑也有相应的更改 :-)
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            if ((i + 1) % data.length != tail) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LoopQueue3<Integer> queue = new LoopQueue3<>();
        for (int i = 0; i < 11; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            // 取余
//            if (i % 3 == 2) {
//                queue.dequeue();
//                System.out.println(queue);
//            }
        }
    }

}
