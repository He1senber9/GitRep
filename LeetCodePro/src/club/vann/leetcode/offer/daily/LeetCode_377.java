package club.vann.leetcode.offer.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>难度：Meidum</p>
 * <p>题目：组合总和IV</p>
 * <p>描述：给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 *
 * 题目数据保证答案符合 32 位整数范围。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3], target = 4
 * 输出：7
 * 解释：
 * 所有可能的组合为：
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * 请注意，顺序不同的序列被视作不同的组合。
 * 示例 2：
 *
 * 输入：nums = [9], target = 3
 * 输出：0
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 1000
 * nums 中的所有元素 互不相同
 * 1 <= target <= 1000
 *  
 *
 * 进阶：如果给定的数组中含有负数会发生什么？问题会产生何种变化？如果允许负数出现，需要向题目中添加哪些限制条件？
 *
 * 通过次数28,531提交次数63,260
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iv
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @ClassName LeetCode_377
 * @Description TODO
 * @User fanyu
 * @Date 2021/4/24 8:52
 */
public class LeetCode_377 {
    public static void main(String[] args) {
        LeetCode_377 leetCode = new LeetCode_377();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.combinationSum4(TestCase.NUMS, TestCase.TARGET));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.combinationSum4(TestCase.NUMS1, TestCase.TARGET1));
    }

    /**
     * 解法一：
     *
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target+1];
        dp[0] = 1;

        for(int i =1; i <= target; i ++) {
            for(int num : nums) {
                if(num <= i) {
                    dp[i] += dp[i-num];
                }
            }
        }
        return dp[target];
    }

    static class TestCase {
        public static int ANS = 7;
        public static int[] NUMS = {1,2,3};
        public static int TARGET = 4;

        public static int ANS1 = 0;
        public static int[] NUMS1 = {9};
        public static int TARGET1 = 3;
    }
}
