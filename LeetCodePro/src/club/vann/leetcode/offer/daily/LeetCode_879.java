package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Hard</p>
 * <p>题目：盈利计划</p>
 * <p>集团里有 n 名员工，他们可以完成各种各样的工作创造利润。
 *
 * 第 i 种工作会产生 profit[i] 的利润，它要求 group[i] 名成员共同参与。如果成员参与了其中一项工作，就不能参与另一项工作。
 *
 * 工作的任何至少产生 minProfit 利润的子集称为 盈利计划 。并且工作的成员总数最多为 n 。
 *
 * 有多少种计划可以选择？因为答案很大，所以 返回结果模 10^9 + 7 的值。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 5, minProfit = 3, group = [2,2], profit = [2,3]
 * 输出：2
 * 解释：至少产生 3 的利润，该集团可以完成工作 0 和工作 1 ，或仅完成工作 1 。
 * 总的来说，有两种计划。
 * 示例 2：
 *
 * 输入：n = 10, minProfit = 5, group = [2,3,5], profit = [6,7,8]
 * 输出：7
 * 解释：至少产生 5 的利润，只要完成其中一种工作就行，所以该集团可以完成任何工作。
 * 有 7 种可能的计划：(0)，(1)，(2)，(0,1)，(0,2)，(1,2)，以及 (0,1,2) 。
 *  
 *
 * 提示：
 *
 * 1 <= n <= 100
 * 0 <= minProfit <= 100
 * 1 <= group.length <= 100
 * 1 <= group[i] <= 100
 * profit.length == group.length
 * 0 <= profit[i] <= 100
 * 通过次数3,967提交次数9,254
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/profitable-schemes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @description:
 * @program: GitRep
 * @author: fanyu
 * @create: 2021-06-09  07:30:12
 */
public class LeetCode_879 {
    public static void main(String[] args) {
        LeetCode_879 leetCode = new LeetCode_879();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.profitableSchemes(TestCase.N, TestCase.MINPROFIT, TestCase.GROUP, TestCase.PROFIT));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.profitableSchemes(TestCase.N1, TestCase.MINPROFIT1, TestCase.GROUP1, TestCase.PROFIT1));
    }

    /**
     * 解法一：
     * 定义dp[i][j][k] 表示在前 i 个工作中，选择了 j 个员工，并且满足工作利润至少为 k 的情况下盈利计划的总数目。
     * 1.dp[0][0][0] = 1; // 盈利为0时只有一种方案。
     * 2.dp[i][j][k] = dp[i-1][j][k]; // 当人数上限为 j 时，无法接受第 i 件工作。
     * 3.dp[i][j][k] = dp[i-1][j][k] + dp[i-1][j-group[i]][max(0,k-profit[i])]; // 当可以接收第 i 件工作时，
     * @param n
     * @param minProfit
     * @param group
     * @param profit
     * @return
     */
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int MOD = (int)1e9 + 7;
        int len = group.length;

        int[][][] dp = new int[len+1][n+1][minProfit+1];
        // 盈利为0时，只有一种方案。
        dp[0][0][0] = 1;
        for(int i = 1; i <= len; i ++) {
            int members = group[i - 1], earn = profit[i - 1];
            for(int j = 0; j <= n; j ++) {
                for(int k = 0; k <= minProfit; k ++) {
                    if(j < members) {
                        dp[i][j][k] = dp[i-1][j][k];
                    } else {
                        dp[i][j][k] = (dp[i - 1][j][k] + dp[i - 1][j - members][Math.max(0, k - earn)]) % MOD;
                    }
                }
            }
        }

        int sum = 0;
        for (int j = 0; j <= n; j++) {
            sum = (sum + dp[len][j][minProfit]) % MOD;
        }
        return sum;
    }

    static class TestCase {
        public static int ANS = 2;
        public static int N = 5;
        public static int MINPROFIT = 3;
        public static int[] GROUP = {2,2};
        public static int[] PROFIT = {2,3};

        public static int ANS1 = 7;
        public static int N1 = 10;
        public static int MINPROFIT1 = 5;
        public static int[] GROUP1 = {2,3,5};
        public static int[] PROFIT1 = {6,7,8};
    }
}
