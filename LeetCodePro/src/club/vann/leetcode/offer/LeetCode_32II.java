package leetcode.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import leetcode.common.TreeNode;

/**
 * Easy 从上到下打印二叉树 II
 * 
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * 
 *  
 * 
 * 例如: 
 * 
 * 给定二叉树: [3,9,20,null,null,15,7],
 * 
 *     3 
 *    / \ 
 *   9  20 
 *     / \ 
 *    15  7
 * 返回其层次遍历结果：
 * 
 * [ [3], [9,20], [15,7] ]  
 * 
 * 提示：
 * 
 * 节点总数 <= 1000
 * 
 * @author vann
 *
 */
public class LeetCode_32II {

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
		
		LeetCode_32II leetCode = new LeetCode_32II();
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
		TreeNode node = null;
		
		while(treeList.size() > 0) {
			int len = treeList.size();
			list = new ArrayList<Integer>();
			
			while(len > 0) {
				node = treeList.removeLast();
				list.add(node.val);
				
				if(node.left != null) {
					treeList.addFirst(node.left);
				}
				
				if(node.right != null) {
					treeList.addFirst(node.right);
				}
				
				len --;
			}
			
			result.add(list);
		}
		
		return result;
    }
}
