package leetcode;

/**
 * @ClassName leetcode.ListNode
 * @Description TODO 力扣中的ListNode  帮助测试我们Solution不报错用的
 * @Author wangyi
 * @Date 2020/12/10 21:51
 * @Version 1.0.0
 **/
public class ListNode {

    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
    }

    // 这里让我们的数组转成链表
    // 链表结点的构造函数
    // 使用arr为参数，创建一个链表，当前的ListNode为链表的头结点
    public ListNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("arr can not be empty.");
        }
        this.val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    // 以当前节点的头结点的链表信息字符串
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            res.append(cur.val + "->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
}
