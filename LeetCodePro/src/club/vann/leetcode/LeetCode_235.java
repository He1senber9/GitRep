package club.vann.leetcode;

import club.vann.leetcode.common.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * <p>难度：Easy</p>
 * <p>题目：二叉搜索树的最近公共祖先</p>
 * <p>描述：给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 *
 *
 *  
 *
 * 示例 1:
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * 示例 2:
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 *  
 *
 * 说明:
 *
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉搜索树中。
 * 通过次数59,389提交次数92,749
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-06-11 15:08
 **/
public class LeetCode_235 {
    public static void main(String[] args) {
        LeetCode_235 leetCode = new LeetCode_235();

        System.out.println(leetCode.lowestCommonAncestor(TestCase.fun(), new TreeNode(2), new TreeNode(8)));
        System.out.println(leetCode.lowestCommonAncestor(TestCase.fun(), new TreeNode(2), new TreeNode(4)));
        System.out.println(leetCode.lowestCommonAncestor(TestCase.fun(), new TreeNode(2), new TreeNode(8)));
    }

    private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null) {
            return right;
        }
        if(right == null) {
            return left;
        }

        return root;
    }

    static class TestCase {
        public static TreeNode fun() {
            TreeNode root = new TreeNode(6);

            TreeNode node2 = new TreeNode(2);
            TreeNode node8 = new TreeNode(8);
            root.left = node2;
            root.right = node8;

            TreeNode node0 = new TreeNode(0);
            TreeNode node4 = new TreeNode(4);
            node2.left = node0;
            node2.right = node4;

            TreeNode node7 = new TreeNode(7);
            TreeNode node9 = new TreeNode(9);
            node8.left = node7;
            node8.right = node9;

            TreeNode node3 = new TreeNode(3);
            TreeNode node5 = new TreeNode(5);
            node4.left = node3;
            node4.right = node5;

            return root;
        }
    }
}
