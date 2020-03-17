package club.vann.leetcode.offer.daily;

import club.vann.leetcode.offer.LeetCode_6;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>难度：Easy</p>
 * <p>题目：单词拼写</p>
 * <p>描述：给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 *
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 *
 * 注意：每次拼写时，chars 中的每个字母都只能用一次。
 *
 * 返回词汇表 words 中你掌握的所有单词的 长度之和。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：words = ["cat","bt","hat","tree"], chars = "atach"
 * 输出：6
 * 解释：
 * 可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
 * 示例 2：
 *
 * 输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * 输出：10
 * 解释：
 * 可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
 *  
 *
 * 提示：
 *
 * 1 <= words.length <= 1000
 * 1 <= words[i].length, chars.length <= 100
 * 所有字符串中都仅包含小写英文字母
 * 通过次数12,364提交次数18,585
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/3/17
 * Time: 8:50
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_1160 {
    public static void main(String[] args) {
        String[] words = {};
        String chars = null;
        int result = 0;

        LeetCode_1160 leetCode = new LeetCode_1160();

        words = new String[]{"cat","bt","hat","tree"};
        chars = "atach";
        result = leetCode.countCharacters(words, chars);
        System.out.println("Result[6] :" + result);

        words = new String[]{"hello","world","leetcode"};
        chars = "welldonehoneyr";
        result = leetCode.countCharacters(words, chars);
        System.out.println("Result[10] :" + result);

    }

    /**
     * 解法一：
     * 1.由于 chars 中每个字母只能使用一次，表明如果 words 中字符串 str[n] 长度大于 chars 时，是不满足条件的。
     * 2.
     * @param words
     * @param chars
     * @return
     */
    private int countCharacters(String[] words, String chars) {
        if(words == null || words.length == 0 || chars == null || chars.length() == 0) {
            return 0;
        }

        int lenWords = words.length;
        int lenChars = chars.length();
        int count = 0;

        char[] ch = chars.toCharArray();

        for(int n = 0; n < lenWords; n ++) {
            String str = words[n];
            if(str.length() > lenChars) {
                return 0;
            }

            if(isContains(str, chars)) {
                count += str.length();
            }

        }

        return count;
    }

    /**
     * 用于判断指定字符串是否能组成目标字符串。
     * @param str 目标字符串
     * @param tag 指定字符串
     * @return
     */
    private boolean isContains(String str, String tag) {
        int lenStr = str.length();
        int lenTag = tag.length();

        char[] tagChar = tag.toCharArray();
        char[] strChar = str.toCharArray();

        boolean flag = true;

        outer: for(int n = 0; n < lenStr; n ++) {
            inter: for(int m = 0; m < lenTag; m ++) {
                if(strChar[n] == tagChar[m]) {
                    tagChar[m] = 0;
                    continue outer;
                }
                if(m == lenTag-1) {
                    flag =  false;
                    break;
                }
            }
        }

        return flag;
    }
}
