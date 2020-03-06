package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 * 
 * @author vann
 *
 */
public class LeetCode_1207 {

	public static void main(String[] args) {
		int[] array = {1,2,2,1,1,3};
		int[] array1 = {1,2};
		int[] array2 = {-3,0,1,-3,1,1,1,-3,10,0};
		
		LeetCode_1207 leetCode = new LeetCode_1207();
//		boolean result = leetCode.uniqueOccurrences(array);
//		boolean result = leetCode.uniqueOccurrences(array1);
		boolean result = leetCode.uniqueOccurrences(array2);
		System.out.println(result);
	}

	private boolean uniqueOccurrences(int[] arr) {
		boolean result = true;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int n = 0; n < arr.length; n ++) {
			map.put(arr[n], map.getOrDefault(arr[n], 0) + 1);
		}
		
		Set<Integer> set = new HashSet<Integer>();
		for(Integer integer : map.values()) {
			if(!set.add(integer)) {
				return false;
			}
		}
		
        return true;
    }
}
