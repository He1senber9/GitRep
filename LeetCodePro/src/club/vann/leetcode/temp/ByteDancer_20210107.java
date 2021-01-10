package club.vann.leetcode.temp;

import club.vann.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ByteDancerTest
 * @Description TODO
 * @User fanyu
 * @Date 2021/1/7 15:17
 */
public class ByteDancer_20210107 {
    public static void main(String[] args) {
        ByteDancer_20210107 dancer = new ByteDancer_20210107();

        List<List<Integer>> res;
        res = dancer.findPath(TestCase.NODE, 4);

        for(List<Integer> list : res) {

        }
        System.out.println();
    }

    private List<List<Integer>> findPath(TreeNode head, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(res, path, head, k, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> path, TreeNode node, int k, int sum) {
        if(node == null) {
            return;
        }

        sum += node.val;
        if(sum == k && node.left == null && node.right == null) { // 和为k，且是叶子节点
            path.add(node.val);
            res.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return;
        }

        path.add(node.val);
        // 计算左子树
        dfs(res, path, node.left, k, sum);
        dfs(res, path, node.right, k, sum);
        path.remove(path.size()-1);
    }

    static class TestCase {
        public static TreeNode NODE = TreeNode.deserialize("[0,1,2,3,4,2]");
    }
}
