package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Medium</p>
 * <p>题目：翻转矩阵后的得分</p>
 * <p>描述：有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
 *
 * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
 *
 * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
 *
 * 返回尽可能高的分数。
 *
 *  
 *
 * 示例：
 *
 * 输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
 * 输出：39
 * 解释：
 * 转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
 * 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 20
 * 1 <= A[0].length <= 20
 * A[i][j] 是 0 或 1
 * 通过次数7,378提交次数9,663
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/score-after-flipping-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: LeetCodePro
 * @description:
 * @author: vann
 * @create: 2020-12-07 08:13
 **/
public class LeetCode_861 {
    public static void main(String[] args) {
        LeetCode_861 leetCode = new LeetCode_861();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.matrixScore(TestCase.NUMS));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.matrixScore(TestCase.NUMS1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.matrixScore(TestCase.NUMS2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.matrixScore(TestCase.NUMS3));
        System.out.println("Result["+TestCase.ANS4+"] : " + leetCode.matrixScore(TestCase.NUMS4));
    }

    /**
     * 解法一：
     * @param A
     * @return
     */
    public int matrixScore(int[][] A) {
        int m = A.length, n = A[0].length;
        int ret = m * (1 << (n - 1));

        for (int j = 1; j < n; j++) {
            int nOnes = 0;
            for (int i = 0; i < m; i++) {
                if (A[i][0] == 1) {
                    nOnes += A[i][j];
                } else {
                    nOnes += (1 - A[i][j]); // 如果这一行进行了行反转，则该元素的实际取值为 1 - A[i][j]
                }
            }
            int k = Math.max(nOnes, m - nOnes);
            ret += k * (1 << (n - j - 1));
        }
        return ret;
    }

    static class TestCase {
        public static int ANS = 39;
        public static int[][] NUMS = {{0,0,1,1}, {1,0,1,0}, {1,1,0,0}};

        public static int ANS1 = 1;
        public static int[][] NUMS1 = {{0}};

        public static int ANS2 = 6;
        public static int[][] NUMS2 = {{0,0},{1,1}};

        public static int ANS3 = 6;
        public static int[][] NUMS3 = {{0,1},{1,0}};

        public static int ANS4 = 1;
        public static int[][] NUMS4 = {{1}};
    }
}
