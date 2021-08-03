package club.vann.leetcode.offer.daily;

import java.util.Arrays;

/**
 * <p>难度：Medium</p>
 * <p>题目：最短无序连续子数组</p>
 * <p>描述：给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 *
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [2,6,4,8,10,9,15]
 * 输出：5
 * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * 示例 2：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：0
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：0
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 104
 * -105 <= nums[i] <= 105
 *  
 *
 * 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？
 *
 * 通过次数79,279提交次数202,302
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @description:
 * @program: GitRep
 * @author: fanyu
 * @create: 2021-08-03  08:24:34
 */
public class LeetCode_581 {
    public static void main(String[] args) {
        LeetCode_581 leetCode = new LeetCode_581();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.findUnsortedSubarray(TestCase.NUMS));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.findUnsortedSubarray(TestCase.NUMS1));
    }

    public int findUnsortedSubarray(int[] nums) {
        // 解法一：
        int n = nums.length;
        int[] copys = new int[n];
        System.arraycopy(nums, 0, copys, 0, n);
        Arrays.sort(nums);


        int left = 0, right = n - 1;
        while(left <= right) {
            if(copys[left] == nums[left]) {
                left ++;
                continue;
            }
            break;
        }

        while(right >= left) {
            if(copys[right] == nums[right]) {
                right --;
                continue;
            }
            break;
        }

        return (right-left+1);
    }

    static class TestCase {
        public static int ANS = 5;
        public static int[] NUMS = {2,6,4,8,10,9,15};

        public static int ANS1 = 0;
        public static int[] NUMS1 = {1,2,3,4};
    }
}
