package club.vann.leetcode.offer.daily;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>难度：Easy</p>
 * <p>题目：单词规律</p>
 * <p>描述：给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 示例1:
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 *
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 *
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 *
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。    
 *
 * 通过次数37,872提交次数85,644
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/12/16
 * Time: 8:14
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_290 {
    public static void main(String[] args) {
        LeetCode_290 leetCode = new LeetCode_290();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.wordPattern(TestCase.PATTERN, TestCase.S));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.wordPattern(TestCase.PATTERN1, TestCase.S1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.wordPattern(TestCase.PATTERN2, TestCase.S2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.wordPattern(TestCase.PATTERN3, TestCase.S3));
        System.out.println("Result["+TestCase.ANS4+"] : " + leetCode.wordPattern(TestCase.PATTERN4, TestCase.S4));
    }

    /**
     * 解法一：
     *
     * @param pattern
     * @param s
     * @return
     */
    public boolean wordPattern(String pattern, String s) {
        String[] strs = s.split(" ");
        char[] ch = pattern.toCharArray();

        int len_p = ch.length;
        int len_s = strs.length;

        if(len_p != len_s) {
            return false;
        }

        Map<Character, String> char2Str = new HashMap<>();
        Map<String, Character> str2Char = new HashMap<>();
        for(int i = 0; i < len_p; i ++) {
            String str = strs[i];

            if(char2Str.containsKey(ch[i]) && !char2Str.get(ch[i]).equals(str)) {
                return false;
            }

            if(str2Char.containsKey(str) && str2Char.get(str) != ch[i]) {
                return false;
            }

            char2Str.put(ch[i], str);
            str2Char.put(str, ch[i]);
        }
        return true;
    }

    static class TestCase {
        public static boolean ANS = true;
        public static String PATTERN = "abba";
        public static String S = "dog cat cat dog";

        public static boolean ANS1 = false;
        public static String PATTERN1 = "abba";
        public static String S1 = "dog cat cat fish";

        public static boolean ANS2 = false;
        public static String PATTERN2 = "aaaa";
        public static String S2 = "dog cat cat dog";

        public static boolean ANS3 = false;
        public static String PATTERN3 = "abba";
        public static String S3 = "dog dog dog dog";


        public static boolean ANS4 = false;
        public static String PATTERN4 = "abc";
        public static String S4 = "dog cat dog";

    }
}
