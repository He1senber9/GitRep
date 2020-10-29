package club.vann.leetcode.offer.daily;

import club.vann.leetcode.common.TreeNode;

/**
 * <p>难度：Medium</p>
 * <p>题目：求根到叶子节点数字之和</p>
 * <p>描述：给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 *
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 *
 * 计算从根到叶子节点生成的所有数字之和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *     1
 *    / \
 *   2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 * 示例 2:
 *
 * 输入: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * 输出: 1026
 * 解释:
 * 从根到叶子节点路径 4->9->5 代表数字 495.
 * 从根到叶子节点路径 4->9->1 代表数字 491.
 * 从根到叶子节点路径 4->0 代表数字 40.
 * 因此，数字总和 = 495 + 491 + 40 = 1026.
 * 通过次数44,804提交次数68,622
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/10/29
 * Time: 8:18
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_129 {
    public static void main(String[] args) {
        LeetCode_129 leetCode = new LeetCode_129();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.sumNumbers(TestCase.NODE));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.sumNumbers(TestCase.NODE1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.sumNumbers(TestCase.NODE2));
    }

    private int sum = 0;
    /**
     * 解法一：
     *
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }


    public int sumNumbers(TreeNode node, int base) {
        if(node == null) {
            return 0;
        }

        int tag = base * 10 + node.val;
        int sumA = sumNumbers(node.left, tag);
        int sumB = sumNumbers(node.right, tag);

        if(sumA == 0 && sumB == 0) {
            return tag;
        } else if(sumA == 0 || sumB == 0){
            return sumA == 0 ? sumB : sumA;
        } else {
            return sumA + sumB;
        }
    }

    static class TestCase {
        public static int ANS = 25;
        public static TreeNode NODE = TreeNode.deserialize("[1,2,3]");

        public static int ANS1 = 1026;
        public static TreeNode NODE1 = TreeNode.deserialize("[4,9,0,5,1]");

        public static int ANS2 = 2444;
        public static TreeNode NODE2 = TreeNode.deserialize("[1,1,1,1,1,1,1,1,null,null,null,null,null,null,1]");
    }
}
