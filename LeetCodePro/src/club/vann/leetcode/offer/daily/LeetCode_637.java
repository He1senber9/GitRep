package club.vann.leetcode.offer.daily;

import club.vann.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>难度：Easy</p>
 * <p>题目：二叉树的层平均值</p>
 * <p>描述：给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.
 *
 * 示例 1:
 *
 * 输入:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出: [3, 14.5, 11]
 * 解释:
 * 第0层的平均值是 3,  第1层是 14.5, 第2层是 11. 因此返回 [3, 14.5, 11].
 * 注意：
 *
 * 节点值的范围在32位有符号整数范围内。
 * 通过次数20,128提交次数31,133
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/average-of-levels-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-06-10 15:24
 **/
public class LeetCode_637 {
    public static void main(String[] args) {
        LeetCode_637 leetCode = new LeetCode_637();

        System.out.println(leetCode.averageOfLevels(TestCase.fun()));
        System.out.println(leetCode.averageOfLevels(TestCase.fun1()));
    }

    /**
     * 解法一：
     *  需要考虑每层数据和溢出的问题。
     * @param root
     * @return
     */
    private List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<Double>();

        return result;
    }

    static class TestCase {
        public static TreeNode fun() {
            TreeNode root = new TreeNode(3);

            TreeNode node9 = new TreeNode(9);
            TreeNode node20 = new TreeNode(20);
            root.left = node9;
            root.right = node20;

            TreeNode node15 = new TreeNode(15);
            TreeNode node7 = new TreeNode(7);
            node20.left = node15;
            node20.right = node7;

            return root;
        }

        // [2147483647,2147483647,2147483647]
        // [2147483647.0,2147483647.0]
        public static TreeNode fun1() {
            TreeNode root = new TreeNode(2147483647);

            TreeNode node9 = new TreeNode(2147483647);
            TreeNode node20 = new TreeNode(2147483647);
            root.left = node9;
            root.right = node20;

            return root;
        }
    }
}
