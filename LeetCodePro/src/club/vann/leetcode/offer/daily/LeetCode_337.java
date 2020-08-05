package club.vann.leetcode.offer.daily;

import club.vann.leetcode.common.TreeNode;
import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

/**
 * <p>难度：Medium</p>
 * <p>题目：打家劫舍III</p>
 * <p>描述：在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 *
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 *
 * 示例 1:
 *
 * 输入: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 * 示例 2:
 *
 * 输入: [3,4,5,1,3,null,1]
 *
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 *
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 * 通过次数44,665提交次数76,312
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-08-05 10:05
 **/
public class LeetCode_337 {
    public static void main(String[] args) {
        LeetCode_337 leetCode = new LeetCode_337();

//        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.rob(TestCase.NODE));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.rob(TestCase.NODE1));
    }

    /**
     * 解法一：
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return Math.max(rob(root, true), rob(root, false));
    }

    // isRobed：true：当前节点已经被打劫过；false：当前节点未被打劫
    private int rob(TreeNode node, boolean isRobed) {
        if(node == null) {
            return 0;
        }

        int val = 0;
        if(!isRobed) { // 当前节点未被打劫
            int val1 = rob(node.left, true);
            int val2 = rob(node.right, true);
            int val3 = rob(node.left, false);
            int val4 = rob(node.right, false);

            val = Math.max(val1+val2, val3+val4);
            val = Math.max(val, val1+val4);
            val = Math.max(val, val2+val3);
        } else {
            val = node.val + rob(node.left, false) + rob(node.right, false);
        }

        return val;
    }

    static class TestCase {
        public static int ANS = 7;
        public static TreeNode NODE = TreeNode.deserialize("[3,2,3,null,3,null,1]");

        public static int ANS1 = 9;
        public static TreeNode NODE1 = TreeNode.deserialize("[3,4,5,1,3,null,1]");
    }
}
