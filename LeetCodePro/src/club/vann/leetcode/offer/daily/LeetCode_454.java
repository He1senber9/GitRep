package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Medium</p>
 * <p>题目：四数相加II</p>
 * <p>描述：给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 *
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 *
 * 例如:
 *
 * 输入:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 *
 * 输出:
 * 2
 *
 * 解释:
 * 两个元组如下:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 * 通过次数32,219提交次数56,503
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: LeetCodePro
 * @description:
 * @author: vann
 * @create: 2020-11-27 08:29
 **/
public class LeetCode_454 {
    public static void main(String[] args) {
        LeetCode_454 leetCode = new LeetCode_454();

        System.out.println("Result["+TestCase.ANS+"] :" + leetCode.fourSumCount(TestCase.PARAMS[0], TestCase.PARAMS[1], TestCase.PARAMS[2], TestCase.PARAMS[3]));
        System.out.println("Result["+TestCase.ANS1+"] :" + leetCode.fourSumCount(TestCase.PARAMS1[0], TestCase.PARAMS1[1], TestCase.PARAMS1[2], TestCase.PARAMS1[3]));
        System.out.println("Result["+TestCase.ANS2+"] :" + leetCode.fourSumCount(TestCase.PARAMS2[0], TestCase.PARAMS2[1], TestCase.PARAMS2[2], TestCase.PARAMS2[3]));
        System.out.println("Result["+TestCase.ANS3+"] :" + leetCode.fourSumCount(TestCase.PARAMS3[0], TestCase.PARAMS3[1], TestCase.PARAMS3[2], TestCase.PARAMS3[3]));
    }

    private static int ans = 0;
    /**
     * 解法一：
     * 回溯算法
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int n = A.length;
        int[][] arr = new int[4][n];
        arr[0] = A;
        arr[1] = B;
        arr[2] = C;
        arr[3] = D;

        help(arr, 0, n, 0);
        return ans;
    }

    private void help(int[][] arr, int tag, int n, int k) {
        if(k >= 4) {
            if(tag == 0) {
                ans ++;
            }
            return;
        }

        for(int i = 0; i < n; i ++) {
            tag += arr[k][i];
            help(arr, tag, n, k+1);
            tag -= arr[k][i];
        }
    }

    static class TestCase {
        public static int ANS = 2;
        public static int[][] PARAMS = {{1, 2}, {-2, -1}, {-1, 2}, {0, 2}};

        public static int ANS1 = 16;
        public static int[][] PARAMS1 = {{0, 0}, {0, 0}, {0, 0}, {0, 0}};

        public static int ANS2 = 0;
        public static int[][] PARAMS2 = {{}, {}, {}, {}};

        public static int ANS3 = 100000018;
        public static int[][] PARAMS3 = {{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};

    }
}
