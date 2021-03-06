package club.vann.leetcode.offer.daily;

import club.vann.leetcode.common.ListNode;

/**
 * <p>难度：Easy</p>
 * <p>题目：翻转链表</p>
 * <p>描述：反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * 通过次数451,084提交次数630,985
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @author vann
 * @program GitRep
 * @description
 * @date 2021-03-06:11:26:11
 */
public class LeetCode_206 {
    public static void main(String[] args) {
        LeetCode_206 leetCode = new LeetCode_206();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.reverseList(TestCase.HEAD));
    }

    public ListNode reverseList(ListNode head) {
        // 解法一：递归
//        if(head == null || head.next == null) {
//            return head;
//        }
//
//        ListNode root = reverseList(head.next);
//        head.next.next = head;
//        head.next = null;
//        return root;

        // 解法二：迭代
        if(head == null || head.next == null) {
            return head;
        }

        // 虚拟头节点
        ListNode temp = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = temp;

            temp = cur;
            cur = next;
        }

        return temp;
    }

    static class TestCase {
        public static ListNode ANS = ListNode.deserialize("[5,4,3,2,1]");
        public static ListNode HEAD = ListNode.deserialize("[1,2,3,4,5]");
    }
}
