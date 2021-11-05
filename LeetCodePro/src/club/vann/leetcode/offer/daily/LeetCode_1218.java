package club.vann.leetcode.offer.daily;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>难度：Medium</p>
 * <p>题目：最长定差子序列</p>
 * <p>描述：给你一个整数数组 arr 和一个整数 difference，请你找出并返回 arr 中最长等差子序列的长度，该子序列中相邻元素之间的差等于 difference 。
 *
 * 子序列 是指在不改变其余元素顺序的情况下，通过删除一些元素或不删除任何元素而从 arr 派生出来的序列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [1,2,3,4], difference = 1
 * 输出：4
 * 解释：最长的等差子序列是 [1,2,3,4]。
 * 示例 2：
 *
 * 输入：arr = [1,3,5,7], difference = 1
 * 输出：1
 * 解释：最长的等差子序列是任意单个元素。
 * 示例 3：
 *
 * 输入：arr = [1,5,7,8,5,3,4,2,1], difference = -2
 * 输出：4
 * 解释：最长的等差子序列是 [7,5,3,1]。
 *  
 *
 * 提示：
 *
 * 1 <= arr.length <= 105
 * -104 <= arr[i], difference <= 104
 * 通过次数29,979提交次数59,494
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-arithmetic-subsequence-of-given-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: GitRep
 * @description:
 * @author: fanyu
 * @create: 2021/11/05 21:42
 */
public class LeetCode_1218 {
    public static void main(String[] args) {
        LeetCode_1218 leetCode = new LeetCode_1218();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.longestSubsequence(TestCase.ARR, TestCase.DIFFERENCE));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.longestSubsequence(TestCase.ARR1, TestCase.DIFFERENCE1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.longestSubsequence(TestCase.ARR2, TestCase.DIFFERENCE2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.longestSubsequence(TestCase.ARR3, TestCase.DIFFERENCE3));
        System.out.println("Result["+TestCase.ANS4+"] : " + leetCode.longestSubsequence(TestCase.ARR4, TestCase.DIFFERENCE4));
        System.out.println("Result["+TestCase.ANS5+"] : " + leetCode.longestSubsequence(TestCase.ARR5, TestCase.DIFFERENCE5));
    }

    /**
     * 解法一：
     *
     * @param arr
     * @param difference
     * @return
     */
    public int longestSubsequence(int[] arr, int difference) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int max = 1;
        for(int i = 1; i < n; i ++) {
            for(int j = i-1; j >= 0; j --) {
                if(arr[i] - arr[j] == difference) {
                    dp[i] = dp[j] + 1;
                    break;
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * 解法二：
     *
     * @param arr
     * @param difference
     * @return
     */
    public int longestSubsequence1(int[] arr, int difference) {
        int ans = 0;
        Map<Integer, Integer> dp = new HashMap<Integer, Integer>();

        for (int v : arr) {
            dp.put(v, dp.getOrDefault(v - difference, 0) + 1);
            ans = Math.max(ans, dp.get(v));
        }
        return ans;
    }

    static class TestCase {
        public static int ANS = 4;
        public static int[] ARR = {1,2,3,4};
        public static int DIFFERENCE = 1;

        public static int ANS1 = 1;
        public static int[] ARR1 = {1,3,5,7};
        public static int DIFFERENCE1 = 1;

        public static int ANS2 = 4;
        public static int[] ARR2 = {1,5,7,8,5,3,4,2,1};
        public static int DIFFERENCE2 = -2;

        public static int ANS3 = 2;
        public static int[] ARR3 = {3,4,-3,-2,-4};
        public static int DIFFERENCE3 = -5;

        public static int ANS4 = 2;
        public static int[] ARR4 = {4,12,10,0,-2,7,-8,9,-9,-12,-12,8,8};
        public static int DIFFERENCE4 = 0;

        public static int ANS5 = 2;
        public static int[] ARR5 = {3,4,-3,-2,-4};
        public static int DIFFERENCE5 = -5;
    }
}
