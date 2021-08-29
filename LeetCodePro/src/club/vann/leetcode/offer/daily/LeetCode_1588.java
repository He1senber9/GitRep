package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Easy</p>
 * <p>题目：所有奇数长度子数组的和</p>
 * <p>描述：给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。
 *
 * 子数组 定义为原数组中的一个连续子序列。
 *
 * 请你返回 arr 中 所有奇数长度子数组的和 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [1,4,2,5,3]
 * 输出：58
 * 解释：所有奇数长度子数组和它们的和为：
 * [1] = 1
 * [4] = 4
 * [2] = 2
 * [5] = 5
 * [3] = 3
 * [1,4,2] = 7
 * [4,2,5] = 11
 * [2,5,3] = 10
 * [1,4,2,5,3] = 15
 * 我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
 * 示例 2：
 *
 * 输入：arr = [1,2]
 * 输出：3
 * 解释：总共只有 2 个长度为奇数的子数组，[1] 和 [2]。它们的和为 3 。
 * 示例 3：
 *
 * 输入：arr = [10,11,12]
 * 输出：66
 *  
 *
 * 提示：
 *
 * 1 <= arr.length <= 100
 * 1 <= arr[i] <= 1000
 * 通过次数22,494提交次数27,822
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @description:
 * @program: GitRep
 * @author: fanyu
 * @create: 2021-08-29  07:55:26
 */
public class LeetCode_1588 {
    public static void main(String[] args) {
        LeetCode_1588 leetCode = new LeetCode_1588();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.sumOddLengthSubarrays(TestCase.ARR));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.sumOddLengthSubarrays(TestCase.ARR1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.sumOddLengthSubarrays(TestCase.ARR2));
    }

    /**
     * 解法一：
     *
     * @param arr
     * @return
     */
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int[] preSums = new int[n+1];
        preSums[1] = arr[0];

        for(int i = 1; i < n; i ++) {
            preSums[i+1] = preSums[i] + arr[i];
        }

        int ans = 0;
        for(int right = 1; right <= n; right ++) {
            for(int left = 1; left <=right; left ++) {
                if((right-left+1) % 2 != 0) {
                    ans += preSums[right]-preSums[left-1];
                    left ++;
                }
            }
        }

        return ans;
    }

    static class TestCase {
        public static int ANS = 58;
        public static int[] ARR = {1,4,2,5,3};

        public static int ANS1 = 3;
        public static int[] ARR1 = {1,2};

        public static int ANS2 = 66;
        public static int[] ARR2 = {10,11,12};
    }
}
