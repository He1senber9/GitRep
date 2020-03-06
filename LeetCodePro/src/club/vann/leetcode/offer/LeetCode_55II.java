package leetcode.offer;

import java.util.Stack;

import leetcode.common.TreeNode;

/**
 * Easy 平衡二叉树
 * 
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 * 
 * 示例 1:
 * 
 * 给定二叉树 [3,9,20,null,null,15,7]
 * 
 *       3 
 *      / \ 
 *     9  20 
 *        / \ 
 *       15  7 
 * 返回 true 。
 * 
 * 示例 2:
 * 
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * 
 *       1 
 *      / \ 
 *     2   2 
 *    / \ 
 *   3   3 
 *  / \ 
 * 4   4 
 * 返回 false 。
 * 
 * 限制：
 * 
 * 1 <= 树的结点个数 <= 10000
 * 
 * @author vann
 *
 */
public class LeetCode_55II {
	
	private int index = 0;

	public static void main(String[] args) {
//		TreeNode node3 = new TreeNode(3);
//		TreeNode node9 = new TreeNode(9);
//		TreeNode node20 = new TreeNode(20);
//		node3.left = node9;
//		node3.right = node20;
//		
//		TreeNode node15 = new TreeNode(15);
//		TreeNode node7 = new TreeNode(7);
//		node20.left = node15;
//		node20.right = node7;
		
//		TreeNode node1 = new TreeNode(1);
//		TreeNode node1L2 = new TreeNode(2);
//		TreeNode node1R2 = new TreeNode(2);
//		node1.left = node1L2;
//		node1.right = node1R2;
//		
//		TreeNode node2L3 = new TreeNode(3);
//		TreeNode node2R3 = new TreeNode(3);
//		node1L2.left = node2L3;
//		node1L2.right = node2R3;
//		
//		TreeNode node3L4 = new TreeNode(4);
//		TreeNode node3R4 = new TreeNode(4);
//		node2L3.left = node3L4;
//		node2L3.right = node3R4;
		
//		TreeNode node1 = new TreeNode(1);
//		TreeNode node2 = new TreeNode(2);
//		node1.right = node2;
//		
//		TreeNode node3 = new TreeNode(3);
//		node2.right = node3;
		
		TreeNode node1 = new TreeNode(1);
		TreeNode node1L2 = new TreeNode(2);
		TreeNode node1R2 = new TreeNode(2);
		node1.left = node1L2;
		node1.right = node1R2;
		
		TreeNode node2L3 = new TreeNode(3);
		node1L2.left = node2L3;
		
		TreeNode node2R3 = new TreeNode(3);
		node1R2.right = node2R3;
		
		TreeNode node3L4 = new TreeNode(4);
		node2L3.left = node3L4;
		
		TreeNode node3R4 = new TreeNode(4);
		node2R3.right = node3R4;
		
		LeetCode_55II leetCode = new LeetCode_55II();
		boolean result = leetCode.isBalanced(node1);
		
		System.out.println(result);
	}
	
	/**
	 * 解题思路：
	 * 
	 *  中序遍历后，以根节点为中心，左右两边长度差小于等于3就是平衡树。
	 * @param root
	 * @return
	 */
	private boolean isBalanced(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		
		int index = 0;
		while(index < stack.size()) {
			TreeNode node = stack.get(index);
			if((Math.abs(deep(node.left) - deep(node.right)) > 1)) {
				return false;
			}
			if(node.left != null) {
				stack.push(node.left);
			}
			
			if(node.right != null) {
				stack.push(node.right);
			}
			
			index ++;
		}
		return true;
    }
	
	private int deep(TreeNode node) {
		if(node == null) {
			return 0;
		}
		return 1 + Math.max(deep(node.left), deep(node.right));
	}
}
