package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Midum</p>
 * <p>题目：矩阵旋转</p>
 * <p>描述：给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 *
 * 不占用额外内存空间能否做到？
 *
 *  
 *
 * 示例 1:
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * 示例 2:
 *
 * 给定 matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 * 通过次数10,190提交次数12,586
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-matrix-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: GitRep
 * @description:
 * @author: vann
 * @create: 2020-04-07 13:57
 **/
public class LeetCode_1017 {
    public static void main(String[] args) {
        LeetCode_1017 leetCode = new LeetCode_1017();

        leetCode.rotate(TestCase.matrix);
        System.out.println("Result[] : " + TestCase.matrix);

        leetCode.rotate(TestCase.matrix1);
        System.out.println("Result[] : " + TestCase.matrix1);

        leetCode.rotate(TestCase.matrix2);
        System.out.println("Result[] : " + TestCase.matrix2);
    }

    /**
     * 解法一：采用辅助空间
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return;
        }

        int lenY = matrix.length;
        int lenX = matrix[0].length;

        int[][] newMatrix = new int[lenY][lenX];
        for(int y = 0; y < lenY; y ++) {
            for(int x = 0; x < lenX; x ++) {
                newMatrix[y][x] = matrix[y][x];
            }
        }

        for(int y = 0; y < lenY; y ++) {
            for(int x = 0; x < lenX; x ++) {
                matrix[x][lenY-y-1] = newMatrix[y][x];
            }
        }

        System.out.println("Success");
    }

    static class TestCase {
        public static int[][] ans = {{7,4,1},{8,5,2},{9,6,3}};
        public static int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};

        public static int[][] ans1 = {{15,13, 2, 5},{14, 3, 4, 1},{12, 6, 8, 9},{16, 7,10,11}};
        public static int[][] matrix1 = {{5, 1, 9,11},{ 2, 4, 8,10},{13, 3, 6, 7},{15,14,12,16}};

        public static int[][] ans2 = {};
        public static int[][] matrix2 = {};
    }
}
