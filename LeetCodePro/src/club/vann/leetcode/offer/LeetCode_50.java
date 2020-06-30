package club.vann.leetcode.offer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <p>难度：Easy</p>
 * <p>题目：第一个只出现一次的字符</p>
 * <p>描述：在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 示例:
 *
 * s = "abaccdeff"
 * 返回 "b"
 *
 * s = ""
 * 返回 " "
 *  
 *
 * 限制：
 *
 * 0 <= s 的长度 <= 50000
 *
 * 通过次数25,313提交次数42,172
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-06-30 11:20
 **/
public class LeetCode_50 {
    public static void main(String[] args) {
        LeetCode_50 leetCode = new LeetCode_50();

        System.out.println("Result["+TestCase.ans+"] : " + leetCode.firstUniqChar(TestCase.STR));
        System.out.println("Result["+TestCase.ans1+"] : " + leetCode.firstUniqChar(TestCase.STR1));
        System.out.println("Result["+TestCase.ans2+"] : " + leetCode.firstUniqChar(TestCase.STR2));
        System.out.println("Result["+TestCase.ans3+"] : " + leetCode.firstUniqChar(TestCase.STR3));
    }

    /**
     * 解法一：
     *
     * @param s
     * @return
     */
    private char firstUniqChar(String s) {
        if(s == null || s == "" || s.length() == 0) {
            return ' ';
        }

        int len = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for(int n = 0; n < len; n ++) {
            map.put(s.charAt(n), map.getOrDefault(s.charAt(n), 0) + 1);
        }

        char res = ' ';
        for(int n = 0; n < len; n ++) {
            if(map.get(s.charAt(n)) == 1) {
                res = s.charAt(n);
                break;
            }
        }
        return res;
    }

    static class TestCase {
        public static final char ans = 'b';
        public static final String STR = "abaccdeff";

        public static final char ans1 = 'a';
        public static final String STR1 = "abcdef";

        public static final char ans2 = ' ';
        public static final String STR2 = "";

        public static final char ans3 = ' ';
        public static final String STR3 = "aaaa";
    }
}
