package club.vann.leetcode.race;

import club.vann.leetcode.common.TreeNode;

/**
 * <p>难度：Medium</p>
 * <p>题目：将二叉搜索树变平衡</p>
 * <p>给你一棵二叉搜索树，请你返回一棵 平衡后 的二叉搜索树，新生成的树应该与原来的树有着相同的节点值。
 *
 * 如果一棵二叉搜索树中，每个节点的两棵子树高度差不超过 1 ，我们就称这棵二叉搜索树是 平衡的 。
 *
 * 如果有多种构造方法，请你返回任意一种。
 *
 *
 *
 * 示例：
 *
 *
 *
 * 输入：root = [1,null,2,null,3,null,4,null,null]
 * 输出：[2,1,3,null,null,null,4]
 * 解释：这不是唯一的正确答案，[3,1,4,null,2,null,null] 也是一个可行的构造方案。
 *
 *
 * 提示：
 *
 * 树节点的数目在 1 到 10^4 之间。
 * 树节点的值互不相同，且在 1 到 10^5 之间。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/3/18
 * Time: 22:48
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_1382 {
    public static void main(String[] args) {
        TreeNode result = null;
        LeetCode_1382 leetCode = new LeetCode_1382();

        TreeNode node = new TreeNode(1);
        result = leetCode.balanceBST(node);
        System.out.println(result);
    }

    /**
     * 平衡二叉树
     * @param root
     * @return
     */
    private TreeNode balanceBST(TreeNode root) {
        if(root == null) {
            return null;
        }

        int size = 0;
        TreeNode oneNode = root;
        TreeNode twoNode = root;
        TreeNode target = null;


        target.left = balanceBST(oneNode);
        target.right = balanceBST(twoNode);

        return target;
    }
}
