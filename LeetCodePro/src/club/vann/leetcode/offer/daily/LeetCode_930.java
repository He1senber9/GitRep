package club.vann.leetcode.offer.daily;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @program: GitRep
 * @author: fanyu
 * @create: 2021-07-08  08:45:37
 */
public class LeetCode_930 {
    public static void main(String[] args) {
        LeetCode_930 leetCode = new LeetCode_930();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.numSubarraysWithSum(TestCase.NUMS, TestCase.GOAL));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.numSubarraysWithSum(TestCase.NUMS1, TestCase.GOAL1));
    }

    /**
     * 解法一：
     *
     * @param nums
     * @param goal
     * @return
     */
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;

        // 子数组(i,j]和和为goal，即 sum[j] - sum[i] = goal
        int res = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i ++) {
            // 记录 sum[i] 的个数
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            // 得到 sum[j]
            sum += nums[i];
            res += map.getOrDefault(sum-goal, 0);
        }
        return res;
    }

    static class TestCase {
        public static int ANS = 4;
        public static int[] NUMS = {1,0,1,0,1};
        public static int GOAL = 2;

        public static int ANS1 = 15;
        public static int[] NUMS1 = {0,0,0,0,0};
        public static int GOAL1 = 0;
    }
}
