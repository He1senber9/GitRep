package club.vann.leetcode.offer.daily;

import club.vann.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>难度：Medium</p>
 * <p>题目：二叉搜索树中第K小的元素</p>
 * <p>描述：给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 * 示例 2：
 *
 *
 * 输入：root = [5,3,6,2,4,null,null,1], k = 3
 * 输出：3
 *  
 *
 *  
 *
 * 提示：
 *
 * 树中的节点数为 n 。
 * 1 <= k <= n <= 104
 * 0 <= Node.val <= 104
 *  
 *
 * 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？
 *
 * 通过次数143,309提交次数192,635
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @description:
 * @program: GitRep
 * @author: fanyu
 * @create: 2021-10-17  09:49:55
 */
public class LeetCode_230 {
    public static void main(String[] args) {
        LeetCode_230 leetCode = new LeetCode_230();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.kthSmallest(TestCase.NODE, TestCase.K));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.kthSmallest(TestCase.NODE1, TestCase.K1));
    }

    /**
     * 解法一：
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> path = new ArrayList<>();
        dfs(path, root, k);
        return path.get(k-1);
    }

    private void dfs(List<Integer> path, TreeNode node, int k) {
        if(node == null) {
            return;
        }

        dfs(path, node.left, k);
        path.add(node.val);
        if(path.size() >= k) {
            return;
        }
        dfs(path, node.right, k);
    }

    static class TestCase {
        public static int ANS = 1;
        public static int K = 1;
        public static TreeNode NODE = TreeNode.deserialize("[3,1,4,null,2]");

        public static int ANS1 = 3;
        public static int K1 = 3;
        public static TreeNode NODE1 = TreeNode.deserialize("[5,3,6,2,4,null,null,1]");
    }
}
