/**
 * 
 */
package club.vann.leetcode.offer;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * 难度：Easy
 * <p>
 * 题目：数组中重复的数字。
 * <p>
 * 描述：在一个长度为你的数组nums里所有的数字都在0~n-1的范围内。
 *      数组中某些数字是可重复的，但不知道有几个数字重复，也不知
 *      道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *      
 * <p>
 * 示例1：
 * 
 * 输入：[2,3,1,9,2,5,3] 输出 2 或者 3
 * 
 * <p>
 * 限制： 2<=n<=100000
 * 通过次数：13217，提交次数：19423
 * 
 * @author vann
 * @date Mar 5, 2020
 */
public class LeetCode_03 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LeetCode_03 leetCode = new LeetCode_03();
		
		int[] nums = {2,3,1,9,2,5,3};
		int result = leetCode.findRepeatNumber1(nums);
		System.out.println("Result [2 或者 3] :" + result);
	}
	
	/**
	 * 解法一:
	 * 暴力解法：按照顺序挑选，直到挑到一个重复数字。
	 * 
	 * @param nums
	 * @return
	 */
	private int findRepeatNumber1(int[] nums) {
		
		int len = nums.length;
		
		Set<Integer> set = new HashSet<Integer>();
		for(int n = 0; n < len; n ++) {
			if(set.contains(nums[n])) {
				return nums[n];
			}
			set.add(nums[n]);
		}
		// 如果都不重复，返回 -1
		return -1;
	}

	
}
