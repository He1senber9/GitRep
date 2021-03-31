package club.vann.leetcode.race;

import java.util.Arrays;

/**
 * <p>难度：Hard</p>
 * <p>题目：最接近目标值的子序列和</p>
 * <p>描述：给你一个整数数组 nums 和一个目标值 goal 。
 *
 * 你需要从 nums 中选出一个子序列，使子序列元素总和最接近 goal 。也就是说，如果子序列元素和为 sum ，你需要 最小化绝对差 abs(sum - goal) 。
 *
 * 返回 abs(sum - goal) 可能的 最小值 。
 *
 * 注意，数组的子序列是通过移除原始数组中的某些元素（可能全部或无）而形成的数组。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [5,-7,3,5], goal = 6
 * 输出：0
 * 解释：选择整个数组作为选出的子序列，元素和为 6 。
 * 子序列和与目标值相等，所以绝对差为 0 。
 * 示例 2：
 *
 * 输入：nums = [7,-9,15,-2], goal = -5
 * 输出：1
 * 解释：选出子序列 [7,-9,-2] ，元素和为 -4 。
 * 绝对差为 abs(-4 - (-5)) = abs(1) = 1 ，是可能的最小值。
 * 示例 3：
 *
 * 输入：nums = [1,2,3], goal = -7
 * 输出：7
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 40
 * -107 <= nums[i] <= 107
 * -109 <= goal <= 109</p>
 * @author vann
 * @program GitRep
 * @description
 * @date 2021-02-07:11:40:58
 */
public class LeetCode_5675 {
    public static void main(String[] args) {
        LeetCode_5675 leetCode = new LeetCode_5675();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.minAbsDifference(TestCase.NUMS, TestCase.GOAL));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.minAbsDifference(TestCase.NUMS1, TestCase.GOAL1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.minAbsDifference(TestCase.NUMS2, TestCase.GOAL2));
    }

    /**
     * 解法一：
     *
     * @param nums
     * @param goal
     * @return
     */
    public int minAbsDifference(int[] nums, int goal) {
        int len = nums.length;
        int sum = 0;
        // 初始最小值
        int res = Math.abs(sum - goal);
        Arrays.sort(nums);

        for(int i = 0; i < len; i ++) {
            sum += nums[i];
            int val = Math.abs(sum-goal);
            if(val <= res) {
                res = val;
            } else {
                sum -= nums[i];
            }
        }
        return res;
    }

    static class TestCase {
        public static int ANS = 0;
        public static int[] NUMS = {5,-7,3,5};
        public static int GOAL = 6;

        public static int ANS1 = 1;
        public static int[] NUMS1 = {7,-9,15,-2};
        public static int GOAL1 = -5;

        public static int ANS2 = 7;
        public static int[] NUMS2 = {1,2,3};
        public static int GOAL2 = -7;
    }
}
