package club.vann.leetcode.offer;

import java.util.LinkedList;
import club.vann.leetcode.common.TreeNode;


/**
 * Midum 对称的二叉树
 * 
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * 
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * 
 *     1    
 *    / \   
 *   2   2   
 *  / \ / \ 
 * 3  4 4  3
 * 
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * 
 *     1     
 *    / \   
 *   2   2     
 *    \   \     
 *     3   3
 * 
 * 示例 1：
 * 
 * 输入：root = [1,2,2,3,4,4,3] 输出：true 
 * 
 * 示例 2：
 * 
 * 输入：root = [1,2,2,null,3,null,3] 输出：false  
 * 
 * 限制：
 * 
 * 0 <= 节点个数 <= 1000
 * 
 * @author vann
 *
 */
public class LeetCode_28 {

	public static void main(String[] args) {
//		TreeNode node = new TreeNode(1);
//		TreeNode node_left = new TreeNode(2);
//		TreeNode node_right = new TreeNode(2);
//		TreeNode node_left_left = new TreeNode(3);
//		TreeNode node_left_right = new TreeNode(4);
//		TreeNode node_right_left = new TreeNode(4);
//		TreeNode node_right_right = new TreeNode(3);
//		
//		node.left = node_left;
//		node.right = node_right;
//		node_left.left = node_left_left;
//		node_left.right = node_left_right;
//		node_right.left = node_right_left;
//		node_right.right = node_right_right;
		
		TreeNode node = new TreeNode(1);
		TreeNode node_left = new TreeNode(2);
		TreeNode node_right = new TreeNode(2);
		TreeNode node_left_left = new TreeNode(2);
		TreeNode node_left_right = null;
		TreeNode node_right_left = new TreeNode(2);
		TreeNode node_right_right = null;
		
		node.left = node_left;
		node.right = node_right;
		node_left.left = node_left_left;
		node_left.right = node_left_right;
		node_right.left = node_right_left;
		node_right.right = node_right_right;
		
		LeetCode_28 leetCode = new LeetCode_28();
		boolean result = leetCode.isSymmetric(node);
		System.out.println(result);
	}

	private boolean isSymmetric(TreeNode root) {
		
		// 中序遍历
		LinkedList<TreeNode> list = new LinkedList<TreeNode>();
		printInOrder(list, root);
		int size = list.size();
		int n = size / 2;
		while(n > 0) {
			if(list.pollFirst().val != list.pollLast().val) {
				return false;
			}
			n --;
		}
		
		return true;
	}
	
	private void printInOrder(LinkedList<TreeNode> list, TreeNode root) {
		if(root != null) {
			printInOrder(list, root.left);
			list.add(root);
			printInOrder(list, root.right);
		}
	}
}
