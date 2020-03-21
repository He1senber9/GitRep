package club.vann.leetcode.offer;

import java.util.HashMap;
import java.util.Map;

import club.vann.leetcode.common.TreeNode;


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
		int[] preorder = null;
		int[] inorder = null;
		TreeNode result = null;
		LeetCode_7 leetCode = new LeetCode_7();

//		preorder = new int[]{3,9,20,15,7};
//		inorder = new int[]{9,3,15,20,7};
//		result = leetCode.buildTree(preorder, inorder);
//		System.out.println(result);

		preorder = new int[]{1,2,4,8,9,5,10,11,3,6,7};
		inorder = new int[]{8,4,9,2,10,5,11,1,6,3,7};
		result = leetCode.buildTree(preorder, inorder);
		System.out.println(result);
	}

	Map<Integer, Integer> map = null;

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

		int len = preorder.length;
		// 使用Map存储中序遍历元素及其对应的索引
		map = new HashMap<Integer, Integer>();
		for(int n = 0; n < len; n ++) {
			map.put(inorder[n], n);
		}

		TreeNode root = buildTree(preorder, inorder, 0);
		
		return root;
	}

	private TreeNode buildTree(int[] preorder, int[] inorder, int index) {
		if(index >= preorder.length) {
			return null;
		}

		int curVal = preorder[index];
		TreeNode node = new TreeNode(curVal);

		if(index+1 >= preorder.length) {
			return node;
		}

		int indexNext = map.get(preorder[index+1]);
		if(indexNext < index) { // 左子树
			node.left = buildTree(preorder, inorder, index+1);
		} else {
			node.right = buildTree(preorder, inorder, index+1);
		}

		return node;
	}

}
