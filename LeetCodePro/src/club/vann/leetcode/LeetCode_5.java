package club.vann.leetcode;

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
    }

    /**
     * 解法一：
     * 挑出字符是偶数的字符。
     * @param s
     * @return
     */
    private String longestPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }

        int len = s.length();

        int[] ch = new int[58];
        for(int n = 0; n < len; n ++) {
            int v = s.charAt(n);
            ch[v-'a'] = ch[v-'a'] + 1;
        }

        for(int n = 0; n < 58; n ++) {

        }
        return null;
    }
}
