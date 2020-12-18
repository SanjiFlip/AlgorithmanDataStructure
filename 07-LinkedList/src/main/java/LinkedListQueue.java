/**
 * @ClassName LinkedListQueue
 * @Description TODO 基于链表实现队列--->带有尾指针的链表
 * @Author wangyi
 * @Date 2020/12/10 21:19
 * @Version 1.0.0
 **/
public class LinkedListQueue<E> implements Queue<E> {

    // 基于链表实现的队列，也需要结点的定义
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head, tail;

    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        // 第一次入队 头结点和尾部节点都是指向一个位置
        // 如果tail 为空  那么我们的head也为空（尾部没有元素那么头部也没有元素）
        if (tail == null) {
            // 相当于第一次入队操作
            // 先给尾部设置元素
            tail = new Node(e);
            // 头部应用tail地址
            head = tail;
        } else {
            // 如果入队的时候尾部元素不为空
            // 尾部的下一个节点元素指向e
            tail.next = new Node(e);
            // 重新设置尾部节点tail
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        // 出队元素
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue form an empty queue.");
        }
        // 出队操作
        Node retNode = head;
        // 指向下一个节点
        head = head.next;
        // 释放资源
        retNode.next = null;
        // 如果头结点为空，呢么我们的tail也应该置空 相当于出队最后一个元素，最后这个队列为空
        if (head == null) {
            tail = null;
        }
        size --;
        return retNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: front ");
        Node cur = head;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer>  queue = new LinkedListQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i%3==2){
                queue.dequeue();
                System.out.println(queue);
            }

        }

    }

}
