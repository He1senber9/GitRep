package club.vann.leetcode;

import com.sun.xml.internal.org.jvnet.mimepull.CleanUpExecutorFactory;

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
        result = leetCode.longestPalindrome3(s);
        System.out.println("Result[bab] : " + result);

        s = "cbbd";
        result = leetCode.longestPalindrome3(s);
        System.out.println("Result[bb] : " + result);

        s = "a";
        result = leetCode.longestPalindrome3(s);
        System.out.println("Result[a] : " + result);

        s = "aa";
        result = leetCode.longestPalindrome3(s);
        System.out.println("Result[aa] : " + result);

        s = "aaa";
        result = leetCode.longestPalindrome3(s);
        System.out.println("Result[aaa] : " + result);

        s = "abcda";
        result = leetCode.longestPalindrome3(s);
        System.out.println("Result[a] : " + result);

        s = "ac";
        result = leetCode.longestPalindrome3(s);
        System.out.println("Result[a] : " + result);

        s = "abb";
        result = leetCode.longestPalindrome3(s);
        System.out.println("Result[bb] : " + result);

        s = "ac";
        result = leetCode.longestPalindrome3(s);
        System.out.println("Result[a] : " + result);
    }

    /**
     * 解法一：
     * 找出最长的那个回文子串。该解题思路是只要能组成回文的子串即满足条件。经验证与本地测试案例不符。
     *
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

    /**
     * 解法二：
     * 明确概念：子串/子序列
     * 构造一个当前字符串的逆序字符串，与当前字符串异或。
     * @param s
     * @return
     */
    private String longestPalindrome2(String s) {
        String result = "";
        if(s == null || s.length() == 0) {
            return result;
        }

        int len = s.length();
        char[] c = new char[len];
        for(int n = 0; n < len; n ++) {
            c[n] = (char) (s.charAt(n) ^ s.charAt(len-1-n));
        }

        int begin = 0, end = 0;
        for(int n = 0; n < len; n ++) {
            char ch = c[n];
            if(ch == 0) {
                begin = n;
                end = n;
                while(end < len && c[end] == 0) {
                    end ++;
                }

                result = (result.length() < (end-begin) ? s.substring(begin, end) : result);
            }
        }

        if(result.length() == 0) {
            result = s.substring(0, 1);
        }

        return result;
    }

    /**
     * 如果索引 left 至 right 之间是回文串，则返回他们的长度，否则返回 0；
     * @param str
     * @param left
     * @param right
     * @return
     */
    private int palidStr(String str, int left, int right) {

        int l = left;
        int r = right;

        while(left <= right) {
            if(str.charAt(left) != str.charAt(right)) {
                right --;
            }

            if(str.charAt(left) == str.charAt(right)) {
                r = right;

                right --;
                left ++;
            }

        }
        return r-l+1;
    }

    /**
     * 动态规划解法
     * @param s
     * @return
     */
    public String longestPalindrome3(String s) {
        int len = s.length();

        if(len == 1) {
            return s;
        }
        boolean[][] dp = new boolean[len][len];

        int maxLen = 1;
        int index = 0;
        for(int right = 1; right < len; right ++) {
            for(int left = 0; left < right; left ++) {
                if(s.charAt(left) != s.charAt(right)) {
                    dp[left][right] = false;
                } else {
                    if(right-left < 3) {
                        dp[left][right] = true;
                    } else {
                        dp[left][right] = dp[left+1][right-1];
                    }
                }

                if(right-left+1 > maxLen && dp[left][right]) {
                    maxLen = right-left+1;
                    index = left;
                }
            }
        }

        return s.substring(index, index+maxLen);
    }
}
