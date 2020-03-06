package leetcode.offer;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * 
 * 示例:
 * 
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3 输出: [3,3,5,5,6,7] 解释:
 * 
 * 滑动窗口的位置 					最大值 
 * --------------- 		    	----- 
 * [1  3  -1] -3  5  3  6  7 	3 
 *  1 [3  -1  -3] 5  3  6  7 	3
 *  1  3 [-1  -3  5] 3  6  7 	5 
 * 	1  3  -1 [-3  5  3] 6  7 	5 
 * 	1  3  -1  -3 [5  3  6] 7 	6 
 * 	1  3  -1  -3  5 [3  6  7] 	7
 * 
 * 
 * @author vann
 *
 */
public class LeetCode_59I {

	public static void main(String[] args) {
		int[] nums = {1,3,-1,-3,5,3,6,7};
		int[] nums1 = {};
		int[] nums2 = {1};
		int k = 3;
		
		LeetCode_59I leetCode = new LeetCode_59I();
		int[] result = leetCode.maxSlidingWindow1(nums, 3);
		int[] result1 = leetCode.maxSlidingWindow1(nums1, 0);
		int[] result2 = leetCode.maxSlidingWindow1(nums2, 1);
		System.out.println(Arrays.toString(result));
	}
	
	private int[] maxSlidingWindow(int[] nums, int k) {
		if(nums == null || nums.length == 0) {
			return new int[0];
		}
		
		int size = nums.length;
		
		int[] result = new int[size - k + 1];
		
		for(int n = 0; n < result.length; n ++) {
			result[n] = findMaxVal(nums, n, k);
		}
		
        return result;
    }
	
	private int findMaxVal(int[] arr, int leftIndex, int k) {
		int val = Integer.MIN_VALUE;
		int maxValue = Integer.MIN_VALUE;
		for(int n = leftIndex; n < (leftIndex+k); n ++) {
			maxValue = Math.max(maxValue, arr[n]);
		}
		return maxValue;
	}
	
	/**
	 * 这是典型的单调队列问题，利用单调队列求 k 个数的最大值或者最小值，能使得时间复杂度降到最低，
	 * 因为进队出队仅需 O(1) 的时间复杂度。
	 * @param nums
	 * @param k
	 * @return
	 */
	public int[] maxSlidingWindow1(int[] nums, int k) {
		if(nums == null || nums.length < 2) {
			return nums;
		}
		
		// 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
		LinkedList<Integer> queue = new LinkedList<Integer>();
		// 结果数组
		int[] res = new int[nums.length - k + 1];
		
		for(int n = 0; n < nums.length; n ++) {
			// 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
			while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[n]) {
				queue.pollLast();
			}
			
			// 判断当前队列中队首的值是否有效
			if(!queue.isEmpty() && queue.peek() <= (n-k)) {
				queue.poll();
			}
			
			// 添加当前值对应的数组下标
			queue.addLast(n);
			
			// 当窗口长度第一次达到k后，开始保存当前窗口中最大值
			// 以后每走一步，就会保存一个最大值
			if(n+1 >= k){
                res[n+1-k] = nums[queue.peek()];
            }
		}
		
		return res;
	}

}
