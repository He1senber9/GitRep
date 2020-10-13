package club.vann.leetcode.offer.daily;

import club.vann.leetcode.common.TreeNode;

/**
 * <p>难度：Easy</p>
 * <p>题目：二叉搜索树的最小绝对差</p>
 * <p>描述：给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 *
 *  
 *
 * 示例：
 *
 * 输入：
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * 输出：
 * 1
 *
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 *  
 *
 * 提示：
 *
 * 树中至少有 2 个节点。
 * 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 相同
 * 通过次数26,328提交次数44,395
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/10/12
 * Time: 10:08
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_530 {
    public static void main(String[] args) {
        LeetCode_530 leetCode = new LeetCode_530();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.getMinimumDifference(TestCase.NODE));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.getMinimumDifference(TestCase.NODE1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.getMinimumDifference(TestCase.NODE2));
    }

    public int getMinimumDifference(TreeNode root) {
        int result = Integer.MAX_VALUE;

        if(root == null) {
            return result;
        }

        if(root.left != null) {
            result = Math.min(result, root.val-root.left.val);
            result = Math.min(result, getMinimumDifference(root.left));

            TreeNode leftNode = root.left;
            while(leftNode.right != null) {
                leftNode = leftNode.right;
            }
            result = Math.min(result, root.val- leftNode.val);
        }

        if(root.right != null) {
            result = Math.min(result, root.right.val-root.val);
            result = Math.min(result, getMinimumDifference(root.right));

            TreeNode rightNode = root.right;
            while(rightNode.left != null) {
                rightNode = rightNode.left;
            }
            result = Math.min(result, rightNode.val-root.val);
        }

        return result;
    }

    static class TestCase {
        public static int ANS = 1;
        public static TreeNode NODE = TreeNode.deserialize("[1,null,3,2]");

        public static int ANS1 = 519;
        public static TreeNode NODE1 = TreeNode.deserialize("[0,null,2236,1277,2776,519]");

        public static int ANS2 = 9;
        public static TreeNode NODE2 = TreeNode.deserialize("[236,104,701,null,227,null,911]");
    }
}
