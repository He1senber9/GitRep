package leetcode.offer;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 
 * 示例 1：
 * 
 * 输入：s = "We are happy." 输出："We%20are%20happy."  
 * 
 * 限制：
 * 
 * 0 <= s 的长度 <= 10000
 * 
 * @author vann
 *
 */
public class LeetCode_5 {

	public static void main(String[] args) {
		String str = "We are happy.";
		
		LeetCode_5 leetCode = new LeetCode_5();
		String result = leetCode.replaceSpace(str);
		System.out.println(result);
	}

	private String replaceSpace(String s) {
		if(s == null || s.length() == 0) {
			return s;
		}
		
		s = s.replaceAll(" ", "%20");
		return s;
	}

}
