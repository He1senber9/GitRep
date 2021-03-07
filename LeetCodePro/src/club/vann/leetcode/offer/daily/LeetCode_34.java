package club.vann.leetcode.offer.daily;

import apple.laf.JRSUIUtils;
import club.vann.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>难度：Medium</p>
 * <p>题目：二叉树中和为某一值的路径</p>
 * <p>描述：输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 *
 *  
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *  
 *
 * 提示：
 *
 * 节点总数 <= 10000
 * 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/
 *
 * 通过次数73,135提交次数126,494
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @author vann
 * @program GitRep
 * @description
 * @date 2021-03-06:20:17:17
 */
public class LeetCode_34 {
    public static void main(String[] args) {
        LeetCode_34 leetCode = new LeetCode_34();

        List<List<Integer>> ans = null;
        ans = leetCode.pathSum(TestCase.ROOT, TestCase.SUM);
        System.out.println("Success");
    }

    /**
     * 解法一：
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        if(root == null) {
            return ans;
        }
        pathSum(ans, path, root, 0, sum);
        return ans;
    }

    private void pathSum(List<List<Integer>> ans, List<Integer> path, TreeNode node, int curSum,  int sum) {
        if(node.left == null && node.right == null) {
            if(curSum + node.val == sum) {
                path.add(node.val);
                ans.add(new ArrayList<>(path));
                path.remove(path.size()-1);
            }
            return;
        }

        path.add(node.val);

        if(node.left != null) {
            pathSum(ans, path, node.left, curSum+node.val, sum);
        }

        if(node.right != null) {
            pathSum(ans, path, node.right, curSum+node.val, sum);
        }
        path.remove(path.size()-1);
    }

    static class TestCase {
        public static List<List<Integer>> ANS = null;
        public static TreeNode ROOT = TreeNode.deserialize("[5,4,8,11,null,13,4,7,2,null,null,5,1]");
        public static int SUM = 22;
    }
}
