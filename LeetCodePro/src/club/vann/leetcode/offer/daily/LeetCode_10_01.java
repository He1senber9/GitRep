/**
 * 
 */
package leetcode.offer.daily;

import java.util.Arrays;

/**
 * Eays 合并排序的数组
 * 
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 * 
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 * 
 * 示例:
 * 
 * 输入: A = [1,2,3,0,0,0], m = 3 B = [2,5,6], n = 3
 * 
 * 输出: [1,2,2,3,5,6] 
 * 
 * 通过次数1,900提交次数3,294
 * 
 * @author vann
 * @date Mar 3, 2020
 */
public class LeetCode_10_01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] A = {1,2,3,0,0,0};
		int[] B = {2,5,6};
		
		int[] AA = {2,0};
		int[] BB = {1};
		
		int[] AAA = {};
		int[] BBB = {};
		
		LeetCode_10_01 leetCode = new LeetCode_10_01();
		
		leetCode.merge(A, 3, B, B.length);
		System.out.println(Arrays.toString(A));
		
		leetCode.merge(AA, 1, BB, BB.length);
		System.out.println(Arrays.toString(AA));
		
		leetCode.merge(AAA, 0, BBB, 0);
		System.out.println(Arrays.toString(AAA));
	}
	
	private void merge(int[] A, int m, int[] B, int n) {
		int pA = m - 1; // 数组A的最大值索引
		int pB = n - 1; // 数组B的最大值索引
		int cur = m + n - 1;
		
		while(pB >= 0) {
			if(pA >= 0 && B[pB] < A[pA]) {
				A[cur] = A[pA];
				pA --;
			} else {
				A[cur] = B[pB];
				pB --;
			}
			
			cur --;
		}
    }
	
//	private void merge(int[] A, int m, int[] B, int n) {
//		int tagIndex = 0;
//		A:for(int bIndex = 0; bIndex < n; bIndex ++) {
//			
//			A[m] = B[bIndex];
//			for(int aIndex = tagIndex; aIndex < m; aIndex ++) {
//				if(B[bIndex] < A[aIndex]) {
//					int index = m-1;
//					while(index >= aIndex) {
//						A[index+1] = A[index];
//						index --;
//					}
//					A[aIndex] = B[bIndex];
//					m += 1;
//					tagIndex = aIndex+1;
//					continue A;
//				}else {
//					tagIndex = aIndex+1;
//				}
//			}
//			m += 1;
//		}
//    }
	
}
