package leetcode.offer;

import java.util.HashMap;
import java.util.Map;

import leetcode.common.TreeNode;

/**
 * Midum
 * 
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 
 * 
 * 例如，给出
 * 
 * 前序遍历 preorder = [3,9,20,15,7] 中序遍历 inorder = [9,3,15,20,7] 
 * 
 * 返回如下的二叉树：
 * 
 * 		3 
 * 	   / \ 
 *    9  20 
 *       / \ 
 *      15 7  
 * 
 * 限制：
 * 
 * 0 <= 节点个数 <= 5000
 * 
 * @author vann
 *
 */
public class LeetCode_7 {

	public static void main(String[] args) {
		int[] preorder = {3,9,20,15,7};
		int[] inorder = {9,3,15,20,7};
		
		LeetCode_7 leetCode = new LeetCode_7();
		TreeNode result = leetCode.buildTree(preorder, inorder);
	}

	/**
	 * 思想：
	 *  1. 前序遍历的第一个节点肯定是根节点。
	 *  2. 中序遍历的第一个节点肯定是二叉树的左子树的根或者左叶子。
	 *  
	 * @param preorder 前序遍历
	 * @param inorder  中序遍历
	 * @return
	 */
	private TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder == null || preorder.length == 0) {
			return null;
		}
		
		int size = preorder.length;
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int n = 0; n < size; n ++) {
			map.put(inorder[n], n);
		}
			
		TreeNode root = null;
		TreeNode curNode = null;
		for(int n = 0; n < size; n ++) {
			int val = preorder[n];
			
			if(!map.containsKey(val)) { // 证明该节点已经加载过了
				continue;
			}
			
			curNode = new TreeNode(val);
			
			if(n == 0) {
				root = curNode;
			}
			
			int left = map.get(val) - 1;
			int right = map.get(val) + 1;
			if(left >= 0) {
				curNode.left = new TreeNode(inorder[left]);
				map.remove(inorder[left]);
			}
			if(right < size) {
				curNode.right = new TreeNode(inorder[right]);
				map.remove(inorder[right]);
			}
			
			map.remove(val);
		}
		
		return root;
	}
	
	private TreeNode rebuilderTreeNode(Map<Integer, Integer> map) {
		return null;
	}

}
