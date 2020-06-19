package club.vann.leetcode;

import club.vann.leetcode.common.TreeNode;

/**
 * <p>难度：Easy</p>
 * <p>题目：从根到叶的二进制数之和</p>
 * <p>描述：给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
 *
 * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
 *
 * 以 10^9 + 7 为模，返回这些数字之和。
 *
 *  
 *
 * 示例：
 *
 *
 *
 * 输入：[1,0,1,0,1,0,1]
 * 输出：22
 * 解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 *  
 *
 * 提示：
 *
 * 树中的结点数介于 1 和 1000 之间。
 * node.val 为 0 或 1 。
 * 通过次数7,424提交次数11,704
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-root-to-leaf-binary-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-06-11 16:11
 **/
public class LeetCode_1022 {
    public static void main(String[] args) {
        LeetCode_1022 leetCode = new LeetCode_1022();

        System.out.println("Result["+TestCase.ans+"] : " + leetCode.sumRootToLeaf(TestCase.fun()));
        System.out.println("Result["+TestCase.ans1+"] : " + leetCode.sumRootToLeaf(TestCase.fun1()));
        System.out.println("Result["+TestCase.ans2+"] : " + leetCode.sumRootToLeaf(TestCase.fun2()));
    }

    /**
     * 解法一：
     *
     * @param root
     * @return
     */
    private int sumRootToLeaf(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return sumRootToLeaf(0, root);
    }

    private int sumRootToLeaf(int base, TreeNode root) {
        if(root == null) {
            return 0;
        }

        base = base * 2 + root.val;

        if(root.left == null && root.right == null) {
            return base;
        } else {
            return (int) ((sumRootToLeaf(base, root.left) + sumRootToLeaf(base, root.right)) % (Math.pow(10,9) - 7));
        }
    }

    static class TestCase {
        public static final int ans = 22;
        public static TreeNode fun() {
            TreeNode root = new TreeNode(1);

            TreeNode node0 = new TreeNode(0);
            TreeNode node1 = new TreeNode(1);
            root.left = node0;
            root.right = node1;

            TreeNode nodel00 = new TreeNode(0);
            TreeNode noder01 = new TreeNode(1);
            node0.left = nodel00;
            node0.right = noder01;

            TreeNode nodel10 = new TreeNode(0);
            TreeNode noder11 = new TreeNode(1);
            node1.left = nodel10;
            node1.right = noder11;

            return root;
        }

        public static final int ans1 = 4;
        public static TreeNode fun1() {
            TreeNode root = new TreeNode(1);

            TreeNode node0 = new TreeNode(0);
            TreeNode node1 = new TreeNode(0);
            root.left = node0;
            root.right = node1;

            return root;
        }

        public static final int ans2 = 1;
        public static TreeNode fun2() {
            TreeNode root = new TreeNode(1);

            return root;
        }
    }
}
