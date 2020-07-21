package club.vann.leetcode.offer.daily;

import club.vann.leetcode.common.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>难度：Medium</p>
 * <p>题目：不同的二叉搜索树II</p>
 * <p>描述：给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
 *
 *  
 *
 * 示例：
 *
 * 输入：3
 * 输出：
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释：
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *  
 *
 * 提示：
 *
 * 0 <= n <= 8
 * 通过次数41,638提交次数64,314
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-07-21 10:27
 **/
public class LeetCode_95 {
    public static void main(String[] args) {
        LeetCode_95 leetCode = new LeetCode_95();

        List<TreeNode> result = null;
        result = leetCode.generateTrees(TestCase.N);
        result = leetCode.generateTrees(TestCase.N1);
        System.out.println("Result[] : ");
    }

    /**
     * 解法一：
     *
     * @param n
     * @return
     */
    private List<TreeNode> generateTrees(int n) {
        if(n == 0) {
            return new ArrayList<>();
        }
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTrees = new ArrayList<TreeNode>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        // 枚举可行根节点
        for (int i = start; i <= end; i++) {
            // 获得所有可行的左子树集合
            List<TreeNode> leftTrees = generateTrees(start, i - 1);

            // 获得所有可行的右子树集合
            List<TreeNode> rightTrees = generateTrees(i + 1, end);

            // 从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = left;
                    currTree.right = right;
                    allTrees.add(currTree);
                }
            }
        }
        return allTrees;
    }

    static class TestCase {
        public static int N = 3;

        public static int N1 = 5;
    }
}
