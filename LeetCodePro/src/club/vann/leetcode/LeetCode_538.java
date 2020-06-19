package club.vann.leetcode;

import club.vann.leetcode.common.TreeNode;

import java.util.*;

/**
 * <p>难度：Easy</p>
 * <p>题目：把二叉搜索树转换为累加树</p>
 * <p>描述：给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 *  
 *
 * 例如：
 *
 * 输入: 原始二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 *  
 *
 * 注意：本题和 1038: https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree/ 相同
 *
 * 通过次数28,363提交次数45,951
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-06-19 15:52
 **/
public class LeetCode_538 {
    public static void main(String[] args) {
        LeetCode_538 leetCode = new LeetCode_538();

        System.out.println(leetCode.convertBST(TestCase.node1));
        System.out.println(leetCode.convertBST(TestCase.node2));
    }

    private int sum = 0;

    /**
     * 由于是二叉搜索树，故逆序遍历。反中序遍历
     * @param root
     * @return
     */
    private TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }

    /**
     * 解法一：
     * 暴力解法，先统计所有节点的值，然后累加
     * @param root
     * @return
     */
    private TreeNode convertBST2(TreeNode root) {
        if(root == null) {
            return null;
        }

        List<Integer> list = new ArrayList<>();
        convertBST(list, root);
        convertSum(list, root);
        return root;
    }

    private void convertBST(List<Integer> list, TreeNode node) {
        if(node == null) {
            return;
        }
        list.add(node.val);
        convertBST(list, node.left);
        convertBST(list, node.right);
    }

    private void convertSum(List<Integer> list, TreeNode node) {
        if(node == null) {
            return;
        }

        int val = node.val;
        int offset = 0;
        for(int i = 0; i < list.size(); i ++) {
            if(list.get(i) > val) {
                offset += list.get(i);
            }
        }
        node.val = node.val+offset;
        convertSum(list, node.left);
        convertSum(list, node.right);
    }

    static class TestCase {
        public static TreeNode node1 = TreeNode.deserialize("[5,2,13]");
        public static TreeNode node2 = TreeNode.deserialize("[1,2,3,4,5,6,7]");
    }
}
