package club.vann.leetcode.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import club.vann.leetcode.common.TreeNode;


/**
 * Midum 从上到下打印二叉树
 * 
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * 
 * 例如: 给定二叉树: [3,9,20,null,null,15,7],
 * 
 * 		3 
 *     / \ 
 *    9  20 
 *      / \ 
 *     15 7 
 *     
 * 返回：[3,9,20,15,7]  
 * 
 * 提示：
 * 
 * 节点总数 <= 1000 
 * 通过次数1,498提交次数2,265
 * 
 * @author vann
 * @date 
 */
public class LeetCode_32I {

	public static void main(String[] args) {
		TreeNode node = new TreeNode(3);
		node.left = new TreeNode(9);
		node.right = new TreeNode(20);
		
		node.right.left = new TreeNode(15);
		node.right.right = new TreeNode(7);
		
		LeetCode_32I leetCode = new LeetCode_32I();
		int[] result = leetCode.levelOrder(node);
		System.out.println(Arrays.toString(result));
	}

	private int[] levelOrder(TreeNode root) {
		if(root == null) {
			return new int[] {};
		}
		
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		
		TreeNode node = root;
		stack.push(node);
		
		while(!stack.isEmpty()) {
			
			while(!stack.isEmpty()) {
				node = stack.pop();
				list.add(node.val);
				stack1.push(node);
			}
			
			while(!stack1.isEmpty()) {
				node = stack1.pop();
				
				if(node.right != null) {
					stack.push(node.right);
				}
				
				if(node.left != null) {
					stack.push(node.left);
				}
				
			}
		}
		
		int[] result = new int[list.size()];
		for(int n = 0; n < list.size(); n ++) {
			result[n] = list.get(n);
		}
		return result;
    }
	
}
