package club.vann.leetcode.offer.daily;

import club.vann.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * <p>难度：Easy</p>
 * <p>题目：二叉树的最近公共祖先</p>
 * <p>描述：给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 * 示例 1:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *  
 *
 * 说明:
 *
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 * 注意：本题与主站 236 题相同：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * 通过次数15,864提交次数23,315
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-06-09 14:54
 **/
public class LeetCode_68II {
    public static void main(String[] args) {
        LeetCode_68II leetCode = new LeetCode_68II();

        System.out.println("Result["+TestCase.ans.val+"] : " + leetCode.lowestCommonAncestor(TestCase.fun(), new TreeNode(5), new TreeNode(1)));
        System.out.println("Result["+TestCase.ans1.val+"] : " + leetCode.lowestCommonAncestor(TestCase.fun1(), new TreeNode(5), new TreeNode(4)));
        System.out.println("Result["+TestCase.ans2.val+"] : " + leetCode.lowestCommonAncestor(TestCase.fun1(), new TreeNode(7), new TreeNode(8)));
    }

    /**
     * 解法一：
     * 采用栈辅助，栈存祖先节点
     * @param root
     * @param p
     * @param q
     * @return
     */
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

    /**
     * 判断指定的节点是否是p,q的祖先节点
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    private boolean isAncestor(TreeNode root, TreeNode p, TreeNode q) {

        return false;
    }

    static class TestCase {
        public static TreeNode ans = new TreeNode(3);
        public static TreeNode fun() {
            TreeNode root = new TreeNode(3);
            TreeNode node5 = new TreeNode(5);
            TreeNode node1 = new TreeNode(1);
            root.left = node5;
            root.right = node1;

            TreeNode node6 = new TreeNode(6);
            TreeNode node2 = new TreeNode(2);
            node5.left = node6;
            node5.right = node2;

            TreeNode node7 = new TreeNode(7);
            TreeNode node4 = new TreeNode(4);
            node2.left = node7;
            node2.right = node4;

            TreeNode node0 = new TreeNode(0);
            TreeNode node8 = new TreeNode(8);
            node1.left = node0;
            node1.right = node8;

            return root;
        }

        public static TreeNode ans1 = new TreeNode(5);
        public static TreeNode fun1() {
            TreeNode root = new TreeNode(3);
            TreeNode node5 = new TreeNode(5);
            TreeNode node1 = new TreeNode(1);
            root.left = node5;
            root.right = node1;

            TreeNode node6 = new TreeNode(6);
            TreeNode node2 = new TreeNode(2);
            node5.left = node6;
            node5.right = node2;

            TreeNode node7 = new TreeNode(7);
            TreeNode node4 = new TreeNode(4);
            node2.left = node7;
            node2.right = node4;

            TreeNode node0 = new TreeNode(0);
            TreeNode node8 = new TreeNode(8);
            node1.left = node0;
            node1.right = node8;

            return root;
        }

        public static TreeNode ans2 = new TreeNode(3);
        public static TreeNode fun2() {
            TreeNode root = new TreeNode(3);
            TreeNode node5 = new TreeNode(5);
            TreeNode node1 = new TreeNode(1);
            root.left = node5;
            root.right = node1;

            TreeNode node6 = new TreeNode(6);
            TreeNode node2 = new TreeNode(2);
            node5.left = node6;
            node5.right = node2;

            TreeNode node7 = new TreeNode(7);
            TreeNode node4 = new TreeNode(4);
            node2.left = node7;
            node2.right = node4;

            TreeNode node0 = new TreeNode(0);
            TreeNode node8 = new TreeNode(8);
            node1.left = node0;
            node1.right = node8;

            return root;
        }
    }
}
