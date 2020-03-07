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

		int n = 0;
		int result = 0;
		
		n = 123;
		result = leetCode.reverse(n);
		System.out.println("Result [321]: " + result);

		n = -123;
		result = leetCode.reverse(n);
		System.out.println("Result [-321]: " + result);

		n = 120;
		result = leetCode.reverse(n);
		System.out.println("Result [21]: " + result);
		
		n = 1534236469;
		result = leetCode.reverse(n);
		System.out.println("Result [0]: " + result);
		System.out.println(n < Integer.MAX_VALUE);
		
		n = 463847412;
		result = leetCode.reverse(n);
		System.out.println("Result [214748364]: " + result);
		System.out.println(n < Integer.MAX_VALUE);
		
		n = 563847412;
		result = leetCode.reverse(n);
		System.out.println("Result [214748365]: " + result);
		System.out.println(n < Integer.MAX_VALUE);
	}

	private int reverse(int x) {
		int result = 0;
		
		while(x != 0) {
			if(result*10/10 != result) { // 证明溢出
				return 0;
			}
			
			result = result * 10 + x % 10;
			x = x / 10;
		}
		
		
		return result;
	}

}
