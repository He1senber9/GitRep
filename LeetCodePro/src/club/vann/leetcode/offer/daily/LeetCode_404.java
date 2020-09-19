package club.vann.leetcode.offer.daily;

import club.vann.leetcode.common.TreeNode;

/**
 * <p>难度：Easy</p>
 * <p>题目：左叶子之和</p>
 * <p>描述：计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *  
 *
 * 通过次数37,652提交次数67,375
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-left-leaves
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: LeetCodePro
 * @description:
 * @author: vann
 * @create: 2020-09-19 08:57
 **/
public class LeetCode_404 {
    public static void main(String[] args) {
        LeetCode_404 leetCode = new LeetCode_404();

//        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.sumOfLeftLeaves(TestCase.node));
//        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.sumOfLeftLeaves(TestCase.node1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.sumOfLeftLeaves(TestCase.node2));
    }

    /**
     * 解法一：
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int sum = 0;
        if(root.left != null) {
            if(root.left.left == null && root.left.right == null) {
                sum += root.left.val;
            } else {
                sum += sumOfLeftLeaves(root.left);
            }
        }

        sum += sumOfLeftLeaves(root.right);
        return sum;
    }

    static class TestCase {
        public static int ANS = 24;
        public static TreeNode node = TreeNode.deserialize("[3,9,20,null,null,15,7]");

        public static int ANS1 = 4;
        public static TreeNode node1 = TreeNode.deserialize("[1,2,3,4,5]");

        public static int ANS2 = 5;
        public static TreeNode node2 = TreeNode.deserialize("[0,2,4,1,null,3,-1,5,1,null,6,null,8]");
    }
}
