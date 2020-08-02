package club.vann.leetcode.offer;

import java.util.Arrays;

/**
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-07-31 08:45
 **/
public class LeetCode_56_I {
    public static void main(String[] args) {
        LeetCode_56_I leetCode = new LeetCode_56_I();

        System.out.println("Result["+ Arrays.toString(TestCase.ANS)+"] : " + Arrays.toString(leetCode.singleNumbers(TestCase.NUMS)));
        System.out.println("Result["+ Arrays.toString(TestCase.ANS1)+"] : " + Arrays.toString(leetCode.singleNumbers(TestCase.NUMS1)));
    }

    /**
     * 解法一：
     *
     * @param nums
     * @return
     */
    private int[] singleNumbers(int[] nums) {
        int len = nums.length;

        int tag = 0;
        for(int num : nums) {
            tag ^= num;
        }

        int div = tag & -tag;

        int a = 0, b = 0;
        for(int num : nums) {
            if((num & div) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a,b};
    }

    static class TestCase {
        public static int[] ANS = {1,6};
        public static int[] NUMS = {4,1,4,6};

        public static int[] ANS1 = {2,10};
        public static int[] NUMS1 = {1,2,10,4,1,4,3,3};
    }
}
