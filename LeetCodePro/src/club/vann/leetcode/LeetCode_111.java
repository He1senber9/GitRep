package club.vann.leetcode;

import club.vann.leetcode.common.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/7/28
 * Time: 21:30
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_111 {
    public static void main(String[] args) {
        LeetCode_111 leetCode = new LeetCode_111();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.minDepth(TestCase.NODE));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.minDepth(TestCase.NODE1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.minDepth(TestCase.NODE2));
    }

    private int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return min(root);
    }

    private int min(TreeNode node) {
        if(node == null) {
            return 0;
        }

        if(node.left != null && node.right != null) {
            return 1 + Math.min(min(node.left), min(node.right));
        }

        return node.left == null ? 1+min(node.right) : 1+min(node.left);
    }

    static class TestCase {
        public static int ANS = 2;
        public static TreeNode NODE = TreeNode.deserialize("[3,9,20,null,null,15,7]");

        public static int ANS1 = 2;
        public static TreeNode NODE1 = TreeNode.deserialize("[1,2,3,4,null]");

        public static int ANS2 = 3;
        public static TreeNode NODE2 = TreeNode.deserialize("[1,2,null,3,null]");
    }
}
