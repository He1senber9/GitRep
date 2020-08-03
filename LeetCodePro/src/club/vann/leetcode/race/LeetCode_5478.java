package club.vann.leetcode.race;

/**
 * <p>难度：Hard</p>
 * <p>题目：最大得分</p>
 * <p>描述：你有两个 有序 且数组内元素互不相同的数组 nums1 和 nums2 。
 *
 * 一条 合法路径 定义如下：
 *
 * 选择数组 nums1 或者 nums2 开始遍历（从下标 0 处开始）。
 * 从左到右遍历当前数组。
 * 如果你遇到了 nums1 和 nums2 中都存在的值，那么你可以切换路径到另一个数组对应数字处继续遍历（但在合法路径中重复数字只会被统计一次）。
 * 得分定义为合法路径中不同数字的和。
 *
 * 请你返回所有可能合法路径中的最大得分。
 *
 * 由于答案可能很大，请你将它对 10^9 + 7 取余后返回。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：nums1 = [2,4,5,8,10], nums2 = [4,6,8,9]
 * 输出：30
 * 解释：合法路径包括：
 * [2,4,5,8,10], [2,4,5,8,9], [2,4,6,8,9], [2,4,6,8,10],（从 nums1 开始遍历）
 * [4,6,8,9], [4,5,8,10], [4,5,8,9], [4,6,8,10]  （从 nums2 开始遍历）
 * 最大得分为上图中的绿色路径 [2,4,6,8,10] 。
 * 示例 2：
 *
 * 输入：nums1 = [1,3,5,7,9], nums2 = [3,5,100]
 * 输出：109
 * 解释：最大得分由路径 [1,3,5,100] 得到。
 * 示例 3：
 *
 * 输入：nums1 = [1,2,3,4,5], nums2 = [6,7,8,9,10]
 * 输出：40
 * 解释：nums1 和 nums2 之间无相同数字。
 * 最大得分由路径 [6,7,8,9,10] 得到。
 * 示例 4：
 *
 * 输入：nums1 = [1,4,5,8,9,11,19], nums2 = [2,3,4,11,12]
 * 输出：61
 *
 *
 * 提示：
 *
 * 1 <= nums1.length <= 10^5
 * 1 <= nums2.length <= 10^5
 * 1 <= nums1[i], nums2[i] <= 10^7
 * nums1 和 nums2 都是严格递增的数组。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/8/2
 * Time: 11:08
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_5478 {
    public static void main(String[] args) {
        LeetCode_5478 leetCode = new LeetCode_5478();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.maxSum(TestCase.NUMS1, TestCase.NUMS2));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.maxSum(TestCase.NUMS11, TestCase.NUMS21));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.maxSum(TestCase.NUMS12, TestCase.NUMS22));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.maxSum(TestCase.NUMS13, TestCase.NUMS23));
    }

    /**
     * 解法一：
     * 动态规划
     * dp[i][j]表示nums1中索引i，nums2中索引j路径最大
     * @param nums1
     * @param nums2
     * @return
     */
    private int maxSum(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        return 0;
    }

    static class TestCase {
        public static int ANS = 30;
        public static int[] NUMS1 = {2,4,5,8,10};
        public static int[] NUMS2 = {4,6,8,9};

        public static int ANS1 = 109;
        public static int[] NUMS11 = {1,3,5,7,9};
        public static int[] NUMS21 = {3,5,100};

        public static int ANS2 = 40;
        public static int[] NUMS12 = {1,2,3,4,5};
        public static int[] NUMS22 = {6,7,8,9,10};

        public static int ANS3 = 61;
        public static int[] NUMS13 = {1,4,5,8,9,11,19};
        public static int[] NUMS23 = {2,3,4,11,12};
    }
}
