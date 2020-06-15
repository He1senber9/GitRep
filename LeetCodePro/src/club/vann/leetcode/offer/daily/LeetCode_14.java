package club.vann.leetcode.offer.daily;

/**
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/6/15
 * Time: 10:40
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_14 {
    public static void main(String[] args) {
        LeetCode_14 leetCode = new LeetCode_14();

        System.out.println("Result["+TestCase.ans+"] : " + leetCode.longestCommonPrefix(TestCase.strs));
        System.out.println("Result["+TestCase.ans1+"] : " + leetCode.longestCommonPrefix(TestCase.strs1));
        System.out.println("Result["+TestCase.ans2+"] : " + leetCode.longestCommonPrefix(TestCase.strs2));
        System.out.println("Result["+TestCase.ans3+"] : " + leetCode.longestCommonPrefix(TestCase.strs3));
    }

    private String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    static class TestCase {
        public static final String ans = "fl";
        public static final String[] strs = {"flower","flow","flight"};

        public static final String ans1 = "";
        public static final String[] strs1 = {"dog","racecar","car"};

        public static final String ans2 = "a";
        public static final String[] strs2 = {"a"};

        public static final String ans3 = "";
        public static final String[] strs3 = {"", ""};
    }
}
