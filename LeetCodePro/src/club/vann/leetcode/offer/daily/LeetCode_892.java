package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Easy</p>
 * <p>题目：三维形体的表面积</p>
 * <p>描述：在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
 *
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
 *
 * 请你返回最终形体的表面积。
 *
 * 示例 1：
 *
 * 输入：[[2]]
 * 输出：10
 * 示例 2：
 *
 * 输入：[[1,2],[3,4]]
 * 输出：34
 * 示例 3：
 *
 * 输入：[[1,0],[0,2]]
 * 输出：16
 * 示例 4：
 *
 * 输入：[[1,1,1],[1,0,1],[1,1,1]]
 * 输出：32
 * 示例 5：
 *
 * 输入：[[2,2,2],[2,1,2],[2,2,2]]
 * 输出：46
 *  
 *
 * 提示：
 *
 * 1 <= N <= 50
 * 0 <= grid[i][j] <= 50
 * 通过次数21,219提交次数33,354
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/surface-area-of-3d-shapes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/3/25
 * Time: 20:41
 * Description:
 */
public class LeetCode_892 {
    public static void main(String[] args) {
        int[][] grid = null;
        int result = 0;
        LeetCode_892 leetCode = new LeetCode_892();

        grid = new int[][] {{2}};
        result = leetCode.surfaceArea(grid);
        System.out.println("Result[10] :  " + result);

        grid = new int[][] {{1,2}, {3,4}};
        result = leetCode.surfaceArea(grid);
        System.out.println("Result[34] :  " + result);

        grid = new int[][] {{1,0}, {0,2}};
        result = leetCode.surfaceArea(grid);
        System.out.println("Result[16] :  " + result);

        grid = new int[][] {{1,1,1}, {1,0,1}, {1,1,1}};
        result = leetCode.surfaceArea(grid);
        System.out.println("Result[32] :  " + result);

        grid = new int[][] {{2,2,2}, {2,1,2}, {2,2,2}};
        result = leetCode.surfaceArea(grid);
        System.out.println("Result[46] :  " + result);
    }

    private int surfaceArea(int[][] grid) {
        int result = 0;
        if(grid == null || grid.length == 0) {
            return result;
        }

        int lenY = grid.length;
        int lenX = grid[0].length;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for(int y = 0; y < lenY; y ++) {
            for(int x = 0; x < lenX; x ++) {
                int num = grid[y][x];
                result += num * 6; // 每个立方体有6个面

                if(num > 1) { // 如果有重叠的立方体，要减去重叠面
                    result -= ((num-1) * 2);
                }

                // 还需要减去当前节点与周围节点的重叠面
                for(int k = 0; k < 4; k ++) {
                    if(y+dr[k] >= 0 && y+dr[k] < lenY && x+dc[k] >= 0 && x+dc[k] < lenX) {
                        result -= Math.min(num, grid[y+dr[k]][x+dc[k]]);
                    }
                }
            }
        }

        return result;
    }
}
