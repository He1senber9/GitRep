package club.vann.leetcode.race;

/**
 * <p>难度：Medium</p>
 * <p>题目：十-二进制数的最少数目</p>
 * <p>描述：如果一个十进制数字不含任何前导零，且每一位上的数字不是 0 就是 1 ，那么该数字就是一个 十-二进制数 。例如，101 和 1100 都是 十-二进制数，而 112 和 3001 不是。
 *
 * 给你一个表示十进制整数的字符串 n ，返回和为 n 的 十-二进制数 的最少数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = "32"
 * 输出：3
 * 解释：10 + 11 + 11 = 32
 * 示例 2：
 *
 * 输入：n = "82734"
 * 输出：8
 * 示例 3：
 *
 * 输入：n = "27346209830709182346"
 * 输出：9
 *
 *
 * 提示：
 *
 * 1 <= n.length <= 105
 * n 仅由数字组成
 * n 不含任何前导零并总是表示正整数</p>
 * @program: LeetCodePro
 * @description:
 * @author: vann
 * @create: 2020-12-13 11:11
 **/
public class LeetCode_5626 {
    public static void main(String[] args) {
        LeetCode_5626 leetCode = new LeetCode_5626();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.minPartitions(TestCase.STR));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.minPartitions(TestCase.STR1));
    }

    /**
     * 解法一：
     * @param n
     * @return
     */
    public int minPartitions(String n) {
        return 0;
    }

    static class TestCase {
        public static int ANS = 3;
        public static String STR = "32";

        public static int ANS1 = 8;
        public static String STR1 = "82734";

        public static int ANS2 = 9;
        public static String STR2 = "27346209830709182346";
    }
}
