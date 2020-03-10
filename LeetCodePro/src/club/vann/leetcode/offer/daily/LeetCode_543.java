package club.vann.leetcode.offer.daily;

import java.util.ArrayList;
import java.util.List;

import club.vann.leetcode.common.TreeNode;

/**
 * <p>
 * 难度：Easy
 * <p>
 * 题目：二叉树的直径
 * <p>
 * 描述：给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 * <p>
 * 示例 : 给定二叉树 
 * 
 *     1 
 *    / \ 
 *   2   3 
 *  / \ 
 * 4   5
 * 
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *<p> 
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 * 通过次数22,971提交次数48,073
 * 
 * @author fanyu
 * @date 2020年3月10日
 */
public class LeetCode_543 {

	public static void main(String[] args) {
		LeetCode_543 leetCode = new LeetCode_543();
		
		int result = 0;
		
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		result = leetCode.diameterOfBinaryTree(node1);
		System.out.println("Result[3] :" + result);
		
		TreeNode node = new TreeNode(0);
		result = leetCode.diameterOfBinaryTree(node);
		System.out.println("Result[0] :" + result);
		
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);
		node7.left = node8;
		result = leetCode.diameterOfBinaryTree(node7);
		System.out.println("Result[1] :" + result);
		
		TreeNode node9 = new TreeNode(9);
		TreeNode node10 = new TreeNode(10);
		TreeNode node11 = new TreeNode(11);
		TreeNode node12 = new TreeNode(12);
		TreeNode node13 = new TreeNode(13);
		TreeNode node14 = new TreeNode(14);
		TreeNode node15 = new TreeNode(15);
		TreeNode node16 = new TreeNode(16);
		TreeNode node17 = new TreeNode(17);
		TreeNode node18 = new TreeNode(18);
		node9.left = node10;
		node9.right = node11;
		node11.left = node12;
		node11.right = node13;
		node13.left = node14;
		node13.right = node15;
		node14.left = node16;
		node14.right = node17;
		node17.right = node18;
		result = leetCode.diameterOfBinaryTree(node9);
		System.out.println("Result[6] :" + result);
		
		TreeNode node19 = new TreeNode(4);
		TreeNode node20 = new TreeNode(-7);
		TreeNode node21 = new TreeNode(-3);
		TreeNode node22 = new TreeNode(-9);
		TreeNode node23 = new TreeNode(-3);
		TreeNode node24 = new TreeNode(9);
		TreeNode node25 = new TreeNode(-7);
		TreeNode node26 = new TreeNode(-4);
		TreeNode node27 = new TreeNode(6);
		TreeNode node28 = new TreeNode(-6);
		TreeNode node29 = new TreeNode(-6);
		TreeNode node30 = new TreeNode(0);
		TreeNode node31 = new TreeNode(6);
		TreeNode node32 = new TreeNode(5);
		TreeNode node33 = new TreeNode(9);
		TreeNode node34 = new TreeNode(-1);
		TreeNode node35 = new TreeNode(-4);
		TreeNode node36 = new TreeNode(-2);
		
		node19.left = node20;
		node19.right = node21;
		node21.left = node22;
		node21.right = node23;
		node22.left = node24;
		node22.right = node25;
		node23.left = node26;
		node24.left = node27;
		node25.left = node28;
		node25.right = node29;
		node27.left = node30;
		node27.right = node31;
		node28.left = node32;
		node29.left = node33;
		node30.right = node34;
		node31.left = node35;
		node33.left = node36;
		result = leetCode.diameterOfBinaryTree(node19);
		System.out.println("Result[8] :" + result);
	}
	
	/**
	 * 思路：
	 *       定义dp(node)表示为当前节点左右子树深度和。
	 *      那么原问题就是求最终 dp(node)的最大值问题。
	 * 
	 * 
	 * @param root
	 * @return
	 */
	private int diameterOfBinaryTree(TreeNode root) {
		if(root == null) {
			return 0;
		}
		
		int max = 0;
		max = diameter(root);
		
		return max;
    }
	
	private int diameter(TreeNode root) {
		//
		if(root == null) {
			return 0;
		}
		
		int max = 0;
		
		int lenL = deep(root.left);
		int lenR = deep(root.right);
		
		if(root.left != null) {
			lenL = 1 + lenL;
		}
		if(root.right != null) {
			lenR = 1 + lenR;
		}
		
		max = Math.max(max, lenL+lenR);
		max = Math.max(max, diameter(root.left));
		max = Math.max(max, diameter(root.right));
		
		return max;
    }
	
	/**
	 * 计算当前节点的深度。
	 * @param node
	 * @return
	 */
	private int deep(TreeNode node) {
		if(node == null) {
			return 0;
		}
		int deepL = 0;
		if(node.left != null) {
			deepL = 1 + deep(node.left);
		}
		
		int deepR = 0;
		if(node.right != null) {
			deepR = 1 + deep(node.right);
		}
		return Math.max(deepL, deepR);
	}

}
