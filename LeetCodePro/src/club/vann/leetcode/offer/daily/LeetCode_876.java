package club.vann.leetcode.offer.daily;

import club.vann.leetcode.common.ListNode;

/**
 * <p>难度：Easy</p>
 * <p>题目：链表的中间结点</p>
 * <p>描述：给定一个带有头结点 head 的非空单链表，返回链表的中间结点。如果有两个中间结点，则返回第二个中间结点。
 *
 * 示例 1：
 *
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
 * 示例 2：
 *
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 *
 *
 * 提示：
 *
 * 给定链表的结点数介于 1 和 100 之间。
 * 通过次数33,694提交次数50,822</p>
 *
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/3/23
 * Time: 9:32
 * Description:
 */
public class LeetCode_876 {
    public static void main(String[] args) {
        ListNode node = null;
        ListNode result = null;
        LeetCode_876 leetCode = new LeetCode_876();

        node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        result = leetCode.middleNode(node);
        System.out.println("Result[3] " + result.val);

        node = new ListNode(1);
        node2 = new ListNode(2);
        node3 = new ListNode(3);
        node4 = new ListNode(4);
        node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        result = leetCode.middleNode(node);
        System.out.println("Result[4] " + result.val);

        node = new ListNode(1);
        node2 = new ListNode(2);
        node.next = node2;
        result = leetCode.middleNode(node);
        System.out.println("Result[2] " + result.val);

        node = new ListNode(1);
        result = leetCode.middleNode(node);
        System.out.println("Result[1] " + result.val);
    }

    private ListNode middleNode(ListNode head) {
        if(head == null) {
            return null;
        }

        ListNode curNode = head;
        ListNode result = curNode;

        int mid = 0;
        int last = 0;
        while(curNode != null) {
            if(mid != (last+1)/2) {
                result = result.next;
                mid = (last+1)/2;
            }
            curNode = curNode.next;
            last ++;
        }
        return result;
    }
}
