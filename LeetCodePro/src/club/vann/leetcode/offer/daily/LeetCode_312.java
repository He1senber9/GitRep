package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Hard</p>
 * <p>题目：戳气球</p>
 * <p>描述：有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 *
 * 现在要求你戳破所有的气球。如果你戳破气球 i ，就可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的 left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。
 *
 * 求所能获得硬币的最大数量。
 *
 * 说明:
 *
 * 你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
 * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * 示例:
 *
 * 输入: [3,1,5,8]
 * 输出: 167
 * 解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 *      coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 * 通过次数16,531提交次数26,447
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/burst-balloons
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/7/19
 * Time: 9:37
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_312 {
    public static void main(String[] args) {
        LeetCode_312 leetCode = new LeetCode_312();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.maxCoins(TestCase.nums));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.maxCoins(TestCase.nums1));
    }

    int res = 0;
    /**
     * 解法一：
     * 暴力破解
     * @param nums
     * @return
     */
    public int maxCoins(int[] nums) {
        int len = nums.length;
        for(int n = 0; n < len; n ++) {
            // 尝试以每一格为起点
            maxCoins(nums, n);
        }
        return 0;
    }

    private int maxCoins(int[] nums, int index) {
        if(nums[index] == Integer.MIN_VALUE) {
            return 0;
        }
        int left = index-1, right = index+1;
        while(left >= 0 && nums[left] == Integer.MIN_VALUE) {
            left --;
        }

        while(right < nums.length && nums[right] == Integer.MIN_VALUE) {
            right ++;
        }
        int leftVal = left >= 0 ? nums[left] : 1;
        int rightVal = right < nums.length ? nums[right] : 1;

        res += leftVal * nums[index] * rightVal;
        nums[index] = Integer.MIN_VALUE;

        return 0;
    }

    static class TestCase {
        public static int ANS = 167;
        public static int[] nums = {};

        public static int ANS1 = 167;
        public static int[] nums1 = {1,2,3,4,5,6};
    }
}
