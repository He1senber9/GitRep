package leetcode.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * Easy 和为s的连续正数序列
 * 
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * 
 * 示例 1：
 * 
 * 输入：target = 9 输出：[[2,3,4],[4,5]]
 * 
 * 示例 2：
 * 
 * 输入：target = 15 输出：[[1,2,3,4,5],[4,5,6],[7,8]]  
 * 
 * 限制：
 * 
 * 1 <= target <= 10^5  
 * 
 * 通过次数1,794提交次数2,503
 * 
 * @author vann
 * @date Feb 29, 2020
 */
public class LeetCode_57II {

	public static void main(String[] args) {
		int n = 15;
		LeetCode_57II leetCode = new LeetCode_57II();
		int[][] result = leetCode.findContinuousSequence(n);
		
		System.out.println(result);
	}

	/**
	 * 思路： 
	 * 1. x, x+1, x+2 ... 为连续的正整数。
	 * 2. target == 1、或者2 时，返回空。
	 * 3. 如果target为偶数时，不存在两个连续的值相加为target。如果为奇数，必存在 target/2, target/2+1 这两个连续的数。（前提是target >= 3)
	 * 4. 设结果集合[m,n](m<n)。 则有 1<=m<n， 1<n平方<=target平方/4.
	 * @param target
	 * @return
	 */
	private int[][] findContinuousSequence(int target) {
		if(target == 1 || target == 2) {
			return new int[0][0];
		}
		
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		
		List<Integer> l = null;
		// 针对target， 结果集合从 [1, target平方/4再开根)
		int left = 1, right = target/2;
		for(int n = 1; n <= right; n ++) {
			l = new ArrayList<Integer>();
			int sum = 0, tmp = n;
			while((sum+tmp) <= target) {
				l.add(tmp);
				sum = sum + tmp;
				tmp = tmp + 1;
			}
			
			if(sum != target) {
				l.clear();
				l = null;
			} else {
				list.add(l);
			}
		}
		
		
		
		int size = list.size();
		int[][] result = new int[size][];
		for(int n = 0; n < size; n ++) {
			List<Integer> li = list.get(n);
			int[] tmp = new int[li.size()];
			for(int m = 0; m < li.size(); m ++) {
				tmp[m] = li.get(m);
			}
			result[n] = tmp;
		}
		
		return result;
	}

}
