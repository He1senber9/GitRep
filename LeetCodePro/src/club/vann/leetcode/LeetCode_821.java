package leetcode;

import java.util.Arrays;
import java.util.Stack;

public class LeetCode_821 {

	public static void main(String[] args) {
//		String str = "loveleetcode";
//		char c = 'e';
		
		String str = "aaba";
		char c = 'b';
		
		LeetCode_821 leetCode = new LeetCode_821();
		int[] array = leetCode.shortestToChar(str, c);
		
		System.out.println(Arrays.toString(array));
	}
	
	private int[] shortestToChar(String S, char C) {
		int len = S.length();
		
		int[] arrays = new int[len];
		
		Stack<Integer> stack = new Stack<Integer>();
		
		int index = -1;
		for(int n = 0; n < len; n ++) {
			char cc = S.charAt(n);
			stack.add(n);
			if(cc != C && index == -1) {
				continue;
			} else if(cc == C && index == -1) {
				while(!stack.isEmpty()) {
					int code = stack.pop();
					arrays[code] = n - code;
				}
				index = n;
			} else if(cc != C && index >= 0) {
				arrays[n] = n-index;
			} else if(cc == C && index >= 0) {
				while(!stack.isEmpty()) {
					int code = stack.pop();
					if(code > (n+index)/2) {
						arrays[code] = n - code;
					}
				}
				index = n;
			}
		}
		
		return arrays;
    }

}
