package club.vann.leetcode.offer.daily;

import club.vann.leetcode.common.ListNode;

import java.util.Stack;

/**
 * <p>难度：Medium</p>
 * <p>题目：翻转链表II</p>
 * <p>描述：反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * 通过次数107,425提交次数204,788
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @author vann
 * @program GitRep
 * @description
 * @date 2021-03-06:11:15:22
 */
public class LeetCode_92 {
    public static void main(String[] args) {
        LeetCode_92 leetCode = new LeetCode_92();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.reverseBetween(TestCase.HEAD, TestCase.M, TestCase.N));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.reverseBetween(TestCase.HEAD1, TestCase.M1, TestCase.N1));
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 虚拟头节点
        ListNode node0 = new ListNode(0);
        node0.next = head;
        ListNode pre = node0;

        for(int i = 0; i < left-1; i ++) {
            pre = pre.next;
        }

        ListNode cur = pre.next;
        ListNode next = null;
        for(int i = left; i < right; i ++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }

        return node0.next;
    }

    private ListNode reverse(ListNode cur, int k) {
        return null;
    }

    static class TestCase {
        public static ListNode ANS = ListNode.deserialize("[1,4,3,2,5]");
        public static ListNode HEAD = ListNode.deserialize("[1,2,3,4,5]");
        public static int M = 2;
        public static int N = 4;

        public static ListNode ANS1 = ListNode.deserialize("[5]");
        public static ListNode HEAD1 = ListNode.deserialize("[5]");
        public static int M1 = 1;
        public static int N1 = 1;
    }
}
