package club.vann.leetcode.race;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>描述：给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。
 *
 * 幸运数是指矩阵中满足同时下列两个条件的元素：
 *
 * 在同一行的所有元素中最小
 * 在同一列的所有元素中最大
 *
 *
 * 示例 1：
 *
 * 输入：matrix = [[3,7,8],[9,11,13],[15,16,17]]
 * 输出：[15]
 * 解释：15 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
 * 示例 2：
 *
 * 输入：matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
 * 输出：[12]
 * 解释：12 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
 * 示例 3：
 *
 * 输入：matrix = [[7,8],[1,2]]
 * 输出：[7]
 *
 *
 * 提示：
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= n, m <= 50
 * 1 <= matrix[i][j] <= 10^5
 * 矩阵中的所有元素都是不同的</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/3/18
 * Time: 21:58
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_1380 {
    public static void main(String[] args) {
        int[][] matrix = null;
        List<Integer> result = null;
        LeetCode_1380 leetCode = new LeetCode_1380();

        matrix = new int[][] {{3,7,8},{9,11,13}, {15,16,17}};
        result = leetCode.luckyNumbers(matrix);
        System.out.println("Result: " + result);

        matrix = new int[][] {{1,10,4,2},{9,3,8,7}, {15,16,17,12}};
        result = leetCode.luckyNumbers(matrix);
        System.out.println("Result: " + result);

        matrix = new int[][] {{7,8},{1,2}};
        result = leetCode.luckyNumbers(matrix);
        System.out.println("Result: " + result);
    }

    private List<Integer> luckyNumbers (int[][] matrix) {
        int lenY = matrix.length;
        int lenX = matrix[0].length;

        List<Integer> list = new ArrayList<Integer>();
        A: for(int y = 0; y < lenY; y ++) {
            int indexX = 0;
            int minVal = matrix[y][0];
            // 找每一行中的最小值
            for(int x = 1; x < lenX; x ++) {
                if(matrix[y][x] < minVal) {
                    indexX = x;
                    minVal = matrix[y][x];
                }
            }

            // 找到最小值后再看是不是这一列里的最大值
            int maxVal = minVal;
            for(int k = 0; k < lenY; k ++) {
                if(maxVal < matrix[k][indexX]) {
                    continue A;
                }

            }
            list.add(maxVal);
        }
        return list;
    }
}
