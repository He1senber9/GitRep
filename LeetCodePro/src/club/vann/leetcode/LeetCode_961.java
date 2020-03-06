package club.vann.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode_961 {

	public static void main(String[] args) {
		int[] array = {1,2,3,3};
		int[] array1 = {2,1,2,5,3,2};
		int[] array2 = {5,1,5,2,5,3,5,4};
		
		LeetCode_961 leetCode = new LeetCode_961();
		int code = leetCode.repeatedNTimes(array2);
		System.out.println(code);
	}
	
	private int repeatedNTimes(int[] A) {
        // 出现次数大于1的即为要找的元素
        int len = A.length;
        int code = -1;
        
        Set<Integer> set = new HashSet<Integer>(len/2+2);
        // 只需要在 [0, len/2]范围内找
        for(int n = 0; n <= len/2+1; n ++) {
            if(set.contains(A[n])) {
            	code = A[n];
            } else {
                set.add(A[n]);
            }
        }
        
        return code;
    }

}
