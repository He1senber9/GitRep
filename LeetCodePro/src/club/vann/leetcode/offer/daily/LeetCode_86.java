package club.vann.leetcode.offer.daily;

import club.vann.leetcode.common.ListNode;

/**
 * <p>难度：Medium</p>
 * <p>题目：分隔链表</p>
 * <p>描述：给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 *  
 *
 * 示例：
 *
 * 输入：head = 1->4->3->2->5->2, x = 3
 * 输出：1->2->2->4->3->5
 * 通过次数64,758提交次数106,831
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @ClassName LeetCode_86
 * @Description TODO
 * @User fanyu
 * @Date 2021/1/3 9:07
 */
public class LeetCode_86 {
    public static void main(String[] args) {
        LeetCode_86 leetCode = new LeetCode_86();

//        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.partition(TestCase.NODE, TestCase.X));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.partition(TestCase.NODE1, TestCase.X1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.partition(TestCase.NODE2, TestCase.X2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.partition(TestCase.NODE3, TestCase.X3));
        System.out.println("Result["+TestCase.ANS4+"] : " + leetCode.partition(TestCase.NODE4, TestCase.X4));
    }

    /**
     * 解法一：
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        if(head == null) {
            return head;
        }

        ListNode node0 = new ListNode(0);
        node0.next = head;

        ListNode pre = node0;
        while(pre.next != null) {
            ListNode cur = pre.next;
            if(cur.val < x) {
                pre.next = cur.next;
                cur.next = null;

                // 从头开始遍历
                ListNode point = node0;
                while(point.next.val < x && point.next != pre.next) {
                    point = point.next;
                }

                ListNode temp = point.next;
                point.next = cur;
                cur.next = temp;
                pre = cur;
            }
            pre = pre.next;
        }
        return node0.next;
    }

    private ListNode helper(ListNode begin, ListNode end, ListNode node) {
        return null;
    }

    static class TestCase {
        public static ListNode ANS = ListNode.deserialize("[1,2,2,4,3,5]");
        public static ListNode NODE = ListNode.deserialize("[1,4,3,2,5,2]");
        public static int X = 3;

        public static ListNode ANS1 = ListNode.deserialize("[1,4,3,5,4,7,7]");
        public static ListNode NODE1 = ListNode.deserialize("[1,4,3,7,5,4,7]");
        public static int X1 = 7;

        public static ListNode ANS2 = ListNode.deserialize("[1,2,3,4,5,6,7]");
        public static ListNode NODE2 = ListNode.deserialize("[1,2,3,4,5,6,7]");
        public static int X2 = 1;

        public static ListNode ANS3 = ListNode.deserialize("[6,5,4,3,2,1,7]");
        public static ListNode NODE3 = ListNode.deserialize("[7,6,5,4,3,2,1]");
        public static int X3 = 7;

        public static ListNode ANS4 = ListNode.deserialize("[1,2,3,6,5,7,8]");
        public static ListNode NODE4 = ListNode.deserialize("[1,2,3,7,6,5,8]");
        public static int X4 = 7;

        public static ListNode ANS5 = ListNode.deserialize("[2,5,7,4]");
        public static ListNode NODE5 = ListNode.deserialize("[7,5,2,4]");
        public static int X5 = 4;
    }
}
