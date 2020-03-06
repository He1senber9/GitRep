/**
 * 
 */
package club.vann.leetcode.offer;

import java.util.LinkedList;

/**
 * Easy 翻转单词顺序 
 * 
 * <p>
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 * 
 * <p>
 * 示例 1：
 * 
 * 输入: "the sky is blue" 输出: "blue is sky the" 
 * 
 * <p>
 * 示例 2：
 * 
 * 输入: "  hello world!  " 输出: "world! hello" 
 * 解释:
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。 
 * 
 * <p>
 * 示例 3：
 * 
 * 输入: "a good   example" 输出: "example good a" 
 * 解释:
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。  
 * 
 * 说明：
 * 
 * 无空格字符构成一个单词。 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。 注意：本题与主站 151
 * 题相同：https://leetcode-cn.com/problems/reverse-words-in-a-string/
 * 
 * 注意：此题对比原题有改动
 * 
 * 通过次数1,813提交次数4,353
 * 
 * @author vann
 * @date Mar 1, 2020
 */
public class LeetCode_58I {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "the sky is blue";
		String str1 = "  hello world!  ";
		String str2 = "a good    example";
		String str3 = "  abc dd  ";
		LeetCode_58I leetCode = new LeetCode_58I();
		
		String result = leetCode.reverseWords(str);
		System.out.println(str +" : \\" + result + "\\");
		
		String result1 = leetCode.reverseWords(str1);
		System.out.println(str1 + " : \\" + result1 + "\\");
		
		String result2 = leetCode.reverseWords(str2);
		System.out.println(str2 + " : \\" + result2 + "\\");
		
		String result3 = leetCode.reverseWords(str3);
		System.out.println(str3 + " : \\" + result3 + "\\");
	}

	private String reverseWords(String s) {
//		String str = s.trim(); // 去除两头多余空格
		
		StringBuilder builder = new StringBuilder();
		
		char[] ch = s.toCharArray();
		int len = ch.length;
		
		LinkedList<Character> linkedList = new LinkedList<Character>();
		for(int n = len-1; n >= 0; n --) {
			if(ch[n] == ' ') {
				if(!linkedList.isEmpty() && linkedList.peekLast() == ' ') { // 连续空格跳过
					continue;
				} else if(!linkedList.isEmpty() && linkedList.peekLast() != ' '){
					linkedList.addLast(ch[n]);
					char[] tmp = new char[linkedList.size()];
					int index = 0;
					while(!linkedList.isEmpty()) {
						tmp[index] = linkedList.pollFirst();
						index ++;
					}
					builder.append(new String(tmp));
				}
			} else {
				linkedList.addFirst(ch[n]);
				
				if(n == 0) {
					char[] tmp = new char[linkedList.size()];
					int index = 0;
					while(!linkedList.isEmpty()) {
						tmp[index] = linkedList.pollFirst();
						index ++;
					}
					builder.append(new String(tmp));
				}
			}
			
		}
		
		String newStr = builder.toString();
		
		return newStr;
    }
}
