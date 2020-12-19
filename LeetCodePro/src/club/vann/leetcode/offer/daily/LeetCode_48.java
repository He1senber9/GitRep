package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Medium</p>
 * <p>题目：旋转图像</p>
 * <p>描述：给定一个 n × n 的二维矩阵表示一个图像。
 *
 * 将图像顺时针旋转 90 度。
 *
 * 说明：
 *
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
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
 * 通过次数116,706提交次数165,260
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-image
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/12/19
 * Time: 10:03
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_48 {
    public static void main(String[] args) {
        LeetCode_48 leetCode = new LeetCode_48();

//        leetCode.rotate1(TestCase.MATRIX);
        leetCode.rotate1(TestCase.MATRIX1);

        System.out.println("Success");
    }

    /**
     * 解法一：
     * 采用辅助矩阵
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // 辅助矩阵
        int[][] tags = new int[n][n];
        for(int y = 0; y < n; y ++) {
            int newX = n - 1 - y;
            for(int x = 0; x < n; x ++) {
                tags[x][newX] = matrix[y][x];
            }
        }
        matrix = tags;
    }

    /**
     * 解法一：
     * 原地解法
     * @param matrix
     */
    public void rotate1(int[][] matrix) {
        int n = matrix.length;

        // 先进行 y 坐标逆序
        for(int y = 0; y < (n+1)/2; y ++) {
            for(int x = 0; x < n; x ++) {
                int temp = matrix[y][x];
                matrix[y][x] = matrix[n-1-y][x];
                matrix[n-1-y][x] = temp;
            }
        }

        // 然后进行对称翻转
        for(int y = 0; y < n; y ++) {
            for(int x = 0; x <= y; x ++) {
                int temp = matrix[y][x];
                matrix[y][x] = matrix[x][y];
                matrix[x][y] = temp;
            }
        }
    }

    static class TestCase {
        public static int[][] MATRIX = {{1,2,3},{4,5,6},{7,8,9}};
        public static int[][] MATRIX1 = {{1,2},{3,4}};
    }
}
