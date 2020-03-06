package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_922 {

	public static void main(String[] args) {
		int[] array = {4,2,5,7};
		
		LeetCode_922 leetCode = new LeetCode_922();
		array = leetCode.sortArrayByParityII(array);
		
		System.out.println(Arrays.toString(array));
	}

	private int[] sortArrayByParityII(int[] A) {
		int len = A.length;

		List<Integer> oddList = new ArrayList<Integer>(len/2);
		List<Integer> evenList = new ArrayList<Integer>(len/2);
		for (int n = 0; n < len; n++) {
			if(A[n]%2==0) {
				evenList.add(A[n]);
			} else {
				oddList.add(A[n]);
			} 
		}
		
		int m = 0;
		for(int n = 0; n < len/2; n ++) {
			A[m] = evenList.get(n);
			A[m+1] = oddList.get(n);
			m = m + 2;
		}

		return A;
	}
}
