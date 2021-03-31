package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Easy</p>
 * <p>题目：子数组最大平均数I</p>
 * <p>描述：给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 *
 *  
 *
 * 示例：
 *
 * 输入：[1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 *  
 *
 * 提示：
 *
 * 1 <= k <= n <= 30,000。
 * 所给数据范围 [-10,000，10,000]。
 * 通过次数26,514提交次数64,110
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-average-subarray-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @author vann
 * @program GitRep
 * @description
 * @date 2021-02-04:09:11:16
 */
public class LeetCode_643 {
    public static void main(String[] args) {
        LeetCode_643 leetCode = new LeetCode_643();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.findMaxAverage(TestCase.NUMS, TestCase.K));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.findMaxAverage(TestCase.NUMS1, TestCase.K1));
    }

    /**
     * 解法一：
     *
     * @param nums
     * @param k
     * @return
     */
    public double findMaxAverage(int[] nums, int k) {
        int len = nums.length;
        double ans = Integer.MIN_VALUE;

        int sum = 0;
        int count = 0;
        for(int i = 0; i < len; i ++) {
            count ++;
            sum += nums[i];
            if(count == k) {
                // 计算平均数
                ans = Math.max(ans, (double)sum/k);
                sum -= nums[i-k+1];
                count --;
            }
        }
        return ans;
    }

    static class TestCase {
        public static double ANS = 12.75;
        public static int[] NUMS = {1,12,-5,-6,50,3};
        public static int K = 4;

        public static double ANS1 = 2147483647.0;
        public static int[] NUMS1 = {2147483647,2147483647,2147483647};
        public static int K1 = 3;
    }
}
