package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Hard</p>
 * <p>题目：最大矩形</p>
 * <p>描述：给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：6
 * 解释：最大矩形如上图所示。
 * 示例 2：
 *
 * 输入：matrix = []
 * 输出：0
 * 示例 3：
 *
 * 输入：matrix = [["0"]]
 * 输出：0
 * 示例 4：
 *
 * 输入：matrix = [["1"]]
 * 输出：1
 * 示例 5：
 *
 * 输入：matrix = [["0","0"]]
 * 输出：0
 *  
 *
 * 提示：
 *
 * rows == matrix.length
 * cols == matrix[0].length
 * 0 <= row, cols <= 200
 * matrix[i][j] 为 '0' 或 '1'
 * 通过次数50,262提交次数102,538
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximal-rectangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-12-26 08:58
 **/
public class LeetCode_85 {
    public static void main(String[] args) {
        LeetCode_85 leetCode = new LeetCode_85();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.maximalRectangle(TestCase.MATRIX));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.maximalRectangle(TestCase.MATRIX1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.maximalRectangle(TestCase.MATRIX2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.maximalRectangle(TestCase.MATRIX3));
        System.out.println("Result["+TestCase.ANS4+"] : " + leetCode.maximalRectangle(TestCase.MATRIX4));
        System.out.println("Result["+TestCase.ANS5+"] : " + leetCode.maximalRectangle(TestCase.MATRIX5));
        System.out.println("Result["+TestCase.ANS6+"] : " + leetCode.maximalRectangle(TestCase.MATRIX6));
    }

    /**
     * 解法一：
     *
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int max = 0;
        for(int y = 0; y < rows; y ++) {
            for(int x = 0; x < cols; x ++) {
                if(matrix[y][x] == '1') {
                    max = Math.max(max, maxRect(matrix, rows, cols, y, x));
                }
            }
        }

        return max;
    }

    // 计算yi[y,x]为原点的矩形面积
    private int maxRect(char[][] matrix, int rows, int cols, int y, int x) {
        int sum = 0;
        int rectY = rows; // 矩形高度
        int rectX = cols; // 矩形宽度

        int lenY = 0;
        for(int newY = y; newY < rows; newY ++) {
            if(matrix[newY][x] != '1') {
                rectY = Math.min(rectY, lenY);
                break;
            }
            lenY ++;

            int lenX = 0;
            for(int newX = x; newX < cols; newX ++) {
                if(matrix[newY][newX] == '1') {
                    lenX += 1;
//                    matrix[newY][newX] = '2'; // 测试用
                } else {
                    break;
                }
            }
            rectX = Math.min(rectX, lenX);
            sum = Math.max(sum, rectX * lenY);
        }

        rectY = Math.min(rectY, lenY);

        // 方便测试
        for(int tempY = y; y < rows; y ++) {
            for(int tempX = x; x < cols; x ++) {
                if(matrix[tempY][tempX] == '2') {
                    matrix[tempY][tempX] = '1';
                }
            }
        }

        return sum;
    }

    static class TestCase {
        public static int ANS = 6;
        public static char[][] MATRIX = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};

        public static int ANS1 = 0;
        public static char[][] MATRIX1 = {};

        public static int ANS2 = 0;
        public static char[][] MATRIX2 = {{'0'}};

        public static int ANS3 = 1;
        public static char[][] MATRIX3 = {{'1'}};

        public static int ANS4 = 0;
        public static char[][] MATRIX4 = {{'0','0'}};

        public static int ANS5 = 1;
        public static char[][] MATRIX5 = {{'1','0'},{'0','1'}};

        public static int ANS6 = 21;
        public static char[][] MATRIX6 = {{'1','1','1','1','1','1','1','1'},{'1','1','1','1','1','1','1','0'}, {'1','1','1','1','1','1','1','0'},{'1','1','1','1','1','0','0','0'},{'0','1','1','1','1','0','0','0'}};

    }
}
