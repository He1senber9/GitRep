package club.vann.leetcode.offer.daily;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>难度：Midum</p>
 * <p>题目：地图分析</p>
 * <p>描述：你现在手里有一份大小为 N x N 的『地图』（网格） grid，上面的每个『区域』（单元格）都用 0 和 1 标记好了。其中 0 代表海洋，1 代表陆地，你知道距离陆地区域最远的海洋区域是是哪一个吗？请返回该海洋区域到离它最近的陆地区域的距离。
 *
 * 我们这里说的距离是『曼哈顿距离』（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 - x1| + |y0 - y1| 。
 *
 * 如果我们的地图上只有陆地或者海洋，请返回 -1。
 * 示例 1：
 *
 * 输入：[[1,0,1],[0,0,0],[1,0,1]]
 * 输出：2
 * 解释：
 * 海洋区域 (1, 1) 和所有陆地区域之间的距离都达到最大，最大距离为 2。
 * 示例 2：
 *
 * 输入：[[1,0,0],[0,0,0],[0,0,0]]
 * 输出：4
 * 解释：
 * 海洋区域 (2, 2) 和所有陆地区域之间的距离都达到最大，最大距离为 4。
 * 提示：
 *
 * 1 <= grid.length == grid[0].length <= 100
 * grid[i][j] 不是 0 就是 1
 * 通过次数7,451提交次数18,930
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/as-far-from-land-as-possible
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/3/29
 * Time: 8:23
 * Description:
 */
public class LeetCode_1162 {
    public static void main(String[] args) {
        int[][] grid = null;
        int result = -1;
        LeetCode_1162 leetCode = new LeetCode_1162();
        TestCase testCase = leetCode.new TestCase();

//        result = leetCode.maxDistance2(testCase.grid);
//        System.out.println("Result[2] : " + result);

        result = leetCode.maxDistance2(testCase.grid1);
        System.out.println("Result[4] : " + result);

        result = leetCode.maxDistance2(testCase.grid2);
        System.out.println("Result[2] : " + result);

        result = leetCode.maxDistance2(testCase.grid3);
        System.out.println("Result[-1] : " + result);

        result = leetCode.maxDistance2(testCase.grid4);
        System.out.println("Result[-1] : " + result);

        result = leetCode.maxDistance2(testCase.grid5);
        System.out.println("Result[2] : " + result);

        result = leetCode.maxDistance2(testCase.grid6);
        System.out.println("Result[2] : " + result);

    }

    /**
     * 解法一：
     *
     * @param grid
     * @return
     */
    private int maxDistance(int[][] grid) {
        int len = grid.length;

        int max = Integer.MIN_VALUE;

        outer: for(int y = 0; y < len; y ++) {
            inter :for(int x = 0; x < len; x ++) {
                int v = grid[y][x];

                if(v == 0) {
                    int t = maxDistance(grid, x, y);
                    max = Math.max(max, t);
                }
            }
        }


        return (max == Integer.MIN_VALUE|| max == Integer.MAX_VALUE) ? -1 : max;
    }

    private int maxDistance(int[][] grid, int baseX, int baseY) {
        int len = grid.length;

        int max = Integer.MAX_VALUE;
        for(int y = 0; y < len; y ++) {
            for(int x = 0; x < len; x ++) {
                if(!(baseX == x && baseY == y) && grid[y][x] == 1) {
                    int offer = Math.abs(x-baseX) + Math.abs(y-baseY);
                    if(offer < max) {
                        max = offer;
                    }
                }
            }
        }

        return max;
    }

