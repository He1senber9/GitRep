package club.vann.leetcode;

/**
 * <p>难度：Hard</p>
 * <p>题目：滑动窗口最大值</p>
 * <p>描述：给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 *  
 *
 * 进阶：
 *
 * 你能在线性时间复杂度内解决此题吗？
 *
 *  
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 1 <= k <= nums.length
 * 通过次数88,685提交次数180,653
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: LeetCodePro
 * @description:
 * @author: vann
 * @create: 2020-11-25 20:24
 **/
public class LeetCode_239 {
    public static void main(String[] args) {
        LeetCode_239 leetCode = new LeetCode_239();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.maxSlidingWindow(TestCase.NUMS, TestCase.K));
    }

    /**
     * 解法一：
     * 超时
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] ans = new int[len-k+1];

        for(int i = 0; i < ans.length; i ++) {
            int max = nums[i];
            for(int j = i; j < i+k; j ++) {
                max = Math.max(max, nums[j]);
            }
            ans[i] = max;
        }

        return ans;
    }

    static class TestCase {
        public static int[] ANS = {3,3,5,5,6,7};
        public static int[] NUMS = {1,3,-1,-3,5,3,6,7};
        public static int K = 3;
    }
}
