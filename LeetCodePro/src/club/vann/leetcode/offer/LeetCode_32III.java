package leetcode.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.common.TreeNode;

/**
 * Midum
 * 
 * 从上到下打印二叉树 III
 * 
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，
 * 第三行再按照从左到右的顺序打印，其他行以此类推。
 * 
 * 例如: 给定二叉树: [3,9,20,null,null,15,7],
 * 
 *      3 
 *     / \ 
 *    9  20 
 *      / \ 
 *     15 7 
 *     
 * 返回其层次遍历结果：[ [3], [20,9], [15,7] ]  
 * 
 * 提示：
 * 
 * 节点总数 <= 1000
 * 
 * @author vann
 *
 */
public class LeetCode_32III {

	public static void main(String[] args) {
//		TreeNode node = new TreeNode(3);
//		node.left = new TreeNode(9);
//		node.right = new TreeNode(20);
//		
//		node.right.left = new TreeNode(15);
//		node.right.right = new TreeNode(7);
		
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		
		node.left.left = new TreeNode(4);
		node.right.right = new TreeNode(5);
		
		LeetCode_32III leetCode = new LeetCode_32III();
		List<List<Integer>> result = leetCode.levelOrder(node);
		System.out.println(result);
	}
	
	private List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root == null) {
			return result;
		}
		
		LinkedList<TreeNode> treeList = new LinkedList<TreeNode>();
		treeList.add(root);
		
		List<Integer> list = null;
		int flag = 1; // 1 表示从左往右， -1 表示从右往左
		while(!treeList.isEmpty()) {
			int len = treeList.size();
			
			list = new ArrayList<Integer>();
			while(len > 0) {
				
				TreeNode node = null;
				if(flag == 1) { // 从左往右
					node = treeList.removeFirst();
					
					if(node.left != null) {
						treeList.addLast(node.left);
					}
					if(node.right != null) {
						treeList.addLast(node.right);
					}
				} else {
					node = treeList.removeLast();
					
					if(node.right != null) {
						treeList.addFirst(node.right);
					}
					if(node.left != null) {
						treeList.addFirst(node.left);
					}
				}
					
				list.add(node.val);
				len --;
			}
			flag *= -1;
			result.add(list);
		}
		
		
		return result;
    }

}
