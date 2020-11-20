package club.vann.leetcode.offer.daily;

import club.vann.leetcode.common.ListNode;

/**
 * <p>难度：Medium</p>
 * <p>题目：对链表进行插入排序</p>
 * <p>描述：对链表进行插入排序。
 *
 *
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 *
 *  
 *
 * 插入排序算法：
 *
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *  
 *
 * 示例 1：
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 * 通过次数47,796提交次数72,298
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insertion-sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: LeetCodePro
 * @description:
 * @author: vann
 * @create: 2020-11-20 10:42
 **/
public class LeetCode_147 {
    public static void main(String[] args) {
        LeetCode_147 leetCode = new LeetCode_147();

        System.out.println(leetCode.insertionSortList(TestCase.NODE));
        System.out.println(leetCode.insertionSortList(TestCase.NODE1));
    }

    /**
     * 解法一：
     *
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        if(head == null) {
            return head;
        }

        ListNode node0 = new ListNode(Integer.MIN_VALUE);
        node0.next = head;

        ListNode preNode = node0;
        while(preNode.next != null) {
            if(preNode.val > preNode.next.val) {
                ListNode next = preNode.next.next;
                ListNode tagNode = preNode.next;
                tagNode.next = null;

                preNode.next = next;

                ListNode pre = node0;
                ListNode node = pre;
                while(node.val <= tagNode.val) {
                    pre = node;
                    node = node.next;
                }

                pre.next = tagNode;
                tagNode.next = node;
            } else {
                preNode = preNode.next;
            }
        }

        return node0.next;
    }

    static class TestCase {
        public static ListNode NODE = ListNode.deserialize("[4,2,1,3]");
        public static ListNode NODE1 = ListNode.deserialize("[-1,5,3,4,0]");
    }
}
