package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Hard</p>
 * <p>题目：按要求补齐数组</p>
 * <p>描述：给定一个已排序的正整数数组 nums，和一个正整数 n 。从 [1, n] 区间内选取任意个数字补充到 nums 中，使得 [1, n] 区间内的任何数字都可以用 nums 中某几个数字的和来表示。请输出满足上述要求的最少需要补充的数字个数。
 *
 * 示例 1:
 *
 * 输入: nums = [1,3], n = 6
 * 输出: 1
 * 解释:
 * 根据 nums 里现有的组合 [1], [3], [1,3]，可以得出 1, 3, 4。
 * 现在如果我们将 2 添加到 nums 中， 组合变为: [1], [2], [3], [1,3], [2,3], [1,2,3]。
 * 其和可以表示数字 1, 2, 3, 4, 5, 6，能够覆盖 [1, 6] 区间里所有的数。
 * 所以我们最少需要添加一个数字。
 * 示例 2:
 *
 * 输入: nums = [1,5,10], n = 20
 * 输出: 2
 * 解释: 我们需要添加 [2, 4]。
 * 示例 3:
 *
 * 输入: nums = [1,2,2], n = 5
 * 输出: 0
 * 通过次数4,344提交次数9,329
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/patching-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-12-29 09:22
 **/
public class LeetCode_330 {
    public static void main(String[] args) {
        LeetCode_330 leetCode = new LeetCode_330();

//        System.out.println("Result["+ TestCase.ANS+"] : " + leetCode.minPatches(TestCase.NUMS, TestCase.N));
//        System.out.println("Result["+ TestCase.ANS1+"] : " + leetCode.minPatches(TestCase.NUMS1, TestCase.N1));
//        System.out.println("Result["+ TestCase.ANS2+"] : " + leetCode.minPatches(TestCase.NUMS2, TestCase.N2));
        System.out.println("Result["+ TestCase.ANS3+"] : " + leetCode.minPatches(TestCase.NUMS3, TestCase.N3));
        System.out.println("Result["+ TestCase.ANS4+"] : " + leetCode.minPatches(TestCase.NUMS4, TestCase.N4));
    }

    /**
     * 解法一：
     *
     * @param nums
     * @param n
     * @return
     */
    public int minPatches(int[] nums, int n) {
        int len = nums.length;
        int res = 0;
        long max = 1;
        int index = 0;
        while(max <= n) {
            if(index < len && nums[index] <= max) {
                max += nums[index++];
            } else {
                max += max;
                res ++;
            }
        }

        return res;
    }

    static class TestCase {
        public static int ANS = 1;
        public static int[] NUMS = {1,3};
        public static int N = 6;

        public static int ANS1 = 2;
        public static int[] NUMS1 = {1,5,10};
        public static int N1 = 20;

        public static int ANS2 = 0;
        public static int[] NUMS2 = {1,2,2};
        public static int N2 = 5;

        public static int ANS3 = 0;
        public static int[] NUMS3 = {1,2,31,33};
        public static int N3 = 2147483647;

        public static int ANS4 = 3;
        public static int[] NUMS4 = {};
        public static int N4 = 7;
    }
}
