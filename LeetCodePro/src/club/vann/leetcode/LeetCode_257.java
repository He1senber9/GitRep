package club.vann.leetcode;

import club.vann.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>难度：Easy</p>
 * <p>题目：二叉树的所有路径</p>
 * <p>描述：给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 * 通过次数39,483提交次数61,697
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-06-11 15:23
 **/
public class LeetCode_257 {
    public static void main(String[] args) {
        LeetCode_257 leetCode = new LeetCode_257();

        System.out.println("Result["+ Arrays.toString(TestCase.ans)+"] : " + leetCode.binaryTreePaths(TestCase.fun()));
        System.out.println("Result["+ Arrays.toString(TestCase.ans1)+"] : " + leetCode.binaryTreePaths(TestCase.fun1()));
    }

    /**
     * 解法一：
     * 先序遍历
     * @param root
     * @return
     */
    private List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if(root == null) {
            return result;
        }

        preOrder(root, "", result);

        return result;
    }

    private void preOrder(TreeNode node, String path, List<String> res) {
        if(node == null) {
            return;
        }

        if(path != "") {
            path = path + "->" + node.val;
        } else {
            path = node.val + "";
        }

        // 只有当前节点是叶子节点时计算路径
        if(node.left == null && node.right == null) {
            res.add(path);
            return;
        }

        preOrder(node.left, path, res);
        preOrder(node.right, path, res);
        return;
    }

    static class TestCase {
        public static final String[] ans = {"1->2->5", "1->3"};
        public static TreeNode fun() {
            TreeNode root = new TreeNode(1);

            TreeNode node2 = new TreeNode(2);
            TreeNode node3 = new TreeNode(3);
            root.left = node2;
            root.right = node3;

            TreeNode node5 = new TreeNode(5);
            node2.right = node5;

            return root;
        }

        public static final String[] ans1 = {"1"};
        public static TreeNode fun1() {
            TreeNode root = new TreeNode(1);

            return root;
        }
    }
}
