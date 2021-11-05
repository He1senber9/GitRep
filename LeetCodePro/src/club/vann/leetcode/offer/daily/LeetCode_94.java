package club.vann.leetcode.offer.daily;

import club.vann.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>难度：Easy</p>
 * <p>题目：二叉树的中序遍历</p>
 * <p>描述：给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：[1]
 * 示例 4：
 *
 *
 * 输入：root = [1,2]
 * 输出：[2,1]
 * 示例 5：
 *
 *
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 *  
 *
 * 提示：
 *
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 *  
 *
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 通过次数459,749提交次数609,376
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @description:
 * @program: GitRep
 * @author: fanyu
 * @create: 2021-06-25  09:15:59
 */
public class LeetCode_94 {
    public static void main(String[] args) {
        LeetCode_94 leetCode = new LeetCode_94();

        List<Integer> result = null;

        result = leetCode.inorderTraversal(TestCase.NODE);
        System.out.println("Succ");
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        // 迭代
        List<Integer> result = new ArrayList<>();
        if(root == null) {
            return result;
        }

        TreeNode node = root;
        LinkedList<TreeNode> queue = new LinkedList<>();

        while(node != null || !queue.isEmpty()) {
            while(node != null) {
                queue.addLast(node);
                node = node.left;
            }

            node = queue.poll();
            result.add(node.val);

            node = node.right;
        }

        return result;
    }

    static class TestCase {
        public static TreeNode NODE = TreeNode.deserialize("[1,null,2,3]");
    }
}
