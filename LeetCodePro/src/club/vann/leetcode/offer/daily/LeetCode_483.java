package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Hard</p>
 * <p>题目：最小好进制</p>
 * <p>描述：对于给定的整数 n, 如果n的k（k>=2）进制数的所有数位全为1，则称 k（k>=2）是 n 的一个好进制。
 *
 * 以字符串的形式给出 n, 以字符串的形式返回 n 的最小好进制。
 *
 *  
 *
 * 示例 1：
 *
 * 输入："13"
 * 输出："3"
 * 解释：13 的 3 进制是 111。
 * 示例 2：
 *
 * 输入："4681"
 * 输出："8"
 * 解释：4681 的 8 进制是 11111。
 * 示例 3：
 *
 * 输入："1000000000000000000"
 * 输出："999999999999999999"
 * 解释：1000000000000000000 的 999999999999999999 进制是 11。
 *  
 *
 * 提示：
 *
 * n的取值范围是 [3, 10^18]。
 * 输入总是有效且没有前导 0。
 *  
 *
 * 通过次数2,927提交次数6,087
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-good-base
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @description:
 * @program: GitRep
 * @author: fanyu
 * @create: 2021-06-18  08:07:58
 */
public class LeetCode_483 {
    public static void main(String[] args) {
        LeetCode_483 leetCode = new LeetCode_483();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.smallestGoodBase(TestCase.N));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.smallestGoodBase(TestCase.N1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.smallestGoodBase(TestCase.N2));
    }

    /**
     * 解法一：
     *
     * @param n
     * @return
     */
    public String smallestGoodBase(String n) {
        long nVal = Long.parseLong(n);
        int mMax = (int) Math.floor(Math.log(nVal) / Math.log(2));
        for (int m = mMax; m > 1; m--) {
            int k = (int) Math.pow(nVal, 1.0 / m);
            long mul = 1, sum = 1;
            for (int i = 0; i < m; i++) {
                mul *= k;
                sum += mul;
            }
            if (sum == nVal) {
                return Integer.toString(k);
            }
        }
        return Long.toString(nVal - 1);
    }

    static class TestCase {
        public static String ANS = "3";
        public static String N = "13";

        public static String ANS1 = "8";
        public static String N1 = "4681";

        public static String ANS2 = "999999999999999999";
        public static String N2 = "1000000000000000000";
    }
}
