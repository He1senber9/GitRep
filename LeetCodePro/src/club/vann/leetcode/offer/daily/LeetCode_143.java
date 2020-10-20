package club.vann.leetcode.offer.daily;

import club.vann.leetcode.common.ListNode;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>难度：Medium</p>
 * <p>题目：重排链表</p>
 * <p>描述：给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 *
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 *
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 * 通过次数42,731提交次数75,007
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: LeetCodePro
 * @description:
 * @author: vann
 * @create: 2020-10-20 08:38
 **/
public class LeetCode_143 {
    public static void main(String[] args) {
        LeetCode_143 leetCode = new LeetCode_143();

        ListNode result = null;
        leetCode.reorderList(TestCase.NODE);
        leetCode.reorderList(TestCase.NODE1);

        System.out.println("Success");
    }

    /**
     * 解法一：
     *
     * @param head
     */
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) {
            return;
        }

        LinkedList<ListNode> linkedList = new LinkedList<>();
        ListNode curNode = head.next;
        while(curNode != null) {
            ListNode node = curNode;
            linkedList.offer(curNode);
            curNode = curNode.next;
            node.next = null;
        }

        int flag = 0;
        curNode = head;
        while(!linkedList.isEmpty()) {
            ListNode node = null;
            node = (flag % 2 == 0) ? linkedList.pollLast() : linkedList.pollFirst();
            curNode.next = node;
            flag ++;
            curNode = curNode.next;
        }
    }

    static class TestCase {
        public static ListNode NODE = ListNode.deserialize("[1,2,3,4]");
        public static ListNode NODE1 = ListNode.deserialize("[1,2,3,4,5]");
    }
}
