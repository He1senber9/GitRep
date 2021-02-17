package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Easy</p>
 * <p>题目：重塑矩阵</p>
 * <p>描述：在MATLAB中，有一个非常有用的函数 reshape，它可以将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。
 *
 * 给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。
 *
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。
 *
 * 如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 *
 * 示例 1:
 *
 * 输入:
 * nums =
 * [[1,2],
 *  [3,4]]
 * r = 1, c = 4
 * 输出:
 * [[1,2,3,4]]
 * 解释:
 * 行遍历nums的结果是 [1,2,3,4]。新的矩阵是 1 * 4 矩阵, 用之前的元素值一行一行填充新矩阵。
 * 示例 2:
 *
 * 输入:
 * nums =
 * [[1,2],
 *  [3,4]]
 * r = 2, c = 4
 * 输出:
 * [[1,2],
 *  [3,4]]
 * 解释:
 * 没有办法将 2 * 2 矩阵转化为 2 * 4 矩阵。 所以输出原矩阵。
 * 注意：
 *
 * 给定矩阵的宽和高范围在 [1, 100]。
 * 给定的 r 和 c 都是正数。
 * 通过次数29,768提交次数44,331
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reshape-the-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 *
 * @author vann
 * @program GitRep
 * @description
 * @date 2021-02-17:08:56:22
 */
public class LeetCode_566 {
    public static void main(String[] args) {
        LeetCode_566 leetCode = new LeetCode_566();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.matrixReshape(TestCase.NUMS, TestCase.R, TestCase.C));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.matrixReshape(TestCase.NUMS1, TestCase.R1, TestCase.C1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.matrixReshape(TestCase.NUMS2, TestCase.R2, TestCase.C2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.matrixReshape(TestCase.NUMS3, TestCase.R3, TestCase.C3));
        System.out.println("Result["+TestCase.ANS4+"] : " + leetCode.matrixReshape(TestCase.NUMS4, TestCase.R4, TestCase.C4));
    }

    /**
     * 解法一：
     *
     * @param nums
     * @param r
     * @param c
     * @return
     */
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int lenY = nums.length;
        int lenX = nums[0].length;

        if(r * c != lenY * lenX) {
            return nums;
        }

        int[][] res = new int[r][c];
        for(int i = 0; i < lenY; i ++) {
            for(int j = 0; j < lenX; j ++) {
                int newY = (i*lenX+j)/c;
                int newX = (i*lenX+j)%c;
                res[newY][newX] = nums[i][j];
            }
        }
        return res;
    }

    static class TestCase {
        public static int[][] ANS = {{1}, {2}, {3}, {4}};
        public static int[][] NUMS = {{1}, {2}, {3}, {4}};
        public static int R = 4;
        public static int C = 1;

        public static int[][] ANS1 = {{1, 2, 3, 4}};
        public static int[][] NUMS1 = {{1}, {2}, {3}, {4}};
        public static int R1 = 1;
        public static int C1 = 4;

        public static int[][] ANS2 = {{1, 2}, {3, 4}};
        public static int[][] NUMS2 = {{1, 2, 3, 4}};
        public static int R2 = 2;
        public static int C2 = 2;

        public static int[][] ANS3 = {{1, 2}, {3, 4}};
        public static int[][] NUMS3 = {{1, 2}, {3, 4}};
        public static int R3 = 2;
        public static int C3 = 2;

        public static int[][] ANS4 = {{1, 2, 3, 4}};
        public static int[][] NUMS4 = {{1, 2}, {3, 4}};
        public static int R4 = 1;
        public static int C4 = 4;
    }
}
