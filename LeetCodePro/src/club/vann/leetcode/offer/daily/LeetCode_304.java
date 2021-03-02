package club.vann.leetcode.offer.daily;

import java.util.Arrays;

/**
 * <p>难度：Medium</p>
 * <p>题目：二维区域和检索：-矩阵不可变</p>
 * <p></p>
 * @author vann
 * @program GitRep
 * @description
 * @date 2021-03-02:08:28:33
 */
public class LeetCode_304 {
    public static void main(String[] args) {
        NumMatrix matrix = new LeetCode_304().new NumMatrix(TestCase.MATRIX);
        System.out.println(matrix.sumRegion(2,1,4,3));
        System.out.println(matrix.sumRegion(1,1,2,2));
        System.out.println(matrix.sumRegion(1,2,2,4));

        NumMatrix matrix1 = new LeetCode_304().new NumMatrix(new int[][]{});

        NumMatrix matrix2 = new LeetCode_304().new NumMatrix(new int[][]{{-1}});
        System.out.println(matrix2.sumRegion(0,0,0,0));
    }

    class NumMatrix {
        private int[][] matrix;
        private int[][] preSum;

        public NumMatrix(int[][] matrix) {
            if(matrix.length == 0 || matrix[0].length == 0) {
                return;
            }
            this.matrix = matrix;
            int y = matrix.length;
            int x = matrix[0].length;

            // [i][j]表示以[0,0]为左上坐标，[i-1][j-1]为右下坐标的矩阵和
            preSum = new int[y+1][x+1];
            preSum[1][1] = matrix[0][0];

            for(int i = 1; i < y; i ++) {
//                preSum[i][0] = 0;
                preSum[i+1][1] = preSum[i][1] + matrix[i][0];
            }

            for(int i = 1; i < x; i ++) {
//                preSum[0][i] = 0;
                preSum[1][i+1] = preSum[1][i] + matrix[0][i];
            }

            for(int i = 1; i < y; i ++) {
                for(int j = 1; j < x; j ++) {
                    preSum[i+1][j+1] = preSum[i+1][j] + matrix[i][j] + preSum[i][j+1] - preSum[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return preSum[row2+1][col2+1] - preSum[row2+1][col1] - (preSum[row1][col2+1] - preSum[row1][col1]);
        }
    }

    static class TestCase {
        public static int[][] MATRIX = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
    }
}
