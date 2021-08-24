package club.vann.leetcode.offer.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * <p>难度：Medium</p>
 * <p>题目：K 站中转内最便宜的航班</p>
 * <p>描述：有 n 个城市通过一些航班连接。给你一个数组 flights ，其中 flights[i] = [fromi, toi, pricei] ，表示该航班都从城市 fromi 开始，以价格 toi 抵达 pricei。
 *
 * 现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到出一条最多经过 k 站中转的路线，使得从 src 到 dst 的 价格最便宜 ，并返回该价格。 如果不存在这样的路线，则输出 -1。
 *
 *  
 *
 * 示例 1：
 *
 * 输入:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 1
 * 输出: 200
 * 解释:
 * 城市航班图如下
 *
 *
 * 从城市 0 到城市 2 在 1 站中转以内的最便宜价格是 200，如图中红色所示。
 * 示例 2：
 *
 * 输入:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 0
 * 输出: 500
 * 解释:
 * 城市航班图如下
 *
 *
 * 从城市 0 到城市 2 在 0 站中转以内的最便宜价格是 500，如图中蓝色所示。
 *  
 *
 * 提示：
 *
 * 1 <= n <= 100
 * 0 <= flights.length <= (n * (n - 1) / 2)
 * flights[i].length == 3
 * 0 <= fromi, toi < n
 * fromi != toi
 * 1 <= pricei <= 104
 * 航班没有重复，且不存在自环
 * 0 <= src, dst, k < n
 * src != dst
 * 通过次数20,524提交次数57,378
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cheapest-flights-within-k-stops
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @description:
 * @program: GitRep
 * @author: fanyu
 * @create: 2021-08-24  08:18:56
 */
public class LeetCode_787 {
    public static void main(String[] args) {
        LeetCode_787 leetCode = new LeetCode_787();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.findCheapestPrice(TestCase.N, TestCase.FLIGHTS, TestCase.SRC, TestCase.DST, TestCase.K));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.findCheapestPrice(TestCase.N1, TestCase.FLIGHTS1, TestCase.SRC1, TestCase.DST1, TestCase.K1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.findCheapestPrice(TestCase.N2, TestCase.FLIGHTS2, TestCase.SRC2, TestCase.DST2, TestCase.K2));
    }

    /**
     * 解法一：
     *
     * @param n
     * @param flights
     * @param src
     * @param dst
     * @param k
     * @return
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // dp[i][j]表示恰好乘坐 i 次飞机，到达目的地 j 的最小费用
        // dp[0][j] = 0 (src == j);
        // dp[0][j] = Integer.MAX_VALUE (src != j);
        final int INF = 10000 * 101 + 1;
        int[][] dp = new int[k+2][n];
        for(int i = 0; i < k+2; i ++) {
            Arrays.fill(dp[i], INF);
        }
        dp[0][src] = 0;

        for(int i = 1; i < k+2; i ++) {
            for(int[] fligh : flights) {
                int j = fligh[0];
                int m = fligh[1];
                int cost = fligh[2];

                dp[i][m] = Math.min(dp[i][m], dp[i-1][j]+cost);
            }
        }

        int ans = INF;
        for (int i = 1; i < k + 2; i ++) {
            ans = Math.min(ans, dp[i][dst]);
        }
        return ans == INF ? -1 : ans;
    }

    static class TestCase {
        public static int ANS = 200;
        public static int N = 3;
        public static int[][] FLIGHTS = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        public static int SRC = 0;
        public static int DST = 2;
        public static int K = 1;

        public static int ANS1 = 500;
        public static int N1 = 3;
        public static int[][] FLIGHTS1 = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        public static int SRC1 = 0;
        public static int DST1 = 2;
        public static int K1 = 0;

        public static int ANS2 = -1;
        public static int N2 = 5;
        public static int[][] FLIGHTS2 = {{4, 1, 1}, {1, 2, 3}, {0, 3, 2}, {0, 4, 10}, {3, 1, 1}, {1, 4, 3}};
        public static int SRC2 = 2;
        public static int DST2 = 1;
        public static int K2 = 1;
    }
}
