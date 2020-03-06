package club.vann.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。
 * 
 * 示例：
 * 输入: ["Hello", "Alaska", "Dad", "Peace"]
 * 输出: ["Alaska", "Dad"]
 * 
 * 注意：你可以重复使用键盘上同一字符。你可以假设输入的字符串将只包含字母。
 * 
 * 
 * @author vann
 *
 */
public class LeetCode_500 {

	public static void main(String[] args) {
		String[] strs = {"Hello", "Alaska", "Dad", "Peace"};
		
		LeetCode_500 leetCode = new LeetCode_500();
		strs = leetCode.findWords(strs);
		
		System.out.println(Arrays.toString(strs));
	}
	
	public String[] findWords(String[] words) {
        if(words == null || words.length == 0) {
            return new String[]{};
        }
        
        String one = "qwertyuiop";
        String two = "asdfghjkl";
        String thrid = "zxcvbnm";
        
        List<String> list = new ArrayList<String>();
        
        int len = words.length;
        String str;
        for(int n = 0; n < len; n ++) {
        	str = words[n].toLowerCase();
        	int strLen = str.length();
        	int tag = 0;
        	
        	String code = str.charAt(0)+"";
        	if(one.contains(code)) {
        		tag = 1;
        	} else if(two.contains(code)) {
        		tag = 2;
        	} else if(thrid.contains(code)) {
        		tag = 3;
        	}
        	
        	if(strLen == 1) {
        		list.add(str);
        		continue;
        	}
        	
        	boolean flag = false;
        	for(int m = 1; m < strLen; m ++) {
        		code = str.charAt(m) + "";
        		if((one.contains(code) && tag != 1) || (two.contains(code) && tag != 2) || (thrid.contains(code) && tag != 3)) {
        			flag = false;
        			break;
        		} else {
        			flag = true;
        			continue;
        		}
        	}
        	
        	if(flag) {
        		list.add(str);
        	}
        }
        
        if(list.size() > 0) {
        	String[] result = new String[list.size()];
        	for(int x = 0; x < list.size(); x ++) {
        		result[x] = list.get(x);
        	}
        	return result;
        } else {
        	return new String[] {};
        }
        
    }

}
