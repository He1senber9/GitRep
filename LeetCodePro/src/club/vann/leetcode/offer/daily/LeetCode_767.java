package club.vann.leetcode.offer.daily;

import sun.font.SunLayoutEngine;

/**
 * <p>难度：Medium</p>
 * <p>题目：重构字符串</p>
 * <p>描述：给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 *
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 *
 * 示例 1:
 *
 * 输入: S = "aab"
 * 输出: "aba"
 * 示例 2:
 *
 * 输入: S = "aaab"
 * 输出: ""
 * 注意:
 *
 * S 只包含小写字母并且长度在[1, 500]区间内。
 * 通过次数12,660提交次数28,906
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorganize-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: LeetCodePro
 * @description:
 * @author: vann
 * @create: 2020-11-30 08:32
 **/
public class LeetCode_767 {
    public static void main(String[] args) {
        LeetCode_767 leetCode = new LeetCode_767();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.reorganizeString(TestCase.STR));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.reorganizeString(TestCase.STR1));
    }

    /**
     * 解法一：
     *
     * @param S
     * @return
     */
    public String reorganizeString(String S) {
        if(S == null || S.length() == 0) {
            return S;
        }

        int len = S.length();
        char[] ch = S.toCharArray();
        
        return null;
    }

    static class TestCase {
        public static String ANS = "aba";
        public static String STR = "aab";

        public static String ANS1 = "";
        public static String STR1 = "aaab";
    }
}
