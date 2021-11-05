package club.vann.leetcode.offer.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>难度：Medium</p>
 * <p>题目：最大整除子集</p>
 * <p>描述：给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[j]) 都应当满足：
 * answer[i] % answer[j] == 0 ，或
 * answer[j] % answer[i] == 0
 * 如果存在多个有效解子集，返回其中任何一个均可。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[1,2]
 * 解释：[1,3] 也会被视为正确答案。
 * 示例 2：
 *
 * 输入：nums = [1,2,4,8]
 * 输出：[1,2,4,8]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 2 * 109
 * nums 中的所有整数 互不相同
 * 通过次数14,893提交次数35,879
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-divisible-subset
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @ClassName LeetCode_368
 * @Description TODO
 * @User fanyu
 * @Date 2021/4/23 8:35
 */
public class LeetCode_368 {
    public static void main(String[] args) {
        LeetCode_368 leetCode = new LeetCode_368();

        List<Integer> list = null;
        list = leetCode.largestDivisibleSubset(TestCase.NUMS);
        list = leetCode.largestDivisibleSubset(TestCase.NUMS1);
        System.out.println("Success");
    }

    /**
     * 解法一：
     *
     * @param nums
     * @return
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxSize = 1, maxVal = dp[0];
        for(int i = 1; i < n; i ++) {
            for(int j = 0; j < i; j ++) {
                if(nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }

            if(dp[i] > maxSize) {
                maxSize = dp[i];
                maxVal = nums[i];
            }
        }

        if(maxSize == 1) {
            ans.add(nums[0]);
            return ans;
        }

        for(int i = n-1; i >= 0; i --) {
            if(dp[i] == maxSize && maxVal % nums[i] == 0) {
                ans.add(nums[i]);
                maxVal = nums[i];
                maxSize --;
            }
        }
        return ans;
    }

    static class TestCase {
        public static int[] NUMS = {1,2,3};
        public static int[] NUMS1 = {1,2,4,8};
    }
}
