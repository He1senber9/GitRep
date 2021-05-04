package club.vann.leetcode.offer.daily;

import java.util.Arrays;

/**
 * <p>难度：Hard</p>
 * <p>题目：粉刷房子III</p>
 * <p>描述：在一个小城市里，有 m 个房子排成一排，你需要给每个房子涂上 n 种颜色之一（颜色编号为 1 到 n ）。有的房子去年夏天已经涂过颜色了，所以这些房子不需要被重新涂色。
 *
 * 我们将连续相同颜色尽可能多的房子称为一个街区。（比方说 houses = [1,2,2,3,3,2,1,1] ，它包含 5 个街区  [{1}, {2,2}, {3,3}, {2}, {1,1}] 。）
 *
 * 给你一个数组 houses ，一个 m * n 的矩阵 cost 和一个整数 target ，其中：
 *
 * houses[i]：是第 i 个房子的颜色，0 表示这个房子还没有被涂色。
 * cost[i][j]：是将第 i 个房子涂成颜色 j+1 的花费。
 * 请你返回房子涂色方案的最小总花费，使得每个房子都被涂色后，恰好组成 target 个街区。如果没有可用的涂色方案，请返回 -1 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：houses = [0,0,0,0,0], cost = [[1,10],[10,1],[10,1],[1,10],[5,1]], m = 5, n = 2, target = 3
 * 输出：9
 * 解释：房子涂色方案为 [1,2,2,1,1]
 * 此方案包含 target = 3 个街区，分别是 [{1}, {2,2}, {1,1}]。
 * 涂色的总花费为 (1 + 1 + 1 + 1 + 5) = 9。
 * 示例 2：
 *
 * 输入：houses = [0,2,1,2,0], cost = [[1,10],[10,1],[10,1],[1,10],[5,1]], m = 5, n = 2, target = 3
 * 输出：11
 * 解释：有的房子已经被涂色了，在此基础上涂色方案为 [2,2,1,2,2]
 * 此方案包含 target = 3 个街区，分别是 [{2,2}, {1}, {2,2}]。
 * 给第一个和最后一个房子涂色的花费为 (10 + 1) = 11。
 * 示例 3：
 *
 * 输入：houses = [0,0,0,0,0], cost = [[1,10],[10,1],[1,10],[10,1],[1,10]], m = 5, n = 2, target = 5
 * 输出：5
 * 示例 4：
 *
 * 输入：houses = [3,1,2,3], cost = [[1,1,1],[1,1,1],[1,1,1],[1,1,1]], m = 4, n = 3, target = 3
 * 输出：-1
 * 解释：房子已经被涂色并组成了 4 个街区，分别是 [{3},{1},{2},{3}] ，无法形成 target = 3 个街区。
 *  
 *
 * 提示：
 *
 * m == houses.length == cost.length
 * n == cost[i].length
 * 1 <= m <= 100
 * 1 <= n <= 20
 * 1 <= target <= m
 * 0 <= houses[i] <= n
 * 1 <= cost[i][j] <= 10^4
 * 通过次数3,207提交次数5,831
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/paint-house-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @ClassName LeetCode_1473
 * @Description TODO
 * @User fanyu
 * @Date 2021/5/4 8:42
 */
public class LeetCode_1473 {
    public static void main(String[] args) {
        LeetCode_1473 leetCode = new LeetCode_1473();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.minCost(TestCase.HOUSES, TestCase.COSTS, TestCase.M, TestCase.N, TestCase.TARGET));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.minCost(TestCase.HOUSES1, TestCase.COSTS1, TestCase.M1, TestCase.N1, TestCase.TARGET1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.minCost(TestCase.HOUSES2, TestCase.COSTS2, TestCase.M2, TestCase.N2, TestCase.TARGET2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.minCost(TestCase.HOUSES3, TestCase.COSTS3, TestCase.M3, TestCase.N3, TestCase.TARGET3));
    }

    // 极大值
    // 选择 Integer.MAX_VALUE / 2 的原因是防止整数相加溢出
    static final int INFTY = Integer.MAX_VALUE / 2;

    /**
     * 解法一：
     *
     * @param houses
     * @param cost
     * @param m
     * @param n
     * @param target
     * @return
     */
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        // 将颜色调整为从 0 开始编号，没有被涂色标记为 -1
        for (int i = 0; i < m; ++i) {
            --houses[i];
        }

        // dp 所有元素初始化为极大值
        int[][][] dp = new int[m][n][target];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                Arrays.fill(dp[i][j], INFTY);
            }
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (houses[i] != -1 && houses[i] != j) {
                    continue;
                }

                for (int k = 0; k < target; ++k) {
                    for (int j0 = 0; j0 < n; ++j0) {
                        if (j == j0) {
                            if (i == 0) {
                                if (k == 0) {
                                    dp[i][j][k] = 0;
                                }
                            } else {
                                dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j][k]);
                            }
                        } else if (i > 0 && k > 0) {
                            dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j0][k - 1]);
                        }
                    }

                    if (dp[i][j][k] != INFTY && houses[i] == -1) {
                        dp[i][j][k] += cost[i][j];
                    }
                }
            }
        }

        int ans = INFTY;
        for (int j = 0; j < n; ++j) {
            ans = Math.min(ans, dp[m - 1][j][target - 1]);
        }
        return ans == INFTY ? -1 : ans;
    }

    static class TestCase {
        public static int ANS = 9;
        public static int[] HOUSES = {0,0,0,0,0};
        public static int[][] COSTS = {{1,10},{10,1},{10,1},{1,10},{5,1}};
        public static int M = 5;
        public static int N = 2;
        public static int TARGET = 3;


        public static int ANS1 = 11;
        public static int[] HOUSES1 = {0,2,1,2,0};
        public static int[][] COSTS1 = {{1,10},{10,1},{10,1},{1,10},{5,1}};
        public static int M1 = 5;
        public static int N1 = 2;
        public static int TARGET1 = 3;


        public static int ANS2 = 5;
        public static int[] HOUSES2 = {0,0,0,0,0};
        public static int[][] COSTS2 = {{1,10},{10,1},{1,10},{10,1},{1,10}};
        public static int M2 = 5;
        public static int N2 = 2;
        public static int TARGET2 = 5;


        public static int ANS3 = -1;
        public static int[] HOUSES3 = {3,1,2,3};
        public static int[][] COSTS3 = {{1,1,1},{1,1,1},{1,1,1},{1,1,1},{1,1,1}};
        public static int M3 = 4;
        public static int N3 = 3;
        public static int TARGET3 = 3;
    }
}
