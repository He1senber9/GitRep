package club.vann.leetcode.offer.daily;

import java.util.Arrays;
import java.util.List;

/**
 * <p>难度：Medium</p>
 * <p>题目：单词接龙</p>
 * <p>描述：给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 *
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 *
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出: 5
 *
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *      返回它的长度 5。
 * 示例 2:
 *
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * 输出: 0
 *
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 * 通过次数66,836提交次数151,450
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-ladder
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: LeetCodePro
 * @description:
 * @author: vann
 * @create: 2020-11-05 09:03
 **/
public class LeetCode_127 {
    public static void main(String[] args) {
        LeetCode_127 leetCode = new LeetCode_127();
    }

    /**
     * 解法一：
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) {
            return 0;
        }


        return 0;
    }

    static class TestCase {
        public static int ANS = 5;
        public static String[] PARAMS = {"hit", "cog"};
        public static List<String> LIST = Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"});

        public static int ANS1 = 5;
        public static String[] PARAMS1 = {"hit", "cog"};
        public static List<String> LIST1 = Arrays.asList(new String[]{"hot","dot","dog","lot","log"});
    }
}
