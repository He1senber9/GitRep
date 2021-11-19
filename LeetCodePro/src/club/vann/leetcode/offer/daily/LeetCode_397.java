package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Medium</p>
 * <p>题目：整数替换</p>
 * <p>描述：给定一个正整数 n ，你可以做如下操作：
 *
 * 如果 n 是偶数，则用 n / 2替换 n 。
 * 如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。
 * n 变为 1 所需的最小替换次数是多少？
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 8
 * 输出：3
 * 解释：8 -> 4 -> 2 -> 1
 * 示例 2：
 *
 * 输入：n = 7
 * 输出：4
 * 解释：7 -> 8 -> 4 -> 2 -> 1
 * 或 7 -> 6 -> 3 -> 2 -> 1
 * 示例 3：
 *
 * 输入：n = 4
 * 输出：2
 *  
 *
 * 提示：
 *
 * 1 <= n <= 231 - 1
 * 通过次数41,145提交次数97,083
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-replacement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: GitRep
 * @description:
 * @author: fanyu
 * @create: 2021/11/19 21:10
 */
public class LeetCode_397 {
    public static void main(String[] args) {
        LeetCode_397 leetCode = new LeetCode_397();
        System.out.println("Result["+TestCase.ANS+"]: " + leetCode.integerReplacement(TestCase.N));
        System.out.println("Result["+TestCase.ANS1+"]: " + leetCode.integerReplacement(TestCase.N1));
        System.out.println("Result["+TestCase.ANS2+"]: " + leetCode.integerReplacement(TestCase.N2));
        System.out.println("Result["+TestCase.ANS3+"]: " + leetCode.integerReplacement(TestCase.N3));
        System.out.println("Result["+TestCase.ANS4+"]: " + leetCode.integerReplacement(TestCase.N4));
    }

    /**
     * 解法一：
     *
     * @param n
     * @return
     */
    public int integerReplacement(int n) {
        int[] dp = new int[n+2];
        dp[0] = 0;
        dp[1] = 0;

        for(int i = 2; i <= n; i ++) {
            if(i%2==0) {
                dp[i] = dp[i/2] + 1;
            } else {
                dp[i] = Math.min(dp[(i+1)/2]+2, dp[i-1]+1);
            }
        }
        return dp[n];
    }

    /**
     * 解法二：
     *
     * @param n
     * @return
     */
    public int integerReplacement1(int n) {
        if(n == 1) {
            return 0;
        }

        if(n % 2 == 0) {
            return 1 + integerReplacement(n/2);
        }

        return 2 + Math.min(integerReplacement(n/2), integerReplacement(n/2+1));
    }

    static class TestCase {
        public static int ANS = 0;
        public static int N = 1;

        public static int ANS1 = 3;
        public static int N1 = 8;

        public static int ANS2 = 4;
        public static int N2 = 7;

        public static int ANS3 = 2;
        public static int N3 = 4;

        public static int ANS4 = 1;
        public static int N4 = 2;
    }
}
