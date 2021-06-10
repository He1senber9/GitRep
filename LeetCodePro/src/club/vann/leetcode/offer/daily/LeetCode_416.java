package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Medium</p>
 * <p>题目：分割等和子集</p>
 * <p>描述：给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * 示例 2：
 *
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 * 通过次数134,037提交次数267,585
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @description:
 * @program: GitRep
 * @author: fanyu
 * @create: 2021-06-10  13:42:38
 */
public class LeetCode_416 {
    public static void main(String[] args) {
        LeetCode_416 leetCode = new LeetCode_416();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.canPartition1(TestCase.NUMS));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.canPartition1(TestCase.NUMS1));
    }

    /**
     * 解法一：
     *
     * sums为nums所有元素的和。tag = sums/2。
     * 该题等价于从 nums 中能否找出子集[x,y] 满足子集和等于 tag。
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < n; i ++) {
            sum = sum + nums[i];
        }

        if(sum % 2 != 0) {
            return false;
        }

        int tag = sum/2;

        // dp[i][j]表示前 i 个元素和不超过j的最大元素和
        int[][] dp = new int[n+1][tag+1];

        for(int i = 1; i <= n; i ++) {
            int val = nums[i-1];
            for(int j = 0; j <= tag; j ++) {
                dp[i][j] = dp[i-1][j];
                if(j >= val) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-val] + val);
                }
            }
        }

        return (dp[n][tag] == tag);
    }

    /**
     * 解法二：
     *
     * @param nums
     * @return
     */
    public boolean canPartition1(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < n; i ++) {
            sum = sum + nums[i];
        }

        if(sum % 2 != 0) {
            return false;
        }

        int tag = sum/2;

        // dp[i][j]表示前 i 个元素和不超过j的最大元素和
        int[][] dp = new int[2][tag+1];

        for(int i = 1; i <= n; i ++) {
            int val = nums[i-1];
            for(int j = 0; j <= tag; j ++) {
                dp[i&1][j] = dp[(i-1)&1][j];
                if(j >= val) {
                    dp[i&1][j] = Math.max(dp[i&1][j], dp[(i-1)&1][j-val] + val);
                }
            }
        }

        return (dp[n&1][tag] == tag);
    }

    static class TestCase {
        public static boolean ANS = true;
        public static int[] NUMS = {1,5,11,5};

        public static boolean ANS1 = false;
        public static int[] NUMS1 = {1,2,3,5};
    }
}
