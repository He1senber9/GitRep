package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
 * 
 * 例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 * 
 * 你可以按任意顺序返回答案。
 * 
 *  
 * 
 * 示例 1：
 * 
 * 输入：["bella","label","roller"] 输出：["e","l","l"] 
 * 
 * 示例 2：
 * 
 * 输入：["cool","lock","cook"] 输出：["c","o"]  
 * 
 * 提示：
 * 
 * 1 <= A.length <= 100 1 <= A[i].length <= 100 A[i][j] 是小写字母
 * 
 * @author vann
 *
 */
public class LeetCode_1002 {

	public static void main(String[] args) {
		String[] strs = {"bella","label","roller"};
		String[] strs2 = {"cool","lock","cook"};
		
		LeetCode_1002 leetCode = new LeetCode_1002();
		List<String> list = leetCode.commonChars(strs2);
		System.out.println(Arrays.toString(list.toArray()));
	}

	private List<String> commonChars(String[] A) {
		if(A == null || A.length == 0) {
			return null;
		}
		int len = A.length;
		
		String tag = findTagString(A[0], A[1]);
		for(int n = 2; n < len; n ++) {
			tag = findTagString(tag, A[n]);
		}
		
		List<String> resultList = new ArrayList<String>();
		for(int m = 0; m < tag.length(); m ++) {
			resultList.add(tag.charAt(m)+"");
		}
		
        return resultList;
    }
	
	/**
	 * 找到两个指定字符串中公共子串。
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	private String findTagString(String str1, String str2) {
		String result = "";
		int[] nums = new int[26];
		int len = str1.length();
		for(int n = 0; n < len; n ++) {
			char ch = str1.charAt(n);
			int index = str2.indexOf(ch, nums[ch-'a']);
			
			if(index<str2.length() && index >= 0) {
				result += ch;
				nums[ch-'a'] = index + 1;
			}
		}
		return result;
	}
}
