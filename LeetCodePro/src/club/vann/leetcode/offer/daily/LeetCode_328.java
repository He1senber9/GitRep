package club.vann.leetcode.offer.daily;

import club.vann.leetcode.common.ListNode;

import java.util.LinkedList;

/**
 * <p>难度：Medium</p>
 * <p>题目：奇偶链表</p>
 * <p>描述：给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 *
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 *
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 * 通过次数65,531提交次数102,185
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/odd-even-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: LeetCodePro
 * @description:
 * @author: vann
 * @create: 2020-11-13 09:59
 **/
public class LeetCode_328 {
    public static void main(String[] args) {
        LeetCode_328 leetCode = new LeetCode_328();

        System.out.println(leetCode.oddEvenList(TestCase.NODE));
        System.out.println(leetCode.oddEvenList(TestCase.NODE1));
        System.out.println(leetCode.oddEvenList(TestCase.NODE2));
    }

    /**
     * 解法一
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode newHead = head;
        ListNode partNode = head.next;

        LinkedList<ListNode> linkedList = new LinkedList<>();
        ListNode node = partNode.next;
        while(node != null) {
            linkedList.add(node);
            node = node.next;
        }

        int flag = 1;
        ListNode left = newHead;
        left.next = null;
        ListNode right = partNode;
        right.next = null;
        while(!linkedList.isEmpty()) {
            ListNode temp = linkedList.pollFirst();
            temp.next = null;

            if(flag == 1) {
                left.next = temp;
                left = left.next;
            } else {
                right.next = temp;
                right = right.next;
            }

            flag = flag * -1;
        }

        left.next = partNode;
        return newHead;
    }

    static class TestCase {
        public static ListNode NODE = ListNode.deserialize("[1,2,3,4,5]");
        public static ListNode NODE1 = ListNode.deserialize("[2,1,3,5,6,4,7]");
        public static ListNode NODE2 = ListNode.deserialize("[1,2,3]");
    }
}
