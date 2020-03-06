package leetcode.offer;

/**
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * 
 *  
 * 
 * 示例 1：
 * 
 * 输入: n = 3 输出: 6 示例 2：
 * 
 * 输入: n = 9 输出: 45  
 * 
 * 限制：
 * 
 * 1 <= n <= 10000
 * 
 * @author vann
 *
 */
public class LeetCode_64 {

	public static void main(String[] args) {
		int n = 9;
		LeetCode_64 leetCode = new LeetCode_64();
		int result = leetCode.sumNums(n);
		System.out.println(result);
	}

	private int sumNums(int n) {
		boolean b = (n > 0) && ((n += sumNums(n-1)) > 0);
		return n;
	}

}
