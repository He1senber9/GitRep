package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Easy</p>
 * <p>题目：打家劫舍</p>
 * <p>描述：你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 *
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * 通过次数116,289提交次数259,202
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/5/29
 * Time: 6:50
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_198 {
    public static void main(String[] args) {
        LeetCode_198 leetCode = new LeetCode_198();
//        System.out.println("Result["+TestCase.res+"] : " + leetCode.rob1(TestCase.nums));
        System.out.println("Result["+TestCase.res1+"] : " + leetCode.rob1(TestCase.nums1));
        System.out.println("Result["+TestCase.res2+"] : " + leetCode.rob1(TestCase.nums2));
        System.out.println("Result["+TestCase.res3+"] : " + leetCode.rob1(TestCase.nums3));
    }

    /**
     * 解法一：
     * dp[n][0]：表示索引为n的不打劫
     * dp[n][1]：表示索引为n的打劫
     * 推导：dp[n][0] = dp[n-1][1] || dp[n-1][0]
     *      dp[n][1] = dp[n-1][0]
     *      dp[0][0] = 0;
     *      dp[0][1] = nums[0];
     * @param nums
     * @return
     */
    private int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        if(len == 1) {
            return nums[0];
        }

//        int[] dp = new int[len];
//        dp[0] = nums[0];
//        dp[1] = Math.max(nums[0], nums[1]);
        int pre1 = nums[0];
        int pre2 = Math.max(nums[0], nums[1]);
        int max = pre2;
        // dp[i][0] = dp[i-1]
        // dp[i][1] = max(dp[i-2]+nums[i])
        for(int i = 2; i < len; i ++) {
            max = Math.max(pre1 + nums[i], pre2);
            pre1 = pre2;
            pre2 = max;
        }
        return max;
    }

    public int rob1(int[] nums) {
        int len = nums.length;

        if(len == 0) {
            return 0;
        }

        if(len == 1) {
            return nums[len-1];
        }

        if(len == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[][] dp = new int[len][2];
        dp[0][1] = nums[0];
        dp[0][0] = 0;
        dp[1][1] = nums[1];
        dp[1][0] = nums[0];

        int max = 0;
        for(int i = 2; i < len; i ++) {
            dp[i][0] = Math.max(dp[i-1][1], dp[i-1][0]);
            dp[i][1] = dp[i-1][0] + nums[i];
        }

        return Math.max(dp[len-1][0], dp[len-1][1]);
    }

    static class TestCase {
        public static final int res = 4;
        public static final int[] nums = {1,2,3,1};

        public static final int res1 = 8;
        public static final int[] nums1 = {1,4,1,2,4};

        public static final int res2 = 2;
        public static final int[] nums2 = {1,2};

        public static final int res3 = 8;
        public static final int[] nums3 = {4,1,2,4};

        public static final int res4 = 8;
        public static final int[] nums4 = {1,4,1,2,4};
    }
}
