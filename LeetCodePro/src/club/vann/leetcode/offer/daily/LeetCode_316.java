package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Medium</p>
 * <p>题目：去除重复字母</p>
 * <p>描述：给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 *
 * 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "bcabc"
 * 输出："abc"
 * 示例 2：
 *
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 * 通过次数28,884提交次数65,667
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/12/20
 * Time: 8:43
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_316 {
    public static void main(String[] args) {
        LeetCode_316 leetCode = new LeetCode_316();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.removeDuplicateLetters(TestCase.STR));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.removeDuplicateLetters(TestCase.STR1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.removeDuplicateLetters(TestCase.STR2));
    }

    /**
     * 解法一：
     *
     * @param s
     * @return
     */
    public String removeDuplicateLetters(String s) {
        return "";
    }

    static class TestCase {
        public static String ANS = "abc";
        public static String STR = "bcabc";

        public static String ANS1 = "acdb";
        public static String STR1 = "cbacdcbc";

        public static String ANS2 = "";
        public static String STR2 = "";
    }
}
