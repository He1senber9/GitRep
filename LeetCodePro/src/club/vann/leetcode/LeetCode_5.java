package club.vann.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>难度：Midum</p>
 * <p>题目：最长回文子串</p>
 * <p>描述：给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 * 通过次数211,282提交次数727,637</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/3/21
 * Time: 23:06
 * Description:
 */
public class LeetCode_5 {
    public static void main(String[] args) {
        String s = "";
        String result = "";
        LeetCode_5 leetCode = new LeetCode_5();

        s = "babad";
        result = leetCode.longestPalindrome(s);
        System.out.println("Result[bab] : " + result);

        s = "cbbd";
        result = leetCode.longestPalindrome(s);
        System.out.println("Result[bb] : " + result);

        s = "a";
        result = leetCode.longestPalindrome(s);
        System.out.println("Result[a] : " + result);

        s = "aa";
        result = leetCode.longestPalindrome(s);
        System.out.println("Result[aa] : " + result);

        s = "aaa";
        result = leetCode.longestPalindrome(s);
        System.out.println("Result[aaa] : " + result);

        s = "abcda";
        result = leetCode.longestPalindrome(s);
        System.out.println("Result[a] : " + result);
    }

    /**
     * 解法一：
     * 找出最长的那个回文子串
     * @param s
     * @return
     */
    private String longestPalindrome(String s) {
        String result = "";
        if(s == null || s.length() == 0) {
            return result;
        }

        int len = s.length();
        char[] ch = s.toCharArray();

        LinkedList<Character> pre = null;
        LinkedList<Character> sub = null;
        for(int n = 0; n < len; n ++) {
            int left = n, right = len-1;

            pre = new LinkedList<Character>();
            sub = new LinkedList<Character>();

            while(left <= right) {
                while(left < right && ch[left] != ch[right]) {
                    right --;
                }

                if(left == right) {
                    pre.addLast(ch[left]);
                } else {
                    pre.addLast(ch[left]);
                    sub.addFirst(ch[right]);
                    right --;
                }

                left ++;
            }

            pre.addAll(sub);

            if(pre.size() > result.length()) {
                result = combineString(pre);
            }
        }
        return result;
    }

    private String combineString(LinkedList<Character> list) {
        int size = list.size();

        char[] ch = new char[size];

        for(int n = 0; n < size; n ++) {
            ch[n] = list.get(n);
        }

        return new String(ch);

    }
}
