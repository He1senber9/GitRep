package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Midum</p>
 * <p>题目：岛屿的最大面积</p>
 * <p>描述：给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。
 * 你可以假设二维矩阵的四个边缘都被水包围着。
 * <p>
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
 * <p>
 * 示例 1:
 * <p>
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,1,1,0,1,0,0,0,0,0,0,0,0],
 * [0,1,0,0,1,1,0,0,1,0,1,0,0],
 * [0,1,0,0,1,1,0,0,1,1,1,0,0],
 * [0,0,0,0,0,0,0,0,0,0,1,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 对于上面这个给定矩阵应返回 6。注意答案不应该是11，因为岛屿只能包含水平或垂直的四个方向的‘1’。
 * <p>
 * 示例 2:
 * <p>
 * [[0,0,0,0,0,0,0,0]]
 * 对于上面这个给定的矩阵, 返回 0。
 * <p>
 * 注意: 给定的矩阵grid 的长度和宽度都不超过 50。
 * <p>
 * 通过次数20,441提交次数33,933
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-area-of-island
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/3/15
 * Time: 8:37
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_695 {
    public static void main(String[] args) {
        int[][] grid = null;
        int result = 0;
        LeetCode_695 leetCode = new LeetCode_695();

        grid = new int[][]{{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        result = leetCode.maxAreaOfIsland(grid);
        System.out.println("Result[6] : " + result);

        grid = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0}};
        result = leetCode.maxAreaOfIsland(grid);
        System.out.println("Result[0] : " + result);

        grid = new int[][]{{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}};
        result = leetCode.maxAreaOfIsland(grid);
        System.out.println("Result[4] : " + result);
    }

    /**
     * 解法一：暴力破解，按顺序遍历，找到所有的岛屿。
     *
     * @param grid
     * @return
     */
    private int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int lenY = grid.length;
        int lenX = grid[0].length;
        int max = 0;

        for (int y = 0; y < lenY; y++) {
            for (int x = 0; x < lenX; x++) {
                if (grid[y][x] == 1) {
                    int count = findMax(grid, y, x, lenY, lenX);
                    max = Math.max(max, count);
                }
            }
        }
        return max;
    }

    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1}; // 用于寻找周边陆地

    /**
     * 根据指定岛屿找到所有岛屿
     *
     * @param grid
     * @param y
     * @param x
     * @return
     */
    private int findMax(int[][] grid, int y, int x, int lenY, int lenX) {
        if (grid[y][x] == 0) {
            return 0;
        }

        int count = 0;
        count++; // 当前节点为陆地，记为 1
        grid[y][x] = 0;

        for (int k = 0; k < 4; k++) {
            int pointY = y + dr[k];
            int pointX = x + dc[k];

            if (pointY >= 0 && pointY < lenY && pointX >= 0 && pointX < lenX) {
                count = count + findMax(grid, pointY, pointX, lenY, lenX);
            }
        }

        return count;
    }
}
