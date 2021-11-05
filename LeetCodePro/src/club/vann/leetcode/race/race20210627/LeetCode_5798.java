package club.vann.leetcode.race.race20210627;

/**
 * @description:
 * @program: GitRep
 * @author: fanyu
 * @create: 2021-06-27  10:51:28
 */
public class LeetCode_5798 {
    public static void main(String[] args) {
        LeetCode_5798 leetCode = new LeetCode_5798();

        int[][] result = null;

        result = leetCode.rotateGrid(TestCase.GRID, TestCase.K);
        result = leetCode.rotateGrid(TestCase.GRID1, TestCase.K1);
        System.out.println("Succss");
    }

    public int[][] rotateGrid(int[][] grid, int k) {
        for(int i = 0; i < k; i ++) {
            rotateGrid(grid);
        }
        return grid;
    }

    public int[][] rotateGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int left = 0, right = n-1, top = 0, bottom = m-1;

        int count = m*n;
        while(count > 0) {
            int tmp = grid[top][left];

            for(int i = left+1; i <= right; i ++) {
                grid[top][i-1] = grid[top][i];
                count --;
            }
            top ++;

            for(int i = top; i <= bottom; i ++) {
                grid[i-1][right] = grid[i][right];
                count --;
            }
            right --;

            for(int i = right; i >= left; i --) {
                grid[bottom][i+1] = grid[bottom][i];
                count --;
            }
            bottom --;

            for(int i = bottom; i >= top; i --) {
                grid[i+1][left] = grid[i][left];
                count --;
            }
            left ++;

            grid[top][left-1] = tmp;
            count --;
        }

        return grid;
    }

    static class TestCase {
        public static int[][] ANS = {{10, 20}, {40, 30}};
        public static int[][] GRID = {{40, 10}, {30, 20}};
        public static int K = 1;

        public static int[][] ANS1 = {{3, 4, 8, 12}, {2, 11, 10, 16}, {1, 7, 6, 15}, {5, 9, 13, 14}};
        public static int[][] GRID1 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        public static int K1 = 2;
    }
}
