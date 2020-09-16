package club.vann.leetcode;

import club.vann.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCodePro
 * @description:
 * @author: vann
 * @create: 2020-09-16 11:12
 **/
public class LeetCode_102 {
    public static void main(String[] args) {
        LeetCode_102 leetCode = new LeetCode_102();
        List<List<Integer>> res = null;
        res = leetCode.levelOrder(TestCase.node);
        System.out.println("Success");
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }

        LinkedList<TreeNode> linkedList = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        linkedList.offer(root);

        int count_p = 1; // 父层计数
        int count_c = 0; // 子层计数
        while(!linkedList.isEmpty()) {
            TreeNode node = linkedList.pollFirst();
            list.add(node.val);
            count_p --;

            if(node.left != null) {
                linkedList.offer(node.left);
                count_c ++;
            }

            if(node.right != null) {
                linkedList.offer(node.right);
                count_c ++;
            }

            if(count_p == 0) {
                count_p = count_c;
                count_c = 0;
                res.add(list);
                list = new ArrayList<>();
            }
        }
        return res;
    }

    static class TestCase {
        public static TreeNode node = TreeNode.deserialize("[3,9,20,null,null,15,7]");
    }
}
