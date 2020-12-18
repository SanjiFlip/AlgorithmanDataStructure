package leetcode;

import java.util.List;

/**
 * @ClassName leetcode.Solution
 * @Description TODO 力扣203题移出链表中的元素
 * @Author wangyi
 * @Date 2020/12/10 21:50
 * @Version 1.0.0
 **/
public class Solution {

    public ListNode removeElements(ListNode head, int val) {
        // 删除头结点
        while (head != null && head.val == val) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }
        // 如果里面所有的元素都是val，head为空了
        if (head == null) {
            return null;
        }

        // 删除链表中间的元素为val的
        // prev一定不是我们需要删除的节点
        ListNode prev = head;
        while (prev.next != null) {
            // 如果prev的下一个节点是我们要删除的节点
            if (prev.next.val == val) {
                // prev的下一个节点就是我们要删除的节点
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else {
                // 如果没有需要删除的，我们需要向下移动节点
                prev = prev.next;
            }
        }
        return head;
    }

    // 可以优化，内存会自动释放
    public ListNode removeElements2(ListNode head, int val) {
        // 删除头结点
        while (head != null && head.val == val) {
            head = head.next;
        }
        // 如果里面所有的元素都是val，head为空了
        if (head == null) {
            return null;
        }

        // 删除链表中间的元素为val的
        // prev一定不是我们需要删除的节点
        ListNode prev = head;
        while (prev.next != null) {
            // 如果prev的下一个节点是我们要删除的节点
            if (prev.next.val == val) {
                // prev的下一个节点就是我们要删除的节点
                prev.next = prev.next.next;

            } else {
                // 如果没有需要删除的，我们需要向下移动节点
                prev = prev.next;
            }
        }
        return head;
    }


    // 使用虚拟头结点来操作我们的链表 简化逻辑处理
    public ListNode removeElements3(ListNode head, int val) {

        // 使用虚拟头结点
        ListNode dummyHead = new ListNode(-10);
        dummyHead.next = head;
        // 不需要对头结点特殊处理了
        ListNode prev = dummyHead;
        while (prev.next != null) {
            // 如果prev的下一个节点是我们要删除的节点
            if (prev.next.val == val) {
                // prev的下一个节点就是我们要删除的节点
                prev.next = prev.next.next;

            } else {
                // 如果没有需要删除的，我们需要向下移动节点
                prev = prev.next;
            }
        }
        // 返回虚拟头结点的下一个节点
        return dummyHead.next;
    }


    public static void main(String[] args) {

        int[] arr = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(arr);
        System.out.println(head);

//        ListNode listNode = new Solution().removeElements(head, 6);
//        System.out.println(listNode);

//        ListNode listNode2 = new Solution().removeElements(head, 6);
//        System.out.println(listNode2);

        ListNode listNode3 = new Solution().removeElements(head, 6);
        System.out.println(listNode3);

    }

}
