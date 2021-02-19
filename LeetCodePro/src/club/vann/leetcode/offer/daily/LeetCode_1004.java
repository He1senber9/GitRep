package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Medium</p>
 * <p>题目：大连续1的个数 III</p>
 * <p>描述：给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
 *
 * 返回仅包含 1 的最长（连续）子数组的长度。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：
 * [1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 * 示例 2：
 *
 * 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：
 * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 20000
 * 0 <= K <= A.length
 * A[i] 为 0 或 1 
 * 通过次数23,245提交次数40,465
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-consecutive-ones-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @author vann
 * @program GitRep
 * @description
 * @date 2021-02-19:08:31:59
 */
public class LeetCode_1004 {
    public static void main(String[] args) {
        LeetCode_1004 leetCode = new LeetCode_1004();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.longestOnes1(TestCase.A, TestCase.K));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.longestOnes1(TestCase.A1, TestCase.K1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.longestOnes1(TestCase.A2, TestCase.K2));
    }

    /**
     *
     * @param A
     * @param K
     * @return
     */
    public int longestOnes(int[] A, int K) {
        int len = A.length;
        int max = 0;
        int count1 = 0;
        int countK = 0;
        int left = 0, right = 0;
        while(right < len) {
            if(A[right] == 0) {
                countK ++;
            }

            count1 ++;

            if(countK > K) {
                // 计算结果
                max = Math.max(max, count1-1);
                // 从左向右找第一个0的位置
                while(A[left] == 1) {
                    count1 --;
                    left ++;
                    continue;
                }

                left ++;
                count1 --;
                countK --;
            }

            right ++;
        }

        max = Math.max(max, right-left);
        return max;
    }

    public int longestOnes1(int[] A, int K) {
        int len = A.length;
        int left = 0, right = 0;
        while(right < len) {
            if(A[right] == 0) {
                K --;
            }
            right++;

            if(K < 0) {
                if(A[left] == 0) {
                    K ++;
                }
                left ++;
            }
        }

        return right - left;
    }

    static class TestCase {
        public static int ANS = 6;
        public static int[] A = {1,1,1,0,0,0,1,1,1,1,0};
        public static int K = 2;

        public static int ANS1 = 10 ;
        public static int[] A1 = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        public static int K1 = 3;

        public static int ANS2 = 4 ;
        public static int[] A2 = {0,0,0,1};
        public static int K2 = 4;

    }
}
