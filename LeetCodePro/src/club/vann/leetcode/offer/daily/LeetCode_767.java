package club.vann.leetcode.offer.daily;

import sun.awt.image.ImageWatched;
import sun.font.SunLayoutEngine;
import sun.util.resources.cldr.zh.CalendarData_zh_Hans_HK;

import java.util.*;

/**
 * <p>难度：Medium</p>
 * <p>题目：重构字符串</p>
 * <p>描述：给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 *
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 *
 * 示例 1:
 *
 * 输入: S = "aab"
 * 输出: "aba"
 * 示例 2:
 *
 * 输入: S = "aaab"
 * 输出: ""
 * 注意:
 *
 * S 只包含小写字母并且长度在[1, 500]区间内。
 * 通过次数12,660提交次数28,906
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorganize-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: LeetCodePro
 * @description:
 * @author: vann
 * @create: 2020-11-30 08:32
 **/
public class LeetCode_767 {
    public static void main(String[] args) {
        LeetCode_767 leetCode = new LeetCode_767();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.reorganizeString(TestCase.STR));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.reorganizeString(TestCase.STR1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.reorganizeString(TestCase.STR2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.reorganizeString(TestCase.STR3));
        System.out.println("Result["+TestCase.ANS4+"] : " + leetCode.reorganizeString(TestCase.STR4));
        System.out.println("Result["+TestCase.ANS5+"] : " + leetCode.reorganizeString(TestCase.STR5));
        System.out.println("Result["+TestCase.ANS6+"] : " + leetCode.reorganizeString(TestCase.STR6));
        System.out.println("Result["+TestCase.ANS7+"] : " + leetCode.reorganizeString(TestCase.STR7));
    }

    /**
     * 解法一：
     * 基于最大堆的贪心算法
     *
     * 时间复杂度：O(n\log|\Sigma| + |\Sigma|)O(nlog∣Σ∣+∣Σ∣)
     * @param S
     * @return
     */
    public String reorganizeString(String S) {
        if(S == null || S.length() <= 1) {
            return S;
        }

        int len = S.length();
        char[] ch = S.toCharArray();

        int max = 0;
        int[] count = new int[26];
        for(int i = 0; i < len; i ++) {
            int k = ch[i] - 'a';
            count[k] ++;
            max = Math.max(max, count[k]);
        }

        if(max > (len+1)/2) {
            return "";
        }

        PriorityQueue<Character> queue = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return count[o2-'a'] - count[o1-'a'];
            }
        });

        for(int i = 0; i < 26; i ++) {
            if(count[i] > 0) {
                queue.offer((char)(i+'a'));
            }
        }

        StringBuilder builder = new StringBuilder();
        while(queue.size() > 1) {
            char c1 = queue.poll();
            char c2 = queue.poll();

            builder.append(c1);
            builder.append(c2);

            count[c1-'a'] --;
            count[c2-'a'] --;

            if(count[c1-'a'] > 0) {
                queue.offer(c1);
            }

            if(count[c2-'a'] > 0) {
                queue.offer(c2);
            }
        }

        if(queue.size() > 0) {
            builder.append(queue.poll());
        }

        return builder.toString();
    }

    /**
     * 解法二
     * 基于计数的贪心算法
     *
     * @param S
     * @return
     */
    public String reorganizeString1(String S) {
        return null;
    }

    static class TestCase {
        public static String ANS = "aba";
        public static String STR = "aab";

        public static String ANS1 = "";
        public static String STR1 = "aaab";

        public static String ANS2 = "abaca";
        public static String STR2 = "aaabc";

        public static String ANS3 = "ababac";
        public static String STR3 = "aaabbc";

        public static String ANS4 = "a";
        public static String STR4 = "a";

        public static String ANS5 = "ab";
        public static String STR5 = "ab";

        public static String ANS6 = "";
        public static String STR6 = "aa";

        public static String ANS7 = "ababa";
        public static String STR7 = "baaba";
    }
}
