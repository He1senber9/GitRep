package club.vann.leetcode.offer;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * 
 *  
 * 
 * 示例:
 * 
 * 输入: a = 1, b = 1 输出: 2  
 * 
 * 提示：
 * 
 * a, b 均可能是负数或 0 
 * 结果不会溢出 32 位整数
 * 
 * @author vann
 *
 */
public class LeetCode_65 {

	public static void main(String[] args) {
		int a = 1, b = 1;
		
		LeetCode_65 leetCode = new LeetCode_65();
		int result = leetCode.add(a, b);
		System.out.println("result:" + result);
	}
	
	private int add(int a, int b) {
		while(b != 0) {
			int sum = a ^ b;
			b = a & b << 1;
			a = sum;
		}
        return a;
    }
}
