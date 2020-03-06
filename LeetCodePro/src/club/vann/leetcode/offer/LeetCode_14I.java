package club.vann.leetcode.offer;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m≥1），每段绳子的长度记为 k[0],k[1]...k[m]
 * 。请问 k[0]*k[1]*...*k[m]
 * 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * 
 * @author vann
 *
 */
public class LeetCode_14I {
	
	public static void main(String[] args) {
		int n = 8;
		
		LeetCode_14I leetCode = new LeetCode_14I();
		int result = leetCode.cuttingRope1(n);
		System.out.println(result);
	}
	
	/** 
	 * 递归算法。
	 * 
	 * @param n
	 * @return
	 */
	public int cuttingRope(int n) {
		if(n == 2) {
			return 1;
		}
		
		int maxValue = 0;
		
		for(int x = 2; x <= (n+1)/2; x ++) {
			int left = x;
			int right = n-x;
			
			int result = 0;
			if(right > 2) {
				result = left * cuttingRope(right);
			} else {
				result = left * right;
			}
			
			if(result < (left*right)) {
				result = left*right;
			}
			
			if(result > maxValue) {
				maxValue = result;
			}
		}
		
        return maxValue;
    }
	
	private int cuttingRope1(int n) {
		int maxValue = 1;
		
		if(n % 3 == 2) {
			n -= 2;
			maxValue *= 2;
		}
		
		if(n % 3 == 1) {
			n -= 4;
			maxValue *= 4;
		}
		
		while(n > 0) {
			n -= 3;
			maxValue *= 3;
		}
		
		return maxValue;
	}
}
