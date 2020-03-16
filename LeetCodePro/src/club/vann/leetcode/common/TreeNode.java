package club.vann.leetcode.common;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(int val) {
		this.val = val;
	}


	/**
	 * 重写二叉树 toString 方法，逐层输出
	 * @return
	 */
	@Override
	public String toString() {
		LinkedList<TreeNode> list = new LinkedList<TreeNode>();
		list.add(this);

		StringBuilder builder = new StringBuilder();
		builder.append("[");
		int i = 0;
		while(!list.isEmpty()) {
			TreeNode node = list.pollFirst();
			builder.append(node.val + ", ");
			if(node.left != null) {
				list.add(node.left);
			}
			if(node.right != null) {
				list.add(node.right);
			}
		}
		builder.append("]");
		return builder.toString();
	}
}
