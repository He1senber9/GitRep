package club.vann.leetcode.offer;

/**
 * <p>难度：Medium</p>
 * <p>题目：数值的整数次方</p>
 * <p>描述：实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 *  
 *
 * 说明:
 *
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 * 注意：本题与主站 50 题相同：https://leetcode-cn.com/problems/powx-n/
 *
 * 通过次数28,028提交次数85,522
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/7/22
 * Time: 20:56
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_16 {
    public static void main(String[] args) {
        LeetCode_16 leetCode = new LeetCode_16();

        System.out.println("Result["+TestCase.ANS+"] :" + leetCode.myPow1(TestCase.X, TestCase.N));
        System.out.println("Result["+TestCase.ANS1+"] :" + leetCode.myPow1(TestCase.X1, TestCase.N1));
        System.out.println("Result["+TestCase.ANS2+"] :" + leetCode.myPow1(TestCase.X2, TestCase.N2));
    }

    /**
     * 解法一：
     *
     * @param x
     * @param n
     * @return
     */
    private double myPow(double x, int n) {
        double res = 1;
        if(n < 0) {
            n = -1*n;
            x = 1/x;
        }

        for(int i = 0; i < n; i ++) {
            res *= x;
        }
        return res;
    }

    /**
     * 解法二
     *
     * @param x
     * @param n
     * @return
     */
    private double myPow1(double x, int n) {
        double res = 1.0;
        long b = n;
        if(b < 0) {
            x = 1/x;
            b = -1*b;
        }

        while(b > 0) {
            if((b&1) == 1) {
                res *= x;
            }

            x *= x;
            b = b >> 1;
        }
        return res;
    }

    static class TestCase {
        public static double ANS = 1024.00000;
        public static int N = 10;
        public static double X = 2.00000;

        public static double ANS1 = 9.26100;
        public static int N1 = 3;
        public static double X1 = 2.10000;

        public static double ANS2 = 0.25000;
        public static int N2 = -2;
        public static double X2 = 2.00000;
    }
}
