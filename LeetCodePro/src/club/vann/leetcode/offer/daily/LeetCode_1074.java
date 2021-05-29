package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Hard</p>
 * <p>题目：元素和为目标值的子矩阵数量</p>
 * <p>描述：给出矩阵 matrix 和目标值 target，返回元素总和等于目标值的非空子矩阵的数量。
 *
 * 子矩阵 x1, y1, x2, y2 是满足 x1 <= x <= x2 且 y1 <= y <= y2 的所有单元 matrix[x][y] 的集合。
 *
 * 如果 (x1, y1, x2, y2) 和 (x1', y1', x2', y2') 两个子矩阵中部分坐标不同（如：x1 != x1'），那么这两个子矩阵也不同。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：matrix = [[0,1,0],[1,1,1],[0,1,0]], target = 0
 * 输出：4
 * 解释：四个只含 0 的 1x1 子矩阵。
 * 示例 2：
 *
 * 输入：matrix = [[1,-1],[-1,1]], target = 0
 * 输出：5
 * 解释：两个 1x2 子矩阵，加上两个 2x1 子矩阵，再加上一个 2x2 子矩阵。
 * 示例 3：
 *
 * 输入：matrix = [[904]], target = 0
 * 输出：0
 *  
 *
 * 提示：
 *
 * 1 <= matrix.length <= 100
 * 1 <= matrix[0].length <= 100
 * -1000 <= matrix[i] <= 1000
 * -10^8 <= target <= 10^8
 * 通过次数4,634提交次数8,527
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-submatrices-that-sum-to-target
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @description:
 * @program: GitRep
 * @author: fanyu
 * @create: 2021-05-29  08:58:50
 */
public class LeetCode_1074 {
    public static void main(String[] args) {
        LeetCode_1074 leetCode = new LeetCode_1074();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.numSubmatrixSumTarget(TestCase.MATRIX, TestCase.TARGET));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.numSubmatrixSumTarget(TestCase.MATRIX1, TestCase.TARGET1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.numSubmatrixSumTarget(TestCase.MATRIX2, TestCase.TARGET2));
    }

    /**
     * 解法一：
     *
     * @param matrix
     * @param target
     * @return
     */
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        // 前缀和
        int[][] sums = new int[m][n];
        sums[0][0] = matrix[0][0];
        for(int i = 1; i < m; i ++) {
            sums[i][0] = sums[i-1][0] + matrix[i][0];
        }
        for(int j = 1; j < m; j ++) {
            sums[0][j] = sums[0][j-1] + matrix[0][j];
        }

        for(int i = 1; i < m; i ++) {
            for(int j = 1; j < n; j ++) {
                sums[i][j] = sums[i-1][j] + sums[i][j-1] - sums[i-1][j-1] + matrix[i][j];
            }
        }

        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j ++) {

            }
        }
        return 0;
    }

    static class TestCase {
        public static int ANS = 4;
        public static int[][] MATRIX = {{0, 1, 0}, {1, 1, 1}, {0, 1, 0}};
        public static int TARGET = 0;

        public static int ANS1 = 0;
        public static int[][] MATRIX1 = {{904}};
        public static int TARGET1 = 0;

        public static int ANS2 = 5;
        public static int[][] MATRIX2 = {{1, -1}, {-1, 1}};
        public static int TARGET2 = 0;
    }
}
