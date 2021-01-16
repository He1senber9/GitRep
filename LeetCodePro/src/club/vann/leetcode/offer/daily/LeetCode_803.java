package club.vann.leetcode.offer.daily;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>难度：Hard</p>
 * <p>题目：打砖块</p>
 * <p>描述：有一个 m x n 的二元网格，其中 1 表示砖块，0 表示空白。砖块 稳定（不会掉落）的前提是：
 *
 * 一块砖直接连接到网格的顶部，或者
 * 至少有一块相邻（4 个方向之一）砖块 稳定 不会掉落时
 * 给你一个数组 hits ，这是需要依次消除砖块的位置。每当消除 hits[i] = (rowi, coli) 位置上的砖块时，对应位置的砖块（若存在）会消失，然后其他的砖块可能因为这一消除操作而掉落。一旦砖块掉落，它会立即从网格中消失（即，它不会落在其他稳定的砖块上）。
 *
 * 返回一个数组 result ，其中 result[i] 表示第 i 次消除操作对应掉落的砖块数目。
 *
 * 注意，消除可能指向是没有砖块的空白位置，如果发生这种情况，则没有砖块掉落。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：grid = [[1,0,0,0],[1,1,1,0]], hits = [[1,0]]
 * 输出：[2]
 * 解释：
 * 网格开始为：
 * [[1,0,0,0]，
 *  [1,1,1,0]]
 * 消除 (1,0) 处加粗的砖块，得到网格：
 * [[1,0,0,0]
 *  [0,1,1,0]]
 * 两个加粗的砖不再稳定，因为它们不再与顶部相连，也不再与另一个稳定的砖相邻，因此它们将掉落。得到网格：
 * [[1,0,0,0],
 *  [0,0,0,0]]
 * 因此，结果为 [2] 。
 * 示例 2：
 *
 * 输入：grid = [[1,0,0,0],[1,1,0,0]], hits = [[1,1],[1,0]]
 * 输出：[0,0]
 * 解释：
 * 网格开始为：
 * [[1,0,0,0],
 *  [1,1,0,0]]
 * 消除 (1,1) 处加粗的砖块，得到网格：
 * [[1,0,0,0],
 *  [1,0,0,0]]
 * 剩下的砖都很稳定，所以不会掉落。网格保持不变：
 * [[1,0,0,0],
 *  [1,0,0,0]]
 * 接下来消除 (1,0) 处加粗的砖块，得到网格：
 * [[1,0,0,0],
 *  [0,0,0,0]]
 * 剩下的砖块仍然是稳定的，所以不会有砖块掉落。
 * 因此，结果为 [0,0] 。
 *  
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * grid[i][j] 为 0 或 1
 * 1 <= hits.length <= 4 * 104
 * hits[i].length == 2
 * 0 <= xi <= m - 1
 * 0 <= yi <= n - 1
 * 所有 (xi, yi) 互不相同
 * 通过次数5,637提交次数12,741
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bricks-falling-when-hit
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @ClassName LeetCode_803
 * @Description TODO
 * @User fanyu
 * @Date 2021/1/16 17:24
 */
public class LeetCode_803 {
    public static void main(String[] args) {
        LeetCode_803 leetCode = new LeetCode_803();

        System.out.println("Result["+ Arrays.toString(TestCase.ANS)+"] : " + Arrays.toString(leetCode.hitBricks(TestCase.GRID, TestCase.HITS)));
        System.out.println("Result["+ Arrays.toString(TestCase.ANS1)+"] : " + Arrays.toString(leetCode.hitBricks(TestCase.GRID1, TestCase.HITS1)));
        System.out.println("Result["+ Arrays.toString(TestCase.ANS2)+"] : " + Arrays.toString(leetCode.hitBricks(TestCase.GRID2, TestCase.HITS2)));
    }

    /**
     * 解法一：
     *
     * @param grid
     * @param hits
     * @return
     */
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int m = grid.length;
        int n = grid[0].length;

        // 1. 使用额外数组存储，不该表原数组。
        int[][] copy = new int[m][n];
        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j ++) {
                copy[i][j] = grid[i][j];
            }
        }

        // 2.先标记出被敲碎的节点。
        for(int[] hit : hits) {
            int y = hit[0];
            int x = hit[1];

            copy[y][x] = 0;
        }

        // 3.一共有m*n个元素，额外需要一个元素表示屋顶。
        Union union = new Union(m*n+1);
        // 4.处理第一行（屋顶）元素
        for(int x = 0; x < n; x ++) {
            if(copy[0][x] == 1) {
                union.union(trans(n, 0,x), m*n);
            }
        }
        // 5.处理剩下的行
        for(int y = 1; y < m; y ++) {
            for(int x = 0; x < n; x ++) {
                if(copy[y][x] == 1) {
                    // 判断上面节点
                    if(copy[y-1][x] == 1) {
                        union.union(trans(n, y-1,x), trans(n, y, x));
                    }
                    // 判断左边的节点
                    if(x > 0 && copy[y][x-1] == 1) {
                        union.union(trans(n, y,x-1), trans(n, y, x));
                    }
                }
            }
        }

        //
        int hitLen = hits.length;
        int[] res = new int[hitLen];
        for(int i = hitLen-1; i >= 0; i --) {
            int y = hits[i][0];
            int x = hits[i][1];
            if(grid[y][x] == 0) {
                continue;
            }

            // 合并前节点数量
            int beforeCount = union.size(m*n);

            // 合并
            // 如果此时是第一行，需要合并至屋顶
            if(y == 0) {
                union.union(trans(n, y, x), m*n);
            }

            int[][] dr = {{0,1},{0,-1},{1,0},{-1,0}};
            for(int t = 0; t < dr.length; t ++) {
                int newY = y+dr[t][0];
                int newX = x+dr[t][1];

                if(newX>=0 && newX<n && newY>=0 && newY<m && copy[newY][newX] == 1) {
                    union.union(trans(n, newY, newX), trans(n,y,x));
                }
            }

            // 合并后节点数量
            int afterCount = union.size(m*n);
            res[i] = Math.max(0, afterCount - beforeCount - 1);
            copy[y][x] = 1;
        }
        return res;
    }

    /**
     * 二维坐标转换为一维。
     * @param x
     * @param y
     * @return
     */
    private int trans(int n ,int y, int x) {
        return y * n + x;
    }

    private class Union {
        private int[] parent;
        private int[] counts;
        public Union(int n) {
            parent = new int[n];
            counts = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                counts[i] = 1;
            }
        }

        /**
         * 合并连通分量。
         *
         * @param x
         * @param y
         */
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if(rootX == rootY) {
                return;
            }
            parent[rootX] = rootY;
            counts[rootY] += counts[rootX];
        }

        /**
         * 路径压缩。
         * @param x
         * @return
         */
        public int find(int x) {
            if(x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public int size(int x) {
            int root = find(x);
            return counts[root];
        }
    }

    static class TestCase {
        public static int[] ANS = {2};
        public static int[][] GRID = {{1, 0, 0, 0}, {1, 1, 1, 0}};
        public static int[][] HITS = {{1,0}};

        public static int[] ANS1 = {0,0};
        public static int[][] GRID1 = {{1, 0, 0, 0}, {1, 1, 0, 0}};
        public static int[][] HITS1 = {{1, 1}, {1, 0}};

        public static int[] ANS2 = {1,0,1,0,0};
        public static int[][] GRID2 = {{1}, {1}, {1}, {1}, {1}};
        public static int[][] HITS2 = {{3, 0}, {4, 0}, {1, 0}, {2, 0}, {0, 0}};
    }
}
