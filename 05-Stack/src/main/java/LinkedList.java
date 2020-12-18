/**
 * @ClassName LinkedList
 * @Description TODO 链表 链表知识  ---->>>>> 需要学习07-LinkedList链表知识
 * @Author wangyi
 * @Date 2020/12/9 18:59
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

    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
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

    public void addFirst(E e) {
        add(0, e);
    }

    // 在链表的index(0-based)位置添加新的元素e
    // 在链表中不是一个常用的操作，练习用 :）
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed,Illegal index.");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;
        prev.next = new Node(e, prev.next);
        size++;

    }

    // 在链表末添加一个元素
    public void addLast(E e) {
        add(size, e);
    }

    // 获得链表的滴inde（0-based）个位置的元素
    // 在链表中不是一个常用的操作:)
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed,Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    // 获得链表中的第一个元素
    public E getFirst() {
        return get(0);
    }

    // 获得链表中的最后一个元素
    public E getLast() {
        return get(size - 1);
    }

    // 修改链表中的第index（0-based）个位置的元素为e
    // 在链表中不是一个常用的操作，练习用 :)
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Update failed,Illegal index.");
        }

        Node cur = dummyHead.next;

        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;

    }

    // 查找链表中是否有元素e
    public boolean contain(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    // 修改链表中的第index（0-based）个位置的元素为e
    // 在链表中不是一个常用的操作，练习用 :)
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Remove failed,Illegal index.");
        }
        // 实例化待删除元素的前一个元素
        Node prev = dummyHead;
        // 迭代出待删除的前一个元素
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        // 获取待删除的元素
        Node retNode = prev.next;
        // index-1 这个节点指向 index+1这个节点
        // 待删除的前一个节点指向删除节点的下一个界面
        prev.next = retNode.next;
        retNode.next = null;
        size--;
        return retNode.e;
    }

    // 从链表中删除第一个元素，返回删除的元素
    public E removeFirst() {
        return remove(0);
    }

    // 从链表中删除最后一个元素，返回删除的元素
    public E removeLast() {
        return remove(size - 1);
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
//        Node cur = dummyHead.next;
//        while (cur != null) {
//            res.append(cur + "->");
//            cur = cur.next;
//        }
        for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
            res.append(cur + "->");
        }
        res.append("NULL");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.removeFirst();
        System.out.println(linkedList);
    }

}
