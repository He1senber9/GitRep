package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Hard</p>
 * <p>题目：停在原地的方案数</p>
 * <p>描述：有一个长度为 arrLen 的数组，开始有一个指针在索引 0 处。
 *
 * 每一步操作中，你可以将指针向左或向右移动 1 步，或者停在原地（指针不能被移动到数组范围外）。
 *
 * 给你两个整数 steps 和 arrLen ，请你计算并返回：在恰好执行 steps 次操作以后，指针仍然指向索引 0 处的方案数。
 *
 * 由于答案可能会很大，请返回方案数 模 10^9 + 7 后的结果。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：steps = 3, arrLen = 2
 * 输出：4
 * 解释：3 步后，总共有 4 种不同的方法可以停在索引 0 处。
 * 向右，向左，不动
 * 不动，向右，向左
 * 向右，不动，向左
 * 不动，不动，不动
 * 示例  2：
 *
 * 输入：steps = 2, arrLen = 4
 * 输出：2
 * 解释：2 步后，总共有 2 种不同的方法可以停在索引 0 处。
 * 向右，向左
 * 不动，不动
 * 示例 3：
 *
 * 输入：steps = 4, arrLen = 2
 * 输出：8
 *  
 *
 * 提示：
 *
 * 1 <= steps <= 500
 * 1 <= arrLen <= 10^6
 * 通过次数4,503提交次数10,147
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @ClassName LeetCode_1269
 * @Description TODO
 * @User fanyu
 * @Date 2021/5/13 8:10
 */
public class LeetCode_1269 {
    public static void main(String[] args) {
        LeetCode_1269 leetCode = new LeetCode_1269();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.numWays1(TestCase.STEP, TestCase.ARRLEN));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.numWays1(TestCase.STEP1, TestCase.ARRLEN1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.numWays1(TestCase.STEP2, TestCase.ARRLEN2));
    }

    /**
     * 解法一：
     *
     * @param steps
     * @param arrLen
     * @return
     */
    public int numWays(int steps, int arrLen) {
        final int MODULO = 1000000007;
        int len = Math.min(steps, arrLen-1);
        int[][] dp = new int[steps+1][len+1];
        dp[0][0] = 1;

        // dp[i][j] = dp[i-1][j-1] + dp[i-1][j] + dp[i-1][j+1]
        for (int i = 1; i <= steps; i ++) {
            for (int j = 0; j <= len; j ++) {
                dp[i][j] = dp[i-1][j];

                if(j - 1 >= 0) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % MODULO;
                }

                if(j + 1 <= len) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % MODULO;
                }
            }
        }
        return dp[steps][0];
    }

    /**
     * 解法二：
     *
     * @param steps
     * @param arrLen
     * @return
     */
    public int numWays1(int steps, int arrLen) {
        final int MODULO = 1000000007;
        int len = Math.min(steps, arrLen-1);
        int[] dp = new int[len+1];
        dp[0] = 1;

        for(int i = 1; i <= steps; i ++) {
            int left = 0, mid = 0;
            for(int j = 0; j <= len; j ++) {
                mid = dp[j];

                if(j-1 >= 0) {
                    dp[j] = (left + mid) % MODULO;
                }

                if(j+1 <= len) {
                    dp[j] = (dp[j+1] + dp[j]) % MODULO;
                }

                left = mid;
            }
        }
        return dp[0];
    }

    static class TestCase {
        public static int ANS = 4;
        public static int STEP = 3;
        public static int ARRLEN = 2;

        public static int ANS1 = 2;
        public static int STEP1 = 2;
        public static int ARRLEN1 = 4;

        public static int ANS2 = 8;
        public static int STEP2 = 4;
        public static int ARRLEN2 = 2;
    }
}
