package club.vann.leetcode;

import java.util.LinkedList;

/**
 * <p>难度：Hard</p>
 * <p>题目：网格中的最短路径</p>
 * <p>描述：给你一个 m * n 的网格，其中每个单元格不是 0（空）就是 1（障碍物）。每一步，您都可以在空白单元格中上、下、左、右移动。
 *
 * 如果您 最多 可以消除 k 个障碍物，请找出从左上角 (0, 0) 到右下角 (m-1, n-1) 的最短路径，并返回通过该路径所需的步数。如果找不到这样的路径，则返回 -1。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 * grid =
 * [[0,0,0],
 *  [1,1,0],
 *  [0,0,0],
 *  [0,1,1],
 *  [0,0,0]],
 * k = 1
 * 输出：6
 * 解释：
 * 不消除任何障碍的最短路径是 10。
 * 消除位置 (3,2) 处的障碍后，最短路径是 6 。该路径是 (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2) -> (3,2) -> (4,2).
 *  
 *
 * 示例 2：
 *
 * 输入：
 * grid =
 * [[0,1,1],
 *  [1,1,1],
 *  [1,0,0]],
 * k = 1
 * 输出：-1
 * 解释：
 * 我们至少需要消除两个障碍才能找到这样的路径。
 *  
 *
 * 提示：
 *
 * grid.length == m
 * grid[0].length == n
 * 1 <= m, n <= 40
 * 1 <= k <= m*n
 * grid[i][j] == 0 or 1
 * grid[0][0] == grid[m-1][n-1] == 0
 * 通过次数6,159提交次数16,982
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-path-in-a-grid-with-obstacles-elimination
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-07-29 14:58
 **/
public class LeetCode_1293 {
    public static void main(String[] args) {
        LeetCode_1293 leetCode = new LeetCode_1293();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.shortestPath(TestCase.GRID, TestCase.K));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.shortestPath(TestCase.GRID1, TestCase.K1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.shortestPath(TestCase.GRID2, TestCase.K2));
    }

    /**
     * 解法一：
     *
     * @param grid
     * @param k
     * @return
     */
    private int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        // 二维标记数组初始状态为-1，值记录剩余消除障碍的次数，剩余次数越多 越有价值（此处贪心，记录局部最优）
        int[][] visited = new int[m][n];
        for(int y = 0; y < m; y ++) {
            for(int x = 0; x < n; x ++) {
                visited[y][x] = -1;
            }
        }
        visited[0][0] = k;

        if(m==1 && n==1) {
            return 0;
        }

        int[] dr = {1,-1,0,0};
        int[] dc = {0,0,-1,1};

        // 初始步数为0，m=n=1的特殊场景已处理
        int minSteps = 0;

        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(new Node(0,0,0));

        while(!queue.isEmpty()) {
            minSteps ++;

            // BFS搜索-遍历相同层级下所有节点
            // 当前队列长度一定要在循环外部定义，循环内部有插入对列操作
            int size = queue.size();
            for(int i = 0; i < size; i ++) {
                Node node = queue.pollFirst();
                int y = node.y;
                int x = node.x;
                int step = node.step;

                for(int o = 0; o < 4; o ++) {
                    int newY = y + dr[o];
                    int newX = x + dc[o];

                    // 越界判断
                    if(newY<0 || newY > m-1 || newX < 0 || newX > n-1) {
                        continue;
                    }

                    // 搜索到目标节点直接返回结果，按层级就是最短步数
                    if(newY == m-1 && newX == n-1) {
                        return minSteps;
                    }

                    // 穿越障碍次数已满
                    if(grid[newY][newX]==1 && step >= k) {
                        continue;
                    }

                    int oneCountNew = grid[newY][newX] == 1 ? step + 1 : step;
                    // 剪枝 - 节点已被访问过，且当前visited记录的剩余障碍物消除次数 >= 当前搜索节点层级的剩余消除次数
                    if (visited[newY][newX] != -1 && visited[newY][newX] >= k - oneCountNew) {
                        continue;
                    } else {
                        // 否则，贪心将最优值更新，并将该层级节点入队
                        visited[newY][newX] = k - oneCountNew;
                    }
                    queue.offer(new Node(newY, newX, oneCountNew));
                }
            }
        }
        return -1;
    }

    class Node {
        int y;
        int x;
        int step;

        Node(int y, int x, int step) {
            this.y = y;
            this.x = x;
            this.step = step;
        }
    }

    static class TestCase {
        public static int ANS = 6;
        public static int[][] GRID = {{0,0,0}, {1,1,0}, {0,0,0}, {0,1,1}, {0,0,0}};
        public static int K = 1;

        public static int ANS1 = -1;
        public static int[][] GRID1 = {{0,1,1},{1,1,1},{1,0,0}};
        public static int K1 = 1;

        public static int ANS2 = 2;
        public static int[][] GRID2 = {{0,0,0}};
        public static int K2 = 1;
    }
}
