package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Medium</p>
 * <p>题目：求 1+2+...n</p>
 * <p>描述：求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 * 示例 1：
 *
 * 输入: n = 3
 * 输出: 6
 * 示例 2：
 *
 * 输入: n = 9
 * 输出: 45
 *  
 *
 * 限制：
 *
 * 1 <= n <= 10000
 * 通过次数23,294提交次数27,405
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/qiu-12n-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-06-02 08:50
 **/
public class LeetCode_64 {
    public static void main(String[] args) {
        LeetCode_64 leetCode = new LeetCode_64();

        System.out.println("Result["+TestCase.ans+"] : " + leetCode.sumNums(TestCase.num));
        System.out.println("Result["+TestCase.ans1+"] : " + leetCode.sumNums(TestCase.num1));
    }

    private int sumNums(int n) {
        boolean flag = (n > 0) && ((n+=sumNums(n-1))  > 0);
        return n;
    }

    static class TestCase {
        public static final int ans = 6;
        public static final int num = 3;

        public static final int ans1 = 45;
        public static final int num1 = 9;
    }
}
