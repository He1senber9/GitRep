package club.vann.leetcode.offer.daily;

import org.omg.CORBA.INTERNAL;
import sun.jvm.hotspot.oops.InstanceKlass;

import java.util.*;

/**
 * <p>难度：Medium</p>
 * <p>题目：数组中第K大的元素</p>
 * <p>描述：在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *
 * 通过次数133,480提交次数212,137
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/6/29
 * Time: 7:11
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_215 {
    public static void main(String[] args) {
        LeetCode_215 leetCode = new LeetCode_215();

        System.out.println("Result["+TestCase.ans+"] : " + leetCode.findKthLargest2(TestCase.nums, 2));
        System.out.println("Result["+TestCase.ans1+"] : " + leetCode.findKthLargest2(TestCase.nums1, 4));
    }

    /**
     * 解法一：
     *
     * @param nums
     * @param k
     * @return
     */
    private int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        return nums.length < k ? 0 : nums[nums.length-k];
    }

    /**
     * 解法二：
     *  基于快排思想
     * @param nums
     * @param k
     * @return
     */
    private int findKthLargest1(int[] nums, int k) {
        quickSort(nums, 0, nums.length-1);
        return nums[nums.length-k];
    }

    /**
     * 找到中间位置。
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private int findMiddle(int[] nums, int left, int right) {
        int tag = nums[left];
        while(left < right) {
            while(left < right && tag <= nums[right]) {
                right --;
            }
            nums[left] = nums[right];

            while(left < right && nums[left] <= tag) {
                left ++;
            }
            nums[right] = nums[left];
        }

        nums[left] = tag;
        return left;
    }

    private void quickSort(int[] nums, int left, int right) {
        if(left < right) {
            int mid = findMiddle(nums, left, right);
            quickSort(nums, left, mid-1);
            quickSort(nums, mid+1, right);
        }
    }

    /**
     * 解法三：
     * 基于大根堆思想
     * @param nums
     * @param k
     * @return
     */
    private int findKthLargest2(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
            swap(nums, 0, i);
            --heapSize;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    private void maxHeapify(int[] nums, int i, int heapSize) {
        int l = i * 2 + 1, r = i * 2 + 2, largest = i;
        if (l < heapSize && nums[l] > nums[largest]) {
            largest = l;
        }
        if (r < heapSize && nums[r] > nums[largest]) {
            largest = r;
        }

        if (largest != i) {
            swap(nums, i, largest);
            maxHeapify(nums, largest, heapSize);
        }
    }

    /**
     * 堆调整
     * 
     * @param nums
     * @param i
     * @param j
     */
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 构造大根堆
     * @param nums
     * @param heapSize
     */
    private void buildMaxHeap(int[] nums, int heapSize) {
        for (int i = heapSize / 2; i >= 0; --i) {
            maxHeapify(nums, i, heapSize);
        }
    }

    static class TestCase {
        public static final int ans = 5;
        public static int[] nums = {3,2,1,5,6,4};

        public static final int ans1 = 4;
        public static int[] nums1 = {3,2,3,1,2,4,5,5,6};
    }
}
