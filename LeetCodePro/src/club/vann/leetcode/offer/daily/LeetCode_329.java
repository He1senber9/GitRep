package club.vann.leetcode.offer.daily;

/**
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/7/26
 * Time: 10:26
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_329 {
    public static void main(String[] args) {
        LeetCode_329 leetCode = new LeetCode_329();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.longestIncreasingPath(TestCase.MATRIX));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.longestIncreasingPath(TestCase.MATRIX1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.longestIncreasingPath(TestCase.MATRIX2));
    }

    /**
     * 解法一：
     *
     * @param matrix
     * @return
     */
    private int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] memo = new int[rows][columns];
        int ans = 0;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                ans = Math.max(ans, dfs(matrix, i, j, memo));
            }
        }
        return ans;
    }

    int[][] dirs = {{-1,0}, {1,0}, {0,-1},{0,1}};
    private int dfs(int[][] matrix, int row, int column, int[][] memo) {
        if (memo[row][column] != 0) {
            return memo[row][column];
        }
        ++memo[row][column];
        for (int[] dir : dirs) {
            int newRow = row + dir[0], newColumn = column + dir[1];
            if (newRow >= 0 && newRow < matrix.length && newColumn >= 0 && newColumn < matrix[0].length && matrix[newRow][newColumn] > matrix[row][column]) {
                memo[row][column] = Math.max(memo[row][column], dfs(matrix, newRow, newColumn, memo) + 1);
            }
        }
        return memo[row][column];
    }

    static class TestCase {
        public static int ANS = 4;
        public static int[][] MATRIX = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};

        public static int ANS1 = 4;
        public static int[][] MATRIX1 = {{3, 4, 5}, {3, 2, 6}, {2, 2, 1}};

        public static int ANS2 = 4;
        public static int[][] MATRIX2 = {{7, 7, 5}, {2, 4, 6}, {8, 2, 0}};
    }
}
