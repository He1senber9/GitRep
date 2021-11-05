package club.vann.leetcode.race;

/**
 * @ClassName LeetCode_5746
 * @Description TODO
 * @User fanyu
 * @Date 2021/5/2 10:38
 */
public class LeetCode_5746 {
    public static void main(String[] args) {
        LeetCode_5746 leetCode = new LeetCode_5746();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.getMinDistance(TestCase.NUMS, TestCase.TARGET, TestCase.START));
    }

    public int getMinDistance(int[] nums, int target, int start) {
        int left = distance(nums, target, start, true);
        int right = distance(nums, target, start, false);
        return Math.min(left, right);
    }

    private int distance(int[] nums, int target, int index, boolean flag) {
        if(index < 0 || index >= nums.length) {
            return Integer.MAX_VALUE;
        }

        if(nums[index] == target) {
            return 0;
        }

        if(flag) {
            if(distance(nums, target, index-1, flag) == Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else {

            }
            return 1 + distance(nums, target, index-1, flag);
        } else {
            return 1 + distance(nums, target, index+1, flag);
        }
    }

    static class TestCase {
        public static int ANS = 1;
        public static int[] NUMS = {1,2,3,4,5};
        public static int TARGET = 5;
        public static int START = 3;
    }
}
