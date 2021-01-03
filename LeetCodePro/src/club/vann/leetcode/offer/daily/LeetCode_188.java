package club.vann.leetcode.offer.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

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

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.maxProfit1(TestCase.K, TestCase.PRICES));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.maxProfit1(TestCase.K1, TestCase.PRICES1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.maxProfit1(TestCase.K2, TestCase.PRICES2));
        System.out.println("Result["+TestCase.ANS4+"] : " + leetCode.maxProfit1(TestCase.K4, TestCase.PRICES4));
        System.out.println("Result["+TestCase.ANS5+"] : " + leetCode.maxProfit1(TestCase.K5, TestCase.PRICES5));
        System.out.println("Result["+TestCase.ANS6+"] : " + leetCode.maxProfit1(TestCase.K6, TestCase.PRICES6));
    }

    /**
     * 解法一：
     * 动态规划
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length == 0 || k == 0) {
            return 0;
        }

        int len = prices.length;
        k = Math.min(k, len/2); // len天最多能进行 len/2 笔交易，需要判断 k 与 len/2 的大小。
        int[][] buy = new int[len][k+1];
        int[][] sell = new int[len][k+1];

        for (int i = 1; i <= k; ++i) {
//            buy[0][i] = sell[0][i] = Integer.MIN_VALUE/2; // 这里不解
            buy[0][i] = sell[0][i] = -2;
        }

        buy[0][0] = -prices[0];
        sell[0][0] = 0;

        for(int i = 1; i < len; i ++) {
            buy[i][0] = Math.max(buy[i-1][0], sell[i-1][0] - prices[i]);
            for(int j = 1; j <= k; j ++) {
                buy[i][j] = Math.max(buy[i-1][j], sell[i-1][j]-prices[i]);
                sell[i][j] = Math.max(sell[i-1][j], buy[i-1][j-1]+prices[i]);
            }
        }

//        return sell[len-1][k];
        int max = 0;
        for(int i = 1; i <= k; i ++) {
            max = Math.max(max, sell[len-1][i]);
        }
        return max;
    }

    /**
     * 解法二：
     *
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit1(int k, int[] prices) {
        if(k == 0){
            return 0;
        }

        int[] buy = new int[k+1];
        Arrays.fill(buy,Integer.MAX_VALUE);
        int[] pro = new int[k+1];
        for(int price : prices) {
            for(int i = 0; i < k; ++i){
                buy[i] = Math.min(buy[i], price);
                pro[i] = Math.max(pro[i], price - buy[i]);
                buy[i+1] = Math.min(buy[i+1], price - pro[i]);
                pro[i+1] = Math.max(pro[i+1], price - buy[i+1]);
            }
        }
        return pro[k-1];
    }

    static class TestCase {
        public static int ANS = 2;
        public static int K = 2;
        public static int[] PRICES = {2,4,1};

        public static int ANS1 = 7;
        public static int K1 = 2;
        public static int[] PRICES1 = {3,2,6,5,0,3};

        public static int ANS2 = 4;
        public static int K2 = 1;
        public static int[] PRICES2 = {1,2,3,4,5};

        public static int ANS3 = 4;
        public static int K3 = 2;
        public static int[] PRICES3 = {1,2,3,4,5};

        public static int ANS4 = 0;
        public static int K4 = 2;
        public static int[] PRICES4 = {5,4,3,2,1};

        public static int ANS5 = 6;
        public static int K5 = 2;
        public static int[] PRICES5 = {3,3,5,0,0,3,1,4};

        public static int ANS6 = 13;
        public static int K6 = 2;
        public static int[] PRICES6 = {1,2,4,2,5,7,2,4,9,0};
    }
}
