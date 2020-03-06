package club.vann.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角。
 * 
 * @author vann
 *
 */
public class LeetCode_118 {
	public static void main(String[] args) {
		LeetCode_118 leetCode = new LeetCode_118();
		int numRows = 5;
		List<List<Integer>> result = leetCode.generate(numRows);
		for(int n = 0; n < result.size(); n ++) {
			System.out.println(result.get(n));
		}
	}

	private List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(numRows == 0) {
			List<Integer> data = new ArrayList<Integer>();
			result.add(data); 
			return result;
		}
		
		int[] rowPri = {1, 0};
		for(int n = 1; n <= numRows; n ++) {
			List<Integer> data = new ArrayList<Integer>();
			int lenPri = rowPri.length;
			int[] rowNew = new int[lenPri+1];
			for(int m = 1; m < lenPri; m ++) {
				rowNew[m] = rowPri[m-1] + rowPri[m];
				data.add(rowNew[m]);
			}
			result.add(data);
			rowPri = rowNew;
		}
		return result;
	}
}
