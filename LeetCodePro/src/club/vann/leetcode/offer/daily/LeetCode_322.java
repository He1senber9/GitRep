package club.vann.leetcode.offer.daily;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

//		coins = new int[] { 1, 2, 5 };
//		amount = 11;
//		result = leetCode.coinChange(coins, amount);
//		System.out.println("Resutl [3] : " + result);
//
//		coins = new int[] { 2 };
//		amount = 3;
//		result = leetCode.coinChange(coins, amount);
//		System.out.println("Resutl [-1] : " + result);
//
//		coins = new int[] { 2, 5, 10, 1 };
//		amount = 27;
//		result = leetCode.coinChange(coins, amount);
//		System.out.println("Resutl [4] : " + result);

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
//		return coinChange2(coins, amount);
//		return coinChange3(coins, amount, new int[amount]);
		return coinChange4(coins, amount);
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

	/**
	 * 方法二、动态规划-自上而下
	 * 
	 * 我们能改进上面的指数时间复杂度的解吗？当然可以，利用动态规划，我们可以在多项式的时间范围内求解。首先，我们定义：
	 * 
	 *    F(S)：组成金额  S 所需的最少硬币数量。
	 *    [C0,C1...Cn-1]:可选的 n 枚硬币面额值
	 * 
	 * 我们注意到这个问题有一个最优的子结构性质，这是解决动态规划问题的关键。最优解可以从其子问题的最优解构造出来。如何将问题分解成子问题？假设我们知道
	 * F(S)，即组成金额  S 最少的硬币数，最后一枚硬币的面值是 C。那么由于问题的最优子结构，转移方程应为：
	 * 
	 *    F(S) = F(S - C) + 1
	 * 
	 * 但我们不知道最后一枚硬币的面值是多少，所以我们需要枚举每个硬币面额值 C0,C1,C2...Cn-1​ 并选择其中的最小值。下列递推关系成立：
	 * 
	 *    F(S) = min{i=0 ... n-1} { F(S - Ci) } + 1 {subject to}  S-Ci >= 0
	 *    F(S)=0 ,when S=0
	 *    F(S)=−1 ,when n=0
	 * 
	 * @param coins
	 * @param amount
	 * @param count
	 * @return
	 */
	private int coinChange3(int[] coins, int amount, int[] count) {
		if (amount < 0)
			return -1;
		if (amount == 0)
			return 0;
		if (count[amount - 1] != 0)
			return count[amount - 1];
		int min = Integer.MAX_VALUE;
		for (int coin : coins) {
			int res = coinChange3(coins, amount - coin, count);
			if (res >= 0 && res < min)
				min = 1 + res;
		}
		count[amount - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
		return count[amount - 1];

	}

	// 额外定义一个缓存表
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	private int coinChange4(int[] coins, int amount) {
		if(amount == 0) {
			return 0;
		}
		
		if(amount < 0) {
			return -1;
		}
		
		if(map.containsKey(amount)) {
			return map.get(amount);
		}
		
		int min = Integer.MAX_VALUE;
		for(int n = 0; n < coins.length; n ++) {
			int num = coinChange4(coins, amount-coins[n]);
			if(num == -1) {
				continue;
			}
			min = Math.min(min, 1+num);
		}
		
		if(min == Integer.MAX_VALUE) {
			min = -1;
		}
		
		if(min != -1) {
			map.put(amount, min);
		}
		return min;
	}
}
