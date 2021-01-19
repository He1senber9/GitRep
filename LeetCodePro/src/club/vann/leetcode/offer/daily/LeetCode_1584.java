package club.vann.leetcode.offer.daily;

import java.util.*;

/**
 * @ClassName LeetCode_1584
 * @Description TODO
 * @User fanyu
 * @Date 2021/1/19 8:32
 */
public class LeetCode_1584 {
    public static void main(String[] args) {
        LeetCode_1584 leetCode = new LeetCode_1584();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.minCostConnectPoints(TestCase.POINTS));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.minCostConnectPoints(TestCase.POINTS1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.minCostConnectPoints(TestCase.POINTS2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.minCostConnectPoints(TestCase.POINTS3));
        System.out.println("Result["+TestCase.ANS4+"] : " + leetCode.minCostConnectPoints(TestCase.POINTS4));
    }

    /**
     * 解法一：
     *
     * @param points
     * @return
     */
    public int minCostConnectPoints(int[][] points) {
        // n 个顶点
        int n = points.length;
        if(n <= 1) {
            return 0;
        }

        List<Edge> edges = new ArrayList<>();
        for(int i = 0; i < n; i ++) {
            for(int j = i+1; j < n; j ++) {
                int len = Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1]-points[j][1]);
                if(len != 0) {
                    edges.add(new Edge(i, j, len));
                }
            }
        }

        int ans = 0;
        Collections.sort(edges);
        UnionUtil unionUtil = new UnionUtil(n);
        for(Edge edge : edges) {
            int x = edge.x;
            int y = edge.y;
            int len = edge.len;

            if(unionUtil.find(x) == unionUtil.find(y)) {
                continue;
            }

            ans += len;
            unionUtil.union(x, y);
        }

        return ans;
    }

    class Edge implements Comparable<Edge> {
        int x, y, len;
        public Edge(int x, int y, int len) {
            this.len = len;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.len, o.len);
        }
    }

    /**
     * 并查集工具。
     */
    class UnionUtil {
        int[] parent;

        public UnionUtil(int n) {
            parent = new int[n];
            for(int i = 0; i < n; i ++) {
                parent[i]= i;
            }
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if(rootX == rootY) {
                return;
            }

            parent[rootX] = rootY;
        }

        private int find(int x) {
            if(x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }

    static class TestCase {
        public static int ANS = 20;
        public static int[][] POINTS = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};

        public static int ANS1 = 18;
        public static int[][] POINTS1 = {{3, 12}, {-2, 5}, {-4, 1}};

        public static int ANS2 = 4;
        public static int[][] POINTS2 = {{0, 0}, {1, 1}, {1, 0}, {-1, 1}};

        public static int ANS3 = 4000000;
        public static int[][] POINTS3 = {{-1000000, -1000000}, {1000000, 1000000}};

        public static int ANS4 = 0;
        public static int[][] POINTS4 = {{0,0}};
    }
}
