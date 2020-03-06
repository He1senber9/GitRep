package club.vann.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class LeetCode_349 {

	public static void main(String[] args) {
		int[] nums1 = {1,2,2,1}, nums2 = {2,2};
		int[] nums3 = {4,9,5}, nums4 = {9,4,9,8,4};
		
		LeetCode_349 leetCode = new LeetCode_349();
		int[] result = leetCode.intersection(nums3, nums4);
		
		System.out.println(Arrays.toString(result));
	}

	private int[] intersection(int[] nums1, int[] nums2) {
        int len_1 = nums1.length;
        int len_2 = nums2.length;
        
        Set<Integer> setContainer = new HashSet<Integer>();
        Set<Integer> setResult = new HashSet<Integer>();
        for(int n = 0; n < len_1; n ++) {
        	setContainer.add(nums1[n]);
        }
        
        for(int m = 0; m < len_2; m ++) {
            if(setContainer.contains(nums2[m])) {
            	setResult.add(nums2[m]);
            }
        }
        
        int[] result = new int[setResult.size()];
        Iterator<Integer> iterator = setResult.iterator();
        int n = 0;
        while(iterator.hasNext()) {
        	result[n++] = iterator.next();
        }
        
        
        return result;
    }
}
