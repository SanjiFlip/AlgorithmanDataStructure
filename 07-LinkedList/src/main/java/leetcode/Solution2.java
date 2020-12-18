package leetcode;

/**
 * @ClassName Solution2
 * @Description TODO 力扣206 链表的反转 ，非递归的实现
 * @Author 17803
 * @Date 2020/12/11 17:13
 * @Version 1.0.0
 **/
public class Solution2 {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            // 获取到下一个节点 等会赋值给我们的当前节点
            ListNode next = cur.next;
            // 直接抛弃这个空间，把他后面的定义为空
            cur.next = pre;
            // 定义前一个节点
            pre = cur;
            // 重新给当前节点赋值
            cur = next;
        }
        return pre;
    }



}
