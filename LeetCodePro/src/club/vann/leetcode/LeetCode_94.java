package club.vann.leetcode;

import club.vann.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <p>难度：Medium</p>
 * <p>题目：二叉树的中序遍历</p>
 * <p>描述：给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 通过次数151,151提交次数211,874
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/5/6
 * Time: 21:09
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_94 {
    public static void main(String[] args) {
        LeetCode_94 leetCode = new LeetCode_94();

        List<Integer> result = leetCode.inorderTraversal2(TestCase.case1());
        System.out.println("Case1：" + result);

        result = leetCode.inorderTraversal2(TestCase.case2());
        System.out.println("Case2：" + result);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        inorderTraversal(list, root);
        return list;
    }

    private void inorderTraversal(List<Integer> list, TreeNode node) {
        if(node == null) {
            return;
        }
        inorderTraversal(list, node.left);
        list.add(node.val);
        inorderTraversal(list, node.right);
    }

    /**
<<<<<<< HEAD
     * 采用迭代法
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
=======
     * 迭代法：
     * @param root
     */
    private List<Integer> inorderTraversal2(TreeNode root) {
>>>>>>> 4c3719f1555a99e3d3655baacd7e5717beb38dc6
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode node = root;
<<<<<<< HEAD
        stack.push(node);

        while(!stack.isEmpty()) {
            node = stack.peek();
            if(node.left != null) {

            } else if(node.right != null) {

            } else {
                stack.pop();
                list.add(node.val);
            }
        }

=======

        while(node != null || !stack.isEmpty()) {
            while(node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            list.add(node.val);
            node = node.right;
        }
>>>>>>> 4c3719f1555a99e3d3655baacd7e5717beb38dc6
        return list;
    }

    static class TestCase {
        public static TreeNode case1() {
            TreeNode root = new TreeNode(1);
            TreeNode node2 = new TreeNode(2);
            root.right = node2;

            TreeNode node3 = new TreeNode(3);
            node2.left = node3;
            return root;
        }

        public static TreeNode case2() {
            TreeNode root = new TreeNode(1);
            TreeNode node2 = new TreeNode(2);
            root.left = node2;
            TreeNode node3 = new TreeNode(3);
            root.right = node3;
            TreeNode node4 = new TreeNode(4);
            node2.left = node4;
            TreeNode node5 = new TreeNode(5);
            node3.left = node5;
            return root;
        }
    }
}
