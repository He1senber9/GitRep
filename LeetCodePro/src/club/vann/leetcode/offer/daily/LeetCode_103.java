package club.vann.leetcode.offer.daily;

import club.vann.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>难度：Medium</p>
 * <p>题目：二叉树的锯齿形层序遍历</p>
 * <p>描述：给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层序遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 * 通过次数85,334提交次数154,108
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/12/22
 * Time: 8:43
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_103 {
    public static void main(String[] args) {
        LeetCode_103 leetCode = new LeetCode_103();

        List<List<Integer>> res = null;
        res = leetCode.zigzagLevelOrder(TestCase.NODE);
        res = leetCode.zigzagLevelOrder(TestCase.NODE1);

        System.out.println("Success");
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }

        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);

        int flag = 1; // 顺序标志位
        while(!linkedList.isEmpty()) {
            int size = linkedList.size();

            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i ++) {
                TreeNode node = (flag == 1) ? linkedList.pollFirst() : linkedList.pollLast();
                list.add(node.val);

                if(flag == 1) {
                    if(node.left != null) {
                        linkedList.addLast(node.left);
                    }
                    if(node.right != null) {
                        linkedList.addLast(node.right);
                    }
                } else {
                    if(node.right != null) {
                        linkedList.addFirst(node.right);
                    }
                    if(node.left != null) {
                        linkedList.addFirst(node.left);
                    }
                }

            }
            res.add(list);
            flag = flag * -1;
        }

        return res;
    }

    static class TestCase {
        public static TreeNode NODE = TreeNode.deserialize("[3,9,20,null,null,15,7]");
        public static TreeNode NODE1 = TreeNode.deserialize("[1,2,3,4,5]");
    }
}
