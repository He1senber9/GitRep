package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Easy</p>
 * <p>题目：买卖股票的最佳时机 II</p>
 * <p>描述：给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * 示例 2:
 *
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *  
 *
 * 提示：
 *
 * 1 <= prices.length <= 3 * 10 ^ 4
 * 0 <= prices[i] <= 10 ^ 4
 * 通过次数238,628提交次数373,245
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: LeetCodePro
 * @description:
 * @author: vann
 * @create: 2020-11-08 08:52
 **/
public class LeetCode_122 {
    public static void main(String[] args) {
        LeetCode_122 leetCode = new LeetCode_122();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.maxProfit(TestCase.PRICES));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.maxProfit(TestCase.PRICES1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.maxProfit(TestCase.PRICES2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.maxProfit(TestCase.PRICES3));
    }

    /**
     * 解法一：
     * 单调递增序列
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;

        int result = 0;
        for(int i = 1; i < len; i ++) {
            if(prices[i-1] < prices[i]) {
                result += prices[i] - prices[i-1];
            }
        }
        return result;
    }

    /**
     * 解法二
     * 动态规划
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int len = prices.length;

        // dp[i][j] 表示第 i 天进行 j 操作后的最大利润。
        // dp[i][0]：第 i 天什么也不操作，dp[i][1]：第 i 天买入股票，dp[i][2]：第 i 天卖出股票。
        // 转移方程:
        // dp[i][0] = max(dp[i-1][0],dp[i-1][2])
        // dp[i][1] = max(dp[i-1][0]-prices[i],dp[i-1][2]
        return 0;
    }

    static class TestCase {
        public static int ANS = 7;
        public static int[] PRICES = {7,1,5,3,6,4};

        public static int ANS1 = 4;
        public static int[] PRICES1 = {1,2,3,4,5};

        public static int ANS2 = 0;
        public static int[] PRICES2 = {7,6,4,3,1};

        public static int ANS3 = 12;
        public static int[] PRICES3 = {5,6,7,8,9,4,3,2,1,5,6,7,8,9};
    }
}
