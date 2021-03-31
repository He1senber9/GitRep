package club.vann.leetcode.offer.daily;

import java.util.Arrays;

/**
 * <p>难度：Medimu</p>
 * <p>题目：字符串的排列</p>
 * <p>描述：给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 * 示例1:
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *  
 *
 * 示例2:
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *  
 *
 * 注意：
 *
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 * 通过次数55,932提交次数143,719
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @author vann
 * @program GitRep
 * @description
 * @date 2021-02-10:08:04:21
 */
public class LeetCode_567 {
    public static void main(String[] args) {
        LeetCode_567 leetCode = new LeetCode_567();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.checkInclusion1(TestCase.S1, TestCase.S2));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.checkInclusion1(TestCase.S11, TestCase.S21));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.checkInclusion1(TestCase.S12, TestCase.S22));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.checkInclusion1(TestCase.S13, TestCase.S23));
        System.out.println("Result["+TestCase.ANS4+"] : " + leetCode.checkInclusion1(TestCase.S14, TestCase.S24));
        System.out.println("Result["+TestCase.ANS5+"] : " + leetCode.checkInclusion1(TestCase.S15, TestCase.S25));
    }

    /**
     * 解法一：
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        int lenS1 = s1.length();
        int lenS2 = s2.length();

        if(lenS1 > lenS2) {
            return false;
        }

        char[] charS1 = s1.toCharArray();
        char[] charS2 = s2.toCharArray();

        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for(int i = 0; i < lenS1; i ++) {
            cnt1[charS1[i] - 'a'] ++;
            cnt2[charS2[i] - 'a'] ++;
        }

        if(Arrays.equals(cnt1, cnt2)) {
            return true;
        }

        for(int i = lenS1; i < lenS2; i ++) {
            char charLeft = charS2[i-lenS1];
            char charRight = charS2[i];

            cnt2[charLeft-'a'] --;
            cnt2[charRight-'a'] ++;

            if(Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 解法一优化：
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion1(String s1, String s2) {
        int lenS1 = s1.length();
        int lenS2 = s2.length();

        if(lenS1 > lenS2) {
            return false;
        }

        char[] charS1 = s1.toCharArray();
        char[] charS2 = s2.toCharArray();

        int[] cnt = new int[26];
        for(int i = 0; i < lenS1; i ++) {
            cnt[charS1[i]-'a'] --;
            cnt[charS2[i]-'a'] ++;
        }

        int diff = 0;
        for(int i = 0; i < 26; i ++) {
            if(cnt[i] != 0) {
                diff ++;
            }
        }

        if(diff == 0) {
            return true;
        }

        for(int i = lenS1; i < lenS2; i ++) {
            char charLeft = charS2[i-lenS1];
            char charRight = charS2[i];

            if(charLeft == charRight) {
                continue;
            }

            // 如果新增字符前该字符数量上已经一致，新增会导致diff+1
            if(cnt[charRight-'a'] == 0) {
                diff ++;
            }
            cnt[charRight-'a'] ++;
            // 如果新增字符在新增后导致数量一致，则diff-1
            if(cnt[charRight-'a'] == 0) {
                diff --;
            }

            if(cnt[charLeft-'a'] == 0) {
                diff ++;
            }
            cnt[charLeft-'a'] --;

            if(cnt[charLeft-'a'] == 0) {
                diff --;
            }

            if(diff == 0) {
                return true;
            }
        }

        return false;
    }

    /**
     * 解法三：
     * 双指针。
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion2(String s1, String s2) {
        int lenS1 = s1.length();
        int lenS2 = s2.length();

        if(lenS1 > lenS2) {
            return false;
        }

        char[] charS1 = s1.toCharArray();
        char[] charS2 = s2.toCharArray();

        int[] cnt = new int[26];
        for(int i = 0; i < lenS1; i ++) {
            cnt[charS1[i]-'a'] --;
            cnt[charS2[i]-'a'] ++;
        }

        int diff = 0;
        for(int i = 0; i < 26; i ++) {
            if(cnt[i] != 0) {
                diff ++;
            }
        }

        if(diff == 0) {
            return true;
        }

        for(int i = lenS1; i < lenS2; i ++) {
            char charLeft = charS2[i-lenS1];
            char charRight = charS2[i];

            if(charLeft == charRight) {
                continue;
            }

            // 如果新增字符前该字符数量上已经一致，新增会导致diff+1
            if(cnt[charRight-'a'] == 0) {
                diff ++;
            }
            cnt[charRight-'a'] ++;
            // 如果新增字符在新增后导致数量一致，则diff-1
            if(cnt[charRight-'a'] == 0) {
                diff --;
            }

            if(cnt[charLeft-'a'] == 0) {
                diff ++;
            }
            cnt[charLeft-'a'] --;

            if(cnt[charLeft-'a'] == 0) {
                diff --;
            }

            if(diff == 0) {
                return true;
            }
        }

        return false;
    }

    static class TestCase {
        public static boolean ANS = true;
        public static String S1 = "ab";
        public static String S2 = "eidbaooo";

        public static boolean ANS1 = false;
        public static String S11 = "ab";
        public static String S21 = "eidboaoo";

        public static boolean ANS2 = false;
        public static String S12 = "ab";
        public static String S22 = "adbcdefgh";

        public static boolean ANS3 = true;
        public static String S13 = "fed";
        public static String S23 = "adbcdefgh";

        public static boolean ANS4 = true;
        public static String S14 = "adc";
        public static String S24 = "dcda";

        public static boolean ANS5 = true;
        public static String S15 = "adc";
        public static String S25 = "abdefgdca";
    }
}
