package club.vann.leetcode.offer;

import club.vann.leetcode.common.ListNode;

/**
 * <p>难度：Easy</p>
 * <p>题目：两个链表的第一个公共节点</p>
 * <p>描述：输入两个链表，找出它们的第一个公共节点。
 *
 * 如下面的两个链表：
 *
 *
 *
 * 在节点 c1 开始相交。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *  
 *
 * 示例 2：
 *
 *
 *
 * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Reference of the node with value = 2
 * 输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 *  
 *
 * 示例 3：
 *
 *
 *
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 解释：这两个链表不相交，因此返回 null。
 *  
 *
 * 注意：
 *
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 * 本题与主站 160 题相同：https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * 通过次数22,667提交次数35,705
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-06-24 16:28
 **/
public class LeetCode_52 {
    public static void main(String[] args) {
        LeetCode_52 leetCode = new LeetCode_52();

        System.out.println("Result[8]" + leetCode.getIntersectionNode1(TestCase.fun()[0], TestCase.fun()[1]).val);
        System.out.println("Result[2]" + leetCode.getIntersectionNode1(TestCase.fun1()[0], TestCase.fun1()[1]).val);
        System.out.println("Result[0]" + leetCode.getIntersectionNode1(TestCase.fun2()[0], TestCase.fun2()[1]).val);
        System.out.println("Result[3]" + leetCode.getIntersectionNode1(TestCase.fun3()[0], TestCase.fun3()[1]).val);
    }

    /**
     * 解法一：
     *
     * @param headA
     * @param headB
     * @return
     */
    private ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == headB) {
            return headA;
        }

        if(headA == null || headB == null) {
            return null;
        }

        ListNode baseNode = headA;
        while(baseNode != null) {
            ListNode tagNode = headB;
            while(tagNode != null && baseNode != tagNode) {
                tagNode = tagNode.next;
            }
            if(baseNode == tagNode) {
                return baseNode;
            }
            baseNode = baseNode.next;
        }

        return null;
    }

    /**
     * 解法二：
     *
     * @param headA
     * @param headB
     * @return
     */
    private ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode node1 = headA;
        ListNode node2 = headB;

        while(node1 != node2) {
            node1 = (node1 == null) ? headB : node1.next;
            node2 = (node2 == null) ? headA : node2.next;
        }
        return node1;
    }

    static class TestCase {
        public static final ListNode[] fun() {
            ListNode[] nodes = new ListNode[2];

            ListNode rootA = new ListNode(4);
            ListNode rootA1 = new ListNode(1);
            rootA.next = rootA1;

            ListNode rootB = new ListNode(5);
            ListNode rootB1 = new ListNode(0);
            rootB.next = rootB1;
            ListNode rootB2 = new ListNode(1);
            rootB1.next = rootB2;

            ListNode node0 = new ListNode(8);
            ListNode node1 = new ListNode(4);
            ListNode node2 = new ListNode(5);
            node0.next = node1;
            node1.next = node2;

            rootA1.next = node0;
            rootB2.next = node0;

            nodes[0] = rootA;
            nodes[1] = rootB;
            return nodes;
        }

        public static final ListNode[] fun1() {
            ListNode[] nodes = new ListNode[2];

            ListNode rootA = new ListNode(0);
            ListNode rootA1 = new ListNode(9);
            ListNode rootA2 = new ListNode(1);
            rootA.next = rootA1;
            rootA1.next = rootA2;

            ListNode rootB = new ListNode(2);

            ListNode node0 = new ListNode(2);
            ListNode node1 = new ListNode(4);
            node0.next = node1;

            rootA2.next = node0;
            rootB.next = node0;

            nodes[0] = rootA;
            nodes[1] = rootB;
            return nodes;
        }

        public static final ListNode[] fun2() {
            ListNode[] nodes = new ListNode[2];

            ListNode rootA = new ListNode(2);
            ListNode rootA1 = new ListNode(6);
            ListNode rootA2 = new ListNode(4);
            rootA.next = rootA1;
            rootA1.next = rootA2;

            ListNode rootB = new ListNode(1);
            ListNode rootB1 = new ListNode(5);
            rootB.next = rootB1;

            nodes[0] = rootA;
            nodes[1] = rootB;
            return nodes;
        }

        public static final ListNode[] fun3() {
            ListNode[] nodes = new ListNode[2];

            ListNode rootA = new ListNode(1);
            ListNode rootA1 = new ListNode(2);
            rootA.next = rootA1;

            ListNode rootB = new ListNode(3);
            ListNode rootB1 = new ListNode(4);
            ListNode rootB2 = new ListNode(5);
            ListNode rootB3 = new ListNode(6);
            rootB.next = rootB1;
            rootB1.next = rootB2;
            rootB2.next = rootB3;


            nodes[0] = rootA;
            nodes[1] = rootB;
            return nodes;
        }

    }
}
