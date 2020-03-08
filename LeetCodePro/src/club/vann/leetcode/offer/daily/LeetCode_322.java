package club.vann.leetcode.offer.daily;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * <p>
 * 难度：Midum
 * <p>
 * 题目：零钱兑换
 * <p>
 * 描述：给定不同面额的硬币 coins 和一个总金额
 * amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 
 * <p>
 * 示例 1:
 * 
 * 输入: coins = [1, 2, 5], amount = 11 输出: 3 解释: 11 = 5 + 5 + 1
 * <p>
 * 示例 2:
 * 
 * 输入: coins = [2], amount = 3 输出: -1
 * 
 * <p>
 * 说明: 你可以认为每种硬币的数量是无限的。
 * 
 * 通过次数47,144提交次数124,202
 * 
 * @author fanyu
 * @date 2020年3月8日
 */
public class LeetCode_322 {

	public static void main(String[] args) {
		LeetCode_322 leetCode = new LeetCode_322();

		int[] coins = null;
		int amount = 0;
		int result = 0;

		coins = new int[] { 1, 2, 5 };
		amount = 11;
		result = leetCode.coinChange(coins, amount);
		System.out.println("Resutl [3] : " + result);

		coins = new int[] { 2 };
		amount = 3;
		result = leetCode.coinChange(coins, amount);
		System.out.println("Resutl [-1] : " + result);

		coins = new int[] { 2, 5, 10, 1 };
		amount = 27;
		result = leetCode.coinChange(coins, amount);
		System.out.println("Resutl [4] : " + result);

		coins = new int[] { 186, 419, 83, 408 };
		amount = 6249;
		result = leetCode.coinChange(coins, amount);
		System.out.println("Resutl [20] : " + result);
	}

	/**
	 * 给定不同面额的硬币 coins 和一个总金额
	 * amount，该方法能计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1
	 * 
	 * @param coins
	 * @param amount
	 * @return 凑成所需金额的最少硬币个数，如果没有任何一种硬币组合能组成总金额，返回 -1
	 */
	private int coinChange(int[] coins, int amount) {
//		return coinChange1(coins, amount, 0);
		return coinChange2(coins, amount);
	}

	/**
	 * 搜索回溯算法。
	 * 
	 * @param coins
	 * @param amount
	 * @param index
	 * @return
	 */
	private int coinChange1(int[] coins, int amount, int index) {
		if (amount == 0) {
			return 0;
		}

		if (index < coins.length && amount > 0) {
			int indexMaxCount = amount / coins[index]; // 当前面额硬币能使用的最大数量
			int minVal = Integer.MAX_VALUE;
			for (int n = 0; n <= indexMaxCount; n++) {
				if (amount >= n * coins[index]) {
					int v = coinChange1(coins, amount - (n * coins[index]), index + 1);
					if (v != -1) {
						minVal = Math.min(minVal, v + n);
					}
				}
			}

			return (minVal == Integer.MAX_VALUE ? -1 : minVal);
		}

		return -1;
	}

	private int coinChange2(int[] coins, int amount) {
		int max = amount + 1;
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, max);
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (coins[j] <= i) {
					dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
				}
			}
		}
		return dp[amount] > amount ? -1 : dp[amount];
	}

}
