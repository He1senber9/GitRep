package club.vann.leetcode.race;

import java.util.Arrays;

/**
 * <p>难度：Easy</p>
 * <p>题目：商品折扣后的最终价格</p>
 * <p>描述：给你一个数组 prices ，其中 prices[i] 是商店里第 i 件商品的价格。
 *
 * 商店里正在进行促销活动，如果你要买第 i 件商品，那么你可以得到与 prices[j] 相等的折扣，其中 j 是满足 j > i 且 prices[j] <= prices[i] 的 最小下标 ，如果没有满足条件的 j ，你将没有任何折扣。
 *
 * 请你返回一个数组，数组中第 i 个元素是折扣后你购买商品 i 最终需要支付的价格。
 *
 *
 *
 * 示例 1：
 *
 * 输入：prices = [8,4,6,2,3]
 * 输出：[4,2,4,2,3]
 * 解释：
 * 商品 0 的价格为 price[0]=8 ，你将得到 prices[1]=4 的折扣，所以最终价格为 8 - 4 = 4 。
 * 商品 1 的价格为 price[1]=4 ，你将得到 prices[3]=2 的折扣，所以最终价格为 4 - 2 = 2 。
 * 商品 2 的价格为 price[2]=6 ，你将得到 prices[3]=2 的折扣，所以最终价格为 6 - 2 = 4 。
 * 商品 3 和 4 都没有折扣。
 * 示例 2：
 *
 * 输入：prices = [1,2,3,4,5]
 * 输出：[1,2,3,4,5]
 * 解释：在这个例子中，所有商品都没有折扣。
 * 示例 3：
 *
 * 输入：prices = [10,1,1,6]
 * 输出：[9,0,1,6]
 *
 *
 * 提示：
 *
 * 1 <= prices.length <= 500
 * 1 <= prices[i] <= 10^3</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/6/27
 * Time: 22:22
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_1475 {

    public static void main(String[] args) {
        LeetCode_1475 leetCode = new LeetCode_1475();

        System.out.println(Arrays.toString(leetCode.finalPrices(TestCase.prices)));
        System.out.println(Arrays.toString(leetCode.finalPrices(TestCase.prices1)));
        System.out.println(Arrays.toString(leetCode.finalPrices(TestCase.prices2)));
    }

    /**
     * 解法一：
     *
     * @param prices
     * @return
     */
    private int[] finalPrices(int[] prices) {
        if(prices == null || prices.length < 2) {
            return prices;
        }

        int len = prices.length;
        for(int n = 0; n < len-1; n ++) {
            for(int m = n+1; m < len; m ++) {
                if(prices[m] <= prices[n]) {
                    prices[n] = prices[n] - prices[m];
                    break;
                }
            }
        }
        return prices;
    }

    static class TestCase {
        public static int[] prices = {8,4,6,2,3};
        public static int[] prices1 = {1,2,3,4,5};
        public static int[] prices2 = {10,1,1,6};
    }
}
