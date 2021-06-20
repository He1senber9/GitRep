package club.vann.leetcode.race.race20210620;

/**
 * <p>难度：Easy</p>
 * <p>题目：字符串中的最大奇数</p>
 * <p>描述：给你一个字符串 num ，表示一个大整数。请你在字符串 num 的所有 非空子字符串 中找出 值最大的奇数 ，并以字符串形式返回。如果不存在奇数，则返回一个空字符串 "" 。
 *
 * 子字符串 是字符串中的一个连续的字符序列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：num = "52"
 * 输出："5"
 * 解释：非空子字符串仅有 "5"、"2" 和 "52" 。"5" 是其中唯一的奇数。
 * 示例 2：
 *
 * 输入：num = "4206"
 * 输出：""
 * 解释：在 "4206" 中不存在奇数。
 * 示例 3：
 *
 * 输入：num = "35427"
 * 输出："35427"
 * 解释："35427" 本身就是一个奇数。
 *
 *
 * 提示：
 *
 * 1 <= num.length <= 105
 * num 仅由数字组成且不含前导零</p>
 * @description:
 * @program: GitRep
 * @author: fanyu
 * @create: 2021-06-20  10:55:01
 */
public class LeetCode_5788 {
    public static void main(String[] args) {
        LeetCode_5788 leetCode = new LeetCode_5788();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.largestOddNumber(TestCase.NUM));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.largestOddNumber(TestCase.NUM1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.largestOddNumber(TestCase.NUM2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.largestOddNumber(TestCase.NUM3));
    }

    /**
     * 解法一：
     *
     * @param num
     * @return
     */
    public String largestOddNumber(String num) {
        char[] ch = num.toCharArray();
        int len = ch.length;
        int index = len-1;
        while(index >= 0) {
            if(ch[index] % 2 == 0) {
                index --;
            } else {
                break;
            }
        }

        if(index < 0) {
            return "";
        }

        return num.substring(0, index+1);
    }

    static class TestCase {
        public static String ANS = "5";
        public static String NUM = "52";

        public static String ANS1 = "";
        public static String NUM1 = "4206";

        public static String ANS2 = "35427";
        public static String NUM2 = "35427";

        public static String ANS3 = "239537672423884969653287101";
        public static String NUM3 = "239537672423884969653287101";
    }
}
