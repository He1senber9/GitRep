package club.vann.leetcode.offer;

/**
 * Easy 青蛙跳台阶问题
 * 
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * 
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * 
 * 示例 1：
 * 
 * 输入：n = 2 输出：2 
 * 
 * 示例 2：
 * 
 * 输入：n = 7 输出：21 提示：
 * 
 * 提示:0 <= n <= 100
 * 
 * @author vann
 *
 */
public class LeetCode_10II {

	public static void main(String[] args) {
//		int n = 2;
		int n = 7;
		LeetCode_10II leetCode = new LeetCode_10II();
		int result = leetCode.numWays(n);
		
		System.out.println(result);
		
	}
	
	private int numWays(int n) {
		if(n == 0) {
			return 0;
		}
		return (n-1) + n/2;
    }

}
