package club.vann.leetcode;

import java.util.Arrays;

/**
 * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n
 * 的 min(ai, bi) 总和最大。
 * 
 * @author vann
 *
 */
public class LeetCode_561 {

	public static void main(String[] args) {
		int[] arrays = {1, 4, 3 , 2};
		
		LeetCode_561 leetCode = new LeetCode_561();
		int result = leetCode.arrayPairSum(arrays);
		System.out.println(result);
	}
	
	private int arrayPairSum(int[] nums) {
        // 1、nums 长度一定是偶数。
        // 2、对 nums 升序排序。
        // 3、答案即 排序后的 奇数位上的和
		
//		int sum = bubbleSort(nums);
//		int sum = quickSort(nums);
		int sum = maxHeadSort(nums);
		
        return sum;
    }
	
	/**
	 *  冒泡排序
	 * @param array
	 * @return
	 */
	private int bubbleSort(int[] array) {
		int len = array.length;
		int sum = 0;
		
		for(int n = 0; n < len; n ++) {
			for(int m = 0; m < len - n - 1; m ++) {
				if(array[m] > array[m+1]) {
					array[m] = array[m] ^ array[m+1];
					array[m+1] = array[m] ^ array[m+1];
					array[m] = array[m] ^ array[m+1];
				}
			}
			if(n%2 != 0) {
				sum += array[len-n-1];
			}
		}
		
		return sum;
	}

	/**
	 * 快速排序
	 * @param array
	 * @return
	 */
	private int quickSort(int[] array) {
		int sum = 0;
		
		quickSort(array, 0, array.length-1);
		
		System.out.println(Arrays.toString(array));
		
		for(int n = 0; n < array.length; n +=2) {
			sum += array[n];
		}
		
		return sum;
	}
	
	private void quickSort(int[] array, int left, int right) {
		int low = left, high = right;
		int pivotKey = array[left];
		
		while(low < high) {
			while(low < high && array[high] >= pivotKey) {
				high --;
			}
			array[low] = array[high];
			
			while(low < high && array[low] <= pivotKey) {
				low ++;
			}
			array[high] = array[low];
		}
		array[low] = pivotKey;
		
		if(low > left) {
			quickSort(array, left, low-1);
		}
		if(low < right) {
			quickSort(array, low+1, right);
		}
	}
	
	private int maxHeadSort(int[] array) {
		int sum = 0;
		int len = array.length;
		maxHeadBuilt(array, len);
		
		for(int n = len-1; n > 0; n--) {
			array[0] = array[0] ^ array[n];
			array[n] = array[n] ^ array[0];
			array[0] = array[0] ^ array[n];
			if(n % 2 == 0) {
				sum += array[n];
			}
			
			maxHeadBuilt(array, n);
		}
		
		sum += array[0];
		
		System.out.println(Arrays.toString(array));
		
		return sum;
	}
	
	/**
	 * 构建最小堆
	 * @param array
	 */
	private void maxHeadBuilt(int[] array, int size) {
		// 构建堆
		for(int n = size/2-1; n >=0; n --) {
			int index = n;
			if((2*n+1 <= size -1) && array[2*n+1] > array[index]) {
				index = 2*n+1;
			}
			if((2*n+2 <= size -1) && array[2*n+2] > array[index]) {
				index = 2*n+2;
			}
			
			if(index != n) {
				array[n] = array[n] ^ array[index];
				array[index] = array[n] ^ array[index];
				array[n] = array[n] ^ array[index];
			}
		}
	}
	
}
