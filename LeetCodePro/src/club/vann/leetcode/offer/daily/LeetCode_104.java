package club.vann.leetcode.offer.daily;

import club.vann.leetcode.common.TreeNode;

/**
 * <p>难度：Easy</p>
 * <p>题目：二叉树的最大深度</p>
 * <p>描述：给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * 通过次数220,292提交次数297,185
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-07-28 09:09
 **/
public class LeetCode_104 {
    public static void main(String[] args) {
        LeetCode_104 leetCode = new LeetCode_104();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.maxDepth(TestCase.NODE));
    }

    /**
     * 解法一：
     *
     * @param root
     * @return
     */
    private int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    static class TestCase {
        public static int ANS = 3;
        public static TreeNode NODE = TreeNode.deserialize("[3,9,20,null,null,15,7]");
    }
}
