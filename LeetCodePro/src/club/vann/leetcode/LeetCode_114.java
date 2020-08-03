package club.vann.leetcode;

import club.vann.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TransferQueue;

/**
 * <p>难度：Medium</p>
 * <p>题目：二叉树展开为链表</p>
 * <p>给定一个二叉树，原地将它展开为一个单链表。
 *
 *  
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 * 通过次数56,813提交次数81,135
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/8/2
 * Time: 9:41
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_114 {
    public static void main(String[] args) {
        LeetCode_114 leetCode = new LeetCode_114();

        TreeNode res = null;
        res = leetCode.flatten(TestCase.PARAMS);
        res = leetCode.flatten(TestCase.PARAMS1);
        System.out.println();
    }

    /**
     * 解法一：
     *
     * @param root
     * @return
     */
    public TreeNode flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();

        pre(list, root);

        TreeNode head = null;
        TreeNode cur = null;
        for(int i = 0; i < list.size(); i ++) {
            if(i==0) {
                head = list.get(i);
                cur = head;
            } else {
                cur.right = list.get(i);
                cur.left = null;
                cur = cur.right;
            }
        }

        return head;
    }


    private void pre(List<TreeNode> list, TreeNode node) {
        if(node == null) {
            return;
        }

        list.add(node);
        pre(list, node.left);
        pre(list, node.right);
    }

    /**
     * 解法二：
     * @param root
     */
    public void flatten1(TreeNode root) {

    }

    static class TestCase {
        public static TreeNode PARAMS = TreeNode.deserialize("[1,2,5,3,4,null,6]");
        public static TreeNode PARAMS1 = TreeNode.deserialize("[1,2,5,3,4,7,6]");
    }
}
