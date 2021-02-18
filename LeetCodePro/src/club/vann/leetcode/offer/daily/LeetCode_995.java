package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Hard</p>
 * <p>题目：K 连续位的最小翻转次数</p>
 * <p>描述：在仅包含 0 和 1 的数组 A 中，一次 K 位翻转包括选择一个长度为 K 的（连续）子数组，同时将子数组中的每个 0 更改为 1，而每个 1 更改为 0。
 *
 * 返回所需的 K 位翻转的最小次数，以便数组没有值为 0 的元素。如果不可能，返回 -1。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：A = [0,1,0], K = 1
 * 输出：2
 * 解释：先翻转 A[0]，然后翻转 A[2]。
 * 示例 2：
 *
 * 输入：A = [1,1,0], K = 2
 * 输出：-1
 * 解释：无论我们怎样翻转大小为 2 的子数组，我们都不能使数组变为 [1,1,1]。
 * 示例 3：
 *
 * 输入：A = [0,0,0,1,0,1,1,0], K = 3
 * 输出：3
 * 解释：
 * 翻转 A[0],A[1],A[2]: A变成 [1,1,1,1,0,1,1,0]
 * 翻转 A[4],A[5],A[6]: A变成 [1,1,1,1,1,0,0,0]
 * 翻转 A[5],A[6],A[7]: A变成 [1,1,1,1,1,1,1,1]
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 30000
 * 1 <= K <= A.length
 * 通过次数3,602提交次数7,893
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-number-of-k-consecutive-bit-flips
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @author vann
 * @program GitRep
 * @description
 * @date 2021-02-18:08:18:28
 */
public class LeetCode_995 {
    public static void main(String[] args) {
        LeetCode_995 leetCode = new LeetCode_995();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.minKBitFlips1(TestCase.A, TestCase.K));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.minKBitFlips1(TestCase.A1, TestCase.K1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.minKBitFlips1(TestCase.A2, TestCase.K2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.minKBitFlips1(TestCase.A3, TestCase.K3));
        System.out.println("Result["+TestCase.ANS4+"] : " + leetCode.minKBitFlips1(TestCase.A4, TestCase.K4));
    }

    /**
     * 解法一：
     * 超时。
     * @param A
     * @param K
     * @return
     */
    public int minKBitFlips(int[] A, int K) {
        int len = A.length;
        int res = 0;

        int index = 0;
        while(index < len) {
            if(A[index] == 1) {
                index ++;
                continue;
            }

            if(index + K > len) {
                return -1;
            }

            int newIndex = index+K;
            // 翻转[left,right]区间
            res ++;
            for(int i = index; i < index+K; i ++) {
                A[i] = (A[i] == 0) ? 1 : 0;
                if(newIndex == index+K && A[i] == 0) {
                    newIndex = i;
                }
            }

            index = newIndex;
        }
        return res;
    }

    /**
     * 解法二：
     * 差分数组
     * @param A
     * @param K
     * @return
     */
    public int minKBitFlips1(int[] A, int K) {
        int n = A.length;
        int[] diff = new int[n + 1];
        int ans = 0, revCnt = 0;
        for (int i = 0; i < n; ++i) {
            revCnt += diff[i];
            if ((A[i] + revCnt) % 2 == 0) {
                if (i + K > n) {
                    return -1;
                }
                ++ans;
                ++revCnt;
                --diff[i + K];
            }
        }
        return ans;
    }

    static class TestCase {
        public static int ANS = 2;
        public static int[] A = {0,1,0};
        public static int K = 1;

        public static int ANS1 = -1;
        public static int[] A1 = {1,1,0};
        public static int K1 = 2;

        public static int ANS2 = 3;
        public static int[] A2 = {0,0,0,1,0,1,1,0};
        public static int K2 = 3;

        public static int ANS3 = -1;
        public static int[] A3 = {1,1,0,0,1,0,1,1};
        public static int K3 = 2;

        public static int ANS4 = -1;
        public static int[] A4 = {1,1,0,0,1,0,1,1};
        public static int K4 = 3;
    }
}
