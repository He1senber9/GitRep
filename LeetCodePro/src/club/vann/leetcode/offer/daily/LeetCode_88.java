package club.vann.leetcode.offer.daily;

import java.util.Arrays;

/**
 * <p>难度：Easy</p>
 * <p></p>
 * <p></p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2021/4/5
 * Time: 8:22
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_88 {
    public static void main(String[] args) {
        LeetCode_88 leetCode = new LeetCode_88();

        leetCode.merge(TestCase.NUMS1, TestCase.M, TestCase.NUMS2, TestCase.N);
        leetCode.merge(TestCase.NUMS12, TestCase.M12, TestCase.NUMS22, TestCase.N22);
        leetCode.merge(TestCase.NUMS13, TestCase.M13, TestCase.NUMS23, TestCase.N23);
        System.out.println("Success");
    }

    /**
     * 解法一：
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }

        if(n == 0) {
            return;
        }

        int index = m + n - 1;
        while(m > 0 && n > 0) {

            if(nums1[m-1] >= nums2[n-1]) {
                nums1[index] = nums1[m-1];
                m --;
            } else {
                nums1[index] = nums2[n-1];
                n --;
            }

            index --;
        }

        if(n > 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
        }
    }

    static class TestCase {
        public static int[] NUMS1 = {1,2,3,0,0,0};
        public static int M = 3;
        public static int[] NUMS2 = {2,5,6};
        public static int N = 3;

        public static int[] NUMS12 = {7,8,9,0,0,0};
        public static int M12 = 3;
        public static int[] NUMS22 = {2,5,6};
        public static int N22 = 3;

        public static int[] NUMS13 = {0};
        public static int M13 = 0;
        public static int[] NUMS23 = {1};
        public static int N23 = 1;
    }
}