    /**
     * 解法一：
     *
     * @param grid
     * @return
     */
    private int maxDistance2(int[][] grid) {
        int len = grid.length;

        Queue<Integer> queue = new LinkedList<Integer>();
        // 标记出所有的陆地
        for(int y = 0; y < len; y ++) {
            for(int x = 0; x < len; x ++) {
                if(grid[y][x] == 1) {
                    queue.add(x*len+y);
                }
            }
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int size = queue.size();
        if((size == 0) || (size == len*len)) {
            return -1;
        }

        int indexX = 0, indexY = 0;
        while(!queue.isEmpty()) {
            int val = queue.poll();
            int y = val % len;
            int x = val / len;

            indexY = y;
            indexX = x;

            for(int k = 0; k < 4; k ++) {
                int newY = y + dr[k];
                int newX = x + dc[k];
                if(newY>=0 && newY<len && newX>=0 && newX<len) {
                    if(grid[newY][newX] == 0) {
                        grid[newY][newX] = grid[y][x] + 1;
                        queue.offer(newX*len+newY);
                    }
                }
            }
        }

        return grid[indexY][indexX] - 1;
    }

    /**
     * 测试用例
     */
    class TestCase {
        public final int[][] grid = {{1,0,1}, {0,0,0}, {1,0,1}};

        public final int[][] grid1 = {{1,0,0}, {0,0,0}, {0,0,0}};

        public final int[][] grid2 = {{1,0,0}, {0,1,0}, {0,0,0}};

        public final int[][] grid3 = {{1,1,1}, {1,1,1}, {1,1,1}};

        public final int[][] grid4 = {{0,0,0}, {0,0,0}, {0,0,0}};

        public final int[][] grid5 = {{1,0,0,0,0,1,0,0,0,1},{1,1,0,1,1,1,0,1,1,0},{0,1,1,0,1,0,0,1,0,0},{1,0,1,0,1,0,0,0,0,0},{0,1,0,0,0,1,1,0,1,1},{0,0,1,0,0,1,0,1,0,1},{0,0,0,1,1,1,1,0,0,1},{0,1,0,0,1,0,0,1,0,0},{0,0,0,0,0,1,1,1,0,0},{1,1,0,1,1,1,1,1,0,0}};

        public final int[][] grid6 = {{1,1,1,0,0,0,0,0,1,1,1,1,0,0,0,0,0,1,0,0},{1,1,0,1,0,1,1,1,1,1,1,1,0,1,0,0,0,1,1,1},{0,0,1,1,0,1,0,0,1,0,1,1,1,1,1,1,0,0,0,0},{0,0,1,1,0,0,0,1,1,1,1,0,1,1,1,0,0,1,0,1},{1,0,1,1,0,1,1,1,0,1,0,1,0,1,1,0,1,0,1,0},{0,0,1,1,0,1,0,1,0,0,0,0,0,0,0,1,0,0,0,1},{0,0,0,1,0,0,1,1,0,0,1,1,1,1,0,0,0,0,1,0},{1,0,0,1,0,1,1,0,0,1,0,0,1,0,1,1,1,0,0,1},{0,1,0,1,1,0,0,1,1,1,1,1,0,0,1,0,1,0,0,0},{1,0,1,0,0,0,0,0,0,1,1,1,0,0,1,0,1,0,1,0},{0,1,1,0,1,1,1,0,0,0,1,0,0,0,1,0,0,0,0,0},{0,0,1,1,1,1,1,1,1,0,0,0,1,0,0,0,0,0,1,0},{0,0,1,1,0,0,1,1,1,1,1,1,1,0,1,0,1,0,0,0},{0,1,0,1,0,0,0,1,1,1,0,0,0,1,1,0,0,1,0,1},{1,0,0,0,1,0,1,0,1,1,1,1,0,0,1,0,0,0,1,1},{0,1,0,0,1,0,0,0,0,1,0,0,0,0,1,0,1,0,0,1},{0,1,0,1,0,0,0,1,0,1,1,1,1,1,0,0,0,0,0,1},{1,1,1,0,0,1,0,1,1,0,0,0,0,1,1,0,0,0,1,0},{1,1,1,1,1,1,0,1,0,0,0,1,1,1,1,0,0,1,0,1},{0,0,0,1,1,0,1,0,1,0,1,0,1,1,0,1,0,0,0,0}};
    }
}
