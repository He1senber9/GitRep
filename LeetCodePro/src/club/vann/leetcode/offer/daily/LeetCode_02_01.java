package club.vann.leetcode.offer.daily;

import club.vann.leetcode.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>难度：Easy</p>
 * <p>题目：移除重复节点</p>
 * <p>描述：编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 *
 * 示例1:
 *
 *  输入：[1, 2, 3, 3, 2, 1]
 *  输出：[1, 2, 3]
 * 示例2:
 *
 *  输入：[1, 1, 1, 1, 2]
 *  输出：[1, 2]
 * 提示：
 *
 * 链表长度在[0, 20000]范围内。
 * 链表元素在[0, 20000]范围内。
 * 进阶：
 *
 * 如果不得使用临时缓冲区，该怎么解决？
 *
 * 通过次数11,946提交次数17,911
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-node-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/6/26
 * Time: 6:47
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_02_01 {

    public static void main(String[] args) {
        LeetCode_02_01 leetCode = new LeetCode_02_01();

//        System.out.println(leetCode.removeDuplicateNodes(TestCase.head));
        System.out.println(leetCode.removeDuplicateNodes(TestCase.head1));
    }

    /**
     * 解法一：
     *
     * @param head
     * @return
     */
    private ListNode removeDuplicateNodes(ListNode head) {
        if(head == null) {
            return null;
        }

        Set<Integer> set = new HashSet<Integer>();
        set.add(head.val);

        ListNode pre = head;
        ListNode cur = pre.next;

        while(cur != null) {
            if(set.contains(cur.val)) {
                pre.next = cur.next;
                cur = cur.next;
            } else {
                set.add(cur.val);
                pre = pre.next;
                cur = cur.next;
            }
        }
        return head;
    }

    static class TestCase {
        public static ListNode head = ListNode.deserialize("[1, 2, 3, 3, 2, 1]");
        public static ListNode head1 = ListNode.deserialize("[1, 1, 1, 1, 2]");
        public static ListNode head2 = ListNode.deserialize("[1, 2, 3, 3, 2, 1]");
    }
}
