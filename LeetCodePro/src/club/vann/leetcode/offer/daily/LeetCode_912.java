package club.vann.leetcode.offer.daily;

import java.util.Arrays;

/**
 * <p>难度：Midum</p>
 * <p>题目：排序数组</p>
 * <p>描述：给定一个整数数组 nums，将该数组升序排列。
 *
 * 示例 1：
 *
 * 输入：[5,2,3,1]
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：[5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 *
 * 提示：
 *
 * 1 <= A.length <= 10000
 * -50000 <= A[i] <= 50000
 * 通过次数26,183提交次数47,307
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: GitRep
 * @description:
 * @author: vann
 * @create: 2020-03-31 09:21
 **/
public class LeetCode_912 {
    public static void main(String[] args) {
        int[] result = null;
        LeetCode_912 leetCode = new LeetCode_912();
        TestCase testCase = leetCode.new TestCase();

        result = leetCode.sortArray(testCase.nums);
        System.out.println("Result[1,2,3,5] : " + Arrays.toString(result));

        result = leetCode.sortArray(testCase.nums1);
        System.out.println("Result[0,0,1,1,2,5] : " + Arrays.toString(result));

    }

    /**
     * 解法一：冒泡排序
     * @param nums
     * @return
     */
    private int[] sortArray(int[] nums) {
//        sortBubble(nums);
//        sortQuick(nums, 0, nums.length-1);
        sortInsert(nums);
        return nums;
    }

    /**
     * 冒泡排序
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * @param nums
     */
    private void sortBubble(int[] nums) {
        int len = nums.length;
        for(int n = 0; n < len; n ++) {
            for(int m = 0; m < len-1-n; m ++) {
                if(nums[m] > nums[m+1]) {
                    nums[m] = nums[m] ^ nums[m+1];
                    nums[m+1] = nums[m] ^ nums[m+1];
                    nums[m] = nums[m] ^ nums[m+1];
                }
            }
        }
    }

    /**
     * 快速排序
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(logn)
     * 稳定性：不稳定
     * @param nums
     */
    private void sortQuick(int[] nums, int left, int right) {
        if(left > right) {
            return;
        }

        int l = left, r = right;
        int mid = nums[left];
        while(left < right) {
            while(left < right && mid <= nums[right]) {
                right --;
            }
            nums[left] = nums[right];

            while(left < right && nums[left] <= mid) {
                left ++;
            }
            nums[right] = nums[left];
        }
        nums[left] = mid;
        sortQuick(nums, l, left-1);
        sortQuick(nums, left+1, r);
    }

    /**
     * 直接插入排序
     * 时间复杂度：O(n²)
     * 空间复杂度：O(1)
     * 稳定性：稳定
     * @param nums
     */
    public void sortInsert(int[] nums) {
        int len = nums.length;

        for(int n = 1; n < len; n ++) {
            int min = nums[n];
            for(int m = n-1; m >= 0; m --) {
                if(nums[m] > nums[m+1]) {
                    nums[m] = nums[m+1] ^ nums[m];
                    nums[m+1] = nums[m+1] ^ nums[m];
                    nums[m] = nums[m+1] ^ nums[m];
                }
            }
        }
    }

    class TestCase {
        public final int[] nums = {5,2,3,1};
        public final int[] nums1 = {5,1,1,2,0,0};
    }
}
