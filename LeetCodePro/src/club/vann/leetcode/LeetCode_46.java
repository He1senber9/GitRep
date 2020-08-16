package club.vann.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/8/3
 * Time: 22:04
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_46 {
    public static void main(String[] args) {
        LeetCode_46 leetCode = new LeetCode_46();

        List<List<Integer>> res = leetCode.permute(TestCase.NUMS);
        for(List<Integer> list : res) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        LinkedList<Integer> list = new LinkedList<>();

        dfs(nums, res, list);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, LinkedList<Integer> list) {
        if(list.size() == nums.length) {
            res.add(new LinkedList<>(list));
            return;
        }

        for(int i = 0; i < nums.length; i ++) {
            if(list.contains(nums[i])) {
                continue;
            }

            list.addLast(nums[i]);
            dfs(nums, res, list);
            list.pollLast();
        }
    }

    static class TestCase {
        public static int[][] ANS = {{1, 2, 3}, {1, 3, 2}, {2, 1, 3}, {2, 3, 1}, {3, 1, 2}, {3, 2, 1}};
        public static int[] NUMS = {1,2,3};
    }
}
