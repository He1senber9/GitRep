package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Medium</p>
 * <p>题目：佳买卖股票时机含冷冻期</p>
 * <p>描述：给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 *
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 * 通过次数32,248提交次数58,951
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-07-10 09:12
 **/
public class LeetCode_309 {
    public static void main(String[] args) {
        LeetCode_309 leetCode = new LeetCode_309();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.maxProfit1(TestCase.PRICES));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.maxProfit1(TestCase.PRICES1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.maxProfit1(TestCase.PRICES2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.maxProfit1(TestCase.PRICES3));
        System.out.println("Result["+TestCase.ANS4+"] : " + leetCode.maxProfit1(TestCase.PRICES4));
    }

    /**
     * 解法一：
     * 暴力解法
     * @param prices
     * @return
     */
    private int maxProfit(int[] prices) {

        return 0;
    }

    /**
     * 解法二：
     *  动态规划
     *  令dp[i]为第i天最大收益
     *  1：第i天买：
     *     1.1：i==1(第一天买)：dp[i] = dp[0] - prices[i]
     *     1.2：第i-2天卖：    dp[i] = dp[i-1] - prices[i]
     *
     *  2：第i天卖：
     *     2.1：第i-1天买：   dp[i] = dp[i-1] + prices[i]
     *     2.2：第i-1天冷冻：  dp[i] = dp[i-1] + prices[i]
     *
     *  3：第i天冷冻期：
     *     3.1：第i-1天卖了：   dp[i] = dp[i-1]
     *
     *  4：第i天不操作：
     *     4.1：              dp[i] = dp[i-1]
     *      *     3.1：第i-1天卖了：   dp[i] = dp[i-1]
     *  dp[i] = max(dp[i-1]-prices[i-1],
     * @param prices
     * @return
     */
    private int maxProfit1(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][3];
        dp[0][0] = -prices[0];
        for(int i = 1; i < len; i ++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][2] - prices[i]);
            dp[i][1] = dp[i-1][0] + prices[i];
            dp[i][2] = Math.max(dp[i-1][1], dp[i-1][2]);
        }
        return Math.max(dp[len-1][1], dp[len-1][2]);
    }

    static class TestCase {
        public static int ANS = 3;
        public static int[] PRICES = {1,2,3,0,2}; // {-1,1,0,-1,1}

        public static int ANS1 = 4;
        public static int[] PRICES1 = {1,2,3,4,5}; // {-1,1,0,0,1}

        public static int ANS2 = 2;
        public static int[] PRICES2 = {1,2,3,2,1}; // {-1,0,1,0,0}

        public static int ANS3 = 17;
        public static int[] PRICES3 = {1,2,3,6,2,7,8,9,1,2,3,4,5,6,7,8,9,10}; // {-1,0,1,0,0}

        public static int ANS4 = 4;
        public static int[] PRICES4 = {9,1,2,3,4,5}; // {0,-1,0,0,0,1}
    }
}
