package club.vann.leetcode;

import club.vann.leetcode.common.TreeNode;

/**
 * <p>
 * 难度：Easy
 * <p>
 * 题目： 二叉树的最大深度
 * <p>
 * 描述：给定一个二叉树，找出其最大深度。
 * 
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例： 给定二叉树 [3,9,20,null,null,15,7]，
 * 
 *   3
 *  / \
 * 9  20
 *   /  \
 *  15   7
 * 
 *  返回它的最大深度 3 。
 * 
 *  通过次数136,514提交次数188,444
 * 
 * @author fanyu
 * @date 2020年3月10日
 */
public class LeetCode_104 {

	public static void main(String[] args) {
		LeetCode_104 leetCode = new LeetCode_104();
		
		int result = 0;
		
		TreeNode node = new TreeNode(0);
		result = leetCode.maxDepth(node);
		System.out.println("Result[0] : " + result);
		
		TreeNode node1 = new TreeNode(0);
		TreeNode node2 = new TreeNode(0);
		node1.left = node2;
		result = leetCode.maxDepth(node1);
		System.out.println("Result[0] : " + result);
		
		TreeNode node3 = new TreeNode(3);
		TreeNode node9 = new TreeNode(9);
		TreeNode node20 = new TreeNode(20);
		TreeNode node15 = new TreeNode(15);
		TreeNode node7 = new TreeNode(7);
		node3.left = node9;
		node3.right = node20;
		node20.left = node15;
		node20.right = node7;
		result = leetCode.maxDepth(node3);
		System.out.println("Result[3] : " + result);
	}
	
	private int maxDepth(TreeNode root) {
		if(root == null) {
			return 0;
		}
		
		int l = maxDepth(root.left);
		int r = maxDepth(root.right);
		
		return Math.max(l, r) + 1;
	}

}
