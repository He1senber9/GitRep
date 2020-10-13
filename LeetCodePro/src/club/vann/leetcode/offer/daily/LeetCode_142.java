package club.vann.leetcode.offer.daily;

import club.vann.leetcode.common.ListNode;

/**
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/10/10
 * Time: 8:42
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_142 {
    public static void main(String[] args) {
        LeetCode_142 leetCode = new LeetCode_142();

        ListNode node = null;

        node = TestCase.LISTNODE1();
//        System.out.println("Result[] : " + leetCode.detectCycle(TestCase.LISTNODE));
        System.out.println("Result[] : " + leetCode.detectCycle(TestCase.LISTNODE1()));
    }

    public ListNode detectCycle(ListNode head) {
        if(head == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;

        while(fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }

        return null;
    }

    static class TestCase {
        public static ListNode LISTNODE = ListNode.deserialize("[-21,10,17,8,4,26,5,35,33,-7,-16,27,-12,6,29,-12,5,9,20,14,14,2,13,-24,21,23,-21,5]");
        public static ListNode LISTNODE1() {
            ListNode head = new ListNode(3);

            ListNode node2 = new ListNode(2);
            head.next = node2;
            ListNode node0 = new ListNode(0);
            node2.next = node0;
            ListNode node4 = new ListNode(4);
            node0.next = node4;
            node4.next = node2;

            return head;
        }
    }
}
