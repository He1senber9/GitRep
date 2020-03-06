package club.vann.leetcode.offer;

import java.util.ArrayList;
import java.util.List;

import club.vann.leetcode.common.TreeNode;


/**
 * Easy 叉搜索树的第k大节点
 * 
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 * 
 * 示例 1:
 * 
 * 输入: root = [3,1,4,null,2], k = 1 
 * 
 *       3 
 *      / \ 
 *     1  4 
 *      \   
 *       2 
 * 输出: 4 
 * 
 * 示例 2:
 * 
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3 
 * 
 *      5 
 *     / \ 
 *    3   6 
 *   / \ 
 *  2   4 
 * / 
 *1 
 *
 *输出: 4  
 * 
 * 限制：
 * 
 * 1 ≤ k ≤ 二叉搜索树元素个数
 * 
 * 通过次数2,206提交次数3,020
 * 
 * @author vann
 *
 */
public class LeetCode_54 {

	public static void main(String[] args) {
//		TreeNode node3 = new TreeNode(3);
//		TreeNode node1 = new TreeNode(1);
//		TreeNode node4 = new TreeNode(4);
//		node3.left = node1;
//		node3.right = node4;
//		
//		TreeNode node2 = new TreeNode(2);
//		node1.right = node2;
		
		TreeNode node5 = new TreeNode(5);
		TreeNode node3 = new TreeNode(3);
		TreeNode node6 = new TreeNode(6);
		node5.left = node3;
		node5.right = node6;
		
		TreeNode node2 = new TreeNode(2);
		TreeNode node4 = new TreeNode(4);
		node3.left = node2;
		node3.right = node4;
		
		TreeNode node1 = new TreeNode(1);
		node2.left = node1;
		
		LeetCode_54 leetCode = new LeetCode_54();
		int result = leetCode.kthLargest(node5, 2);
		System.out.println(result);
	}
	
	/**
	 * 分析： 
	 * 1.二叉搜索树：左子节点<根节点<右子节点。
	 * 2.其实就是 右-根-左 遍历。
	 * 
	 * 
	 * @param root
	 * @param k
	 * @return
	 */
	private int kthLargest(TreeNode root, int k) {
		List<TreeNode> list = new ArrayList<TreeNode>();
		backOrder(root, list);
		
		TreeNode node = list.get(k-1);
		return node.val;
    }
	
	private void backOrder(TreeNode node, List<TreeNode> list) {
		if(node != null) {
			if(node.right != null) {
				backOrder(node.right, list);
			}
			
			list.add(node);
			
			if(node.left != null) {
				backOrder(node.left, list);
			}
		}
	}

}
