package club.vann.leetcode.offer.daily;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/4/25
 * Time: 11:15
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_46 {
    public static void main(String[] args) {
        LeetCode_46 leetCode = new LeetCode_46();
        List<List<Integer>> result = null;

        result = leetCode.permute(TestCase.nums);

        System.out.println("Success");
    }

    /**
     * 解法一：
     * 暴力全排列
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        return null;
    }

    static class TestCase {
        public static final int[] nums = {1,2,3};
    }
}
