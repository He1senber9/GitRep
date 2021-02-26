package club.vann.leetcode.offer.daily;

import java.util.*;

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
        result = leetCode.findNumOfValidWords1(TestCase.WORDS, TestCase.PUZZLES);
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

    /**
     * 解法二：
     *
     * @param words
     * @param puzzles
     * @return
     */
    public List<Integer> findNumOfValidWords1(String[] words, String[] puzzles) {
        List<Integer> result = new ArrayList<>();

        Map<Integer, Integer> wordMap = new HashMap<>();
        for(String word : words) {
            // 单词对应的二进制数
            int bit = getBit(word);
            // 谜语的第一个字符对应的二进制数，比如c就是100
            wordMap.put(bit, wordMap.getOrDefault(bit, 0) + 1);
        }

        for(int i = 0; i < puzzles.length; i ++) {
            String puzzle = puzzles[i];
            // 当前谜语的二进制数
            int bit = getBit(puzzle);
            int first = getBit(puzzle.charAt(0)+"");

            int n = bit;
            result.add(0);
            // 遍历puzzle的所有字母组合，当n=0时终止遍历
            while(n > 0) {
                // 按位都是1才为1，否则为0，即n这个组合包含puzzle的首字母
                // 而且n这个组合在map中有值，即有单词长n这样，值累加给res[i]
                if ((n & first) != 0 && wordMap.getOrDefault(n, 0) > 0) {

                    int val = result.get(i);
                    val += wordMap.getOrDefault(n, 0);
                    result.set(i, val);
                }
                // n-1 AND puzzleBit，生成一个puzzleBit的新的子集合
                n = (n - 1) & bit;
            }
        }
        return result;
    }

    private int getBit(String word) {
        int res = 0;
        char[] ch = word.toCharArray();
        int len = ch.length;
        for(char c : ch) {
            // a在最低位，求出当前字符的偏移位
            int offset = c - 'a';
            // 将二进制的1左移offset位，右边用0填充
            int status = 1 << offset;
            // 按位或，该位至少有一个1时，才为1（出现过），否则为0
            res = res | status;
        }
        return res;
    }

    static class TestCase {
        // [1,1,3,2,4,0]
        public static List<Integer> ANS = null;
        public static String[] WORDS = {"aaaa","asas","able","ability","actt","actor","access"};
        public static String[] PUZZLES = {"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"};
    }
}
