/**
 * 
 */
package club.vann.leetcode;

/**
 * Midum 翻转字符串里的单词
 * 
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * 
 *  
 * 
 * 示例 1：
 * 
 * 输入: "the sky is blue" 输出: "blue is sky the" 示例 2：
 * 
 * 输入: "  hello world!  " 输出: "world! hello" 解释:
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。 示例 3：
 * 
 * 输入: "a good   example" 输出: "example good a" 解释:
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。  
 * 
 * 说明：
 * 
 * 无空格字符构成一个单词。 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。  
 * 
 * 进阶：
 * 
 * 请选用 C 语言的用户尝试使用 O(1) 额外空间复杂度的原地解法。
 * 
 * 通过次数32,273提交次数89,262
 * 
 * @author vann
 * @date Mar 3, 2020
 */
public class LeetCode_151 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = " ";
		LeetCode_151 leetCode = new LeetCode_151();

		String result = leetCode.reverseWords(str);
		System.out.println("\\" + result + "\\");
	}

	public String reverseWords(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}

		char[] ch = s.toCharArray();
		int len = s.length();
		int left = 0, right = len - 1;
		while (left <= right && ch[left] == ' ') { // 去除两头空格
			left++;
		}

		while (left <= right && ch[right] == ' ') {
			right--;
		}

		String res = "", tmps = "";
		for (int n = left; n <= right; n++) {
			if (ch[n] != ' ') {
				tmps += ch[n];
			} else {
				while (ch[n] == ' ') {
					n++;
				}

				n--;
				res += swp(tmps);
				res += " ";
				tmps = "";
			}
		}

		res += swp(tmps);
		res = swp(res);

		return res;
	}

	private String swp(String str) {
		int left = 0, right = str.length() - 1;
		char[] ch = str.toCharArray();
		while (left < right) {
			char tmp = ch[left];
			ch[left] = ch[right];
			ch[right] = tmp;
			left++;
			right--;
		}
		return new String(ch);
	}
}
