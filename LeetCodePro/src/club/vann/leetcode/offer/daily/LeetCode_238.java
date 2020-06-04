package club.vann.leetcode.offer.daily;

import java.util.Arrays;

/**
 * <p>难度：Medium</p>
 * <p>题目：除自身以外数组的乘积</p>
 * <p>描述：给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，
 * 其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 *  
 *
 * 示例:
 *
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 *  
 *
 * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
 *
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 *
 * 通过次数43,318提交次数63,060
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/product-of-array-except-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-06-04 08:50
 **/
public class LeetCode_238 {
    public static void main(String[] args) {
        LeetCode_238 leetCode = new LeetCode_238();

        System.out.println("Result["+ Arrays.toString(TestCase.ans)+"] : " + Arrays.toString(leetCode.productExceptSelf(TestCase.nums)));
        System.out.println("Result["+ Arrays.toString(TestCase.ans1)+"] : " + Arrays.toString(leetCode.productExceptSelf(TestCase.nums1)));
    }

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] newNums = new int[len];

        for(int i = 0; i < len; i ++) {
            int tmp = 1;
            for(int t = 0; t < len; t ++) {
                if(i != t) {
                    tmp *= nums[t];
                }
            }
            newNums[i] = tmp;
        }
        return newNums;
    }

    static class TestCase {
        public static final int[] ans = {24,12,8,6};
        public static final int[] nums = {1,2,3,4};

        public static final int[] ans1 = {0, 0};
        public static final int[] nums1 = {0, 0};

        public static final int[] ans2 = {};
        public static final int[] nums2 = {};
    }
}
