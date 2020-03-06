package leetcode.offer;

/**
 * Easy 旋转数组的最小数字
 * 
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 
 * 例如，数组 [3,4,5,1,2]为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 * 
 * 示例 1：
 * 
 * 输入：[3,4,5,1,2] 输出：1 
 * 
 * 示例 2：
 * 
 * 输入：[2,2,2,0,1] 输出：0
 * 
 * @author vann
 *
 */
public class LeetCode_11 {

	public static void main(String[] args) {
		int[] array = {3,4,5,1,2};
		int[] array1 = {2,2,2,0,1};
		int[] array2 = {1,3,5};
		
		LeetCode_11 leetCode = new LeetCode_11();
		int result = leetCode.minArray(array2);
		System.out.println(result);
	}

	private int minArray(int[] numbers) {
		int size = numbers.length;
		
		if(size == 1) {
			return numbers[0];
		}
		
		int index = 0;
		while(index < (size-1)) {
			if(numbers[index] > numbers[index+1]) {
				break;
			}
			
			index ++;
		}
		
		System.out.println(size + ", " + index);
		return numbers[index+1];
	}

}
