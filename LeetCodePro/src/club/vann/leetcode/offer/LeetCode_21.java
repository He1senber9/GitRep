package club.vann.leetcode.offer;

import java.util.Arrays;

/**
 * <p>
 * 难度：Easy
 * <p>
 * 题目：调整数组顺序使奇数位于偶数前面
 * <p>
 * 描述：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * <p>
 * 示例：
 * 
 * 输入：nums = [1,2,3,4] 输出：[1,3,2,4] 注：[3,1,2,4] 也是正确的答案之一。  
 * <p>
 * 提示：
 * 
 * 1 <= nums.length <= 50000 1 <= nums[i] <= 10000 通过次数5,278提交次数8,045
 * 
 * @author fanyu
 * @date 2020年3月7日
 */
public class LeetCode_21 {

	public static void main(String[] args) {
		LeetCode_21 leetCode = new LeetCode_21();
		
		int[] nums = {1,2,3,4,5};
		int[] result = leetCode.exchange(nums);
		System.out.println(Arrays.toString(result));
		
		int[] nums1 = {1,2,2,4,5};
		int[] result1 = leetCode.exchange(nums1);
		System.out.println(Arrays.toString(result1));
	}

	private int[] exchange(int[] nums) {
		if(nums == null || nums.length < 2) {
			return nums;
		}
		int len = nums.length;
		int begin = 0, end = len-1;
		while(begin < end) {
			int leftVal = nums[begin];
			int rightVal = nums[end];
			
			if(leftVal % 2 != 0) { // 左边为奇数
				begin ++;
				continue;
			} 
			
			if(rightVal % 2 == 0) { // 右边为偶数
				end --;
				continue;
			}
			
			// 恰好 左边是有数，右边是基数
			nums[end] = nums[begin] ^ nums[end];
			nums[begin] = nums[begin] ^ nums[end];
			nums[end] = nums[begin] ^ nums[end];
			
			begin ++;
			end --;
		}
		
		return nums;
	}

}
