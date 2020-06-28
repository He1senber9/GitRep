package club.vann.leetcode.offer.daily;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>难度：Medium</p>
 * <p>题目：长度最小的子数组</p>
 * <p>描述：给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回 0。
 *
 *  
 *
 * 示例：
 *
 * 输入：s = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的连续子数组。
 *  
 *
 * 进阶：
 *
 * 如果你已经完成了 O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 * 通过次数64,737提交次数147,080
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/6/28
 * Time: 20:17
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_209 {

    public static void main(String[] args) {
        LeetCode_209 leetCode = new LeetCode_209();

        System.out.println("Result["+TestCase.ans+"] : " + leetCode.minSubArrayLen(TestCase.s, TestCase.nums));
    }

    /**
     * 解法一：
     * 时间复杂度O(n²)
     * @param s
     * @param nums
     * @return
     */
    private int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int count = 1;

        int ans = Integer.MAX_VALUE;
        for(int n = 0; n < len; n ++) {
            int sum = 0;
            for(int m = n; m < len; m ++) {
                sum += nums[m];
                if(sum >= s) {
                    ans = Math.min(ans, m-n+1);
                    break;
                }
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    /**
     * 采用二分查找
     *
     * @param s
     * @param nums
     * @return
     */
    private int minSubArrayLen1(int s, int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int ans = Integer.MAX_VALUE;
        int len = nums.length;
        // 用于存储nums的前缀和
        // nums[i]表示 索引[0,i-1]的元素的和
        int[] arrays = new int[len+1];
        arrays[0] = 0;
        for(int n = 1; n < len; n ++) {
            arrays[n] = arrays[n-1] + nums[n-1];
        }

        for (int i = 1; i <= len; i++) {
            int target = s + arrays[i - 1];
            int bound = Arrays.binarySearch(arrays, target);
            if (bound < 0) {
                bound = -bound - 1;
            }
            if (bound <= len) {
                ans = Math.min(ans, bound - (i - 1));
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    static class TestCase {
        public static final int ans = 2;
        public static int s = 7;
        public static int[] nums = {2,3,1,2,4,3};
    }
}
