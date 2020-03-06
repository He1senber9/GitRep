package leetcode.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Easy 顺时针打印矩阵
 * 
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * 
 * 示例 1：
 * 
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]] 
 * 输出：[1,2,3,6,9,8,7,4,5] 
 * 
 * 示例 2：
 * 
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]  
 * 
 * 限制：
 * 
 * 0 <= matrix.length <= 100 
 * 0 <= matrix[i].length <= 100
 * 
 * @author vann
 *
 */
public class LeetCode_29 {

	public static void main(String[] args) {
		int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
		int[][] matrix1 = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
		
		LeetCode_29 leetCode = new LeetCode_29();
		int[] result = leetCode.spiralOrder(matrix);
		System.out.println(Arrays.toString(result));
	}

	private int[] spiralOrder(int[][] matrix) {
		if(matrix == null || matrix.length == 0) {
			return new int[] {};
		}
		
		int y = matrix.length;
		int x = matrix[0].length;
		
		List<Integer> list = new ArrayList<Integer>();
		
		for(int n = 0; n < x; n ++) {
			list.addAll(spiralOrder1(matrix, n, x, y));
		}
		
		int[] array = new int[list.size()];
		for(int n = 0; n < list.size(); n ++) {
			array[n] = list.get(n);
		}
		
		return array;
    }
	
	private List<Integer> spiralOrder1(int[][] matrix, int n, int x, int y) {
		if(matrix == null || matrix.length == 0) {
			return null;
		}
		
		List<Integer> list = new ArrayList<Integer>();
		
		int index_x = 0;
		int index_y = n;
		for(index_x = n; index_x <= (x - n - 1); index_x ++) { 
			list.add(matrix[index_y][index_x]);
		}
		
		index_x--;
		for(index_y = n+1; index_y <= (y - n - 1); index_y ++) {
			list.add(matrix[index_y][index_x]);
		}
		
		index_y--;
		for(index_x = y-1; index_x >= n; index_x --) {
			list.add(matrix[index_y][index_x]);
		}
		
		index_x--;
		for(index_y = n; index_y >= n; index_y --) {
			list.add(matrix[index_y][index_x]);
		}
		
		return list;
    }
}
