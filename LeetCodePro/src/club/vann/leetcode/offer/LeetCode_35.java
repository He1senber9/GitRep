package club.vann.leetcode.offer;

import club.vann.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * <p>难度：Medium</p>
 * <p>题目：杂链表的复制</p>
 * <p>描述：请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 示例 2：
 *
 *
 *
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 * 示例 3：
 *
 *
 *
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 * 示例 4：
 *
 * 输入：head = []
 * 输出：[]
 * 解释：给定的链表为空（空指针），因此返回 null。
 *  
 *
 * 提示：
 *
 * -10000 <= Node.val <= 10000
 * Node.random 为空（null）或指向链表中的节点。
 * 节点数目不超过 1000 。
 *  
 *
 * 注意：本题与主站 138 题相同：https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 *
 *  
 *
 * 通过次数23,690提交次数33,286
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-07-31 10:22
 **/
public class LeetCode_35 {
    public static void main(String[] args) {
        LeetCode_35 leetCode = new LeetCode_35();
    }

    /**
     * 解法一：
     *
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if(head == null) {
            return head;
        }

        Node root = new Node(head.val);

        Node pre = root;
        Node cur = head.next;
        while(cur != null) {
            Node node = new Node(cur.val);
            node.random = cur.random;

            pre.next = node;
            pre.random = 

            pre = pre.next;
            cur = cur.next;
        }

        return root;
    }

    static class TestCase {
        public static Node ANS = null;
        public static Node HEAD = null;

        public static Node ANS1 = null;
        public static Node HEAD1 = null;

        public static Node ANS2 = null;
        public static Node HEAD2 = null;

        public static Node ANS3 = null;
        public static Node HEAD3 = null;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", next=" + next +
                    ", random=" + random +
                    '}';
        }

        public Node deserialize(String data) {
            return null;
        }

        private Node getNode(Map<Node, Node> map, String[] val) {
            return null;
        }
    }
}
