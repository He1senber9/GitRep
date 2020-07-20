package club.vann.leetcode;

import club.vann.leetcode.common.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * <p>难度：Easy</p>
 * <p>题目：两数之和 IV - 输入 BST</p>
 * <p>描述：给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 *
 * 案例 1:
 *
 * 输入:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 9
 *
 * 输出: True
 *  
 *
 * 案例 2:
 *
 * 输入:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 28
 *
 * 输出: False
 *  
 *
 * 通过次数18,223提交次数32,648
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-07-20 09:03
 **/
public class LeetCode_653 {
    public static void main(String[] args) {
        LeetCode_653 leetCode = new LeetCode_653();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.findTarget(TestCase.PARAMS, 9));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.findTarget(TestCase.PARAMS1, 28));
    }

    /**
     * 解法一：
     *
     * @param root
     * @param k
     * @return
     */
    private boolean findTarget(TreeNode root, int k) {
        if(root == null) {
             return false;
        }
        Set<Integer> set = new HashSet<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(set.contains(k-node.val)) {
                return true;
            }
            set.add(node.val);
            if(node.left != null) {
                queue.offer(node.left);
            }
            if(node.right != null) {
                queue.offer(node.right);
            }
        }
        return false;
    }

    static class TestCase {
        public static boolean ANS = true;
        public static TreeNode PARAMS = TreeNode.deserialize("[5,3,6,2,4,null,7]");

        public static boolean ANS1 = false;
        public static TreeNode PARAMS1 = TreeNode.deserialize("[5,3,6,2,4,null,7]");
    }
}
