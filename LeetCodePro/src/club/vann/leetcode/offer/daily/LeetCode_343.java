package club.vann.leetcode.offer.daily;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

/**
 * <p>难度：Medium</p>
 * <p>题目：整数拆分</p>
 * <p>描述：给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 *
 * 通过次数35,272提交次数61,999
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-07-30 09:14
 **/
public class LeetCode_343 {
    public static void main(String[] args) {
        LeetCode_343  leetCode = new LeetCode_343();

        System.out.println("Result["+TestCase.ANS+"] :" + leetCode.integerBreak(TestCase.N));
        System.out.println("Result["+TestCase.ANS1+"] :" + leetCode.integerBreak(TestCase.N1));
        System.out.println("Result["+TestCase.ANS2+"] :" + leetCode.integerBreak(TestCase.N2));
        System.out.println("Result["+TestCase.ANS3+"] :" + leetCode.integerBreak(TestCase.N3));
    }

    /**
     * 解法一：
     *
     * @param n
     * @return
     */
    private int integerBreak(int n) {
        int res = 1;
        if(n < 4) {
            res = n-1;
            return res;
        }

        while(n > 4) {
            res *= 3;
            n = n-3;
        }

        res = res * n;
        return res;
    }

    static class TestCase {
        public static int ANS = 1;
        public static int N = 2;

        public static int ANS1 = 2;
        public static int N1 = 3;

        public static int ANS2 = 36;
        public static int N2 = 10;

        public static int ANS3 = 18;
        public static int N3 = 8;

        public static int ANS4 = 27;
        public static int N4 = 9;
    }
}
