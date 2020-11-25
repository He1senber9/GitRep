package club.vann.leetcode.offer.daily;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>难度：Easy</p>
 * <p>题目：上升下降字符串</p>
 * <p>描述：给你一个字符串 s ，请你根据下面的算法重新构造字符串：
 *
 * 从 s 中选出 最小 的字符，将它 接在 结果字符串的后面。
 * 从 s 剩余字符中选出 最小 的字符，且该字符比上一个添加的字符大，将它 接在 结果字符串后面。
 * 重复步骤 2 ，直到你没法从 s 中选择字符。
 * 从 s 中选出 最大 的字符，将它 接在 结果字符串的后面。
 * 从 s 剩余字符中选出 最大 的字符，且该字符比上一个添加的字符小，将它 接在 结果字符串后面。
 * 重复步骤 5 ，直到你没法从 s 中选择字符。
 * 重复步骤 1 到 6 ，直到 s 中所有字符都已经被选过。
 * 在任何一步中，如果最小或者最大字符不止一个 ，你可以选择其中任意一个，并将其添加到结果字符串。
 *
 * 请你返回将 s 中字符重新排序后的 结果字符串 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "aaaabbbbcccc"
 * 输出："abccbaabccba"
 * 解释：第一轮的步骤 1，2，3 后，结果字符串为 result = "abc"
 * 第一轮的步骤 4，5，6 后，结果字符串为 result = "abccba"
 * 第一轮结束，现在 s = "aabbcc" ，我们再次回到步骤 1
 * 第二轮的步骤 1，2，3 后，结果字符串为 result = "abccbaabc"
 * 第二轮的步骤 4，5，6 后，结果字符串为 result = "abccbaabccba"
 * 示例 2：
 *
 * 输入：s = "rat"
 * 输出："art"
 * 解释：单词 "rat" 在上述算法重排序以后变成 "art"
 * 示例 3：
 *
 * 输入：s = "leetcode"
 * 输出："cdelotee"
 * 示例 4：
 *
 * 输入：s = "ggggggg"
 * 输出："ggggggg"
 * 示例 5：
 *
 * 输入：s = "spo"
 * 输出："ops"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 500
 * s 只包含小写英文字母。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-decreasing-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: LeetCodePro
 * @description:
 * @author: vann
 * @create: 2020-11-25 09:34
 **/
public class LeetCode_1370 {
    public static void main(String[] args) {
        LeetCode_1370 leetCode = new LeetCode_1370();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.sortString(TestCase.STR));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.sortString(TestCase.STR1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.sortString(TestCase.STR2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.sortString(TestCase.STR3));
        System.out.println("Result["+TestCase.ANS4+"] : " + leetCode.sortString(TestCase.STR4));
        System.out.println("Result["+TestCase.ANS5+"] : " + leetCode.sortString(TestCase.STR5));
    }

    /**
     * 解法一：
     * @param s
     * @return
     */
    public String sortString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] ch = s.toCharArray();
        int len = ch.length;

        for(char c : ch) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int flag = 1; // 控制升序降序，默认升序
        int tag = 0;
        int i = 0;
        while(!map.isEmpty()) {
            if(tag == 26 || tag == -1) {
                flag = flag * -1;
            }

            char c = (char) (tag + 'a');
            if(map.containsKey(c)) {
                ch[i++] = c;
                int count = map.get(c);
                if(count == 1) {
                    map.remove(c);
                } else {
                    map.put(c, count - 1);
                }
            }

            tag += flag * 1;
        }
        return new String(ch);
    }

    static class TestCase {
        public static String ANS = "abccbaabccba";
        public static String STR = "aaaabbbbcccc";

        public static String ANS1 = "art";
        public static String STR1 = "rat";

        public static String ANS2 = "cdelotee";
        public static String STR2 = "leetcode";

        public static String ANS3 = "ggggggg";
        public static String STR3 = "ggggggg";

        public static String ANS4 = "ops";
        public static String STR4 = "spo";

        public static String ANS5 = "aaabbbcccddd";
        public static String STR5 = "abcddcbaabcd";
    }
}
