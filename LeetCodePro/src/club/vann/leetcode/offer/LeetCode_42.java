package club.vann.leetcode.offer;

import org.omg.CORBA.INTERNAL;

/**
 * <p>难度：Easy</p>
 * <p>题目：连续子数组的最大和</p>
 * <p>描述：输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 *  
 *
 * 示例1:
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *  
 *
 * 提示：
 *
 * 1 <= arr.length <= 10^5
 * -100 <= arr[i] <= 100
 * 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/
 *
 *  
 *
 * 通过次数33,054提交次数55,397
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-06-30 14:04
 **/
public class LeetCode_42 {
    public static void main(String[] args) {
        LeetCode_42 leetCode = new LeetCode_42();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.maxSubArray1(TestCase.nums));
    }

    /**
     * 解法一：
     * 超时。
     * @param nums
     * @return
     */
    private int maxSubArray(int[] nums) {
        int len = nums.length;

        int max = Integer.MIN_VALUE;
        for(int n = 0; n < len; n ++) {
            int res = nums[n];
            max = Math.max(max, res);
            for(int m = n+1; m < len; m ++) {
                res += nums[m];
                max = Math.max(max, res);
            }
        }

        return max;
    }

    /**
     * 解法二：
     * dp[i] 为截至索引i的和
     * @param nums
     * @return
     */
    private int maxSubArray1(int[] nums) {
        int len = nums.length;

        int max = Integer.MIN_VALUE;
        int pre = 0; // 前缀和最大值
        for(int n = len-1; n >= 0; n --) {
            max = Math.max(max, nums[n]);
            max = Math.max(max, nums[n] + pre);
            pre = Math.max(nums[n], nums[n] + pre);
        }

        return max;
    }

    static class TestCase {
        public static final int ANS = 6;
        public static final int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
    }
}
