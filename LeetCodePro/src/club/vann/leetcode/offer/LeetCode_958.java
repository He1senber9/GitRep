package club.vann.leetcode.offer;

import club.vann.leetcode.common.TreeNode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>难度：Medium</p>
 * <p>题目：验证二叉树的完全性</p>
 * <p>描述：给定一个二叉树，确定它是否是一个完全二叉树。
 *
 * 百度百科中对完全二叉树的定义如下：
 *
 * 若设二叉树的深度为 h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，第 h 层所有的结点都连续集中在最左边，这就是完全二叉树。（注：第 h 层可能包含 1~ 2h 个节点。）
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：[1,2,3,4,5,6]
 * 输出：true
 * 解释：最后一层前的每一层都是满的（即，结点值为 {1} 和 {2,3} 的两层），且最后一层中的所有结点（{4,5,6}）都尽可能地向左。
 * 示例 2：
 *
 *
 *
 * 输入：[1,2,3,4,5,null,7]
 * 输出：false
 * 解释：值为 7 的结点没有尽可能靠向左侧。
 *  
 *
 * 提示：
 *
 * 树中将会有 1 到 100 个结点。
 * 通过次数13,768提交次数26,564
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @author vann
 * @program GitRep
 * @description
 * @date 2021-03-19:18:11:50
 */
public class LeetCode_958 {
    public static void main(String[] args) {
        LeetCode_958 leetCode = new LeetCode_958();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.isCompleteTree(TestCase.ROOT));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.isCompleteTree(TestCase.ROOT1));
    }

    /**
     * 解法一：
     *
     * @param root
     * @return
     */
    public boolean isCompleteTree(TreeNode root) {
        List<Help> list = new ArrayList<>();
        list.add(new Help(root, 1));

        int i = 0;
        while(i < list.size()) {
            Help help = list.get(i);
            if(help.node != null) {
                list.add(new Help(help.node.left, help.code*2));
                list.add(new Help(help.node.right, help.code*2+1));
            }
            i ++;
        }

        return list.get(i-1).code == list.size();
    }

    class Help {
        TreeNode node;
        int code;
        Help(TreeNode node, int code) {
            this.node = node;
            this.code = code;
        }
    }

    static class TestCase {
        public static boolean ANS = true;
        public static TreeNode ROOT = TreeNode.deserialize("[1,2,3,4,5,6]");

        public static boolean ANS1 = false;
        public static TreeNode ROOT1 = TreeNode.deserialize("[1,2,3,4,5,null,7]");
    }
}
