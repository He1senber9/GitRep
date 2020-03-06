package club.vann.leetcode.common;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(int val) {
		this.val = val;
	}
	
	
	/**
	 * 二叉树自上而下逐层遍历。
	 * 
	 * @param node
	 */
	public static void printFromTopToBottom(TreeNode node) {
		List<Integer> list = new ArrayList<Integer>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		
		if(node != null) {
			queue.offer(node);
		}
		
		while(queue.peek() != null) {
			
		}
	}
}
