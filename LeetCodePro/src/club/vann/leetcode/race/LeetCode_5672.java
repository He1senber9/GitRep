package club.vann.leetcode.race;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>难度：Easy</p>
 * <p>题目：检查数组是否经排序和轮转得到</p>
 * <p>描述：给你一个数组 nums 。nums 的源数组中，所有元素与 nums 相同，但按非递减顺序排列。
 *
 * 如果 nums 能够由源数组轮转若干位置（包括 0 个位置）得到，则返回 true ；否则，返回 false 。
 *
 * 源数组中可能存在 重复项 。
 *
 * 注意：我们称数组 A 在轮转 x 个位置后得到长度相同的数组 B ，当它们满足 A[i] == B[(i+x) % A.length] ，其中 % 为取余运算。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,4,5,1,2]
 * 输出：true
 * 解释：[1,2,3,4,5] 为有序的源数组。
 * 可以轮转 x = 3 个位置，使新数组从值为 3 的元素开始：[3,4,5,1,2] 。
 * 示例 2：
 *
 * 输入：nums = [2,1,3,4]
 * 输出：false
 * 解释：源数组无法经轮转得到 nums 。
 * 示例 3：
 *
 * 输入：nums = [1,2,3]
 * 输出：true
 * 解释：[1,2,3] 为有序的源数组。
 * 可以轮转 x = 0 个位置（即不轮转）得到 nums 。
 * 示例 4：
 *
 * 输入：nums = [1,1,1]
 * 输出：true
 * 解释：[1,1,1] 为有序的源数组。
 * 轮转任意个位置都可以得到 nums 。
 * 示例 5：
 *
 * 输入：nums = [2,1]
 * 输出：true
 * 解释：[1,2] 为有序的源数组。
 * 可以轮转 x = 5 个位置，使新数组从值为 2 的元素开始：[2,1] 。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100</p>
 * @author vann
 * @program GitRep
 * @description
 * @date 2021-02-07:10:42:05
 */
public class LeetCode_5672 {
    public static void main(String[] args) {
        LeetCode_5672 leetCod = new LeetCode_5672();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCod.check(TestCase.NUMS));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCod.check(TestCase.NUMS1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCod.check(TestCase.NUMS2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCod.check(TestCase.NUMS3));
        System.out.println("Result["+TestCase.ANS4+"] : " + leetCod.check(TestCase.NUMS4));
        System.out.println("Result["+TestCase.ANS5+"] : " + leetCod.check(TestCase.NUMS5));
    }

    /**
     * 解法一：
     * @param nums
     * @return
     */
    public boolean check(int[] nums) {
        int len = nums.length;
        reverse(nums, 0, len-1);
        int index = -1;
        for(int i = 0; i < len-1; i ++) {
            if(nums[i] < nums[i+1]) {
                index = i+1;
                break;
            }
        }
        //
        if(index >= 0 && index < len) {
            reverse(nums, 0, index-1);
            reverse(nums, index, len-1);
        } else {
            return true;
        }

        return is(nums);
    }

    private void reverse(int[] nums, int left, int right) {
        while(left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left ++;
            right --;
        }
    }

    private boolean is(int[] nums) {
        for(int i = 0; i < nums.length-1; i ++) {
            if(nums[i] > nums[i+1]) {
                return false;
            }
        }
        return true;
    }

    static class TestCase {
        public static boolean ANS = true;
        public static int[] NUMS = {3,4,5,1,2};

        public static boolean ANS1 = false;
        public static int[] NUMS1 = {2,1,3,4};

        public static boolean ANS2 = true;
        public static int[] NUMS2 = {1,2,3};

        public static boolean ANS3 = true;
        public static int[] NUMS3 = {1,1,1};

        public static boolean ANS4 = true;
        public static int[] NUMS4 = {2,1};

        public static boolean ANS5 = false;
        public static int[] NUMS5 = {2,7,4,1,2,6,2};
    }
}
