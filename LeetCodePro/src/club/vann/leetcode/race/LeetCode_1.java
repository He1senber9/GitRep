package club.vann.leetcode.race;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2021/4/5
 * Time: 15:10
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_1 {
    public static void main(String[] args) {
        LeetCode_1 leetCode = new LeetCode_1();

        System.out.println(leetCode.purchasePlans(TestCase.NUMS, TestCase.TARGET));
        System.out.println(leetCode.purchasePlans(TestCase.NUMS1, TestCase.TARGET1));
    }

    public int purchasePlans(int[] nums, int target) {
        int ans = 0;
        int n = nums.length;
        Arrays.sort(nums);
        A:for(int i = 0; i < n-1; i ++) {
            if(nums[i] >= target) {
                break;
            }
            B:for(int j = i+1; j < n; j ++) {
                if(nums[i] + nums[j] <= target) {
                    ans ++;
                } else {
                    continue A;
                }
            }
        }
        return (ans)%1000000007;
    }

    static class TestCase {
        public static int ANS = 1;
        public static int[] NUMS = {2,5,3,5};
        public static int TARGET = 6;

        public static int ANS1 = 4;
        public static int[] NUMS1 = {2,2,1,9};
        public static int TARGET1 = 10;


    }
}
