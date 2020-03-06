package club.vann.leetcode;

public class LeetCode_908 {

	public static void main(String[] args) {
		int[] array = {1};
		int k = 0;
		
		int[] array1 = {0, 10};
		int k1 = 2;
		
		int[] array2 = {1, 3, 6};
		int k2 = 3;
		
		LeetCode_908 leetCode = new LeetCode_908();
		int code = leetCode.smallestRangeI(array2, k2);
		System.out.println(code);
	}
	
	private int smallestRangeI(int[] A, int K) {
        int len = A.length;
        
        if(len == 1) {
        	return 0;
        }
        
        int min = A[0], max = A[0];
        for(int n = 1; n < len; n ++) {
            if(A[n] < min) {
            	min = A[n];
            } else if(A[n] >= max) {
            	max = A[n];
            }
        }
        
        if(max - min >= 2*K) {
        	return (max-K) - (min+K); 
        } else {
        	return 0;
        }
    }

}
