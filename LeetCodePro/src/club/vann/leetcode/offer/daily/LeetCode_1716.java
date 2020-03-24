package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Easy</p>
 * <p>题目：按摩师</p>
 * <p>描述：一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。
 * 给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 *
 * 注意：本题相对原题稍作改动
 *
 * 示例 1：
 *
 * 输入： [1,2,3,1]
 * 输出： 4
 * 解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
 * 示例 2：
 *
 * 输入： [2,7,9,3,1]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。
 * 示例 3：
 *
 * 输入： [2,1,4,5,3,1,1,3]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。
 * 通过次数3,395提交次数6,318
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/the-masseuse-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/3/24
 * Time: 8:26
 * Description:
 */
public class LeetCode_1716 {
    public static void main(String[] args) {
        int[] nums = null;
        int result = 0;
        LeetCode_1716 leetCode = new LeetCode_1716();

//        nums = new int[]{1,2,3,1};
//        result = leetCode.massage(nums);
//        System.out.println("Result[4] : " +result);
//
//        nums = new int[]{2,7,9,3,1};
//        result = leetCode.massage(nums);
//        System.out.println("Result[12] : " +result);

        nums = new int[]{2,1,4,5,3,1,1,3};
        result = leetCode.massage(nums);
        System.out.println("Result[12] : " +result);

        nums = new int[]{1};
        result = leetCode.massage(nums);
        System.out.println("Result[1] : " +result);

        nums = new int[]{1, 2};
        result = leetCode.massage2(nums);
        System.out.println("Result[2] : " +result);

        nums = new int[]{1, 1};
        result = leetCode.massage2(nums);
        System.out.println("Result[1] : " +result);
    }

    /**
     * 解法一：
     * 思路：暴力法（递归解法）：当前位置位 index时，下一个选取的位置只有两种情况：index+2, index+3。
     * 经过验证，该方法超时。
     * @param nums
     * @return
     */
    private int massage(int[] nums) {
        int result = 0;
        if(nums == null || nums.length == 0) {
            return result;
        }

        int sum1 = massage(nums, 0);
        int sum2 = massage(nums, 1);


        return Math.max(sum1, sum2);
    }

    /**
     * 每次都只能选择当前索引 +2 ，或者 +3的位置
     * @param nums
     * @param curIndex
     * @return
     */
    private int massage(int[] nums, int curIndex) {

        if(curIndex >= nums.length) {
            return 0;
        }

        int sum1 = nums[curIndex] + massage(nums, curIndex + 2);
        int sum2 = nums[curIndex] + massage(nums, curIndex + 3);

        return Math.max(sum1, sum2);
    }

    /**
     * 解法二：
     * 采用迭代法
     * 动态规划：dp[i][0]:标志第i个预约不接受时最大时间。dp[i][1]表示第i个预约接受时最大时间。
     * 状态转移方程：
     *    dp[i][0] = max(dp[i-1][1], dp[i-1][0])
     *    dp[i][1] = dp[i-1][0] + nums[i]
     *
     *  即 最大时间 t = max(dp[i][0], dp[i][1])
     *
     *
     * @param nums
     * @return
     */
    private int massage2(int[] nums) {
        int result = 0;
        if(nums == null || nums.length == 0) {
            return result;
        }

        int dp0 = 0, dp1 = nums[0];
        int len = nums.length;

        for(int n = 1; n < len; n ++) {
            int ndp0 = Math.max(dp0, dp1);
            int ndp1 = dp0 + nums[n];

            dp0 = ndp0;
            dp1 = ndp1;
        }


        return Math.max(dp0, dp1);
    }
}
