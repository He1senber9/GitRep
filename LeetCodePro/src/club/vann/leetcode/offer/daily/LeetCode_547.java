package club.vann.leetcode.offer.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName LeetCode_547
 * @Description TODO
 * @User fanyu
 * @Date 2021/1/7 19:30
 */
public class LeetCode_547 {
    public static void main(String[] args) {
        LeetCode_547 leetCode = new LeetCode_547();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.findCircleNum1(TestCase.ISCONNECTED));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.findCircleNum1(TestCase.ISCONNECTED1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.findCircleNum1(TestCase.ISCONNECTED2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.findCircleNum1(TestCase.ISCONNECTED3));
        System.out.println("Result["+TestCase.ANS4+"] : " + leetCode.findCircleNum1(TestCase.ISCONNECTED4));
    }

    /**
     * 解法一：
     * 深度优先搜索，从一个未被访问过的城市深度搜索。
     * @param isConnected
     * @return
     */
    public int findCircleNum(int[][] isConnected) {
        // 按节点统计
        int res = 0;
        int n = isConnected.length;

        // 标记已经访问过的城市
        int[] visited = new int[n];

        for(int i = 0; i < n; i ++) {
            if(visited[i] == 0) {
                dfs(isConnected, visited, n, i);
                res ++;
            }

        }
        return res;
    }

    private void dfs(int[][] isConnected, int[] visited, int n, int i) {
        for(int j = 0; j < n; j ++) {
            if(isConnected[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(isConnected, visited, n, j);
            }
        }
    }

    /**
     * 解法二：
     * 并查集
     * @param isConnected
     * @return
     */
    public int findCircleNum1(int[][] isConnected) {
        int n = isConnected.length;

        int[] parent = new int[n];
        for(int i = 0; i < n; i ++) {
            parent[i] = i;
        }
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < n; j ++) {
                if(isConnected[i][j] == 1) {
                    join(parent, i, j);
                }
            }
        }

        int res = 0;
        for(int i = 0; i < n; i ++) {
            if(parent[i] == i) {
                res ++;
            }
        }
        return res;
    }

    /**
     * 查找 index元素的根。
     * @param index
     * @return
     */
    private int find(int[] parent, int index) {
        int root = index;
        while(parent[root] != root) {
            root= parent[root];
        }
        return root;
    }

    private void join(int[] parent, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);

        parent[rootY] = rootX;
    }

    static class TestCase {
        public static int ANS = 2;
        public static int[][] ISCONNECTED = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        public static int ANS1 = 3;
        public static int[][] ISCONNECTED1 = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};

        public static int ANS2 = 3;
        public static int[][] ISCONNECTED2 = {{1, 0, 1, 0, 0}, {0, 1, 0, 1, 0}, {1, 0, 1, 0, 0}, {0, 1, 0, 1, 0}, {0, 0, 0, 0, 1}};

        public static int ANS3 = 4;
        public static int[][] ISCONNECTED3 = {{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 2}};

        public static int ANS4 = 1;
        public static int[][] ISCONNECTED4 = {{1,0,0,1}, {0,1,1,0}, {0,1,1,1}, {1,0,1,1}};
    }
}
