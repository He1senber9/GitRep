package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Hard</p>
 * <p>题目：矩形区域不超过 K 的最大数值和</p>
 * <p>描述：给你一个 m x n 的矩阵 matrix 和一个整数 k ，找出并返回矩阵内部矩形区域的不超过 k 的最大数值和。
 *
 * 题目数据保证总会存在一个数值和不超过 k 的矩形区域。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,0,1],[0,-2,3]], k = 2
 * 输出：2
 * 解释：蓝色边框圈出来的矩形区域 [[0, 1], [-2, 3]] 的数值和是 2，且 2 是不超过 k 的最大数字（k = 2）。
 * 示例 2：
 *
 * 输入：matrix = [[2,2,-1]], k = 3
 * 输出：3
 *  
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -100 <= matrix[i][j] <= 100
 * -105 <= k <= 105
 *  
 *
 * 进阶：如果行数远大于列数，该如何设计解决方案？
 *
 * 通过次数9,730提交次数23,501
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @ClassName LeetCode_363
 * @Description TODO
 * @User fanyu
 * @Date 2021/4/22 8:31
 */
public class LeetCode_363 {
    public static void main(String[] args) {
        LeetCode_363 leetCode = new LeetCode_363();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.maxSumSubmatrix(TestCase.MATRIX, TestCase.K));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.maxSumSubmatrix(TestCase.MATRIX1, TestCase.K1));
    }

    /**
     * 解法一：
     *
     * @param matrix
     * @param k
     * @return
     */
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][][][] dp = new int[m][n][m][n];
        int max = Integer.MIN_VALUE;

        for(int y1 = 0; y1 < m; y1 ++) {
            for(int x1 = 0; x1 < n; x1 ++) {
                for(int y2 = y1; y2 < m; y2 ++) {
                    for(int x2 = x1; x2 < n; x2 ++) {
                        if(y1==y2 && x1==x2) {
                            dp[y1][x1][y2][x2] = matrix[y1][x1];
                        } else if(y1==y2) {
                            dp[y1][x1][y2][x2] = dp[y1][x1][y2][x2-1] + matrix[y2][x2];
                        } else if(x2==x1) {
                            dp[y1][x1][y2][x2] = dp[y1][x1][y2-1][x2] + matrix[y2][x2];
                        } else {
                            dp[y1][x1][y2][x2] = dp[y1][x1][y2 - 1][x2] + dp[y1][x1][y2][x2 - 1] - dp[y1][x1][y2 - 1][x2 - 1] + matrix[y2][x2];
                        }
                        if(dp[y1][x1][y2][x2] > k) {
                            continue;
                        } else if(dp[y1][x1][y2][x2] == k) {
                            return k;
                        } else {
                            max = Math.max(max, dp[y1][x1][y2][x2]);
                        }
                    }
                }
            }
        }
        return max;
    }

    public int maxSumSubmatrix1(int[][] matrix, int k) {
        int rows = matrix.length, cols = matrix[0].length, max = Integer.MIN_VALUE;
        for (int i1 = 1; i1 <= rows; i1++) {
            for (int j1 = 1; j1 <= cols; j1++) {
                int[][] dp = new int[rows + 1][cols + 1]; // renew  // from (i1,j1) to (i2,j2)
                dp[i1][j1] = matrix[i1 - 1][j1 - 1];
                for (int i2 = i1; i2 <= rows; i2++) {
                    for (int j2 = j1; j2 <= cols; j2++) {
                        dp[i2][j2] = dp[i2 - 1][j2] + dp[i2][j2 - 1] - dp[i2 - 1][j2 - 1] + matrix[i2 - 1][j2 - 1];
                        if (dp[i2][j2] <= k && dp[i2][j2] > max) {
                            max = dp[i2][j2];
                        }
                    }
                }
            }
        }
        return max;
    }

    static class TestCase {
        public static int ANS = 2;
        public static int[][] MATRIX = {{1,0,1},{0,-2,3}};
        public static int K = 2;

        public static int ANS1 = 3;
        public static int[][] MATRIX1 = {{2,2,-1}};
        public static int K1 = 3;
    }
}
