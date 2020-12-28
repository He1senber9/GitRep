package club.vann.leetcode.offer.daily;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>难度：Easy</p>
 * <p>题目：同构字符串</p>
 * <p>描述：给定两个字符串 s 和 t，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 *
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 示例 1:
 *
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 示例 3:
 *
 * 输入: s = "paper", t = "title"
 * 输出: true
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 *
 * 通过次数63,914提交次数132,488
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/isomorphic-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-12-27 10:19
 **/
public class LeetCode_205 {
    public static void main(String[] args) {
        LeetCode_205 leetCode = new LeetCode_205();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.isIsomorphic(TestCase.PARAMS[0], TestCase.PARAMS[1]));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.isIsomorphic(TestCase.PARAMS1[0], TestCase.PARAMS1[1]));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.isIsomorphic(TestCase.PARAMS2[0], TestCase.PARAMS2[1]));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.isIsomorphic(TestCase.PARAMS3[0], TestCase.PARAMS3[1]));
    }

    public boolean isIsomorphic(String s, String t) {
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        int len = charS.length;

        Map<Character, Character> map = new HashMap<>();
        for(int i = 0; i < len; i ++) {
            char c1 = charS[i];
            char c2 = charT[i];

            // 先检查当前字符对应的字符是否已经被映射过
            if(!map.containsKey(c1)) {
                if(map.containsValue(c2)) {
                    return false;
                }
                map.put(c1,c2);
            } else {
                if(map.get(c1) != c2) {
                    return false;
                }
            }
        }

        return true;
    }

    static class TestCase {
        public static boolean ANS = true;
        public static String[] PARAMS = {"egg", "add"};

        public static boolean ANS1 = false;
        public static String[] PARAMS1 = {"foo", "bar"};

        public static boolean ANS2 = true;
        public static String[] PARAMS2 = {"paper", "title"};

        public static boolean ANS3 = false;
        public static String[] PARAMS3 = {"ab", "aa"};
    }
}
