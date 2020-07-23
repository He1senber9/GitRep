package club.vann.leetcode.offer.daily;

/**
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-07-23 08:54
 **/
public class LeetCode_64_II {
    public static void main(String[] args) {
        LeetCode_64_II leetCode = new LeetCode_64_II();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.minPathSum1(TestCase.GRID));
    }

    /**
     * 解法一：
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int lenY = grid.length;
        int lenX = grid[0].length;
        for(int y = 0; y < lenY; y ++) {
            for(int x = 0; x < lenX; x ++) {
                if(y==0 && x == 0) {

                } else if(y>=1 && x ==0) {
                    grid[y][0] = grid[y-1][0]+grid[y][x];
                } else if(x>=1 && y == 0) {
                    grid[0][x] = grid[0][x-1]+grid[y][x];
                } else {
                    grid[y][x] = Math.min(grid[y-1][x], grid[y][x-1]) + grid[y][x];
                }
            }

        }
        return grid[lenY-1][lenX-1];
    }

    /**
     * 解法二：
     *
     * 滚动数组
     *
     * @param grid
     * @return
     */
    private int minPathSum1(int[][] grid) {
        int lenY = grid.length;
        int lenX =grid[0].length;
        int[] dp = new int[lenX];
        dp[0] = grid[0][0];
        for(int y = 0; y < lenY; y ++) {
            for(int x = 0; x <lenX; x ++) {
                if(x==0 && y > 0) {
                    dp[x] = dp[x] + grid[y][0];
                } else if(y == 0 && x > 0) {
                    dp[x] = dp[x-1] + grid[0][x];
                } else if(x > 0) {
                    dp[x] = Math.min(dp[x], dp[x-1]) + grid[y][x];
                }
            }
        }

        return dp[lenX-1];
    }

    static class TestCase {
        public static int ANS = 7;
        public static int[][] GRID = {{1,3,1},{1,5,1},{4,2,1}};
    }
}
