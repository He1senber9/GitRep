package club.vann.leetcode.offer.daily;

import java.util.Stack;

/**
 * <p>难度：Medium</p>
 * <p>题目：单调递增的数字</p>
 * <p>描述：给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 *
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 *
 * 示例 1:
 *
 * 输入: N = 10
 * 输出: 9
 * 示例 2:
 *
 * 输入: N = 1234
 * 输出: 1234
 * 示例 3:
 *
 * 输入: N = 332
 * 输出: 299
 * 说明: N 是在 [0, 10^9] 范围内的一个整数。
 *
 * 通过次数8,179提交次数17,879
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/monotone-increasing-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/12/15
 * Time: 9:58
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_738 {
    public static void main(String[] args) {
        LeetCode_738 leetCode = new LeetCode_738();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.monotoneIncreasingDigits(TestCase.N));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.monotoneIncreasingDigits(TestCase.N1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.monotoneIncreasingDigits(TestCase.N2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.monotoneIncreasingDigits(TestCase.N3));
        System.out.println("Result["+TestCase.ANS4+"] : " + leetCode.monotoneIncreasingDigits(TestCase.N4));
        System.out.println("Result["+TestCase.ANS5+"] : " + leetCode.monotoneIncreasingDigits(TestCase.N5));
        System.out.println("Result["+TestCase.ANS6+"] : " + leetCode.monotoneIncreasingDigits(TestCase.N6));
    }

    /**
     * 解法一：
     * 存在如下规律：
     * 如果 s[i] > s[i+1] --> s[i]=s[i]-1，s[i+1]~s[len-1]=9;
     * 如果 s[i] <= s[i+1] --> 不变
     * @param N
     * @return
     */
    public int monotoneIncreasingDigits(int N) {
        if(N < 10) {
            return N;
        }

        // 使用栈
        Stack<Integer> stack = new Stack<>();
        int val = N % 10;
        stack.push(val);
        N = N / 10;

        while(N > 0) {
            val = N % 10;
            if(val > stack.peek()) {
                val = val - 1;
                int size = stack.size();
                stack.clear();
                for(int i = 0; i < size; i ++) {
                    stack.push(9);
                }
            }

            stack.push(val);
            N = N / 10;
        }

        int res = 0;
        int pow = 10;
        while(!stack.isEmpty()) {
            int v = stack.pop();
            if(v == 0) {
                continue;
            }

            res = res * pow + v;
        }

        return res;
    }

    static class TestCase {
        public static int ANS = 9;
        public static int N = 10;

        public static int ANS1 = 1234;
        public static int N1 = 1234;

        public static int ANS2 = 299;
        public static int N2 = 332;

        public static int ANS3 = 0;
        public static int N3 = 0;

        public static int ANS4 = 9;
        public static int N4 = 9;

        public static int ANS5 = 29;
        public static int N5 = 32;

        public static int ANS6 = 89;
        public static int N6 = 89;
    }
}
