package club.vann.leetcode.offer.daily;

import java.util.Arrays;

/**
 * @program: GitRep
 * @description:
 * @author: fanyu
 * @create: 2021/11/06 08:38
 */
public class LeetCode_268 {
    public static void main(String[] args) {
        LeetCode_268 leetCode = new LeetCode_268();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.missingNumber(TestCase.NUMS));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.missingNumber(TestCase.NUMS1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.missingNumber(TestCase.NUMS2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.missingNumber(TestCase.NUMS3));
    }

    /**
     * 解法一：
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i < n; i ++) {
            if(nums[i] != i) {
                return i;
            }
        }
        return n;
    }

    /**
     * 解法二：
     *
     * @param nums
     * @return
     */
    public int missingNumber1(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i < n; i ++) {
            if(nums[i] != i) {
                return i;
            }
        }
        return n;
    }

    static class TestCase {
        public static int ANS = 2;
        public static int[] NUMS = {3,0,1};

        public static int ANS1 = 2;
        public static int[] NUMS1 = {0,1};

        public static int ANS2 = 8;
        public static int[] NUMS2 = {9,6,4,2,3,5,7,0,1};

        public static int ANS3 = 1;
        public static int[] NUMS3 = {0};
    }
}
