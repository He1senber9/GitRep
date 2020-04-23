package club.vann.leetcode.offer.daily;

import club.vann.leetcode.common.Node;

import java.util.LinkedList;

/**
 * <p>难度：Medium</p>
 * <p>题目：填充每个节点的下一个右侧节点指针</p>
 * <p>描述：给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 *  
 *
 * 示例：
 *
 *
 *
 * 输入：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":{"$id":"6","left":null,"next":null,"right":null,"val":6},"next":null,"right":{"$id":"7","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}
 *
 * 输出：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":{"$id":"6","left":null,"next":null,"right":null,"val":7},"right":null,"val":6},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"7","left":{"$ref":"5"},"next":null,"right":{"$ref":"6"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"7"},"val":1}
 *
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
 *  
 *
 * 提示：
 *
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 * 通过次数30,203提交次数52,147
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/4/22
 * Time: 17:50
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_116 {
    public static void main(String[] args) {
        Node result = null;
        LeetCode_116 leetCode = new LeetCode_116();

        result = leetCode.connect(TestCase.root());
        System.out.println("Finally");
    }

    /**
     * 解法一：
     *
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if(root == null) {
            return root;
        }

        LinkedList<Node> list = new LinkedList<Node>();
        list.add(root);

        int psize = 1;
        int csize = 0;

        while(!list.isEmpty()) {
            Node node = list.pollFirst();

            if(psize > 1) { // 找到同一层最后一个元素了
                node.next = list.peekFirst();
            }
            psize --;

            if(node.left != null) {
                list.addLast(node.left);
                csize ++;
            }

            if(node.right != null) {
                list.addLast(node.right);
                csize ++;
            }

            if(psize == 0) {
                psize = csize;
                csize = 0;
            }
        }

        return root;
    }

    /**
     * 解法二：
     *  采用递归解法
     * @param node
     * @return
     */
    public Node connect1(Node node) {
        if(node == null) {
            return null;
        }
        return null;
    }

    static class TestCase {
        public static Node root() {
            Node node1 = new Node(1);
            Node node2 = new Node(2);
            Node node3 = new Node(3);
            Node node4 = new Node(4);
            Node node5 = new Node(5);
            Node node6 = new Node(6);
            Node node7 = new Node(7);

            node1.left = node2;
            node1.right = node3;
            node2.left = node4;
            node2.right = node5;
            node3.left = node6;
            node3.right = node7;

            return node1;
        }
    }
}
