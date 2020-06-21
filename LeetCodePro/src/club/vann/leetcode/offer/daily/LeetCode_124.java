package club.vann.leetcode.offer.daily;

import club.vann.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * <p>难度：Hard</p>
 * <p>题目：二叉树的最大路径和</p>
 * <p>描述：给定一个非空二叉树，返回其最大路径和。
 *
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * 输出: 6
 * 示例 2:
 *
 * 输入: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 输出: 42
 * 通过次数45,078提交次数109,889
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/6/21
 * Time: 9:56
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_124 {
    int maxSum = Integer.MIN_VALUE;
    public static void main(String[] args) {
        LeetCode_124 leetCode = new LeetCode_124();

        System.out.println("Result["+TestCase.ans+"] : " + leetCode.maxPathSum(TestCase.node));
        System.out.println("Result["+TestCase.ans1+"] : " + leetCode.maxPathSum(TestCase.node1));
        System.out.println("Result["+TestCase.ans2+"] : " + leetCode.maxPathSum(TestCase.node2));
        System.out.println("Result["+TestCase.ans3+"] : " + leetCode.maxPathSum(TestCase.node3));
        System.out.println("Result["+TestCase.ans4+"] : " + leetCode.maxPathSum(TestCase.node4));
        System.out.println("Result["+TestCase.ans5+"] : " + leetCode.maxPathSum(TestCase.node5));
        System.out.println("Result["+TestCase.ans6+"] : " + leetCode.maxPathSum(TestCase.node6));
    }

    /**
     * 解法一：
     * 暴力求解
     * @param root
     * @return
     */
    private int maxPathSum(TreeNode root) {
        maxGain(root);

        return maxSum;
    }

    /**
     * 返回当前节点的值和其左右子树上最大值之和
     * @param root
     * @return
     */
    private int maxGain(TreeNode root) {
        if(root == null) {
            return 0;
        }

        // 递归计算左右子节点的最大贡献值
        // 只有在最大贡献值大于 0 时，才会选取对应子节点
        int left = Math.max(maxGain(root.left), 0);
        int right =  Math.max(maxGain(root.right), 0);

        maxSum = Math.max(maxSum, root.val + left + right);

        return root.val + Math.max(left, right);
    }

    static class TestCase {
        public static final int ans = 6;
        public static TreeNode node = TreeNode.deserialize("[1,2,3]");

        public static final int ans1 = 42;
        public static TreeNode node1 = TreeNode.deserialize("[-10,9,20,null,null,15,7]");

        public static final int ans2 = 23;
        public static TreeNode node2 = TreeNode.deserialize("[1,2,3,4,null,5,6,null,null,null,null,7]");

        public static final int ans3 = 44;
        public static TreeNode node3 = TreeNode.deserialize("[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15]");

        public static final int ans4 = 3;
        public static TreeNode node4 = TreeNode.deserialize("[1,2]");

        public static final int ans5 = 2;
        public static TreeNode node5 = TreeNode.deserialize("[2,-1]");

        public static final int ans6 = 11;
        public static TreeNode node6 = TreeNode.deserialize("[-1,5,null,4,null,null,2,-4]");

    }
}
