package club.vann.leetcode.offer.daily;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Arrays;

/**
 * <p>难度：Hard</p>
 * <p>题目：缺失的第一个正数</p>
 * <p>描述：给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 *
 * 输入: [7,8,9,11,12]
 * 输出: 1
 *  
 *
 * 提示：
 *
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
 *
 * 通过次数57,970提交次数149,703
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-missing-positive
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/6/27
 * Time: 8:32
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_41 {
    public static void main(String[] args) {
        LeetCode_41 leetCode = new LeetCode_41();

        System.out.println("Result["+TestCase.ans+"] : " + leetCode.firstMissingPositive(TestCase.nums));
        System.out.println("Result["+TestCase.ans1+"] : " + leetCode.firstMissingPositive(TestCase.nums1));
        System.out.println("Result["+TestCase.ans2+"] : " + leetCode.firstMissingPositive(TestCase.nums2));
        System.out.println("Result["+TestCase.ans3+"] : " + leetCode.firstMissingPositive(TestCase.nums3));
        System.out.println("Result["+TestCase.ans4+"] : " + leetCode.firstMissingPositive(TestCase.nums4));
        System.out.println("Result["+TestCase.ans5+"] : " + leetCode.firstMissingPositive(TestCase.nums5));
    }

    /**
     * 解法一：
     * 常规思路，先排序，再求解
     * @param nums
     * @return
     */
    private int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 1;
        }

        Arrays.sort(nums);

        // 用于标记最小的正整数
        int min = 1;
        int len = nums.length;
        for(int n = 0; n < len; n ++) {
            if(nums[n] <= 0) {
                continue;
            }

            if(nums[n] == min) {
                min ++;
            }
        }

        return min;
    }

    /**
     * 解法二：
     * 时间复杂度需要在O(n)中完成，且只需常量的额外空间。
     * 解题思路：最小栈
     * @param nums
     * @return
     */
    private int firstMissingPositive1(int[] nums) {

        return 0;
    }

    static class TestCase {
        public static final int ans = 3;
        public static int[] nums = {1,2,0};

        public static final int ans1 = 2;
        public static int[] nums1 = {3,4,-1,1};

        public static final int ans2 = 1;
        public static int[] nums2 = {7,8,9,11,12};

        public static final int ans3 = 4;
        public static int[] nums3 = {-1,0,1,2,3,5};

        public static final int ans4 = 3;
        public static int[] nums4 = {2,1};

        public static final int ans5 = 3;
        public static int[] nums5 = {2,1,2,1};
    }
}
