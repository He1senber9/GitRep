package club.vann.leetcode.offer.daily;

import java.util.*;

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

        result = leetCode.wordBreak3(TestCase.STR, TestCase.WORDDICT);
        result = leetCode.wordBreak3(TestCase.STR1, TestCase.WORDDICT1);
        result = leetCode.wordBreak3(TestCase.STR2, TestCase.WORDDICT2);
        result = leetCode.wordBreak3(TestCase.STR3, TestCase.WORDDICT3);

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
        List<List<String>> result = new ArrayList<>();
        LinkedList<String> list = new LinkedList<>();
        wordBreak(s, wordDict, result, list, 0);

        for(List<String> l : result) {
            list.add(String.join(" ", l));
        }
        return list;
    }

    public void wordBreak(String str, List<String> wordDict, List<List<String>> result, LinkedList<String> list, int index) {
        if(index > str.length() - 1) {
            result.add(new ArrayList<>(list));
            return;
        }

        int len = str.length();
        for(int i = index+1; i <= len; i ++) {
            String subStr = str.substring(index, i);
            if(!wordDict.contains(subStr)) {
                continue;
            }

            list.addLast(subStr);
            wordBreak(str, wordDict, result, list, i);
            list.pollLast();
        }
    }


    /**
     * 解法二：
     * 优化
     * @param s
     * @param wordDict
     * @return
     */
    public List<String> wordBreak2(String s, List<String> wordDict) {
        Map<Integer, List<List<String>>> map = new HashMap<Integer, List<List<String>>>();
        List<List<String>> wordBreaks = wordBreak2(s, s.length(), new HashSet<String>(wordDict), 0, map);
        List<String> breakList = new LinkedList<String>();
        for (List<String> wordBreak : wordBreaks) {
            breakList.add(String.join(" ", wordBreak));
        }
        return breakList;
    }

    public List<List<String>> wordBreak2(String s, int length, Set<String> wordSet, int index, Map<Integer, List<List<String>>> map) {
        if(map.containsKey(index)) {
            return map.get(index);
        }

        List<List<String>> wordBreaks = new LinkedList<List<String>>();
        if (index == length) {
            wordBreaks.add(new LinkedList<String>());
        }

        for (int i = index + 1; i <= length; i++) {
            String word = s.substring(index, i);
            if (wordSet.contains(word)) {
                List<List<String>> nextWordBreaks = wordBreak2(s, length, wordSet, i, map);
                for (List<String> nextWordBreak : nextWordBreaks) {
                    LinkedList<String> wordBreak = new LinkedList<String>(nextWordBreak);
                    wordBreak.offerFirst(word);
                    wordBreaks.add(wordBreak);
                }
            }
        }

        map.put(index, wordBreaks);
        return map.get(index);
    }

    /**
     * 解法三：
     * 优化
     * @param s
     * @param wordDict
     * @return
     */
    public List<String> wordBreak3(String s, List<String> wordDict) {
        Map<Integer, List<List<String>>> map = new HashMap<Integer, List<List<String>>>();
        List<List<String>> wordBreaks = wordBreak3(s, wordDict, map, 0);
        List<String> breakList = new LinkedList<String>();
        for (List<String> wordBreak : wordBreaks) {
            breakList.add(String.join(" ", wordBreak));
        }
        return breakList;
    }

    public List<List<String>> wordBreak3(String s, List<String> wordDict, Map<Integer, List<List<String>>> map, int index) {
        if(map.containsKey(index)) {
            return map.get(index);
        }

        List<List<String>> wordBreaks = new LinkedList<>();
        if(index > s.length() - 1) {
            wordBreaks.add(new ArrayList<>());
        }

        for(int i = index + 1; i <= s.length(); i ++) {
            String word = s.substring(index, i);
            if(!wordDict.contains(word)) {
                continue;
            }

            List<List<String>> breakWord = wordBreak3(s, wordDict, map, i);

            for(List<String> nextWord : breakWord) {
                LinkedList<String> linkedList = new LinkedList<>(nextWord);
                linkedList.addFirst(word);
                wordBreaks.add(linkedList);
            }
        }

        map.put(index, wordBreaks);
        return map.get(index);
    }

    static class TestCase {
        public static String STR = "catsanddog";
        public static List<String> WORDDICT = Arrays.asList(new String[]{"cat", "cats", "and", "sand", "dog"});

        public static String STR1 = "pineapplepenapple";
        public static List<String> WORDDICT1 = Arrays.asList(new String[]{"apple", "pen", "applepen", "pine", "pineapple"});

        public static String STR2 = "catsandog";
        public static List<String> WORDDICT2 = Arrays.asList(new String[]{"cats", "dog", "sand", "and", "cat"});

        public static String STR3 = "aaaaaaa";
        public static List<String> WORDDICT3 = Arrays.asList(new String[]{"aaaa","aa","a"});

    }
}
