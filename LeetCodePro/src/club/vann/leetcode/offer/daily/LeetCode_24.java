package club.vann.leetcode.offer.daily;

import club.vann.leetcode.common.ListNode;

/**
 * <p>难度：Medium</p>
 * <p>题目：两两交换链表中的节点</p>
 * <p>描述：给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *  
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * 通过次数165,649提交次数245,965
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: LeetCodePro
 * @description:
 * @author: vann
 * @create: 2020-10-13 12:03
 **/
public class LeetCode_24 {
    public static void main(String[] args) {
        LeetCode_24 leetCode = new LeetCode_24();

        ListNode result = null;
        result = leetCode.swapPairs(TestCase.NODE);
        result = leetCode.swapPairs(TestCase.NODE1);
        result = leetCode.swapPairs(TestCase.NODE2);
        result = leetCode.swapPairs(TestCase.NODE3);
        result = leetCode.swapPairs(TestCase.NODE4);
    }

    /**
     * 解法一：
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode pre = new ListNode(0);
        pre.next = head;

        helper(pre);
        return pre.next;
    }

    private ListNode helper(ListNode pre) {
        if(pre == null || pre.next == null || pre.next.next == null) {
            return null;
        }

        ListNode node1 = pre.next;
        ListNode node2 = node1.next;

        node1.next = node2.next;
        node2.next = node1;
        pre.next = node2;

        helper(node1);

        return node2;
    }

    static class TestCase {
        public static ListNode NODE = ListNode.deserialize("[1,2,3,4]");
        public static ListNode NODE1 = ListNode.deserialize("[1,2,3,4,5]");
        public static ListNode NODE2 = ListNode.deserialize("[1]");
        public static ListNode NODE3 = ListNode.deserialize("[1,2]");
        public static ListNode NODE4 = ListNode.deserialize("[1,2,3]");
    }
}
