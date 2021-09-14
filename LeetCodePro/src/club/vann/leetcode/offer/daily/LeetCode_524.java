package club.vann.leetcode.offer.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>难度：Medium</p>
 * <p>题目：通过删除字母匹配到字典里最长单词</p>
 * <p>描述：给你一个字符串 s 和一个字符串数组 dictionary 作为字典，找出并返回字典中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
 *
 * 如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
 * 输出："apple"
 * 示例 2：
 *
 * 输入：s = "abpcplea", dictionary = ["a","b","c"]
 * 输出："a"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * 1 <= dictionary.length <= 1000
 * 1 <= dictionary[i].length <= 1000
 * s 和 dictionary[i] 仅由小写英文字母组成
 * 通过次数64,315提交次数130,964
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @description:
 * @program: GitRep
 * @author: fanyu
 * @create: 2021-09-14  21:48:23
 */
public class LeetCode_524 {
    public static void main(String[] args) {
        LeetCode_524 leetCode = new LeetCode_524();

        System.out.println("Result["+TestCase.ANS+"]: " + leetCode.findLongestWord(TestCase.S, TestCase.PARAMS()));
        System.out.println("Result["+TestCase.ANS+"]: " + leetCode.findLongestWord(TestCase.S, TestCase.PARAMS()));
    }

    /**
     * 解法一：
     *
     * @param s
     * @param dictionary
     * @return
     */
    public String findLongestWord(String s, List<String> dictionary) {
        String res = "";
        for(String str : dictionary) {
            int i = 0, j = 0;
            while(i < str.length() && j < s.length()) {
                if(str.charAt(i) == s.charAt(j)) {
                    ++ i;
                }
                ++ j;
            }

            if(i == str.length()) {
                if(str.length() > res.length() || (str.length() == res.length() && str.compareTo(res) < 0)) {
                    res = str;
                }
            }
        }

        return res;
    }

    static class TestCase {
        public static String ANS = "apple";
        public static String S = "abpcplea";
        public static List<String> PARAMS() {
            List<String> list = new ArrayList<>();
            list.add("ale");
            list.add("apple");
            list.add("monkey");
            list.add("plea");
            return list;
        }

        public static String ANS1 = "";
        public static String S1 = "";
        public static List<String> PARAMS1() {
            List<String> list = new ArrayList<>();
            return list;
        }
    }
}
