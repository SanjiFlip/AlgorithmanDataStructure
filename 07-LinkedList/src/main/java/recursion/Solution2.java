package recursion;

import leetcode.ListNode;

/**
 * @ClassName leetcode.Solution
 * @Description TODO 力扣203题移出链表中的元素  运用递归解决问题  递归调用是有代价的:函数调用+系统栈空间
 * @Author wangyi
 * @Date 2020/12/10 21:50
 * @Version 1.0.0
 **/
public class Solution2 {

    public ListNode removeElements(ListNode head, int val) {
        // 判断基本问题
        if (head == null) {
            return null;
        }
        // 递归 取到下一个元素 第一种做法
//        ListNode res = removeElements(head.next,val);
//        if(head.val == val){
//            return res;
//        }else {
//            head.next = res;
//            return head;
//        }

        // 递归 第二种做法
        head.next = removeElements(head.next, val);
        // 节点删除的关键代码>>>>>>>
        return head.val == val ? head.next : head;

    }

    // 调试用的
    public ListNode removeElements2(ListNode head, int val, int depth) {

        String depthString = generateDepthString(depth);

        System.out.print(depthString);
        System.out.println("Call: remove " + val + " in " + head);
        if (head == null) {
            System.out.print(depthString);
            System.out.println("Return: " + head);
            return head;
        }
        ListNode res = removeElements2(head.next, val, depth + 1);
        System.out.print(depthString);
        System.out.println("After remove " + val + ": " + res);
        ListNode ret;
        if (head.val == val) {
            ret = res;
        } else {
            head.next = res;
            ret = head;
        }
        System.out.print(depthString);
        System.out.println("Return: " + ret);
        return ret;

    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(arr);
        System.out.println(head);


//        ListNode listNode3 = new Solution2().removeElements(head, 6);

        ListNode listNode3 = new Solution2().removeElements2(head, 6, 0);
        System.out.println(listNode3);

    }

}
