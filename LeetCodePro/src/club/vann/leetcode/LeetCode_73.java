package club.vann.leetcode;

import java.util.Arrays;

/**
 *  <p>难度：Midum</p>
 *  <p>题目：矩阵置零</p>
 *  <p>描述：给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * 示例 2:
 *
 * 输入:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 * 进阶:
 *
 * 一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个常数空间的解决方案吗？
 * 通过次数34,028提交次数61,706
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/set-matrix-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/4/2
 * Time: 10:17
 * Description:
 */
public class LeetCode_73 {
    public static void main(String[] args) {
        LeetCode_73 leetCode = new LeetCode_73();

        leetCode.setZeroes2(TestCase.matrix);

        leetCode.setZeroes2(TestCase.matrix1);
    }

    /**
     * 解法一：
     * 采用镜像辅助。
     * @param matrix
     */
    private void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return;
        }

        int lenY = matrix.length;
        int lenX = matrix[0].length;

        // 镜像
        int[][] minor = new int[lenY][lenX];

        for(int y = 0; y < lenY; y ++) {
            for(int x = 0; x < lenX; x ++) {
                minor[y][x] = matrix[y][x];
            }
        }

        // 用于找到行和列上的元素
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        for(int y = 0; y < lenY; y ++) {
            for(int x = 0; x < lenX; x ++) {
                int v = minor[y][x];

                if(v == 0) {
                    for(int k = 0; k < 4; k ++) {
                        int newY = y+dr[k];
                        int newX = x+dc[k];
                        while(newY>=0 && newY<lenY && newX>=0 && newX<lenX) {
                            matrix[newY][newX] = 0;
                            newY+=dr[k];
                            newX+=dc[k];
                        }
                    }
                }
            }
        }
        System.out.println(Arrays.toString(matrix));
    }

    /**
     * 解法二：
     * 时间复杂度：O(m*n)
     * 空间复杂度：O(1)
     * 采用原地解法，当前元素为0时，标记当前行与当前列上不为0的元素为一个特殊值（Integer.MIN_VALUE)。
     * 再次遍历，把特殊值的位置都替换成0
     * 时间复杂度：O(m*n)
     * @param matrix
     */
    private void setZeroes2(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return;
        }

        int lenY = matrix.length;
        int lenX = matrix[0].length;

        for(int y = 0; y < lenY; y ++) {
            for(int x = 0; x < lenX; x ++) {
                if(matrix[y][x] == 0) {
                    for(int tmpY = 0; tmpY < lenY; tmpY ++) {
                        if(matrix[tmpY][x] != 0) {
                            matrix[tmpY][x] = Integer.MIN_VALUE;
                        }
                    }

                    for(int tmpX = 0; tmpX < lenX; tmpX ++) {
                        if(matrix[y][tmpX] != 0) {
                            matrix[y][tmpX] = Integer.MIN_VALUE;
                        }
                    }
                }
            }
        }

        for(int y = 0; y < lenY; y ++) {
            for(int x = 0; x < lenX; x ++) {
                if(matrix[y][x] == Integer.MIN_VALUE) {
                    matrix[y][x] = 0;
                }
            }
        }

        System.out.println(Arrays.toString(matrix));
    }

    /**
     * 解法三：
     * @param matrix
     */
    private void setZeroes3(int[][] matrix) {

    }

    static class TestCase {
        public static int[][] ans_matrix = {{1,0,1}, {0,0,0}, {1,0,1}};
        public static int[][] matrix = {{1,1,1}, {1,0,1}, {1,1,1}};

        public static int[][] ans_matrix1 = {{0,0,0,0}, {0,4,5,0}, {0,3,1,0}};
        public static int[][] matrix1 = {{0,1,2,0}, {3,4,5,2}, {1,3,1,5}};

        public static int[][] ans_matrix2 = {};
        public static int[][] matrix2 = {};

    }
}
