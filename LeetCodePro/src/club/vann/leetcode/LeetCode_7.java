package club.vann.leetcode;

/**
 * <p>
 * 难度：Easy
 * <p>
 * 题目：整数反转
 * <p>
 * 描述：给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * 
 * 输入: 123 输出: 321  
 * <p>
 * 示例 2:
 * 
 * 输入: -123 输出: -321
 * <p>
 * 示例 3:
 * 
 * 输入: 120 输出: 21
 * <p>
 * 注意:
 * 
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * 
 * 通过次数291,760提交次数863,908
 * 
 * @author fanyu
 * @date 2020年3月7日
 */
public class LeetCode_7 {

	public static void main(String[] args) {
		LeetCode_7 leetCode = new LeetCode_7();

		int n = 123;
		int result = leetCode.reverse(n);
		System.out.println("Result [321]: " + result);

		n = -123;
		result = leetCode.reverse(n);
		System.out.println("Result [-321]: " + result);

		n = 120;
		result = leetCode.reverse(n);
		System.out.println("Result [21]: " + result);
	}

	private int reverse(int x) {
		int result = 0;
		
		int flag = 1; // 符号位：1表示正，-1表示负
		
		if(x >= 0) {
			flag = 1;
		} else {
			flag = -1;
		}
		
		
		
		return result;
	}

}
