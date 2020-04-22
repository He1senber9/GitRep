package club.vann.leetcode.offer.daily;

import club.vann.leetcode.common.TreeNode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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
        System.out.println(leetCode.rightSideView(TestCase.root1()));
        System.out.println(leetCode.rightSideView(TestCase.root2()));
    }

    /**
     * 解法一：
     * 采用中序遍历
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        LinkedList<TreeNode> curList = new LinkedList<TreeNode>();

        int psize = 0;
        int csize = 0;
        curList.add(root);
        psize = 1;
        while(!curList.isEmpty()) {
            TreeNode node = curList.pollFirst();

            if(psize == 1) {
                list.add(node.val);
            }
            psize --;

            if(node.left != null) {
                curList.addLast(node.left);
                csize ++;
            }

            if(node.right != null) {
                curList.addLast(node.right);
                csize ++;
            }

            if(psize == 0) {
                psize = csize;
                csize = 0;
            }
        }

        return list;
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
            node2.left = node4;
            node2.right = node5;

            return root;
        }

        public static TreeNode root2() {
            TreeNode root = new TreeNode(1);
            TreeNode node2 = new TreeNode(2);
            TreeNode node3 = new TreeNode(3);
            TreeNode node4 = new TreeNode(4);
            TreeNode node5 = new TreeNode(5);
            TreeNode node6 = new TreeNode(6);
            TreeNode node7 = new TreeNode(7);
            TreeNode node8 = new TreeNode(8);
            TreeNode node9 = new TreeNode(9);
            TreeNode node10 = new TreeNode(10);
            TreeNode node11= new TreeNode(11);

            root.left = node2;
            root.right = node3;
            node2.left = node4;
            node2.right = node5;
            node3.left = node6;
            node4.left = node9;
            node6.left = node7;
            node6.right = node8;
            node9.left = node10;
            node9.right = node11;

            return root;
        }
    }
}
