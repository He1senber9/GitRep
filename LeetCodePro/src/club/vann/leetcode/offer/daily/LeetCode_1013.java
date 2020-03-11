package club.vann.leetcode.offer.daily;

/**
 * <p>
 * 难度：Easy
 * <p>
 * 题目：将数组分成和相等的三个部分
 * <p>
 * 描述：给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
 * 
 * 形式上，如果可以找出索引 i+1 < j 且满足 (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... +
 * A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]) 就可以将数组三等分。
 *  
 * <p>
 * 示例 1：
 * 输出：[0,2,1,-6,6,-7,9,1,2,0,1] 输出：true 
 * 解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1 
 * 
 * <p>
 * 示例 2：
 * 输入：[0,2,1,-6,6,7,9,-1,2,0,1] 输出：false 
 * 
 * <p>
 * 示例 3：
 * 输入：[3,3,6,5,-2,2,5,1,-9,4] 输出：true 
 * 解释：3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4  
 * 
 * <p>
 * 提示：
 * 
 * 3 <= A.length <= 50000 -10^4 <= A[i] <= 10^4 
 * 
 * 通过次数9,051提交次数18,528
 * 
 * @author fanyu
 * @date 2020年3月11日
 */
public class LeetCode_1013 {

	public static void main(String[] args) {
		int[] array = null;
		boolean result = false;
		LeetCode_1013 leetCode = new LeetCode_1013();
		
//		array = new int[] {0,2,1,-6,6,-7,9,1,2,0,1};
//		result = leetCode.canThreePartsEqualSum(array);
//		System.out.println("Result[true] " + result);
//		
//		array = new int[] {0,2,1,-6,6,7,9,-1,2,0,1};
//		result = leetCode.canThreePartsEqualSum(array);
//		System.out.println("Result[false] " + result);
//		
//		array = new int[] {3,3,6,5,-2,2,5,1,-9,4};
//		result = leetCode.canThreePartsEqualSum(array);
//		System.out.println("Result[true] " + result);
		
		array = new int[] {1,-1,1,-1};
		result = leetCode.canThreePartsEqualSum(array);
		System.out.println("Result[false] " + result);
	}
	
	/**
	 * 思路一：
	 *    左右指针 L, R。  0<L<R<len-1;
	 *    即当存在 L，点，R点时，他们三个序列的和 s1,s2,s3 == S/3(S总数组的和)
	 *    1.先求总数组的和S。
	 * @param A
	 * @return
	 */
	private boolean canThreePartsEqualSum(int[] A) {
		// 先求总数组的和 S
		int S = 0;
		int len = A.length;
		for(int n = 0; n < len; n ++) {
			S += A[n];
		}
		
		// 如果能被平分成三份，求 s = S/3;
		if(S%3 != 0) {
			return false; // 如果S不能杯平分成三块，则直接返回false
		}
		
		int s = S/3;
		
		int left = 0, right = len-1;
		int sumL = A[left], sumR=A[right];
		
		while(left < right && sumL != s) {
			left ++;
			sumL += A[left];
		}
			
		while(left < right && sumR != s) {
			right --;
			sumR += A[right];
		}
		
		// 注意： 为了保证是 最终能分成三段
		if(left+1 < right) {
			return true;
		} else {
			return false;
		}
		
    }

}
