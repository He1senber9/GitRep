package club.vann.leetcode;

import java.util.Arrays;

/*
 * 给定由 N 个小写字母字符串组成的数组 A，其中每个字符串长度相等。
 * 删除 操作的定义是：选出一组要删掉的列，删去 A 中对应列中的所有字符，形式上，第 n 列为 [A[0][n], A[1][n], ..., A[A.length-1][n]]）。
 * 
 * 比如，有 A = ["abcdef", "uvwxyz"]，要删掉的列为 {0, 2, 3}，
 * 删除后 A 为["bef", "vyz"]， A 的列分别为["b","v"], ["e","y"], ["f","z"]。
 * 
 * 你需要选出一组要删掉的列 D，对 A 执行删除操作，使 A 中剩余的每一列都是 非降序 排列的，然后请你返回 D.length 的最小可能值。
 * 
 * 
 */
public class LeetCode_944 {

	public static void main(String[] args) {
		LeetCode_944 leetCode = new LeetCode_944();
		
		String[] strArrays = {"cba", "daf", "ghi"};
		String[] strArrays1 = {"a", "b"};
		String[] strArrays2 = {"zyx", "wvu", "tsr"};
		
		int count = leetCode.minDeletionSize(strArrays);
		
		System.out.println("count: " + count);
	}
	
	public int minDeletionSize(String[] A) {
        int count = 0; 
        
        int strLen = A[0].length();
        int len = A.length;
        
        for(int n = 0; n < strLen; n ++) {
        	int maxTag = 0;
        	for(int m = 0; m < len; m ++) {
        		int tag = A[m].charAt(n);
        		if(maxTag <= tag) {
        			maxTag = tag;
        		} else {
        			count ++;
        			break;
        		}
        	}
        }
        
        return count;
    }

}
