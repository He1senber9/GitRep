package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Medium</p>
 * <p>题目：回文子串</p>
 * <p>描述：给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入："abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 示例 2：
 *
 * 输入："aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 *  
 *
 * 提示：
 *
 * 输入的字符串长度不会超过 1000 。
 * 通过次数38,933提交次数61,783
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindromic-substrings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-08-19 09:07
 **/
public class LeetCode_647 {
    public static void main(String[] args) {
        LeetCode_647 leetCode = new LeetCode_647();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.countSubstrings(TestCase.STR));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.countSubstrings(TestCase.STR1));
    }

    /**
     * 解法一：
     *
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        if(s == null || s.length() <= 1) {
            return 1;
        }

        char[] ch = s.toCharArray();
        int res = 0;
        int len = ch.length;

        res += len;
        for(int size = 2; size <= len; size ++) {
            for(int i = 0; i <= (len - size); i ++) {
                if(isValid(ch, i, i+size-1)) {
                    res += 1;
                }
            }
        }

        return res;
    }

    private boolean isValid(char[] ch, int left, int right) {
        while(left < right && ch[left] == ch[right]) {
            left ++;
            right --;
        }

        return left >= right;
    }

    static class TestCase {
        public static int ANS = 3;
        public static String STR = "abc";

        public static int ANS1 = 6;
        public static String STR1 = "aaa";
    }
}
