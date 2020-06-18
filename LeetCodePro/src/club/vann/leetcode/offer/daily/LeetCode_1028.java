package club.vann.leetcode.offer.daily;

import club.vann.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>难度：Hard</p>
 * <p>题目：从先序遍历还原二叉树</p>
 * <p>描述：我们从二叉树的根节点 root 开始进行深度优先搜索。
 *
 * 在遍历中的每个节点处，我们输出 D 条短划线（其中 D 是该节点的深度），然后输出该节点的值。（如果节点的深度为 D，则其直接子节点的深度为 D + 1。根节点的深度为 0）。
 *
 * 如果节点只有一个子节点，那么保证该子节点为左子节点。
 *
 * 给出遍历输出 S，还原树并返回其根节点 root。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入："1-2--3--4-5--6--7"
 * 输出：[1,2,5,3,4,6,7]
 * 示例 2：
 *
 *
 *
 * 输入："1-2--3---4-5--6---7"
 * 输出：[1,2,5,3,null,6,null,4,null,7]
 * 示例 3：
 *
 *
 *
 * 输入："1-401--349---90--88"
 * 输出：[1,401,null,349,88,90]
 *  
 *
 * 提示：
 *
 * 原始树中的节点数介于 1 和 1000 之间。
 * 每个节点的值介于 1 和 10 ^ 9 之间。
 * 通过次数4,401提交次数6,363
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/recover-a-tree-from-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-06-18 09:55
 **/
public class LeetCode_1028 {
    public static void main(String[] args) {
        LeetCode_1028 leetCode = new LeetCode_1028();

        System.out.println(leetCode.recoverFromPreorder(TestCase.STR));
        System.out.println(leetCode.recoverFromPreorder(TestCase.STR1));
        System.out.println(leetCode.recoverFromPreorder(TestCase.STR2));
    }

    /**
     * 解法一：
     * 采用状态机解决
     * @param S
     * @return
     */
    private TreeNode recoverFromPreorder(String S) {
        if(S == null || "".equals(S)) {
            return null;
        }

        Map<Integer, TreeNode> map = new HashMap<>();

        int depth = 0;
        int index = 0;
        int len = S.length();

        while(index < len) {
            // 统计深度
            int i = index;
            while(index < len && S.charAt(index) == '-') {
                index ++;
            }
            if(i < index) {
                depth = index-i;
            }

            // 统计数值
            int t = index;
            while(index < len && '0' <= S.charAt(index) && S.charAt(index) <= '9') {
                index ++;
            }
            if(t < index) {
                int val = Integer.parseInt(S.substring(t, index));
                TreeNode curNode = new TreeNode(val);
                TreeNode p = map.get(depth-1);
                if(p == null) {

                } else {
                    if(p.left != null) {
                        p.right = curNode;
                    } else {
                        p.left = curNode;
                    }
                }

                map.put(depth, curNode);
            }

        }

        return map.get(0);
    }

    private TreeNode recoverFromPreorder(TreeNode node, int depth) {
        return null;
    }

    static class TestCase {
        public static final String STR = "1-2--3--4-5--6--7";
        public static final String STR1 = "1-2--3---4-5--6---7";
        public static final String STR2 = "1-401--349---90--88";
    }
}
