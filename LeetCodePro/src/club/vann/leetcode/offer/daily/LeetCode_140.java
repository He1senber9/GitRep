package club.vann.leetcode.offer.daily;

import java.util.Arrays;
import java.util.List;

/**
 * <p>难度：Hard</p>
 * <p>题目：单词拆分 II</p>
 * <p>描述：给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 *
 * 说明：
 *
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 * 示例 2：
 *
 * 输入:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 输出:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * 解释: 注意你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出:
 * []
 * 通过次数23,288提交次数59,740
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/11/1
 * Time: 11:32
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_140 {
    public static void main(String[] args) {
        LeetCode_140 leetCode = new LeetCode_140();

        List<String> result = null;

        result = leetCode.wordBreak(TestCase.STR, TestCase.WORDDICT);
        result = leetCode.wordBreak(TestCase.STR1, TestCase.WORDDICT1);
        result = leetCode.wordBreak(TestCase.STR2, TestCase.WORDDICT2);

        System.out.println("Success");
    }

    /**
     * 解法一：
     * 
     * @param s
     * @param wordDict
     * @return
     */
    public List<String> wordBreak(String s, List<String> wordDict) {
        return null;
    }

    static class TestCase {
        public static String STR = "catsanddog";
        public static List<String> WORDDICT = Arrays.asList(new String[]{"cat", "cats", "and", "sand", "dog"});

        public static String STR1 = "pineapplepenapple";
        public static List<String> WORDDICT1 = Arrays.asList(new String[]{"apple", "pen", "applepen", "pine", "pineapple"});

        public static String STR2 = "catsandog";
        public static List<String> WORDDICT2 = Arrays.asList(new String[]{"cats", "dog", "sand", "and", "cat"});
    }
}
