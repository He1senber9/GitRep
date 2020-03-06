package leetcode.offer;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素
 * B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * 
 *  
 * 
 * <p>示例:</br>
 * 
 * 输入: [1,2,3,4,5] 输出: [120,60,40,30,24]
 * 
 * @author vann
 *
 */
public class LeetCode_66 {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		// [286654464,1003290624,1003290624,501645312,1003290624,2006581248,250822656,250822656,222953472,334430208,250822656,222953472,334430208,668860416,1003290624,2006581248]
		int[] arr1 = {7, 2, 2, 4, 2, 1, 8, 8, 9, 6, 8, 9, 6, 3, 2, 1};
		
		System.out.println(5 & 4);
		LeetCode_66 leetCode = new LeetCode_66();
		int[] result = leetCode.constructArr(arr);
		System.out.println("[286654464, 1003290624, 1003290624, 501645312, 1003290624, 2006581248, 250822656, 250822656, 222953472, 334430208, 250822656, 222953472, 334430208, 668860416, 1003290624, 2006581248]");
		System.out.println(Arrays.toString(result));
	}

	private int[] constructArr(int[] a) {
		if(a == null || a.length < 2) {
			return a;
		}
		
		int size = a.length;
		int[] result = new int[size];
		
		int left = 1;
		for(int n = 0; n < size; n ++) {
			result[n] = left;
			left *= a[n];
		}
		
		int right = 1;
		for(int n = size-1; n >= 0; n --) {
			result[n] = result[n] * right;
			right *= a[n];
		}
		return result;
	}

}
