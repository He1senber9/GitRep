package club.vann.leetcode.offer.daily;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * <p>
 * 难度：Easy 
 * <p>
 * 题目：和为s的连续正数序列 
 * <p>
 * 描述：输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。</br>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * 
 * <p>
 * 示例 1：
 * 
 * 输入：target = 9 输出：[[2,3,4],[4,5]] 
 * <p>
 * 示例 2：
 * 
 * 输入：target = 15 输出：[[1,2,3,4,5],[4,5,6],[7,8]]  
 * 
 * <p>
 * 限制：
 * 
 * 1 <= target <= 10^5  
 * 
 * 通过次数4,291提交次数5,961
 * 
 * @author fanyu
 *
 */
public class LeetCode_57II {

	public static void main(String[] args) {
		LeetCode_57II leetCode = new LeetCode_57II();
		
		int target = 9;
		int[][] result = leetCode.findContinuousSequence(target);
		System.out.println(result);
		
		target = 15;
		result = leetCode.findContinuousSequence(target);
		System.out.println(result);
		
	}
	
	private int[][] findContinuousSequence(int target) {

        if(target < 3) {
            return new int[0][];
        }

        List<int[]> listArray = new ArrayList<int[]>();
        int begin = 1, end = 2;
        int medium = target/2;
        while(begin <= medium && begin < end) {
        	int sum = (begin+end) * (end-begin+1) / 2;
        	if(sum == target) {
        		int[] array = new int[end-begin+1];
        		int t = 0;
        		for(int i = begin; i <= end; i ++) {
        			array[t++] = i;
        		}
        		listArray.add(array);
                begin ++;
        	} else if(sum < target) {
        		end++;
        	} else {
        		begin ++;
        	}
        }     
        
        int[][] result = new int[listArray.size()][];
        for(int n = 0; n < result.length; n ++) {
        	int[] tmp = listArray.get(n);
        	result[n] = tmp;
        }
        return result;
    }

}
