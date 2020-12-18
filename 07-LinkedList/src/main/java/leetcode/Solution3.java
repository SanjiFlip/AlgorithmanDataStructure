package leetcode;

/**
 * @ClassName Solution2
 * @Description TODO 力扣206 链表的反转 ，递归的实现
 * @Author wangyi
 * @Date 2020/12/11 17:26
 * @Version 1.0.0
 **/
public class Solution3 {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode rev = reverseList(head.next);
        // 反转节点的尾部节点
        head.next.next = head;
        // 当前的一个节点指向为null  不浪费空间
        head.next = null;
        return rev;
    }



}
