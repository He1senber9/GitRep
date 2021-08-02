package club.vann.leetcode.offer.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>难度：Medium</p>
 * <p>题目：网络延迟时间</p>
 * <p>描述：有 n 个网络节点，标记为 1 到 n。
 *
 * 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， wi 是一个信号从源节点传递到目标节点的时间。
 *
 * 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * 输出：2
 * 示例 2：
 *
 * 输入：times = [[1,2,1]], n = 2, k = 1
 * 输出：1
 * 示例 3：
 *
 * 输入：times = [[1,2,1]], n = 2, k = 2
 * 输出：-1
 *  
 *
 * 提示：
 *
 * 1 <= k <= n <= 100
 * 1 <= times.length <= 6000
 * times[i].length == 3
 * 1 <= ui, vi <= n
 * ui != vi
 * 0 <= wi <= 100
 * 所有 (ui, vi) 对都 互不相同（即，不含重复边）
 * 通过次数30,994提交次数63,518
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/network-delay-time
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @description:
 * @program: GitRep
 * @author: fanyu
 * @create: 2021-08-02  08:06:17
 */
public class LeetCode_743 {
    public static void main(String[] args) {
        LeetCode_743 leetCode = new LeetCode_743();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.networkDelayTime(TestCase.TIMES, TestCase.N, TestCase.K));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.networkDelayTime(TestCase.TIMES1, TestCase.N1, TestCase.K1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.networkDelayTime(TestCase.TIMES2, TestCase.N2, TestCase.K2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.networkDelayTime(TestCase.TIMES3, TestCase.N3, TestCase.K3));
    }

    /**
     * 解法一：
     *
     * @param times
     * @param n
     * @param k
     * @return
     */
    public int networkDelayTime(int[][] times, int n, int k) {
        final int INF = Integer.MAX_VALUE / 2;
        int[][] g = new int[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(g[i], INF);
        }
        for (int[] t : times) {
            int x = t[0] - 1, y = t[1] - 1;
            g[x][y] = t[2];
        }

        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[k - 1] = 0;
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; ++i) {
            int x = -1;
            for (int y = 0; y < n; ++y) {
                if (!used[y] && (x == -1 || dist[y] < dist[x])) {
                    x = y;
                }
            }
            used[x] = true;
            for (int y = 0; y < n; ++y) {
                dist[y] = Math.min(dist[y], dist[x] + g[x][y]);
            }
        }

        int ans = Arrays.stream(dist).max().getAsInt();
        return ans == INF ? -1 : ans;
    }

    static class TestCase {
        public static int ANS = 2;
        public static int[][] TIMES = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        public static int N = 4;
        public static int K = 2;

        public static int ANS1 = 1;
        public static int[][] TIMES1 = {{1,2,1}};
        public static int N1 = 2;
        public static int K1 = 1;

        public static int ANS2 = -1;
        public static int[][] TIMES2 = {{1,2,1}};
        public static int N2 = 2;
        public static int K2 = 2;

        public static int ANS3 = 3;
        public static int[][] TIMES3 = {{1,2,1}, {2,1,3}};
        public static int N3 = 2;
        public static int K3 = 2;
    }
}
