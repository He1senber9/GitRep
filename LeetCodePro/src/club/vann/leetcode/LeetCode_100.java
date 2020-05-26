package club.vann.leetcode;

import club.vann.leetcode.common.TreeNode;

/**
 * <p>难度：Easy</p>
 * <p>题目：相同的树</p>
 * <p>描述：给定两个二叉树，编写一个函数来检验它们是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 示例 1:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * 输出: true
 * 示例 2:
 *
 * 输入:      1          1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * 输出: false
 * 示例 3:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 *
 * 输出: false
 * 通过次数88,842提交次数153,996
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/same-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/5/27
 * Time: 6:44
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_100 {
    public static void main(String[] args) {
        LeetCode_100 leetCode = new LeetCode_100();
        System.out.println("Result[true] : " + leetCode.isSameTree(TestCase.func1()[0], TestCase.func1()[1]));
        System.out.println("Result[false] : " + leetCode.isSameTree(TestCase.func2()[0], TestCase.func2()[1]));
        System.out.println("Result[false] : " + leetCode.isSameTree(TestCase.func3()[0], TestCase.func3()[1]));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q != null) {
            return false;
        }

        if(p != null && q == null) {
            return false;
        }

        if(p == null && q == null) {
            return true;
        }

        if(p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    static class TestCase {
        public static TreeNode[] func1() {
            TreeNode[] nodes = new TreeNode[2];

            TreeNode node01 = new TreeNode(1);
            TreeNode node02 = new TreeNode(2);
            TreeNode node03 = new TreeNode(3);
            node01.left = node02;
            node01.right = node03;

            TreeNode node11 = new TreeNode(1);
            TreeNode node12 = new TreeNode(2);
            TreeNode node13 = new TreeNode(3);
            node11.left = node12;
            node11.right = node13;

            nodes[0] = node01;
            nodes[1] = node11;
            return nodes;
        }

        public static TreeNode[] func2() {
            TreeNode[] nodes = new TreeNode[2];

            TreeNode node01 = new TreeNode(1);
            TreeNode node02 = new TreeNode(2);
            node01.left = node02;

            TreeNode node11 = new TreeNode(1);
            TreeNode node12 = new TreeNode(2);
            node11.right = node12;

            nodes[0] = node01;
            nodes[1] = node11;
            return nodes;
        }

        public static TreeNode[] func3() {
            TreeNode[] nodes = new TreeNode[2];

            TreeNode node01 = new TreeNode(1);
            TreeNode node02 = new TreeNode(2);
            TreeNode node03 = new TreeNode(1);
            node01.left = node02;
            node01.right = node03;

            TreeNode node11 = new TreeNode(1);
            TreeNode node12 = new TreeNode(1);
            TreeNode node13 = new TreeNode(2);
            node11.left = node12;
            node11.right = node13;

            nodes[0] = node01;
            nodes[1] = node11;
            return nodes;
        }
    }
}
