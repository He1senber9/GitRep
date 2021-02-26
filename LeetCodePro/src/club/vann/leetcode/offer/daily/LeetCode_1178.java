package club.vann.leetcode.offer.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>难度：Hard</p>
 * <p>题目：猜字谜</p>
 * <p>描述：外国友人仿照中国字谜设计了一个英文版猜字谜小游戏，请你来猜猜看吧。
 *
 * 字谜的迷面 puzzle 按字符串形式给出，如果一个单词 word 符合下面两个条件，那么它就可以算作谜底：
 *
 * 单词 word 中包含谜面 puzzle 的第一个字母。
 * 单词 word 中的每一个字母都可以在谜面 puzzle 中找到。
 * 例如，如果字谜的谜面是 "abcdefg"，那么可以作为谜底的单词有 "faced", "cabbage", 和 "baggage"；而 "beefed"（不含字母 "a"）以及 "based"（其中的 "s" 没有出现在谜面中）。
 * 返回一个答案数组 answer，数组中的每个元素 answer[i] 是在给出的单词列表 words 中可以作为字谜迷面 puzzles[i] 所对应的谜底的单词数目。
 *
 *  
 *
 * 示例：
 *
 * 输入：
 * words = ["aaaa","asas","able","ability","actt","actor","access"],
 * puzzles = ["aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"]
 * 输出：[1,1,3,2,4,0]
 * 解释：
 * 1 个单词可以作为 "aboveyz" 的谜底 : "aaaa"
 * 1 个单词可以作为 "abrodyz" 的谜底 : "aaaa"
 * 3 个单词可以作为 "abslute" 的谜底 : "aaaa", "asas", "able"
 * 2 个单词可以作为 "absoryz" 的谜底 : "aaaa", "asas"
 * 4 个单词可以作为 "actresz" 的谜底 : "aaaa", "asas", "actt", "access"
 * 没有单词可以作为 "gaswxyz" 的谜底，因为列表中的单词都不含字母 'g'。
 *  
 *
 * 提示：
 *
 * 1 <= words.length <= 10^5
 * 4 <= words[i].length <= 50
 * 1 <= puzzles.length <= 10^4
 * puzzles[i].length == 7
 * words[i][j], puzzles[i][j] 都是小写英文字母。
 * 每个 puzzles[i] 所包含的字符都不重复。
 * 通过次数2,798提交次数7,898
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-valid-words-for-each-puzzle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @author vann
 * @program GitRep
 * @description
 * @date 2021-02-26:08:01:32
 */
public class LeetCode_1178 {
    public static void main(String[] args) {
        LeetCode_1178 leetCode = new LeetCode_1178();

        List<Integer> result = null;
        result = leetCode.findNumOfValidWords(TestCase.WORDS, TestCase.PUZZLES);
        System.out.println("Success");
    }

    /**
     * 解法一：
     * 暴力破解
     * @param words
     * @param puzzles
     * @return
     */
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        int len_words = words.length;
        int len_puzzles = puzzles.length;

        List<Integer> result = new ArrayList<>();
        for(String puzzle : puzzles) {
            int count = countForString(puzzle, words);
            result.add(count);
        }
        return result;
    }

    /**
     * 判断word是否是谜面puzzle的谜底。
     * @param puzzle
     * @param words
     * @return
     */
    private int countForString(String puzzle, String[] words) {
        int count = 0;
        int[] tags = new int[26];
        char[] chPuzzle = puzzle.toCharArray();
        for(int i = 0; i < chPuzzle.length; i ++) {
            char c = chPuzzle[i];
            tags[c-'a'] ++;
        }

        A:for(String word : words) {
            char[] chWord = word.toCharArray();

            // 先判断是否包含谜面首字母
            char first = chPuzzle[0];
            if(!word.contains(first+"")) {
                continue;
            }

            // 再判断字符都出现在谜面中
            for(int i = 0; i < chWord.length; i ++) {
                if(!puzzle.contains(chWord[i]+"")) {
                    continue A;
                }
            }
            count ++;
        }
        return count;
    }

    static class TestCase {
        // [1,1,3,2,4,0]
        public static List<Integer> ANS = null;
        public static String[] WORDS = {"aaaa","asas","able","ability","actt","actor","access"};
        public static String[] PUZZLES = {"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"};
    }
}
