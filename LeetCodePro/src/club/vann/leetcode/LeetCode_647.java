package leetcode;

/**
 * 回文子串。
 * 
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * 
 * 注意：具有不同开始位置或者结束位置的子串，即使是相同的字符组成的，也会被计算为不同的子串。
 * 
 * 
 * @author vann
 *
 */
public class LeetCode_647 {
	private static String str1 = "abc"; // result = 3  "a", "b", "c"
	
	private static String str2 = "aaa"; // result = 6  "a", "a", "a", "aa", "aa", "aaa"
	

	public static void main(String[] args) {
		LeetCode_647  leetCode = new LeetCode_647();
		int result = leetCode.countSubstrings(str1);
		
		System.out.println(result);
	}
	
	private int countSubstrings(String str) {
		return solution1(str);
	}
	
	/**
	 * 解法一： 穷举法
	 * @param str
	 * @return
	 */
	private int solution1(String str) {
		return 0;
	}

}
