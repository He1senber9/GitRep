package leetcode;

import java.util.Stack;

public class LeetCode_557 {

	public static void main(String[] args) {
		String str = "Let's take LeetCode contest";
		
		LeetCode_557 leetCode = new LeetCode_557();
		
		str = leetCode.reverseWords(str);
		
		System.out.println(str);
	}

	private String reverseWords(String s) {
		if (s == null && s.length() == 0) {
			return s;
		}

		StringBuilder builder = new StringBuilder();
		
		int len = s.length();
		Stack<Character> stack = new Stack<Character>();
		
		for(int n = 0; n < len; n ++) {
			char c = s.charAt(n);
			if(c != ' ') {
				stack.add(c);
			} else {
				while(!stack.isEmpty()) {
					builder.append(stack.pop());
				}
				
				builder.append(c);
			} 
			
		}
		
		while(!stack.isEmpty()) {
			builder.append(stack.pop());
		}

		return builder.toString();
	}

}
