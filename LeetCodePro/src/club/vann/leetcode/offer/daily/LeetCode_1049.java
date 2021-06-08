package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Medium</p>
 * <p>题目：最后一块石头的重量II</p>
 * <p>描述：有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。
 *
 * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 *
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：stones = [2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 组合 2 和 4，得到 2，所以数组转化为 [2,7,1,8,1]，
 * 组合 7 和 8，得到 1，所以数组转化为 [2,1,1,1]，
 * 组合 2 和 1，得到 1，所以数组转化为 [1,1,1]，
 * 组合 1 和 1，得到 0，所以数组转化为 [1]，这就是最优值。
 * 示例 2：
 *
 * 输入：stones = [31,26,33,21,40]
 * 输出：5
 * 示例 3：
 *
 * 输入：stones = [1,2]
 * 输出：1
 *  
 *
 * 提示：
 *
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 100
 * 通过次数13,823提交次数24,990
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/last-stone-weight-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @description:
 * @program: GitRep
 * @author: fanyu
 * @create: 2021-06-08  07:55:38
 */
public class LeetCode_1049 {
    public static void main(String[] args) {
        LeetCode_1049 leetCode = new LeetCode_1049();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.lastStoneWeightII(TestCase.STONES));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.lastStoneWeightII(TestCase.STONES1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.lastStoneWeightII(TestCase.STONES2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.lastStoneWeightII(TestCase.STONES3));
        System.out.println("Result["+TestCase.ANS4+"] : " + leetCode.lastStoneWeightII(TestCase.STONES4));
    }

    /**
     * 解法一：
     * 思路：将这堆石头分成2部分A，B（A <= B)，A与B的差值最小。
     * 即将 这些石头放入 SUM/2 的背包中，求能放进去的最大容量。
     * @param stones
     * @return
     */
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;

        int sum = 0;
        for(int i = 0; i < n; i ++) {
            sum += stones[i];
        }

        int target = sum/2;
        // dp[i][j] dp[i][j]表示从0-i个物品中选择不超过j重量的物品的最大重量
        int[] dp = new int[target+1];
        for(int stone : stones) {
            for(int i = target; i >= stone; i --) {
                dp[i] = Math.max(dp[i], dp[i-stone]+stone);
            }
        }
        return sum - 2 * dp[target];
    }

    static class TestCase {
        public static int ANS = 1;
        public static int[] STONES = {2,7,4,1,8,1};

        public static int ANS1 = 5;
        public static int[] STONES1 = {31,26,33,21,40};

        public static int ANS2 = 0;
        public static int[] STONES2 = {1,1};

        public static int ANS3 = 1;
        public static int[] STONES3 = {1,1,1};

        public static int ANS4 = 1;
        public static int[] STONES4 = {1,2};
    }
}
