package club.vann.leetcode.offer;

import java.util.Arrays;

/**
 * <p>难度：Easy</p>
 * <p>题目：和为s的两个数字</p>
 * <p>描述：输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * 示例 2：
 *
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 *  
 *
 * 限制：
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^6
 * 通过次数22,236提交次数33,895
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-06-24 15:02
 **/
public class LeetCode_57 {
    public static void main(String[] args) {
        LeetCode_57 leetCode = new LeetCode_57();

        System.out.println(Arrays.toString(leetCode.twoSum(TestCase.nums, 9)));
        System.out.println(Arrays.toString(leetCode.twoSum(TestCase.nums1, 40)));
        System.out.println(Arrays.toString(leetCode.twoSum(TestCase.nums2, 9)));
    }

    /**
     * 解法一：
     * 1、数组递增
     * @param nums
     * @param target
     * @return
     */
    private int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length < 2) {
            return new int[0];
        }

        int len = nums.length;
        if(target < (nums[0] + nums[1]) || (nums[len-2] + nums[len-1]) < target) {
            return new int[0];
        }

        int[] res = new int[2];
        // 因为是有序数组，采用双指针进行二分判断
        int left = 0, right = len-1;
        while(left < right) {
            while(nums[left] + nums[right] > target) {
                right --;
            }

            if(nums[left] + nums[right] == target) {
                res[0] = nums[left];
                res[1] = nums[right];
                break;
            }

            while(nums[left] + nums[right] < target) {
                left ++;
            }

            if(nums[left] + nums[right] == target) {
                res[0] = nums[left];
                res[1] = nums[right];
                break;
            }
        }

        return res;
    }

    static class TestCase {
        public static int[] nums = {2,7,11,15};

        public static int[] nums1 = {10,26,30,31,47,60};

        public static int[] nums2 = {1,2,3,4,5,6};
    }
}
