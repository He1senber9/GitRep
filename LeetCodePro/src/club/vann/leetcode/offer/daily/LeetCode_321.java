package club.vann.leetcode.offer.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * <p>难度：Hard</p>
 * <p>题目：拼接最大数</p>
 * <p>描述：给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。
 *
 * 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。
 *
 * 说明: 请尽可能地优化你算法的时间和空间复杂度。
 *
 * 示例 1:
 *
 * 输入:
 * nums1 = [3, 4, 6, 5]
 * nums2 = [9, 1, 2, 5, 8, 3]
 * k = 5
 * 输出:
 * [9, 8, 6, 5, 3]
 * 示例 2:
 *
 * 输入:
 * nums1 = [6, 7]
 * nums2 = [6, 0, 4]
 * k = 5
 * 输出:
 * [6, 7, 6, 0, 4]
 * 示例 3:
 *
 * 输入:
 * nums1 = [3, 9]
 * nums2 = [8, 9]
 * k = 3
 * 输出:
 * [9, 8, 9]
 * 通过次数6,811提交次数20,247
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/create-maximum-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: LeetCodePro
 * @description:
 * @author: vann
 * @create: 2020-12-02 08:38
 **/
public class LeetCode_321 {
    public static void main(String[] args) {
        LeetCode_321 leetCode = new LeetCode_321();

        System.out.println("Result["+Arrays.toString(TestCase.ANS)+"] : " + Arrays.toString(leetCode.maxNumber(TestCase.NUMS1, TestCase.NUMS2, TestCase.K)));
        System.out.println("Result["+Arrays.toString(TestCase.ANS1)+"] : " + Arrays.toString(leetCode.maxNumber(TestCase.NUMS11, TestCase.NUMS21, TestCase.K1)));
        System.out.println("Result["+Arrays.toString(TestCase.ANS2)+"] : " + Arrays.toString(leetCode.maxNumber(TestCase.NUMS12, TestCase.NUMS22, TestCase.K2)));
        System.out.println("Result["+Arrays.toString(TestCase.ANS3)+"] : " + Arrays.toString(leetCode.maxNumber(TestCase.NUMS13, TestCase.NUMS23, TestCase.K3)));
    }

    /**
     * 解法一：
     *  单调栈
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k];
        int m = nums1.length;
        int n = nums2.length;
        int start = Math.max(0, k - n), end = Math.min(k, m);
        for (int i = start; i <= end; i++) {
            int[] subsequence1 = maxSubsequence(nums1, i);
            int[] subsequence2 = maxSubsequence(nums2, k - i);
            int[] curMaxSubsequence = merge(subsequence1, subsequence2);
            if (compare(curMaxSubsequence, 0, ans, 0) > 0) {
                System.arraycopy(curMaxSubsequence, 0, ans, 0, k);
            }
        }

        return ans;
    }

    /**
     * 从指定数组中获取指定长度的最大序列。
     * @param nums
     * @param size
     * @return
     */
    private int[] maxSubsequence(int[] nums, int size) {
        int len = nums.length;
        int[] stack = new int[size];
        if(size == 0) {
            return stack;
        }

        int top = -1;
        int remain = len - size;

        for(int i = 0; i < len; i ++) {
            int num = nums[i];
            while(top >= 0 && stack[top] < num && remain > 0) {
                top --;
                remain --;
            }

            if(top < size - 1) {
                stack[++top] = num;
            } else {
                remain --;
            }
        }
        return stack;
    }

    /**
     * 合并两个序列。
     *
     * @param subsequence1
     * @param subsequence2
     * @return
     */
    private int[] merge(int[] subsequence1, int[] subsequence2) {
        int len1 = subsequence1.length;
        int len2 = subsequence2.length;

        if (len1 == 0) {
            return subsequence2;
        }
        if (len2 == 0) {
            return subsequence1;
        }

        int mergeLength = len1 + len2;
        int[] merged = new int[mergeLength];

        int index1 = 0, index2 = 0;
        for (int i = 0; i < mergeLength; i++) {
            if (compare(subsequence1, index1, subsequence2, index2) > 0) {
                merged[i] = subsequence1[index1++];
            } else {
                merged[i] = subsequence2[index2++];
            }
        }
        return merged;
    }

    /**
     * 比较两个序列指定位置的大小
     * @param subsequence1
     * @param index1
     * @param subsequence2
     * @param index2
     * @return
     */
    private int compare(int[] subsequence1, int index1, int[] subsequence2, int index2) {
        int x = subsequence1.length, y = subsequence2.length;
        while (index1 < x && index2 < y) {
            int difference = subsequence1[index1] - subsequence2[index2];
            if (difference != 0) {
                return difference;
            }
            index1++;
            index2++;
        }
        return (x - index1) - (y - index2);
    }

    static class TestCase {
        public static int[] ANS = {9, 8, 6, 5, 3};
        public static int[] NUMS1 = {3, 4, 6, 5};
        public static int[] NUMS2 = {9, 1, 2, 5, 8, 3};
        public static int K = 5;

        public static int[] ANS1 = {6, 7, 6, 0, 4};
        public static int[] NUMS11 = {6, 7};
        public static int[] NUMS21 = {6, 0, 4};
        public static int K1 = 5;

        public static int[] ANS2 = {9, 8, 9};
        public static int[] NUMS12 = {3, 9};
        public static int[] NUMS22 = {8, 9};
        public static int K2 = 3;

        public static int[] ANS3 = {6,7,6,0,4};
        public static int[] NUMS13 = {6,7};
        public static int[] NUMS23 = {6,0,4};
        public static int K3 = 5;

    }
}
