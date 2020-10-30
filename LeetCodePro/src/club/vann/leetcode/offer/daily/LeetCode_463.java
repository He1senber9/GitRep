package club.vann.leetcode.offer.daily;

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
 * 通过次数27,141提交次数27,141
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/island-perimeter
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/10/30
 * Time: 7:10
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_463 {
    public static void main(String[] args) {
        LeetCode_463 leetCode = new LeetCode_463();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.islandPerimeter(TestCase.GRID));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.islandPerimeter(TestCase.GRID1));
    }

    /**
     * 解法一：
     * @param grid
     * @return
     */
    public int islandPerimeter(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int result = 0;
        int lenY = grid.length;
        int lenX = grid[0].length;

        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        for(int y = 0; y < lenY; y ++) {
            for(int x = 0; x < lenX; x ++) {
                if(grid[y][x] != 1) {
                    continue;
                }

                result += 4; // 每一格陆地加周长4
                grid[y][x] = 2; // 标记访问过的元素

                for(int i = 0; i < 4; i ++) {
                    int newY = y + dr[i];
                    int newX = x + dc[i];
                    if(newY >= 0 && newY < lenY && newX >= 0 && newX < lenX && grid[newY][newX] != 0) {
                        result -= 1;
                    }
                }
            }
        }
        return result;
    }

    static class TestCase {
        public static int ANS = 16;
        public static int[][] GRID = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};

        public static int ANS1 = 8;
        public static int[][] GRID1 = {{0,0,0,0},{0,1,1,0},{0,1,1,0},{0,0,0,0}};
    }
}
