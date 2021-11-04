package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Easy</p>
 * <p>题目：有效的完全平方数</p>
 * <p>描述：给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 *
 * 进阶：不要 使用任何内置的库函数，如  sqrt 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：num = 16
 * 输出：true
 * 示例 2：
 *
 * 输入：num = 14
 * 输出：false
 *  
 *
 * 提示：
 *
 * 1 <= num <= 2^31 - 1
 * 通过次数111,565提交次数249,812
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-perfect-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: GitRep
 * @description:
 * @author: fanyu
 * @create: 2021/11/04 22:08
 */
public class LeetCode_367 {
    public static void main(String[] args) {
        LeetCode_367 leetCode = new LeetCode_367();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.isPerfectSquare(TestCase.NUM));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.isPerfectSquare(TestCase.NUM1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.isPerfectSquare(TestCase.NUM2));
    }

    /**
     * 解法一：
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        int tag = (int) Math.sqrt(num);
        return tag * tag == num;
    }

    /**
     * 解法二：
     * @param num
     * @return
     */
    public boolean isPerfectSquare1(int num) {
        return false;
    }

    static class TestCase {
        public static boolean ANS = true;
        public static int NUM = 16;

        public static boolean ANS1 = true;
        public static int NUM1 = 14;

        public static boolean ANS2 = false;
        public static int NUM2 = Integer.MAX_VALUE;
    }
}
