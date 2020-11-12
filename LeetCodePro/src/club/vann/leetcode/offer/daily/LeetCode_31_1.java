package club.vann.leetcode.offer.daily;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * <p>难度：Medium</p>
 * <p>题目：下一个排列</p>
 * <p>描述：实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * 通过次数100,042提交次数286,572
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: LeetCodePro
 * @description:
 * @author: vann
 * @create: 2020-11-10 09:21
 **/
public class LeetCode_31_1 {
    public static void main(String[] args) {
        LeetCode_31_1 leetCode = new LeetCode_31_1();

//        leetCode.nextPermutation(TestCase.NUMS);
//        leetCode.nextPermutation(TestCase.NUMS1);
//        leetCode.nextPermutation(TestCase.NUMS2);
//        leetCode.nextPermutation(TestCase.NUMS3);
//        leetCode.nextPermutation(TestCase.NUMS4);
        leetCode.nextPermutation(TestCase.NUMS5);
        System.out.println("Success");
    }

    public LeetCode_31_1() {
    }

    /**
     * 解法一：
     * 解题思路：如果能找到一个升序序列，只需要找到最后一个升序序列，
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1) {
            return;
        }

        int len = nums.length;

        int min = len-1;
        // 从后往前找，先尝试能不能找到一个降序序列
        for(int i = len-2; i >= 0; i --) {
            if(nums[i] >= nums[i+1]) {
                continue;
            }

            // nums[i] < nums[i+1]
            if(nums[min] < nums[i]) {

            } else if(nums[i] <= nums[min] && nums[min] <= nums[i+1]) {
                nums[i] = nums[i] ^ nums[min];
                nums[min] = nums[i] ^ nums[min];
                nums[i] = nums[i] ^ nums[min];
            } else {

            }

            nums[i] = nums[i+1] ^ nums[i];
            nums[i+1] = nums[i+1] ^ nums[i];
            nums[i] = nums[i+1] ^ nums[i];
            Arrays.sort(nums, i+1, len);
        }

        Arrays.sort(nums);
    }

    static class TestCase {
        public static int[] ANS = {1,3,2};
        public static int[] NUMS = {1,2,3};

        public static int[] ANS1 = {1,2,3};
        public static int[] NUMS1 = {3,2,1};

        public static int[] ANS2 = {1,5,1};
        public static int[] NUMS2 = {1,1,5};

        public static int[] ANS3 = {1,2,4,1,2,3,3};
        public static int[] NUMS3 = {1,2,3,4,3,2,1};

        public static int[] ANS4 = {1,2,4,1,2,3,3,4};
        public static int[] NUMS4 = {1,2,3,4,4,3,2,1};

        public static int[] ANS5 = {2,1,3};
        public static int[] NUMS5 = {1,3,2};

        public static int[] ANS6 = {3,1,2};
        public static int[] NUMS6 = {2,3,1};
    }
}