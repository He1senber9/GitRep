package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Medium</p>
 * <p>题目：买卖股票的最佳时机含手续费</p>
 * <p>描述：给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
 *
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 *
 * 返回获得利润的最大值。
 *
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 *
 * 示例 1:
 *
 * 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出: 8
 * 解释: 能够达到的最大利润:
 * 在此处买入 prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * 注意:
 *
 * 0 < prices.length <= 50000.
 * 0 < prices[i] < 50000.
 * 0 <= fee < 50000.
 * 通过次数39,069提交次数56,250
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/12/17
 * Time: 9:17
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_714 {
    public static void main(String[] args) {
        LeetCode_714 leetCode = new LeetCode_714();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.maxProfit(TestCase.PRICES, TestCase.FEE));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.maxProfit(TestCase.PRICES1, TestCase.FEE1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.maxProfit(TestCase.PRICES2, TestCase.FEE2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.maxProfit(TestCase.PRICES3, TestCase.FEE3));
        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.maxProfit(TestCase.PRICES, TestCase.FEE));
    }

    /**
     * 解法一：
     *
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        // 定义
        // f(i,0)为第i天不持有股票的最大收益
        // f(i,1)为第i天持有股票的最大收益
        // f(i,0) = max( f(i-1,0), f(i-1,1) + prices[i] )
        // f(i,1) = max( f(i-1,0) - prices[i] - fee, f(i-1,1) )
        // f(0,0) = 0, f(0,1) = -prices[0] - fee
        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0] - fee;

        for(int i = 1; i < len; i ++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][0] - prices[i] - fee, dp[i-1][1]);
        }

        return dp[len-1][0];
    }

    static class TestCase {
        public static int ANS = 8;
        public static int[] PRICES = {1, 3, 2, 8, 4, 9};
        public static int FEE = 2;

        public static int ANS1 = 3;
        public static int[] PRICES1 = {1,2,3,4,5,6};
        public static int FEE1 = 2;

        public static int ANS2 = 0;
        public static int[] PRICES2 = {6,5,4,3,2,1};
        public static int FEE2 = 2;

        public static int ANS3 = 2;
        public static int[] PRICES3 = {3,2,1,2,3,4,5};
        public static int FEE3 = 2;
    }
}
