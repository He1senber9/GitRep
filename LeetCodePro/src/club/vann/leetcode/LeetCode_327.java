package club.vann.leetcode;

/**
 * <p>难度：Hard</p>
 * <p>题目：区间和的个数</p>
 * <p>描述：给定一个整数数组 nums，返回区间和在 [lower, upper] 之间的个数，包含 lower 和 upper。
 * 区间和 S(i, j) 表示在 nums 中，位置从 i 到 j 的元素之和，包含 i 和 j (i ≤ j)。
 *
 * 说明:
 * 最直观的算法复杂度是 O(n2) ，请在此基础上优化你的算法。
 *
 * 示例:
 *
 * 输入: nums = [-2,5,-1], lower = -2, upper = 2,
 * 输出: 3
 * 解释: 3个区间分别是: [0,0], [2,2], [0,2]，它们表示的和分别为: -2, -1, 2。
 * 通过次数19,683提交次数45,634
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-of-range-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: LeetCodePro
 * @description:
 * @author: vann
 * @create: 2020-12-01 08:40
 **/
public class LeetCode_327 {
    public static void main(String[] args) {
        LeetCode_327 leetCode = new LeetCode_327();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.countRangeSum(TestCase.NUMS, TestCase.LOWER, TestCase.UPPER));
    }

    /**
     * 解法一：
     * 时间复杂度：O(n²)
     * @param nums
     * @param lower
     * @param upper
     * @return
     */
    public int countRangeSum(int[] nums, int lower, int upper) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int ans = 0;
        int len = nums.length;
        for(int i = 0; i < len; i ++) {
            if(lower <= nums[i] && nums[i] <= upper) {
                ans ++;
            }

            int sum = nums[i];
            for(int j = i; j < len; j ++) {
                if(lower <= sum + nums[j] && sum + nums[j] <= upper) {
                    ans ++;
                }
            }
        }
        return ans;
    }

    static class TestCase {
        public static int ANS = 3;
        public static int[] NUMS = {-2,5,-1};
        public static int LOWER = -2;
        public static int UPPER = 2;
    }
}
