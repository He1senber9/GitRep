package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Hard</p>
 * <p>题目：卖股票的最佳时机 IV</p>
 * <p>描述：给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：k = 2, prices = [2,4,1]
 * 输出：2
 * 解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 * 示例 2：
 *
 * 输入：k = 2, prices = [3,2,6,5,0,3]
 * 输出：7
 * 解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
 *      随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
 *  
 *
 * 提示：
 *
 * 0 <= k <= 109
 * 0 <= prices.length <= 1000
 * 0 <= prices[i] <= 1000
 * 通过次数44,175提交次数134,563
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-12-28 11:22
 **/
public class LeetCode_188 {
    public static void main(String[] args) {
        LeetCode_188 leetCode = new LeetCode_188();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.maxProfit(TestCase.K, TestCase.PRICES));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.maxProfit(TestCase.K1, TestCase.PRICES1));
    }

    /**
     * 解法一：
     *
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        return 0;
    }

    static class TestCase {
        public static int ANS = 2;
        public static int K = 2;
        public static int[] PRICES = {2,4,1};

        public static int ANS1 = 7;
        public static int K1 = 2;
        public static int[] PRICES1 = {3,2,6,5,0,3};
    }
}
