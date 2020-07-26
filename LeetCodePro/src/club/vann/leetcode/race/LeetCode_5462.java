package club.vann.leetcode.race;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <p>难度：Hard</p>
 * <p>题目：压缩字符串 II</p>
 * <p>描述：行程长度编码 是一种常用的字符串压缩方法，它将连续的相同字符（重复 2 次或更多次）替换为字符和表示字符计数的数字（行程长度）。例如，用此方法压缩字符串 "aabccc" ，将 "aa" 替换为 "a2" ，"ccc" 替换为` "c3" 。因此压缩后的字符串变为 "a2bc3" 。
 *
 * 注意，本问题中，压缩时没有在单个字符后附加计数 '1' 。
 *
 * 给你一个字符串 s 和一个整数 k 。你需要从字符串 s 中删除最多 k 个字符，以使 s 的行程长度编码长度最小。
 *
 * 请你返回删除最多 k 个字符后，s 行程长度编码的最小长度 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "aaabcccd", k = 2
 * 输出：4
 * 解释：在不删除任何内容的情况下，压缩后的字符串是 "a3bc3d" ，长度为 6 。最优的方案是删除 'b' 和 'd'，这样一来，压缩后的字符串为 "a3c3" ，长度是 4 。
 * 示例 2：
 *
 * 输入：s = "aabbaa", k = 2
 * 输出：2
 * 解释：如果删去两个 'b' 字符，那么压缩后的字符串是长度为 2 的 "a4" 。
 * 示例 3：
 *
 * 输入：s = "aaaaaaaaaaa", k = 0
 * 输出：3
 * 解释：由于 k 等于 0 ，不能删去任何字符。压缩后的字符串是 "a11" ，长度为 3 。
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 100
 * 0 <= k <= s.length
 * s 仅包含小写英文字母</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/7/26
 * Time: 11:22
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_5462 {
    public static void main(String[] args) {
        LeetCode_5462 leetCode = new LeetCode_5462();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.getLengthOfOptimalCompression(TestCase.STR, TestCase.K));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.getLengthOfOptimalCompression(TestCase.STR1, TestCase.K1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.getLengthOfOptimalCompression(TestCase.STR2, TestCase.K2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.getLengthOfOptimalCompression(TestCase.STR3, TestCase.K3));
        System.out.println("Result["+TestCase.ANS4+"] : " + leetCode.getLengthOfOptimalCompression(TestCase.STR4, TestCase.K4));
        System.out.println("Result["+TestCase.ANS5+"] : " + leetCode.getLengthOfOptimalCompression(TestCase.STR5, TestCase.K5));
    }

    /**
     * 解法一：
     *
     * @param s
     * @param k
     * @return
     */
    public int getLengthOfOptimalCompression(String s, int k) {
        int len = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < len; i ++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        StringBuilder builder = new StringBuilder();
        int size = 0;
        for(Character c : map.keySet()) {
            int val = map.get(c);
            if(k <= 0) {
                size += val;
            } else {
                if(k <= val) {
                    size += val - k;
                    k = 0;
                } else {
                    k = k - val;
                }
            }
        }
        return size;
    }

    static class TestCase {
        public static int ANS = 4;
        public static String STR = "aaabcccd";
        public static int K = 2;

        public static int ANS1 = 2;
        public static String STR1 = "aabbaa";
        public static int K1 = 2;

        public static int ANS2 = 3;
        public static String STR2 = "aaaaaaaaaaa";
        public static int K2 = 0;

        public static int ANS3 = 3;
        public static String STR3 = "aaaaaaabaaaa";
        public static int K3 = 1;

        public static int ANS4 = 2;
        public static String STR4 = "aaaaaaabaaaa";
        public static int K4 = 2;

        public static int ANS5 = 4;
        public static String STR5 = "aabaabbcbbbaccc";
        public static int K5 = 6;

    }
}
