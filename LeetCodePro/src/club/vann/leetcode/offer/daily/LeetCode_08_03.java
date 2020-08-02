package club.vann.leetcode.offer.daily;

/**
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-07-31 08:25
 **/
public class LeetCode_08_03 {
    public static void main(String[] args) {
        LeetCode_08_03 leetCode = new LeetCode_08_03();

        System.out.println("Result["+TestCase.ANS+"] :" + leetCode.findMagicIndex(TestCase.NUMS));
        System.out.println("Result["+TestCase.ANS1+"] :" + leetCode.findMagicIndex(TestCase.NUMS1));
        System.out.println("Result["+TestCase.ANS2+"] :" + leetCode.findMagicIndex(TestCase.NUMS2));
    }

    /**
     * 解法一：
     *
     * @param nums
     * @return
     */
    private int findMagicIndex(int[] nums) {
        int len = nums.length;
        if(len == 1) {
            return nums[0] == 0 ? 0 : -1;
        }

        int left = 0, right = len-1;
        while(left <= right) {
            if(nums[left] <= nums[right]) { // 升序
                if(nums[left]==left) {
                    return left;
                } else {
                    left++;
                }
            } else { // 降序
                if(nums[right]==right) {
                    return right;
                } else {
                    right --;
                }
            }
        }
        return -1;
    }

    static class TestCase {
        public static int ANS = 0;
        public static int[] NUMS = {0, 2, 3, 4, 5};

        public static int ANS1 = 1;
        public static int[] NUMS1 = {1, 1, 1};

        public static int ANS2 = 2;
        public static int[] NUMS2 = {-2,-1,2,3,4,5,6,7,8,9,10};
    }
}
