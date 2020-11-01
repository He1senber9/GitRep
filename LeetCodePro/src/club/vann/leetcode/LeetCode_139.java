package club.vann.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * <p>难度：Medium</p>
 * <p>题目：单词拆分</p>
 * <p>描述：给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
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
 * 通过次数97,513提交次数203,205
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/11/1
 * Time: 9:35
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_139 {
    public static void main(String[] args) {
        LeetCode_139 leetCode = new LeetCode_139();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.wordBreak(TestCase.STR, TestCase.wordDict));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.wordBreak(TestCase.STR1, TestCase.wordDict1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.wordBreak(TestCase.STR2, TestCase.wordDict2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.wordBreak(TestCase.STR3, TestCase.wordDict3));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        long begin = System.currentTimeMillis();
//        boolean result =  wordBreak(s, wordDict, 0);

        // 解法二
        int[] memory = new int[s.length()]; // 0：初始状态，1：true，2：false
        boolean result = wordBreak2(s, wordDict, 0, memory);
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - begin));

        return result;
    }

    /**
     * 解法一：
     * @param str
     * @param wordDict
     * @param index
     * @return
     */
    private boolean wordBreak(String str, List<String> wordDict, int index) {
        if(index > str.length() - 1) {
            return true;
        }

        for(String word : wordDict) {
            int i = str.indexOf(word, index);
            if(i == -1 || i != index) {
                continue;
            }

            boolean flag = wordBreak(str, wordDict, index+word.length());

            if(flag) {
                return true;
            }
        }

        return false;
    }

    /**
     * 解法二：
     * 优化
     * @param str
     * @param wordDict
     * @param index
     * @return
     */
    private boolean wordBreak2(String str, List<String> wordDict, int index, int[] memory) {
        if(index > str.length() - 1) {
            return true;
        }

        if(memory[index] != 0) {
            return memory[index] == 1 ? true : false;
        }

        int len = str.length();
        for(int i = index+1; i <= len; i ++) {
            String prefix = str.substring(index, i);
            if(wordDict.contains(prefix) && wordBreak2(str, wordDict, i, memory)) {
                memory[index] = 1;
                return true;
            }
        }
        memory[index] = 2;
        return false;
    }

    static class TestCase {
        public static boolean ANS = true;
        public static String STR = "leetcode";
        public static List<String> wordDict = Arrays.asList(new String[]{"leet", "code"});

        public static boolean ANS1 = true;
        public static String STR1 = "applepenapple";
        public static List<String> wordDict1 = Arrays.asList(new String[]{"apple", "pen"});

        public static boolean ANS2 = false;
        public static String STR2 = "catsandog";
        public static List<String> wordDict2 = Arrays.asList(new String[]{"cats", "dog", "sand", "and", "cat"});

        public static boolean ANS3 = false;
        public static String STR3 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        public static List<String> wordDict3 = Arrays.asList(new String[]{"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"});

    }
}
