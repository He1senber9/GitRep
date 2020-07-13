package club.vann.leetcode.offer;

import java.nio.file.AtomicMoveNotSupportedException;

/**
 * <p>难度：Hard</p>
 * <p>题目：买卖股票的最佳时机 III</p>
 * <p>描述：给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 *
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 示例 1:
 *
 * 输入: [3,3,5,0,0,3,1,4]
 * 输出: 6
 * 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 *      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 * 示例 2:
 *
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。  
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。  
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
 * 通过次数43,665提交次数99,775
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-07-13 09:47
 **/
public class LeetCode_123 {
    public static void main(String[] args) {
        LeetCode_123 leetCode = new LeetCode_123();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.maxProfit(TestCase.PRICES));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.maxProfit(TestCase.PRICES1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.maxProfit(TestCase.PRICES2));
    }

    /**
     * 解法一：
     *
     * @param prices
     * @return
     */
    private int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) {
            return 0;
        }
        int len = prices.length;
        int max = 0;
        for(int n = 0; n < len; n ++) {
            max = Math.max(max, maxProfit(prices,0,n)+maxProfit(prices,n+1,len-1));
        }
        return max;
    }

    /**
     * 计算区间begin/end交易一次能获得的最大利润
     * @param prices
     * @param begin
     * @param end
     * @return
     */
    private int maxProfit(int[] prices, int begin, int end) {
        if(begin>=end){
            return 0;
        }
        int len = prices.length;
        int max = 0;
        for(int i = begin; i <= end; i ++) {
            for(int t = i+1; t <= end; t ++) {
                if(prices[i] > prices[t]) {
                    continue;
                }
                max = Math.max(max, prices[t]-prices[i]);
            }
        }
        return max;
    }

    static class TestCase {
        public static final int ANS = 6;
        public static final int[] PRICES = {3,3,5,0,0,3,1,4};

        public static final int ANS1 = 4;
        public static final int[] PRICES1 = {1,2,3,4,5};

        public static final int ANS2 = 0;
        public static final int[] PRICES2 = {7,6,4,3,1};
    }
}
