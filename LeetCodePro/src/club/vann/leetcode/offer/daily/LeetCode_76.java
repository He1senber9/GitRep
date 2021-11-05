package club.vann.leetcode.offer.daily;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>难度：Hard</p>
 * <p>题目：最小覆盖子串</p>
 * <p>给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 示例 2：
 *
 * 输入：s = "a", t = "a"
 * 输出："a"
 *  
 *
 * 提示：
 *
 * 1 <= s.length, t.length <= 105
 * s 和 t 由英文字母组成
 *  
 *
 * 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？
 * 通过次数106,817提交次数263,349
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @author vann
 * @program GitRep
 * @description
 * @date 2021-02-09:11:18:25
 */
public class LeetCode_76 {
    public static void main(String[] args) {
        LeetCode_76 leetCode = new LeetCode_76();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.minWindow(TestCase.S, TestCase.T));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.minWindow(TestCase.S1, TestCase.T1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.minWindow(TestCase.S2, TestCase.T2));
    }

    /**
     * 解法一：
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        if(lenS == 0 || lenT == 0 || lenS < lenT) {
            return "";
        }

        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();

        int[] windowsFreq = new int[128];
        int[] tFreq = new int[128];
        for(char c : charT) {
            tFreq[c] ++;
        }

        int distence = 0;
        int min = lenS+1;
        int begin = 0;

        int left = 0, right = 0;
        while(right < lenS) {
            // 判断当前字符不属于T
            char rightC = charS[right];
            if(tFreq[rightC] == 0) {
                right ++;
                continue;
            }

            // 当前滑动窗口中字符少于T
            if(windowsFreq[rightC] < tFreq[rightC]) {
                distence ++;
            }

            windowsFreq[rightC] ++;
            right ++;

            while(distence == lenT) {
                char leftC = charS[left];

                if(right - left < min) {
                    min = right - left;
                    begin = left;
                }

                if(tFreq[leftC] == 0) {
                    left ++;
                    continue;
                }

                if(windowsFreq[leftC] == tFreq[leftC]) {
                    distence --;
                }

                windowsFreq[leftC] --;
                left ++;
            }
        }

        if(min == lenS + 1) {
            return "";
        }
        return s.substring(begin, begin+min);
    }

    static class TestCase {
        public static String ANS = "BANC";
        public static String S = "ADOBECODEBANC";
        public static String T = "ABC";

        public static String ANS1 = "a";
        public static String S1 = "a";
        public static String T1 = "a";

        public static String ANS2 = "";
        public static String S2 = "abc";
        public static String T2 = "abd";
    }
}
