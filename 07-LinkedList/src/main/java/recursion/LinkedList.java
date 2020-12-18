package recursion;

/**
 * @ClassName LinkedList
 * @Description TODO 递归实现链表的增删改查
 * @Author wangyi
 * @Date 2020/12/11 13:51
 * @Version 1.0.0
 **/
public class LinkedList<E> {

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

    private Node head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    // 获取链表中的元素个数
    public int getSize() {
        return size;
    }

    // 返回链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int index, E e) {
        head = add(head, index, e);
        size++;
    }

    // 在以node为头结点的链表的index位置插入元素e，递归算法
    private Node add(Node node, int index, E e) {
        if (index == 0) {
            return new Node(e, node);
        }
        node.next = add(node.next, index - 1, e);
        return node;
    }

}
