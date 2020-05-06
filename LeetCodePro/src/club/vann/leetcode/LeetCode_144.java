package club.vann.leetcode;

import club.vann.leetcode.common.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>难度：Medium</p>
 * <p>题目：二叉树的前序遍历</p>
 * <p>描述：给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 通过次数99,831提交次数152,478
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/5/6
 * Time: 21:47
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_144 {
    public static void main(String[] args) {
        LeetCode_144 leetCode = new LeetCode_144();

        List<Integer> result = leetCode.preorderTraversal(TestCase.case1());
        System.out.println("Case1：" + result);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        preorderTraversal(list, root);
        return list;
    }

    private void preorderTraversal(List<Integer> list, TreeNode node) {
        if(node == null) {
            return;
        }

        list.add(node.val);
        preorderTraversal(list, node.left);
        preorderTraversal(list, node.right);
    }

    static class TestCase {
        public static TreeNode case1() {
            TreeNode root = new TreeNode(1);
            TreeNode node2 = new TreeNode(2);
            root.right = node2;
            TreeNode node3 = new TreeNode(3);
            node2.left = node3;
            return root;
        }
    }
}
