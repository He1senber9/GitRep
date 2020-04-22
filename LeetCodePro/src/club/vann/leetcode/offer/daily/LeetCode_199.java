package club.vann.leetcode.offer.daily;

import club.vann.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>难度：Medium</p>
 * <p>题目：二叉树的右视图</p>
 * <p>描述：给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 * 通过次数27,070提交次数42,157
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/4/22
 * Time: 9:14
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_199 {
    public static void main(String[] args) {
        LeetCode_199 leetCode = new LeetCode_199();

        System.out.println(leetCode.rightSideView(TestCase.root()));
    }

    /**
     * 解法一：
     * 
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();

        return result;
    }

    static class TestCase {
        public static TreeNode root() {
            TreeNode root = new TreeNode(1);
            TreeNode node2 = new TreeNode(2);
            TreeNode node3 = new TreeNode(3);
            TreeNode node4 = new TreeNode(4);
            TreeNode node5 = new TreeNode(5);

            root.left = node2;
            root.right = node3;
            node2.right = node5;
            node3.right = node4;

            return root;
        }

        public static TreeNode root1() {
            TreeNode root = new TreeNode(1);
            TreeNode node2 = new TreeNode(2);
            TreeNode node3 = new TreeNode(3);
            TreeNode node4 = new TreeNode(4);
            TreeNode node5 = new TreeNode(5);

            root.left = node2;
            root.right = node3;
            node2.right = node5;
            node3.right = node4;

            return root;
        }
    }
}
