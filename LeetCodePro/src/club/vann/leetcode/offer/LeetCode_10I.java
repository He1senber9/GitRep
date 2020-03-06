package club.vann.leetcode.offer;

/**
 * Easy 斐波那契数列 
 * 
 * <p>
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。
 * 
 * <p>
 * 斐波那契数列的定义如下：</br>
 * 
 * F(0) = 0,   F(1) = 1, F(N) = F(N - 1) + F(N - 2), 其中 N > 1. </br> 
 * 斐波那契数列由 0 和 1开始，之后的斐波那契数就是由之前的两数相加而得出。
 * 
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * 
 * 示例 1：
 * 
 * 输入：n = 2 输出：1 
 * 
 * 示例 2：
 * 
 * 输入：n = 5 输出：5  
 * 
 * 提示：0 <= n <= 100
 * 
 * @author vann
 *
 */
public class LeetCode_10I {

	public static void main(String[] args) {
//		int n = 2;
//		int n = 5;
		int n = 41;
		
		LeetCode_10I leetCode = new LeetCode_10I();
		int result = leetCode.fib(n);
		System.out.println(result);
	}
	
	private int fib(int n) {
		if(n == 0) {
			return 0;
		}
		
		if(n == 1) {
			return 1;
		}
		
		int result = 0;
		
		result = (n-1) * 1 + 0;
		return result;
    }

}
