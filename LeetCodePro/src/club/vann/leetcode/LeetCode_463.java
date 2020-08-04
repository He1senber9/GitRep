package club.vann.leetcode;

/**
 * <p>难度：Easy</p>
 * <p>题目：岛屿的周长</p>
 * <p>描述：给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
 *
 * 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 *
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 *
 *  
 *
 * 示例 :
 *
 * 输入:
 * [[0,1,0,0],
 *  [1,1,1,0],
 *  [0,1,0,0],
 *  [1,1,0,0]]
 *
 * 输出: 16
 *
 * 解释: 它的周长是下面图片中的 16 个黄色的边：
 *
 *
 * 通过次数20,539提交次数30,407
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/island-perimeter
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-08-04 11:08
 **/
public class LeetCode_463 {
    public static void main(String[] args) {
        LeetCode_463 leetCode = new LeetCode_463();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.islandPerimeter(TestCase.GRID));
    }


    public int islandPerimeter(int[][] grid) {
        if(grid == null || grid[0].length == 0) {
            return 0;
        }

        int M = grid.length;
        int N = grid[0].length;

        for(int y = 0; y < M; y ++) {
            for(int x = 0; x < N; x ++) {
                if(grid[y][x] == 1) {
                    return dfs(grid, y, x, M, N);
                }
            }
        }
        return 0;
    }

    private int dfs(int[][] grid, int y, int x, int M, int N) {
        if(y<0 || y>M-1 || x<0 || x>N-1 || grid[y][x] == 0) {
            return 1;
        }

        if(grid[y][x] != 1) {
            return 0;
        }

        grid[y][x] = 2;

        return dfs(grid, y,x-1, M, N) + dfs(grid, y,x+1, M, N)+dfs(grid,y-1, x, M, N)+dfs(grid,y+1, x, M, N);

    }

    static class TestCase {
        public static int ANS = 16;
        public static int[][] GRID = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
    }
}
