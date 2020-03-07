/**
 * 
 */
package club.vann.leetcode.offer;

import club.vann.leetcode.common.TreeNode;

/**
 * <p>
 * 难度：Easy
 * <p>
 * 题目：二叉搜索树的最近公共祖先
 * <p>
 * 描述：给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x
 * 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 * 
 * 示例 1:
 * 
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8 输出: 6 解释: 节点 2 和节点 8
 * 的最近公共祖先是 6。 示例 2:
 * 
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4 输出: 2 解释: 节点 2 和节点 4
 * 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。  
 * 
 * 说明:
 * 
 * 所有节点的值都是唯一的。 p、q 为不同节点且均存在于给定的二叉搜索树中。 注意：本题与主站 235
 * 题相同：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * 
 * 通过次数2,794提交次数4,109
 * 
 * @author vann
 * @date Mar 6, 2020
 */
public class LeetCode_68I {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LeetCode_68I leetCode = new LeetCode_68I();
		
		TreeNode node6 = new TreeNode(6);
		TreeNode node6L2 = new TreeNode(2);
		TreeNode node6R8 = new TreeNode(8);
		node6.left = node6L2;
		node6.right = node6R8;
		
		TreeNode node2L0 = new TreeNode(0);
		TreeNode node2R4 = new TreeNode(4);
		node6L2.left = node2L0;
		node6L2.right = node2R4;
		
		TreeNode node8L7 = new TreeNode(7);
		TreeNode node8R9 = new TreeNode(9);
		node6R8.left = node8L7;
		node6R8.right = node8R9;
		
		TreeNode node4L3 = new TreeNode(3);
		TreeNode node4R5 = new TreeNode(5);
		node2R4.left = node4L3;
		node2R4.right = node4R5;
		
		TreeNode result = leetCode.lowestCommonAncestor(node6, node6L2, node6R8);
		System.out.println("Result [6]:" + result.val);
		
		result = leetCode.lowestCommonAncestor(node6, node6L2, node2R4);
		System.out.println("Result [2]:" + result.val);
	}

	private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		return null;
	}

}
