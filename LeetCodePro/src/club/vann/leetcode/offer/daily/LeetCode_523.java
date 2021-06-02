package club.vann.leetcode.offer.daily;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>难度：Medium</p>
 * <p>题目：连续的子数组和</p>
 * <p>描述：给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
 *
 * 子数组大小 至少为 2 ，且
 * 子数组元素总和为 k 的倍数。
 * 如果存在，返回 true ；否则，返回 false 。
 *
 * 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [23,2,4,6,7], k = 6
 * 输出：true
 * 解释：[2,4] 是一个大小为 2 的子数组，并且和为 6 。
 * 示例 2：
 *
 * 输入：nums = [23,2,6,4,7], k = 6
 * 输出：true
 * 解释：[23, 2, 6, 4, 7] 是大小为 5 的子数组，并且和为 42 。
 * 42 是 6 的倍数，因为 42 = 7 * 6 且 7 是一个整数。
 * 示例 3：
 *
 * 输入：nums = [23,2,6,4,7], k = 13
 * 输出：false
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 109
 * 0 <= sum(nums[i]) <= 231 - 1
 * 1 <= k <= 231 - 1
 * 通过次数33,229提交次数143,483
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/continuous-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @description:
 * @program: GitRep
 * @author: fanyu
 * @create: 2021-06-02  08:24:20
 */
public class LeetCode_523 {
    public static void main(String[] args) {
        LeetCode_523 leetCode = new LeetCode_523();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.checkSubarraySum1(TestCase.NUMS, TestCase.K));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.checkSubarraySum1(TestCase.NUMS1, TestCase.K1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.checkSubarraySum1(TestCase.NUMS2, TestCase.K2));
    }

    /**
     * 解法一：
     * @param nums
     * @param k
     * @return
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        // 解法一：
        int n = nums.length;
        if(n == 1) {
            return false;
        }
        for(int i = 0; i < n-1; i ++) {
            int sum = nums[i];
            for(int j = i+1; j < n; j ++) {
                sum += nums[j];
                if(sum % k == 0) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 解法二：
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean checkSubarraySum1(int[] nums, int k) {
        int n = nums.length;
        // 前缀和
        int[] pre = new int[n];
        pre[0] = nums[0];
        for(int i = 1; i < n; i ++) {
            pre[i] = pre[i-1] + nums[i];
        }

        // k:数组的和%k；v:索引位置
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i = 0; i < n; i ++) {
            int val = (pre[i]%k);
            if(map.containsKey(val)) {
                int preIndex = map.get(val);
                if(i-preIndex >= 2) {
                    return true;
                }
            } else {
                map.put(val, i);
            }
        }
        return false;
    }

    static class TestCase {
        public static boolean ANS = true;
        public static int[] NUMS = {23,2,4,6,7};
        public static int K = 6;

        public static boolean ANS1 = true;
        public static int[] NUMS1 = {23,2,6,4,7};
        public static int K1 = 6;

        public static boolean ANS2 = false;
        public static int[] NUMS2 = {23,2,6,4,7};
        public static int K2 = 13;
    }
}
