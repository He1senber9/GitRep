package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Easy</p>
 * <p>题目：最长回文串</p>
 * <p>描述：给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 *
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 *
 * 注意:
 * 假设字符串的长度不会超过 1010。
 *
 * 示例 1:
 *
 * 输入:
 * "abccccdd"
 *
 * 输出:
 * 7
 *
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * 通过次数28,626提交次数53,018</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/3/19
 * Time: 12:54
 * Description:
 */
public class LeetCode_409 {
    public static void main(String[] args) {
        String s = "";
        int result = 0;
        LeetCode_409 leetCode = new LeetCode_409();

        s = "abccccdd";
        result = leetCode.longestPalindrome(s);
        System.out.println("Result[7] : " + result);

        s = "aaaabbbb";
        result = leetCode.longestPalindrome(s);
        System.out.println("Result[8] : " + result);

        s = "aaabbbb";
        result = leetCode.longestPalindrome(s);
        System.out.println("Result[7] : " + result);

        s = "AAAAAA";
        result = leetCode.longestPalindrome(s);
        System.out.println("Result[6] : " + result);

        s = "zeusnilemacaronimaisanitratetartinasiaminoracamelinsuez";
        result = leetCode.longestPalindrome(s);
        System.out.println("Result[6] : " + result);
    }

    private int longestPalindrome(String s) {
        int result = 0;
        if(s == null || s.length() == 0) {
            return result;
        }

        int[] tags = new int[58];
        char[] ch = s.toCharArray();
        int len = ch.length;

        for(int n = 0; n < len; n++) {
            tags[s.charAt(n)-'A'] = tags[s.charAt(n)-'A'] + 1;
        }

        for(int n = 0; n < 58; n ++) {
            int k = tags[n]/2;
            result += 2*k;
        }

        if(result < len) {
            result += 1;
        }

        return result;
    }
}
