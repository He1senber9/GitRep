package leetcode;

import java.util.Stack;

public class LeetCode_1021 {

	public static void main(String[] args) {
		String str = "(()())(())";
		String str1 = "(()())(())(()(()))";
		String str2 = "()()";
		
		LeetCode_1021 leetCode = new LeetCode_1021();
		str = leetCode.removeOuterParentheses(str1);
		System.out.println(str);
	}

	private String removeOuterParentheses(String S) {
		int len = S.length();
		
		int count = 0;
		
		StringBuilder builder = new StringBuilder();
		
		for(int n = 0; n < len; n++) {
			char c = S.charAt(n);
			if(c == '(' && count++ > 0) {
				builder.append(c);
			} else if(c == ')' && --count > 0) {
				builder.append(c);
			}
			
		}
		
		return builder.toString();
	}

}
