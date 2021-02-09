package club.vann.leetcode.offer.daily;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>难度：Hard</p>
 * <p>题目：K个不同整数的子数组</p>
 * <p>描述：给定一个正整数数组 A，如果 A 的某个子数组中不同整数的个数恰好为 K，则称 A 的这个连续、不一定独立的子数组为好子数组。
 *
 * （例如，[1,2,3,1,2] 中有 3 个不同的整数：1，2，以及 3。）
 *
 * 返回 A 中好子数组的数目。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：A = [1,2,1,2,3], K = 2
 * 输出：7
 * 解释：恰好由 2 个不同整数组成的子数组：[1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
 * 示例 2：
 *
 * 输入：A = [1,2,1,3,4], K = 3
 * 输出：3
 * 解释：恰好由 3 个不同整数组成的子数组：[1,2,1,3], [2,1,3], [1,3,4].
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 20000
 * 1 <= A[i] <= A.length
 * 1 <= K <= A.length
 * 通过次数7,226提交次数20,708
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarrays-with-k-different-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @author vann
 * @program GitRep
 * @description
 * @date 2021-02-09:08:46:09
 */
public class LeetCode_992 {
    public static void main(String[] args) {
        LeetCode_992 leetCode = new LeetCode_992();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.subarraysWithKDistinct1(TestCase.A, TestCase.K));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.subarraysWithKDistinct1(TestCase.A1, TestCase.K1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.subarraysWithKDistinct1(TestCase.A2, TestCase.K2));
    }

    /**
     * 解法一：
     *  暴力破解；
     * @param A
     * @param K
     * @return
     */
    public int subarraysWithKDistinct(int[] A, int K) {
        int len = A.length;
        int res = 0;
        for(int i = 0; i <= len-K; i ++) {
            for(int j = i+K-1; j < len; j ++) {
                if(isCount(A, i, j, K)) {
                    res ++;
                }
            }
        }
        return res;
    }

    private boolean isCount(int[] A, int left, int right, int K) {
        Set<Integer> set = new HashSet<>();
        for(int i = left; i <= right; i ++) {
            set.add(A[i]);
        }
        return set.size() == K;
    }

    /**
     * 解法二：
     * 双指针
     *
     * @param A
     * @param K
     * @return
     */
    public int subarraysWithKDistinct1(int[] A, int K) {
        return atMostKSubLen(A, K) - atMostKSubLen(A, K-1);
    }

    /**
     * A的子数组中最多包含K的不同整数的个数。
     * @param A
     * @param K
     * @return
     */
    public int atMostKSubLen(int[] A, int K) {
        int len = A.length;
        int res = 0;

        // 1<=A[i]<=A.length
        int[] freq = new int[len+1];

        int left = 0, right = 0;
        // [left,right)记录不同整数的个数
        int count = 0;

        while(right < len) {
            int rightVal = A[right];
            // 只统计未出现的字符
            if(freq[rightVal] == 0) {
                count ++;
            }

            freq[rightVal] ++;
            right ++;

            // 如果当前整数个数大于K，需要 left右移
            while(count > K) {
                int leftVal = A[left];
                freq[leftVal] --;
                if(freq[leftVal] == 0) {
                    count --;
                }
                left ++;
            }

            res += right - left;
        }
        return res;
    }

    static class TestCase {
        public static int ANS = 7;
        public static int[] A = {1,2,1,2,3};
        public static int K = 2;

        public static int ANS1 = 3;
        public static int[] A1 = {1,2,1,2,3};
        public static int K1 = 3;

        public static int ANS2 = 3;
        public static int[] A2 = {1,2,1,3,4};
        public static int K2 = 3;
    }
}
