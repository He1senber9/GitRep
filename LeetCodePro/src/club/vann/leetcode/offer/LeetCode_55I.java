/**
 * 
 */
package leetcode.offer;

import leetcode.common.TreeNode;

/**
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径， 
 * 最长路径的长度为树的深度。
 * 
 * 例如：
 * 
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * 
 * 		3 
 * 	   / \ 
 *    9  20 
 *      / \ 
 *     15  7 
 *    
 * 返回它的最大深度 3 。
 * 
 * 提示：
 * 
 * 节点总数 <= 10000
 * 
 * @author vann
 *
 */
public class LeetCode_55I {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode rootNode = new TreeNode(3);
		TreeNode left = new TreeNode(9);
		TreeNode right = new TreeNode(20);
		rootNode.left = left;
		rootNode.right = right;
		
		TreeNode rightleft = new TreeNode(15);
		TreeNode rightright = new TreeNode(7);
		right.left = rightleft;
		right.right = rightright;
		
		LeetCode_55I leetCode = new LeetCode_55I();
		int result = leetCode.maxDepth(rootNode);
		System.out.println(result);
	}
	
	private int maxDepth(TreeNode root) {
		if(root == null) {
			return 0;
		}
		return 1 + (int) Math.max(maxDepth(root.left), maxDepth(root.right)); 
	}

}