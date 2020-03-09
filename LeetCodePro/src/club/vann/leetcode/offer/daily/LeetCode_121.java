/**
 * 
 */
package club.vann.leetcode.offer.daily;

/**
 * <p>
 * 难度：Easy
 * <p>
 * 题目：买卖股票的最佳时机
 * <p>
 * 描述：给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 注意你不能在买入股票前卖出股票。
 * <p>
 * 示例 1:
 * 
 * 输入: [7,1,5,3,6,4] 输出: 5 </br>
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润
 * = 6-1 = 5 。 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。 
 * <p>
 * 示例 2:
 * 
 * 输入: [7,6,4,3,1] 输出: 0 </br>
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。 
 * 
 * <p>
 * 通过次数140,108提交次数265,174
 * 
 * @author vann
 * @date Mar 9, 2020
 */
public class LeetCode_121 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] prices = null;
		int result = 0;
		LeetCode_121 leetCode = new LeetCode_121();
		
		prices = new int[]{7,1,5,3,6,4};
		result = leetCode.maxProfit(prices);
		System.out.println("Result: [5] " + result);
		
		prices = new int[]{7,6,4,3,1};
		result = leetCode.maxProfit(prices);
		System.out.println("Result: [0] " + result);
		
		prices = new int[]{1,2,3,4,5,6};
		result = leetCode.maxProfit(prices);
		System.out.println("Result: [5] " + result);
//		
//		prices = new int[]{6,5,4,3,2,1};
//		result = leetCode.maxProfit(prices);
//		System.out.println("Result: [0] " + result);
//		
//		prices = new int[]{1,2,3,4,5,6,5,4,3,2,1};
//		result = leetCode.maxProfit(prices);
//		System.out.println("Result: [5] " + result);
//		
//		prices = new int[]{6,5,4,3,2,1,2,3,4,5,6};
//		result = leetCode.maxProfit(prices);
//		System.out.println("Result: [5] " + result);
		
//		prices = new int[]{1,2,3,4,5,6,5,4,3,2,1,2,3,4,5,6};
//		result = leetCode.maxProfit(prices);
//		System.out.println("Result: [10] " + result);
		
	}
	
	/**
	 * 暴力法：
	 * 
	 * @param prices
	 * @return
	 */
	private int maxProfit(int[] prices) {
		int max = 0;
		
		for(int n = 0; n < prices.length-1; n ++) {
			for(int m = n+1; m < prices.length; m ++) {
				int v = prices[m] - prices[n];
				max = Math.max(max, v);
			}
		}
		
		return max;
    }

}
