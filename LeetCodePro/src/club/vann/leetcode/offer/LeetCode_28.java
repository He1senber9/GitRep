package club.vann.leetcode.offer;

import java.util.Stack;

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
		TreeNode node = new TreeNode(1);
		TreeNode node_left = new TreeNode(2);
		TreeNode node_right = new TreeNode(2);
		TreeNode node_left_left = new TreeNode(3);
		TreeNode node_left_right = new TreeNode(4);
		TreeNode node_right_left = new TreeNode(4);
		TreeNode node_right_right = new TreeNode(3);

		node.left = node_left;
		node.right = node_right;
		node_left.left = node_left_left;
		node_left.right = node_left_right;
		node_right.left = node_right_left;
		node_right.right = node_right_right;
		
//		TreeNode node = new TreeNode(1);
//		TreeNode node_left = new TreeNode(2);
//		TreeNode node_right = new TreeNode(2);
//		TreeNode node_left_left = new TreeNode(2);
//		TreeNode node_left_right = null;
//		TreeNode node_right_left = new TreeNode(2);
//		TreeNode node_right_right = null;
//
//		node.left = node_left;
//		node.right = node_right;
//		node_left.left = node_left_left;
//		node_left.right = node_left_right;
//		node_right.left = node_right_left;
//		node_right.right = node_right_right;
//
//		LeetCode_28 leetCode = new LeetCode_28();
//		boolean result = leetCode.isSymmetric(node);
//		System.out.println("Result[false]" + result);
	}

	/**
	 * 思路：同一层节点，他们左右子树对称。
	 * 1.如何找到同一层。
	 * 2.怎么找到对称的节点。
	 * 
	 * 借助2个栈实现。
	 * 
	 * @param root
	 * @return
	 */
	private boolean isSymmetric(TreeNode root) {
		if(root == null) {
			return true;
		}
		return isSymmetric(root.left, root.right);
	}

	private boolean isSymmetric(TreeNode left, TreeNode right) {
		if(left == null && right == null) {
			return true;
		}

		if(left == null || right == null) {
			return false;
		}

		if(left.val != right.val) {
			return false;
		}
		return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
	}
}
