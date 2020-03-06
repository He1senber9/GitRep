package club.vann.leetcode.offer;

import java.util.Arrays;

/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * 
 * 示例 1:
 * 
 * 输入: n = 1 输出: [1,2,3,4,5,6,7,8,9]  
 * 
 * 说明：
 * 
 * 用返回一个整数列表来代替打印 n 为正整数
 * 
 * @author vann
 *
 */
public class LeetCode_17 {

	public static void main(String[] args) {
		int n = 2;
		
		LeetCode_17 leetCode = new LeetCode_17();
		int[] result = leetCode.printNumbers(n);
		System.out.println(Arrays.toString(result));
	}

	private int[] printNumbers(int n) {
		if(n == 0) {
			return new int[0];
		}
		
		int x = (int) Math.pow(10,n) - 1;
		int[] result = new int[x];
		for(int i = 1; i <= x; i ++) {
			result[i-1] = i; 
		}
		return result;
	}

}
