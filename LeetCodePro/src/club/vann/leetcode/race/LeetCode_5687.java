package club.vann.leetcode.race;

/**
 * <p>难度：Medium</p>
 * <p>题目：执行乘法运算的最大分数</p>
 * <p>描述：给你两个长度分别 n 和 m 的整数数组 nums 和 multipliers ，其中 n >= m ，数组下标 从 1 开始 计数。
 *
 * 初始时，你的分数为 0 。你需要执行恰好 m 步操作。在第 i 步操作（从 1 开始 计数）中，需要：
 *
 * 选择数组 nums 开头处或者末尾处 的整数 x 。
 * 你获得 multipliers[i] * x 分，并累加到你的分数中。
 * 将 x 从数组 nums 中移除。
 * 在执行 m 步操作后，返回 最大 分数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3], multipliers = [3,2,1]
 * 输出：14
 * 解释：一种最优解决方案如下：
 * - 选择末尾处的整数 3 ，[1,2,3] ，得 3 * 3 = 9 分，累加到分数中。
 * - 选择末尾处的整数 2 ，[1,2] ，得 2 * 2 = 4 分，累加到分数中。
 * - 选择末尾处的整数 1 ，[1] ，得 1 * 1 = 1 分，累加到分数中。
 * 总分数为 9 + 4 + 1 = 14 。
 * 示例 2：
 *
 * 输入：nums = [-5,-3,-3,-2,7,1], multipliers = [-10,-5,3,4,6]
 * 输出：102
 * 解释：一种最优解决方案如下：
 * - 选择开头处的整数 -5 ，[-5,-3,-3,-2,7,1] ，得 -5 * -10 = 50 分，累加到分数中。
 * - 选择开头处的整数 -3 ，[-3,-3,-2,7,1] ，得 -3 * -5 = 15 分，累加到分数中。
 * - 选择开头处的整数 -3 ，[-3,-2,7,1] ，得 -3 * 3 = -9 分，累加到分数中。
 * - 选择末尾处的整数 1 ，[-2,7,1] ，得 1 * 4 = 4 分，累加到分数中。
 * - 选择末尾处的整数 7 ，[-2,7] ，得 7 * 6 = 42 分，累加到分数中。
 * 总分数为 50 + 15 - 9 + 4 + 42 = 102 。
 *
 *
 * 提示：
 *
 * n == nums.length
 * m == multipliers.length
 * 1 <= m <= 103
 * m <= n <= 105
 * -1000 <= nums[i], multipliers[i] <= 1000</p>
 * @author vann
 * @program GitRep
 * @description
 * @date 2021-02-21:11:21:15
 */
public class LeetCode_5687 {
    public static void main(String[] args) {
        LeetCode_5687 leetCode = new LeetCode_5687();

//        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.maximumScore(TestCase.NUMS, TestCase.MULTIPLIERS));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.maximumScore(TestCase.NUMS1, TestCase.MULTIPLIERS1));
    }

    /**
     *
     * @param nums
     * @param multipliers
     * @return
     */
    public int maximumScore(int[] nums, int[] multipliers) {
        int N = nums.length;
        int M = multipliers.length;

        return 0;
    }

    static class TestCase {
        public static int ANS = 14;
        public static int[] NUMS = {1,2,3};
        public static int[] MULTIPLIERS = {3,2,1};

        public static int ANS1 = 102;
        public static int[] NUMS1 = {-5,-3,-3,-2,7,1};
        public static int[] MULTIPLIERS1 = {-10,-5,3,4,6};
    }
}
