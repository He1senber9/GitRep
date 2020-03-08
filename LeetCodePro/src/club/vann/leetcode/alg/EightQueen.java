package club.vann.leetcode.alg;

/**
 * 八皇后问题：经典算法：搜索回溯 在8×8格的国际象棋上摆放八个皇后，使其不能互相攻击，即任意两个皇后都不能处于同一行、同一列或同一斜线上，问有多少种摆法。
 * 
 * @author fanyu
 * @date 2020年3月8日
 */
public class EightQueen {

	public static void main(String[] args) {
		EightQueen eightQueen = new EightQueen();
		
		int number = 0;
		int result = 0;
		int[][] pands = null;
		
		number = 8;
		pands = new int[number][number];
		result = eightQueen.eightQueen(number, pands);
		System.out.println("Result: [] " + result);
	}
	
	/**
	 * 
	 * @param number
	 * @return
	 */
	private int eightQueen(int number, int[][] pands) {
		
		for(int n = 0; n < number; n ++) {
			
		}
		return 0;
	}
	
//	private int eightQueen(int number) {
//		return 0;
//	}

}
