package club.vann.leetcode.offer;

/**
 * Easy
 * 二进制中1的个数
 * 
 * @author vann
 *
 */
public class LeetCode_15 {

	public static void main(String[] args) {
		int n = 9;
		LeetCode_15 leetCode = new LeetCode_15();
		int result = leetCode.hammingWeight(n);
		System.out.println(result);
	}
	
	// you need to treat n as an unsigned value
    public int hammingWeight(int n) {
    	int count = 0;
    	System.out.println("Info:" + Integer.bitCount(n));
//    	count = Integer.bitCount(n);
    	
    	int pow = 1;
    	while((n - pow) > 0) {
    		n = n - pow;
    		pow = pow << 1;
    		count ++;
    	}
    	
        return count;
    }

}
