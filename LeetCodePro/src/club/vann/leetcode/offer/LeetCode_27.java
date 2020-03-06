package leetcode.offer;

import leetcode.common.TreeNode;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * 
 * 例如输入：
 * 
 *     		4    
 * 		  /   \   
 *       2     7  
 *      / \   / \ 
 *     1   3 6   9 
 *    
 * 镜像输出：
 * 
 *       	4    
 *        /   \   
 *       7     2  
 *      / \   / \ 
 *     9   6 3   1
 * 
 * 示例 1：
 * 
 * 输入：root = [4,2,7,1,3,6,9] 输出：[4,7,2,9,6,3,1]  
 * 
 * 限制：
 * 
 * 0 <= 节点个数 <= 1000
 * 
 * @author vann
 *
 */
public class LeetCode_27 {

	public static void main(String[] args) {
		TreeNode node4 = new TreeNode(4);
		TreeNode node2 = new TreeNode(2);
		TreeNode node7 = new TreeNode(7);
		TreeNode node1 = new TreeNode(1);
		TreeNode node3 = new TreeNode(3);
		TreeNode node6 = new TreeNode(6);
		TreeNode node9 = new TreeNode(9);
		
		node4.left = node2;
		node4.right = node7;
		
		node2.left = node1;
		node2.right = node3;
		
		node7.left = node6;
		node7.right = node9;
		
		LeetCode_27 leetCode = new LeetCode_27();
		TreeNode result = leetCode.mirrorTree(node4);
	}

	private TreeNode mirrorTree(TreeNode node) {
		if(node == null) {
			return null;
		}
		
		TreeNode left = node.left;
		node.left = mirrorTree(node.right);
		node.right = mirrorTree(left);
		
        return node;
    }
	
}