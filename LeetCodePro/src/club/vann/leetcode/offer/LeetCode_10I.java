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
		LeetCode_10I leetCode = new LeetCode_10I();
		int n = 0;
		int result = 0;
		
//		n = 2;
//		result = leetCode.fib(n);
//		System.out.println("Result[1] : " + result);
		
//		n = 5;
//		result = leetCode.fib(n);
//		System.out.println("Result[5] : " + result);
		
//		n = 8;
//		result = leetCode.fib(n);
//		System.out.println("Result[21] : " + result);
		
//		n = 45;
//		result = leetCode.fib(n);
//		System.out.println("Result[134903163] : " + result);
		
		n = 48;
		result = leetCode.fib(n);
		System.out.println("Result[807526948] : " + result);
		
	}
	
	private int prev = 0, cur = 1;
	private int fib(int n) {
		if(n == 0) {
			return 0;
		}
		
		if(n == 1) {
			return 1;
		}
		
		int i = 1;
		while (i < n) {
			int code = (prev + cur)%1000000007;
			
			prev = cur;
			cur = code;
			i ++;
		}
		
		return cur;
    }

}
