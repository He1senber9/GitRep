package club.vann.leetcode.offer;

import java.util.LinkedList;

/**
 * Medium
 * 
 * <p>
 * 写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
 * 
 * <p>
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。</br>
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；</br>
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。</br>
 * 
 * <p>
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 * 
 * <p>
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 * 
 * <p>
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 * 
 * <p>
 * 说明：</br>
 * 
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX
 * (231 − 1) 或 INT_MIN (−231) 。
 * 
 * <p>
 * 示例 1:</br>
 * 
 * 输入: "42" 输出: 42
 * 
 * <p>
 * 示例 2:</br>
 * 
 * 输入: " -42" 输出: -42 </br>
 * 解释: 第一个非空白字符为 '-', 它是一个负号。我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 
 * <p>
 * 示例 3:</br>
 * 
 * 输入: "4193 with words" 输出: 4193 </br>
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 
 * <p>
 * 示例 4:</br>
 * 
 * 输入: "words and 987" 输出: 0 </br>
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。 因此无法执行有效的转换。
 * 
 * <p>
 * 示例 5:</br>
 * 
 * 输入: "-91283472332" 输出: -2147483648 </br>
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。   因此返回 INT_MIN (−231) 。
 * 
 * @author vann
 *
 */
public class LeetCode_67 {

	public static void main(String[] args) {
		String str = "42";
		String str1 = "-42";
		String str2 = "4193 with words";
		String str3 = "words and 987";
		String str4 = "91283472332";
		String str5 = "+";
		String str6 = "3.14159";
		String str7 = "   -42";
		String str8 = " ";
		String str9 = "   +0 123";
		String str10 = "20000000000000000000";
		
		LeetCode_67 leetCode = new LeetCode_67();
		
//		int result = leetCode.strToInt(str);
//		System.out.println(result);
//		int result1 = leetCode.strToInt(str1);
//		System.out.println(result1);
//		int result2 = leetCode.strToInt(str2);
//		System.out.println(result2);
//		int result3 = leetCode.strToInt(str3);
//		System.out.println(result3);
//		int result4 = leetCode.strToInt(str4);
//		System.out.println(result4);
//		int result5 = leetCode.strToInt(str5);
//		System.out.println(result5);
//		int result6 = leetCode.strToInt(str6);
//		System.out.println(result6);
//		int result7 = leetCode.strToInt(str7);
//		System.out.println(result7);
//		int result8 = leetCode.strToInt(str8);
//		System.out.println(result8);
//		int result9 = leetCode.strToInt(str9);
//		System.out.println(result9);
		int result10 = leetCode.strToInt(str10);
		System.out.println(result10);
	}
	
    private int strToInt(String str) {
    	// 字符串为空，字符串仅包含空白字符，字符串中的第一个非空格字符不是一个有效整数字符
    	if(str == null || str.length() == 0) {
    		return 0;
    	}
    	
    	LinkedList<Character> list = new LinkedList<Character>();
    	
    	int size = str.length();
    	for(int n = 0; n < size; n ++) {
    		char c = str.charAt(n);
    		
    		if(list.isEmpty()) {
                if(c == '-' || c == '+' || (c > '0' && c <= '9')) { // 有效字符
                    list.offer(c);
                } else if(c == ' '){
                    continue;
                } else {
                	return 0;
                }
            } else {
                if(c >= '0' && c <= '9') {
                    list.offer(c);
                }  else {
                	break;
                }
            }
    	}
    	
    	if(list.isEmpty()) {
    		return 0;
    	}
    	
    	if(list.peekLast() == '-' || list.peekLast() == '+') { // 只有 - + 符号
    		return 0;
    	} 
    	
    	int sign = 1; // 正负标志位，默认是正
    	if(list.peekFirst() == '-' || list.peekFirst() == '+') {
    		list.pollFirst();
    	}
    
    	double result = 0;
    	int pow = list.size() - 1;
    	while(!list.isEmpty()) {
    		int cc = list.pollFirst() - '0';
    		double temp = Math.pow(10, pow) * cc;
    		
//    		if(temp != (int) temp) { //判断乘法溢出
//    			if(sign == -1) {
//    				return Integer.MIN_VALUE;
//    			} else {
//    				return Integer.MAX_VALUE;
//    			}
//    		}
//    		
//    		temp = temp + result;
//    		if(temp != (int) temp) {
//    			if(sign == -1) {
//    				return Integer.MIN_VALUE;
//    			} else {
//    				return Integer.MAX_VALUE;
//    			}
//    		}
    		
    		result = temp * cc + result;
    		if(result != (int) result) {
    			if(sign == 1) {
    				return Integer.MAX_VALUE;
    			} else {
    				return Integer.MIN_VALUE;
    			}
    		} else {
    			pow --;
    		}
    		
    	}
    	
       return (int) (sign * result); 
    }

}
