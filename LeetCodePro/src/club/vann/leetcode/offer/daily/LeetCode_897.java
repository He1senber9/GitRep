package club.vann.leetcode.offer.daily;

import club.vann.leetcode.common.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * <p>难度：Easy</p>
 * <p>题目：递增序列搜索树</p>
 * <p>描述：给你一棵二叉搜索树，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 * 示例 2：
 *
 *
 * 输入：root = [5,1,7]
 * 输出：[1,null,5,null,7]
 *  
 *
 * 提示：
 *
 * 树中节点数的取值范围是 [1, 100]
 * 0 <= Node.val <= 1000
 * 通过次数29,742提交次数40,671
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-order-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @ClassName LeetCode_897
 * @Description TODO
 * @User fanyu
 * @Date 2021/4/25 8:14
 */
public class LeetCode_897 {
    public static void main(String[] args) {
        LeetCode_897 leetCode = new LeetCode_897();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.increasingBST(TestCase.NODE));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.increasingBST(TestCase.NODE1));
    }

    TreeNode curNode = null;
    /**
     * 解法一：
     *
     * @param root
     * @return
     */
    public TreeNode increasingBST(TreeNode root) {
        TreeNode head = new TreeNode(-1);
        curNode = head;

        inorder(root);
        return head.right;
    }

    private void inorder(TreeNode node) {
        if(node == null) {
            return;
        }

        inorder(node.left);

        curNode.right = node;
        node.left = null;
        curNode = curNode.right;

        inorder(node.right);
    }

    static class TestCase {
        public static TreeNode ANS = TreeNode.deserialize("[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]");
        public static TreeNode NODE = TreeNode.deserialize("[5,3,6,2,4,null,8,1,null,null,null,7,9]");

        public static TreeNode ANS1 = TreeNode.deserialize("[1,null,5,null,7]");
        public static TreeNode NODE1 = TreeNode.deserialize("[5,1,7]");
    }
}
