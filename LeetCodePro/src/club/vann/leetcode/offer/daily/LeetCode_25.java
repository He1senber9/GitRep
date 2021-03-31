package club.vann.leetcode.offer.daily;

import club.vann.leetcode.common.ListNode;

import java.util.List;

/**
 * <p>难度：Hard</p>
 * <p>题目：K 个一组翻转链表</p>
 * <p>描述：给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 进阶：
 *
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 * 示例 2：
 *
 *
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 * 示例 3：
 *
 * 输入：head = [1,2,3,4,5], k = 1
 * 输出：[1,2,3,4,5]
 * 示例 4：
 *
 * 输入：head = [1], k = 1
 * 输出：[1]
 * 提示：
 *
 * 列表中节点的数量在范围 sz 内
 * 1 <= sz <= 5000
 * 0 <= Node.val <= 1000
 * 1 <= k <= sz
 * 通过次数140,698提交次数218,763
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @author vann
 * @program GitRep
 * @description
 * @date 2021-03-06:17:36:26
 */
public class LeetCode_25 {
    public static void main(String[] args) {
        LeetCode_25 leetCode = new LeetCode_25();
        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.reverseKGroup(TestCase.HEAD, TestCase.K));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.reverseKGroup(TestCase.HEAD1, TestCase.K1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.reverseKGroup(TestCase.HEAD2, TestCase.K2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.reverseKGroup(TestCase.HEAD3, TestCase.K3));
    }

    /**
     * 解法一：
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        int size = sizeListNode(head);
        if(k <= 0 || k > size) {
            return head;
        }

        // 虚拟头节点
        ListNode node0 = new ListNode(0);
        node0.next = head;
        ListNode pre = node0;

        // 实际要翻转的链表总长度
        size = size - (size%k);
        for(int i = 0; i < size/k; i ++) {
            ListNode cur = pre.next;
            ListNode next = null;
            for(int j = 0; j < k-1; j ++) {
                next = cur.next;
                cur.next = next.next;
                next.next = pre.next;
                pre.next = next;
            }
            pre = cur;
        }
        return node0.next;
    }

    private int sizeListNode(ListNode node) {
        int size = 0;
        while(node != null) {
            size ++;
            node = node.next;
        }
        return size;
    }

    static class TestCase {
        public static ListNode ANS = ListNode.deserialize("[2,1,4,3,5]");
        public static ListNode HEAD = ListNode.deserialize("[1,2,3,4,5]");
        public static int K = 2;

        public static ListNode ANS1 = ListNode.deserialize("[3,2,1,4,5]");
        public static ListNode HEAD1 = ListNode.deserialize("[1,2,3,4,5]");
        public static int K1 = 3;

        public static ListNode ANS2 = ListNode.deserialize("[1,2,3,4,5]");
        public static ListNode HEAD2 = ListNode.deserialize("[1,2,3,4,5]");
        public static int K2 = 1;

        public static ListNode ANS3 = ListNode.deserialize("[1]");
        public static ListNode HEAD3 = ListNode.deserialize("[1]");
        public static int K3 = 1;
    }
}
