package club.vann.leetcode.offer.daily;

import club.vann.leetcode.common.TreeNode;

/**
 * <p>难度：Easy</p>
 * <p>题目：修剪二叉搜索树</p>
 * <p>描述：给定一个二叉搜索树，同时给定最小边界L 和最大边界 R。通过修剪二叉搜索树，使得所有节点的值在[L, R]中 (R>=L) 。你可能需要改变树的根节点，所以结果应当返回修剪好的二叉搜索树的新的根节点。
 *
 * 示例 1:
 *
 * 输入:
 *     1
 *    / \
 *   0   2
 *
 *   L = 1
 *   R = 2
 *
 * 输出:
 *     1
 *       \
 *        2
 * 示例 2:
 *
 * 输入:
 *     3
 *    / \
 *   0   4
 *    \
 *     2
 *    /
 *   1
 *
 *   L = 1
 *   R = 3
 *
 * 输出:
 *       3
 *      /
 *    2
 *   /
 *  1
 * 通过次数13,100提交次数19,937
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trim-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-06-10 11:44
 **/
public class LeetCode_669 {
    public static void main(String[] args) {
        LeetCode_669 leetCode = new LeetCode_669();

//        System.out.println(leetCode.trimBST(TestCase.fun(), 1, 2));
//        System.out.println(leetCode.trimBST(TestCase.fun1(), 1, 3));
//        System.out.println(leetCode.trimBST(TestCase.fun2(), 1, 13));
//        System.out.println(leetCode.trimBST(TestCase.fun2(), 1, 6));
        System.out.println(leetCode.trimBST(TestCase.fun3(), 2, 4));
    }

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root.val < L) {
            return trimBST(root.right, L, R);
        }

        if(root.val > R) {
            return trimBST(root.left, L, R);
        }

        if(root.val == L) {
            root.left = null;
        }

        if(root.val == R) {
            root.right = null;
        }

        TreeNode node = root;

        // 修剪左子树
        TreeNode left = root.left;
        while(left != null) {
            if(left.val > L) {
                node = left;
                left = left.left;
            } else if(left.val == L) {
                left.left = null;
                break;
            } else {
                left = left.right;
                node.left = left;
            }
        }

        // 修剪右子树
        TreeNode right = root.right;
        while(right != null) {
            if(right.val < R) {
                node = right;
                right = right.right;
            } else if(right.val == R) {
                right.right = null;
                break;
            } else {
                right = right.left;
                node.right = right;
            }
        }

        return root;
    }

    static class TestCase {
        public static TreeNode fun() {
            TreeNode root = new TreeNode(1);

            TreeNode node0 = new TreeNode(0);
            TreeNode node2 = new TreeNode(2);
            root.left = node0;
            root.right = node2;

            return root;
        }

        public static TreeNode fun1() {
            TreeNode root = new TreeNode(3);

            TreeNode node0 = new TreeNode(0);
            TreeNode node4 = new TreeNode(4);
            root.left = node0;
            root.right = node4;

            TreeNode node2 = new TreeNode(2);
            node0.right = node2;

            TreeNode node1 = new TreeNode(1);
            node2.left = node1;

            return root;
        }

        public static TreeNode fun2() {
            TreeNode root = new TreeNode(7);

            TreeNode node3 = new TreeNode(3);
            TreeNode node11 = new TreeNode(11);
            root.left = node3;
            root.right = node11;

            TreeNode node1 = new TreeNode(1);
            TreeNode node5 = new TreeNode(5);
            node3.left = node1;
            node3.right = node5;

            TreeNode node9 = new TreeNode(9);
            TreeNode node13 = new TreeNode(13);
            node11.left = node9;
            node11.right = node13;

            TreeNode node0 = new TreeNode(0);
            TreeNode node2 = new TreeNode(2);
            node1.left = node0;
            node1.right = node2;

            TreeNode node4 = new TreeNode(4);
            TreeNode node6 = new TreeNode(6);
            node5.left = node4;
            node5.right = node6;

            TreeNode node8 = new TreeNode(8);
            TreeNode node10 = new TreeNode(10);
            node9.left = node8;
            node9.right = node10;

            TreeNode node12 = new TreeNode(12);
            TreeNode node14 = new TreeNode(14);
            node13.left = node12;
            node13.right = node14;

            return root;
        }

        public static TreeNode fun3() {
            TreeNode root = new TreeNode(1);

            TreeNode node2 = new TreeNode(2);
            root.right = node2;

            return root;
        }
    }
}
