package club.vann.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class LeetCode_832 {
	
	public static void main(String[] args) {
//		int[][] arrays = {{1,1,0},{1,0,1},{0,0,0}};
		int[][] arrays = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
		
		LeetCode_832 leetcode = new LeetCode_832();
		int[][] arraysNew = leetcode.flipAndInvertImage(arrays);
		System.out.println("****");
	}
	
	public int[][] flipAndInvertImage(int[][] A) {
        int len = A.length;
        
        for(int n = 0; n < len; n ++) {
            arraysReverse(A[n]);
        }
        
        return A;
    }
    
    /**
     * 翻转数组
     */
    private void arraysReverse(int[] array) {
        int len = array.length;
        
        for(int n = 0; n < len/2; n ++) {
            int temp = array[n];
            array[n] = array[len-1 - n];
            array[len-1 - n] = temp;
        }
        
        for(int n = 0; n < len; n ++) {
        	array[n] = (array[n] == 1 ? 0 : 1);
        }
    }
}
