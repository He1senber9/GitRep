package club.vann.leetcode.offer.daily;

/**
 * @program: GitRep
 * @description:
 * @author: vann
 * @create: 2020-05-19 06:32
 **/
public class LeetCode_680 {
    public static void main(String[] args) {
        LeetCode_680 leetCode = new LeetCode_680();

        System.out.println("Result["+TestCase.ans+"] : " + leetCode.validPalindrome(TestCase.str));
        System.out.println("Result["+TestCase.ans1+"] : " + leetCode.validPalindrome(TestCase.str1));
        System.out.println("Result["+TestCase.ans2+"] : " + leetCode.validPalindrome(TestCase.str2));
        System.out.println("Result["+TestCase.ans3+"] : " + leetCode.validPalindrome(TestCase.str3));
        System.out.println("Result["+TestCase.ans4+"] : " + leetCode.validPalindrome(TestCase.str4));
        System.out.println("Result["+TestCase.ans5+"] : " + leetCode.validPalindrome(TestCase.str5));
        System.out.println("Result["+TestCase.ans6+"] : " + leetCode.validPalindrome(TestCase.str6));
        System.out.println("Result["+TestCase.ans7+"] : " + leetCode.validPalindrome(TestCase.str7));
    }

    /**
     * 解法一：
     * 采用双指针
     * @param s
     * @return
     */
    private boolean validPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return false;
        }

        int len = s.length();
        int left = 0, right = len-1;
        int tag = 0;

        while(tag < 2 && left <= right) {
            if(s.charAt(left) == s.charAt(right)) {
                left ++;
                right --;
            } else if(s.charAt(left+1) == s.charAt(right)) {
                left ++;
                tag ++;
            } else if(s.charAt(left) == s.charAt(right-1)) {
                right --;
                tag ++;
            } else {
                return false;
            }
        }

        if(tag >= 2) {
            return false;
        }
        return true;
    }

    static class TestCase {
        public static final boolean ans = true;
        public static final String str = "aba";

        public static final boolean ans1 = true;
        public static final String str1 = "abca";

        public static final boolean ans2 = false;
        public static final String str2 = "abcda";

        public static final boolean ans3 = true;
        public static final String str3 = "ab";

        public static final boolean ans4 = true;
        public static final String str4 = "abba";

        public static final boolean ans5 = true;
        public static final String str5 = "abcba";

        public static final boolean ans6 = false;
        public static final String str6 = "eeccccbebaeeabebccceea";

        public static final boolean ans7 = true;
        public static final String str7 = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";

    }
}
