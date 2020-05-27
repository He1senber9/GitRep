package club.vann.leetcode;

import club.vann.leetcode.common.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>难度：Easy</p>
 * <p>题目：递增顺序查找树</p>
 * <p>描述：给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
 *
 *  
 *
 * 示例 ：
 *
 * 输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]
 *
 *        5
 *       / \
 *     3    6
 *    / \    \
 *   2   4    8
 *  /        / \
 * 1        7   9
 *
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 *
 *  1
 *   \
 *    2
 *     \
 *      3
 *       \
 *        4
 *         \
 *          5
 *           \
 *            6
 *             \
 *              7
 *               \
 *                8
 *                 \
 *                  9
 *  
 *
 * 提示：
 *
 * 给定树中的结点数介于 1 和 100 之间。
 * 每个结点都有一个从 0 到 1000 范围内的唯一整数值。
 * 通过次数10,277提交次数15,015
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-order-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: GitRep
 * @description:
 * @author: vann
 * @create: 2020-05-23 11:03
 **/
public class LeetCode_897 {
    public static void main(String[] args) {
        LeetCode_897 leetCode = new LeetCode_897();
        TreeNode result = null;

        result = leetCode.increasingBST(TestCase.func1());
        System.out.println(result);
    }

    List<TreeNode> list = new ArrayList<TreeNode>();
    /**
     * 解法一：
     * 借助List保存顺序
     * @param root
     * @return
     */
    public TreeNode increasingBST(TreeNode root) {

        increasingBST1(root);
        if(list.size() == 0) {
            return null;
        }

        int len = list.size();
        for(int i = 1; i < len; i ++) {
            TreeNode pNode = list.get(i-1);
            TreeNode cNode = list.get(i);
            pNode.left = null;
            pNode.right = cNode;
        }

        return list.get(0);
    }

    public void increasingBST1(TreeNode root) {
        if(root == null) {
            return;
        }

        increasingBST1(root.left);
        list.add(root);
        increasingBST1(root.right);
    }

    static class TestCase {
        public static TreeNode func1() {
            TreeNode node5 = new TreeNode(5);
            TreeNode node3 = new TreeNode(3);
            TreeNode node6 = new TreeNode(6);
            node5.left = node3;
            node5.right = node6;

            TreeNode node2 = new TreeNode(2);
            TreeNode node4 = new TreeNode(4);
            node3.left = node2;
            node3.right = node4;

            TreeNode node8 = new TreeNode(8);
            node6.right = node8;

            TreeNode node1 = new TreeNode(1);
            node2.left = node1;

            TreeNode node7 = new TreeNode(7);
            TreeNode node9 = new TreeNode(9);
            node8.left = node7;
            node8.right = node9;
            return node5;
        }
    }
}
