package club.vann.leetcode;

import club.vann.leetcode.common.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>难度：Easy</p>
 * <p>题目：二叉树的层次遍历II</p>
 * <p>描述：给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 * 通过次数59,518提交次数90,850
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/5/28
 * Time: 7:03
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_107 {

    public static void main(String[] args) {
        LeetCode_107 leetCode = new LeetCode_107();
        System.out.println(leetCode.levelOrderBottom(TestCase.func1()));
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if(root == null) {
            return result;
        }

        LinkedList<TreeNode> linked = new LinkedList<TreeNode>();
        linked.addLast(root);

        int cur = linked.size(); // 当前层的个数
        int child = 0; // 子层的个数
        while(!linked.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            while(cur > 0) {
                TreeNode curNode = linked.pollFirst();
                list.add(curNode.val);
                cur --;

                if(curNode.left != null) {
                    linked.addLast(curNode.left);
                    child ++;
                }

                if(curNode.right != null) {
                    linked.addLast(curNode.right);
                    child ++;
                }
            }

            result.add(list);
            cur = child;
            child = 0;
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int i = result.size()-1; i >= 0; i --) {
            res.add(result.get(i));
        }
        return res;
    }

    static class TestCase {
        public static TreeNode func1() {
            TreeNode node3 = new TreeNode(3);
            TreeNode node9 = new TreeNode(9);
            TreeNode node20 = new TreeNode(20);
            node3.left = node9;
            node3.right = node20;

            TreeNode node15 = new TreeNode(15);
            TreeNode node7 = new TreeNode(7);
            node20.left = node15;
            node20.right = node7;

            return node3;
        }
    }
}
