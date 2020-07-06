package club.vann.leetcode.offer.daily;

import club.vann.leetcode.common.TreeNode;

/**
 * <p>难度：Easy</p>
 * <p>题目：路劲总和</p>
 * <p>描述：给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 *
 * 通过次数89,682提交次数179,401
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/7/7
 * Time: 6:50
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_112 {
    public static void main(String[] args) {
        LeetCode_112 leetCode = new LeetCode_112();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.hasPathSum(TestCase.ROOT, 22));
    }

    /**
     * 解法一：
     *
     * @param root
     * @param sum
     * @return
     */
    private boolean hasPathSum(TreeNode root, int sum) {
        return false;
    }

    static class TestCase {
        public static final boolean ANS = true;
        public static TreeNode ROOT = TreeNode.deserialize("[5,4,8,11,null,13,4,7,2,null,null,null,1]");
    }
}
