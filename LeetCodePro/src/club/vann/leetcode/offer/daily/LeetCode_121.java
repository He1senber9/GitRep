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
		
//		prices = new int[]{7,1,5,3,6,4};
//		result = leetCode.maxProfit(prices);
//		System.out.println("Result: [5] " + result);
//		
//		prices = new int[]{7,6,4,3,1};
//		result = leetCode.maxProfit(prices);
//		System.out.println("Result: [0] " + result);
		
//		prices = new int[]{1,2,3,4,5,6};
//		result = leetCode.maxProfit(prices);
//		System.out.println("Result: [5] " + result);
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
		
		prices = new int[]{1,2,3,4,5,6,5,4,3,2,1,2,3,4,5,6};
		result = leetCode.maxProfit(prices);
		System.out.println("Result: [10] " + result);
		
		prices = new int[]{1,2,3,4,5,6,5,4,3,2,1,2,3,4,5,6};
		result = leetCode.maxProfit(prices);
		System.out.println("Result: [10] " + result);
	}
	
	private int maxProfit(int[] prices) {
		int maxSaly = 0; // 定义最大利润为0
		
		int len = prices.length;
		for(int n = 0; n < len; n ++) {
			int maxValue = 0;
			// 表示第 n 天 买入，即成本价 prices[n]
			int base = prices[n];
			boolean flag = true; // true：可以卖，false，可以买
			for(int m = n+1; m < len; m ++) {
				if(flag) {
					maxValue = Math.max(maxValue, prices[m] - base);
				} else {
					maxValue -= prices[m];
				}
			}
			maxSaly = Math.max(maxSaly, maxValue);
		}
		
		return maxSaly;
    }
	
	private int maxProfit(int[] prices, int index, int flag) {
		for(int n = index; n >= 0; n --) {
			if(flag == 1) {
				return n + maxProfit(prices, n - 1, 1);
			} else {
				return maxProfit(prices, n - 1, 1);
			}
		}
		return 0;
	}

}
