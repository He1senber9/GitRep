package club.vann.leetcode.race;

import java.util.Arrays;

/**
 * <p>难度：Easy</p>
 * <p>题目：一维数组的动态和</p>
 * <p>描述：给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
 *
 * 请返回 nums 的动态和。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,6,10]
 * 解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4] 。
 * 示例 2：
 *
 * 输入：nums = [1,1,1,1,1]
 * 输出：[1,2,3,4,5]
 * 解释：动态和计算过程为 [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1] 。
 * 示例 3：
 *
 * 输入：nums = [3,1,2,10,1]
 * 输出：[3,4,6,16,17]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 1000
 * -10^6 <= nums[i] <= 10^6</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/6/21
 * Time: 11:13
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_1480 {
    public static void main(String[] args) {
        LeetCode_1480 leetCode = new LeetCode_1480();

        System.out.println(Arrays.toString(leetCode.runningSum(TestCase.nums)));
        System.out.println(Arrays.toString(leetCode.runningSum(TestCase.nums1)));
        System.out.println(Arrays.toString(leetCode.runningSum(TestCase.nums2)));
    }

    private int[] runningSum(int[] nums) {
        if(nums == null || nums.length == 0) {
            return nums;
        }

        int len = nums.length;
        for(int i = 1; i < len; i ++) {
            nums[i] = nums[i-1] + nums[i];
        }
        return nums;
    }

    static class TestCase {
        public static int[] nums = {1,2,3,4};
        public static int[] nums1 = {1,1,1,1,1};
        public static int[] nums2 = {3,1,2,10,1};
    }
}
