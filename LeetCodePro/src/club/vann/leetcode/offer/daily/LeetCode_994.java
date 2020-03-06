package club.vann.leetcode.offer.daily;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Easy 
 * ���õ�����
 * @author fanyu
 *
 */
public class LeetCode_994 {
	// �����ҵ�ָ���ڵ���������ҽڵ�
	private int[] dr = {-1, 0, 0, 1};
	private int[] dc = {0, -1, 1, 0};

	public static void main(String[] args) {
		LeetCode_994 leetCode = new LeetCode_994();
		
		int[][] grid = {{2,1,1}, {1,1,0}, {0,1,1}};
		int result = leetCode.orangesRotting(grid);
		System.out.println("Result[4]: " + result);
		
		int[][] grid1 = {{2,1,1}, {0,1,1}, {1,0,1}};
		result = leetCode.orangesRotting(grid1);
		System.out.println("Result[-1]: " + result);
		
		int[][] grid2 = {{0,2}};
		result = leetCode.orangesRotting(grid2);
		System.out.println("Result[0]: " + result);
		
		int[][] grid3 = {{0}};
		result = leetCode.orangesRotting(grid3);
		System.out.println("Result[0]: " + result);
		
		int[][] grid4 = {{1}};
		result = leetCode.orangesRotting(grid4);
		System.out.println("Result[-1]: " + result);
		
		int[][] grid5 = {{2}};
		result = leetCode.orangesRotting(grid5);
		System.out.println("Result[0]: " + result);
	}
	
	private int orangesRotting(int[][] grid) {
		int result = 0;
		int ySize = grid.length;
		int xSize = grid[0].length;
		
		LinkedList<List<Integer>> list = new LinkedList<List<Integer>>();
		// �������е�ǰ���õĽڵ�
		for(int y = 0; y < ySize; y ++) {
			for(int x = 0; x < xSize; x ++) {
				if(grid[y][x] == 2) { 
					List<Integer> l = new ArrayList<Integer>(2);
					l.add(x);
					l.add(y);
					list.offer(l);
				}
			}
		}
		
//		if(list.size() == 0) { // ��ǰ�б���û�и����ڵ�
//			return -1;
//		}
	
		while(!list.isEmpty()) {
			int len = list.size();
			
			// ����������Ԫ����ͬһ��
			for(int t=0; t < len; t ++) {
				List<Integer> ll = list.pollFirst();
				int x = ll.get(0);
				int y = ll.get(1);
				
				// ������������4���ڵ�
				for(int k = 0; k < 4; k ++) {
					int tmpX = x + dr[k];
					int tmpY = y + dc[k];
					
					if(tmpX >= 0 && tmpX < xSize && tmpY >= 0 && tmpY < ySize && grid[tmpY][tmpX] ==1) {
						grid[tmpY][tmpX] = 2;
						List<Integer> tmp = new ArrayList<Integer>(2);
						tmp.add(tmpX);
						tmp.add(tmpY);
						
						list.add(tmp);
					}
				}
			}
			
			if(!list.isEmpty()) {
				result ++;
			}
		}
		
		//
		for(int y = 0; y < ySize; y ++) {
			for(int x = 0; x < xSize; x ++) {
				if(grid[y][x] == 1) {
					return -1;
				}
			}
		}
		
		return result;
    }

}
