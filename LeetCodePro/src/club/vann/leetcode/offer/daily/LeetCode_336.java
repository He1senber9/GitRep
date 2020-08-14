package club.vann.leetcode.offer.daily;

import com.sun.tools.corba.se.idl.InterfaceGen;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>难度：Hard</p>
 * <p>题目：回文对</p>
 * <p>描述：给定一组唯一的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。
 *
 * 示例 1:
 *
 * 输入: ["abcd","dcba","lls","s","sssll"]
 * 输出: [[0,1],[1,0],[3,2],[2,4]]
 * 解释: 可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
 * 示例 2:
 *
 * 输入: ["bat","tab","cat"]
 * 输出: [[0,1],[1,0]]
 * 解释: 可拼接成的回文串为 ["battab","tabbat"]
 * 通过次数6,096提交次数16,867
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-08-06 09:24
 **/
public class LeetCode_336 {
    public static void main(String[] args) {
        LeetCode_336 leetCode = new LeetCode_336();

        List<List<Integer>> res = null;
        res = leetCode.palindromePairs(TestCase.WORDS);
        res = leetCode.palindromePairs(TestCase.WORDS1);

    }

    /**
     * 解法一：
     *
     * 算法超时。
     * @param words
     * @return
     */
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> rest = new ArrayList<>();
        if(words == null || words.length < 2) {
            return rest;
        }

        int len = words.length;
        for(int i = 0; i < len; i ++) {
            for(int j = 0; j < len; j ++) {
                if(i==j) {
                    continue;
                }
                if(isOK(words[i], words[j])) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    rest.add(list);
                }
            }
        }
        return rest;
    }

    /**
     * 判断两个字符串能否组成回文串
     * @param word1
     * @param word2
     * @return
     */
    private boolean isOK(String word1, String word2) {
        String tagStr = word1+word2;
        char[] ch = tagStr.toCharArray();
        int len = ch.length;
        int left = 0, right = len-1;
        while(left <= right) {
            if(ch[left] != ch[right]) {
                return false;
            }
            left ++;
            right --;
        }

        return true;
    }

    /**
     * 解法二：
     *
     * @param words
     * @return
     */
    public List<List<Integer>> palindromePairs1(String[] words) {
        return null;
    }

    static class TestCase {
        public static String[] WORDS = {"abcd","dcba","lls","s","sssll"};

        public static String[] WORDS1 = {"bat","tab","cat"};
    }
}
