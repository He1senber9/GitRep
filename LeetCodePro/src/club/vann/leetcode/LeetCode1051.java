package club.vann.leetcode;

public class LeetCode1051 {
	public static void main(String[] args) {
		
		LeetCode1051 leetCode = new LeetCode1051();
		int[] heights = {1, 1, 4, 2, 1, 3};
		
		int index = 1;
		int x = heights[index++];
		
		System.out.println(x + " *** " + index);
//		System.out.println("Result :" + leetCode.heightChecker(heights));
	}
	
	private int heightChecker(int[] arrays) {
		int len = arrays.length;
		
		if(len == 1) {
			return 0;
		}
		
		int counts = 0;
		
		for(int n = 1; n < len; n ++) {
			if(arrays[n] > arrays[n+1]) {
				int minIndex = n + 1;
				for(int m = n+1; m < len; m ++) {
					if(arrays[m] < arrays[minIndex]) {
						counts = counts + 2;
						
						minIndex = m;
					}
				}
			}
		}
		
		return 0;
	}
}
