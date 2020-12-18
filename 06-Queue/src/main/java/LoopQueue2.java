/**
 * @ClassName LoopQueue
 * @Description TODO 循环队列  不浪费空间用法
 * @Author wangyi
 * @Date 2020/12/8 19:41
 * @Version 1.0.0
 **/
public class LoopQueue2<E> implements Queue<E> {

    private E[] data;

    private int front, tail;

    private int size;

    public LoopQueue2(int capacity) {
        data = (E[]) new Object[capacity];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue2() {
        this(10);
    }

    public int getCapacity() {
        // 因为循环队列需要浪费一个空间 （tail + 1）% capacity == front 队列满了
        return data.length;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        // 注意，我们不再使用front和tail之间的关系来判断队列是否为空，而直接使用size
        return size == 0;
    }

    // 入队操作
    @Override
    public void enqueue(E e) {
        // 注意，我们不再使用front和tail之间的关系来判断队列是否为满，而直接使用size
        if (size == getCapacity()) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue form an empty queue.");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        // 判断容量是否需要缩容，判断容量不为空
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
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
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");
        // 注意，我们的循环遍历打印队列的逻辑也有相应的更改 :-)
        for (int i = front; i < size; i++) {
            res.append(data[(front + i) % data.length]);
            if ((i + front + 1) % data.length != tail) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LoopQueue2<Integer> queue = new LoopQueue2<>();
        for (int i = 0; i < 11; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            // 取余
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }

}
