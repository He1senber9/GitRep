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
		
		int n = 0;
		int result = 0;
		LeetCode_10II leetCode = new LeetCode_10II();
		
		n = 0;
		result = leetCode.numWays(n);
		System.out.println("Result[10]" + result);
		
		n = 1;
		result = leetCode.numWays(n);
		System.out.println("Result[1]" + result);
		
		n = 2;
		result = leetCode.numWays(n);
		System.out.println("Result[2]" + result);
		
		n = 3;
		result = leetCode.numWays(n);
		System.out.println("Result[3]" + result);
		
		n = 4;
		result = leetCode.numWays(n);
		System.out.println("Result[5]" + result);
		
		n = 5;
		result = leetCode.numWays(n);
		System.out.println("Result[8]" + result);
		
		n = 6;
		result = leetCode.numWays(n);
		System.out.println("Result[13]" + result);
		
		n = 7;
		result = leetCode.numWays(n);
		System.out.println("Result[21]" + result);
		
	}
	
	/**
	 * F(0) = 0;
	 * F(1) = 1;
	 * F(2) = 2;
	 * F(n) = F(n-1) + 1;
	 * F(n) = F(n-2) + 2;
	 * @param n
	 * @return
	 */
	private int numWays(int n) {
		int prev = 0, cur = 1;
		int sum = 0;
		
		int i = 0;
		while(i < n) {
			sum = cur + prev;
			prev = cur;
			cur = sum;
			i ++;
		}
		
		return cur;
    }

}
