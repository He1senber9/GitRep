package club.vann.leetcode.offer.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>难度：Medium</p>
 * <p>题目：单词拆分</p>
 * <p>描述：给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 *
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 *
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 * 通过次数63,179提交次数138,518
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/6/25
 * Time: 15:27
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_139 {
    public static void main(String[] args) {
        LeetCode_139 leetCode = new LeetCode_139();

        System.out.println("Result["+TestCase.ans+"] : " + leetCode.wordBreak(TestCase.STR, TestCase.fun()));
        System.out.println("Result["+TestCase.ans1+"] : " + leetCode.wordBreak(TestCase.STR1, TestCase.fun1()));
        System.out.println("Result["+TestCase.ans2+"] : " + leetCode.wordBreak(TestCase.STR2, TestCase.fun2()));
    }

    /**
     * 解法一：
     * 
     * @param s
     * @param wordDict
     * @return
     */
    private boolean wordBreak(String s, List<String> wordDict) {
        return false;
    }

    static class TestCase {
        public static final boolean ans = true;
        public static List<String> fun() {
            List<String> list = new ArrayList<>();

            list.add("leet");
            list.add("code");
            return list;
        }
        public static final String STR = "leetcode";

        public static final boolean ans1 = true;
        public static List<String> fun1() {
            List<String> list = new ArrayList<>();

            list.add("apple");
            list.add("pen");
            return list;
        }
        public static final String STR1 = "applepenapple";

        public static final boolean ans2 = true;
        public static List<String> fun2() {
            List<String> list = new ArrayList<>();

            list.add("cats");
            list.add("dog");
            list.add("sand");
            list.add("and");
            list.add("cat");
            return list;
        }
        public static final String STR2 = "applepenapple";
    }
}
