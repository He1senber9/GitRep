package club.vann.leetcode.offer.daily;

import java.util.Arrays;

/**
 * <p>难度：Hard</p>
 * <p>题目：分割数组的最大值</p>
 * <p>描述：给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。设计一个算法使得这 m 个子数组各自和的最大值最小。
 *
 * 注意:
 * 数组长度 n 满足以下条件:
 *
 * 1 ≤ n ≤ 1000
 * 1 ≤ m ≤ min(50, n)
 * 示例:
 *
 * 输入:
 * nums = [7,2,5,10,8]
 * m = 2
 *
 * 输出:
 * 18
 *
 * 解释:
 * 一共有四种方法将nums分割为2个子数组。
 * 其中最好的方式是将其分为[7,2,5] 和 [10,8]，
 * 因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
 * 通过次数8,899提交次数19,698
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-array-largest-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/7/25
 * Time: 9:11
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_410 {
    public static void main(String[] args) {
        LeetCode_410 leetCode = new LeetCode_410();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.splitArray1(TestCase.NUMS, TestCase.M));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.splitArray1(TestCase.NUMS1, TestCase.M1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.splitArray1(TestCase.NUMS2, TestCase.M2));
    }

    /**
     * 解法一：
     *
     * @param nums
     * @param m
     * @return
     */
    private int splitArray(int[] nums, int m) {
        int len = nums.length;
        int left = 0, right = 0;
        for(int n = 0; n < len; n ++) {
            right += nums[n];
            if(left < nums[n]) {
                left = nums[n];
            }
        }

        while(left < right) {
            int mid = left + (right-left)/2;
            if(sum(nums, mid, m)) { // 计算数组和为mid时数组个数是否小于m
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return left;
    }

    /**
     *
     * @param nums
     * @param tag
     * @param m
     * @return true:
     */
    private boolean sum(int[] nums, int tag, int m) {
        int sum = 0;
        int cnt = 1;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] > tag) {
                cnt++;
                sum = nums[i];
            } else {
                sum += nums[i];
            }
        }
        return cnt <= m;
    }

    /**
     * 解法二：
     *
     * 动态规划
     *
     * @param nums
     * @param m
     * @return
     */
    private int splitArray1(int[] nums, int m) {
        int len = nums.length;
        int[][] dp = new int[len+1][m+1];

        int[] arrays = new int[len+1];
        arrays[0] = nums[0];
        for(int n = 0; n < len; n ++) {
            arrays[n+1] = arrays[n] +nums[n];
        }

        for (int i = 0; i <= len; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[0][0] = 0;
        for(int i = 1; i <= len; i ++) {
            for(int j = 1; j <= Math.min(i, m); j ++) {
                for(int x = j-1; x < i; x ++) {
                    int prev = Math.max(dp[x][j-1], arrays[i]-arrays[x]);
                    dp[i][j] = Math.min(dp[i][j], prev);
                }
            }
        }
        return dp[len][m];
    }

    static class TestCase {
        public static int ANS = 18;
        public static int M = 2;
        public static int[] NUMS = {7,2,5,10,8};

        public static int ANS1 = 14;
        public static int M1 = 3;
        public static int[] NUMS1 = {7,2,5,10,8};

        public static int ANS2 = 11;
        public static int M2 = 2;
        public static int[] NUMS2 = {1,2,3,4,5,6};
    }
}
