package club.vann.leetcode.offer.daily;

import java.util.Stack;

/**
 * <p>难度：Midum</p>
 * <p>题目：最长上升子序列</p>
 * <p>描述：给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 *
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 *
 * 通过次数58,344提交次数131,952
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * 
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/3/14
 * Time: 10:36
 * Description:
 */
public class LeetCode_300 {
    public static void main(String[] args) {
        int[] nums = {};
        int result = 0;
        LeetCode_300 leetCode = new LeetCode_300();

//        nums = new int[] {1};
//        result = leetCode.lengthOfLIS(nums);
//        System.out.println("Result[1] :" + result);
//
//        nums = new int[] {10,9,2,5,3,7,101,18};
//        result = leetCode.lengthOfLIS(nums);
//        System.out.println("Result[4] :" + result);
//
//        nums = new int[] {1,2,3,4,5,6,7,8};
//        result = leetCode.lengthOfLIS(nums);
//        System.out.println("Result[8] :" + result);
//
//        nums = new int[] {3,4,5,3,5,6,7,8};
//        result = leetCode.lengthOfLIS(nums);
//        System.out.println("Result[6] :" + result);
//
//        nums = new int[] {2,2};
//        result = leetCode.lengthOfLIS(nums);
//        System.out.println("Result[1] :" + result);
//
//        nums = new int[] {4,10,4,3,8,9};
//        result = leetCode.lengthOfLIS(nums);
//        System.out.println("Result[3] :" + result);
//
//        nums = new int[] {10,9,2,5,3,4};
//        result = leetCode.lengthOfLIS(nums);
//        System.out.println("Result[3] :" + result);

        nums = new int[] {3,5,6,2,5,4,19,5,6,7,12};
        result = leetCode.lengthOfLIS(nums);
        System.out.println("Result[6] :" + result);

        nums = new int[] {-2, -1};
        result = leetCode.lengthOfLIS(nums);
        System.out.println("Result[2] :" + result);

    }

    /**
     * 解法一：线性动态规划
     * 令 F(i) 为 A[i]结尾的子序列的长度。
     * 则： F(i) = F(j) + 1 {0<=j<i A[j]<A[i]，此时A[j]最大}
     *     F(0) = 0;
     * @param nums
     * @return
     */
    private int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int max = 0;
        int len = nums.length;
        int[] dp = new int[len];

        // 状态方程：F(i) = if(A[i-1]<A[i]) F(i-1)+1 else F(i-1);

        for(int n = 0; n < len; n ++) {
            for(int m = 0; m < n; m ++) { // 遍历前 m 个数
                if(nums[m] < nums[n]) { // 如果第 m 个数比 第 n 个数小，存在递增关系
                    dp[n] = Math.max(dp[n], dp[m]); // 获取第 n 个数之前的最大子序列长度
                }
            }
            dp[n] = dp[n]+1;
            max = Math.max(dp[n], max);
        }
        return max;
    }

    /**
     * 快速排序
     * @param array
     * @param left
     * @param right
     */
    private void quickSort(int[] array, int left, int right) {
        if(left >= right) {
            return;
        }

        int mid = array[left];
        int low = left, high = right;
        while(low < high) {
            while(low < high && mid <= array[high]) {
                high --;
            }
            array[low] = array[high];

            while(low < high && mid >= array[low]) {
                low ++;
            }
            array[high] = array[low];
        }
        array[low] = mid;

        quickSort(array, left, low-1);
        quickSort(array, low+1, right);
    }
}
