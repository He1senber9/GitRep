package club.vann.leetcode;

import club.vann.leetcode.common.TreeNode;

/**
 * <p>难度：Easy</p>
 * <p>题目：叶子相似的树</p>
 * <p>描述：请考虑一颗二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 *
 *
 *
 * 举个例子，如上图所示，给定一颗叶值序列为 (6, 7, 4, 9, 8) 的树。
 *
 * 如果有两颗二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
 *
 * 如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
 *
 *  
 *
 * 提示：
 *
 * 给定的两颗树可能会有 1 到 200 个结点。
 * 给定的两颗树上的值介于 0 到 200 之间。
 * 通过次数12,920提交次数20,537
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/leaf-similar-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-06-19 15:23
 **/
public class LeetCode_872 {
    public static void main(String[] args) {
        LeetCode_872 leetCode = new LeetCode_872();

        System.out.println("Result["+TestCase.ans+"]: " + leetCode.leafSimilar(TestCase.func()[0],TestCase.func()[1]));
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        System.out.println("T");
        return false;
    }

    static class TestCase {
        public static boolean ans = true;
        public static TreeNode[] func() {
            TreeNode[] nodes = new TreeNode[2];

            nodes[0] = TreeNode.deserialize("[3,5,1,6,2,9,8,null,null,7,4,null,null,null,null]");
            nodes[1] = TreeNode.deserialize("[3,5,1,6,2,9,8,null,null,7,4,null,null,null,null]");

            return nodes;
        }
    }
}