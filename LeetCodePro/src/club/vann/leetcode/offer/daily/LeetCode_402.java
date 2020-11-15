package club.vann.leetcode.offer.daily;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

/**
 * <p>难度：Easy</p>
 * <p>题目：移除掉K位数字</p>
 * <p>描述：给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 *
 * 注意:
 *
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * 示例 1 :
 *
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * 示例 2 :
 *
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 :
 *
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 * 通过次数31,000提交次数101,880
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-k-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: LeetCodePro
 * @description:
 * @author: vann
 * @create: 2020-11-15 08:50
 **/
public class LeetCode_402 {
    public static void main(String[] args) {
        LeetCode_402 leetCode = new LeetCode_402();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.removeKdigits(TestCase.STR, TestCase.K));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.removeKdigits(TestCase.STR1, TestCase.K1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.removeKdigits(TestCase.STR2, TestCase.K2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.removeKdigits(TestCase.STR3, TestCase.K3));
    }

    /**
     * 解法一：
     * 回溯算法
     * @param num
     * @param k
     * @return
     */
    public String removeKdigits(String num, int k) {
        return null;
    }

    static class TestCase {
        public static String ANS = "1219";
        public static String STR = "1432219";
        public static int K = 3;

        public static String ANS1 = "200";
        public static String STR1 = "10200";
        public static int K1 = 1;

        public static String ANS2 = "0";
        public static String STR2 = "10";
        public static int K2 = 2;

        public static String ANS3 = "1219";
        public static String STR3 = "1432219";
        public static int K3 = 3;
    }
}
