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

	public static String serialize(TreeNode node) {
		return null;
	}

	/**
	 * "[1,2,3,null,null,4,5]"
	 * @param data
	 * @return
	 */
	// Decodes your encoded data to tree.
	public static TreeNode deserialize(String data) {
		String dataStr = data;
		dataStr = dataStr.substring(1);
		dataStr = dataStr.substring(0, dataStr.lastIndexOf("]"));

		String[] datas = dataStr.split(",");

		TreeNode root = deserialize(datas, 0);

		return root;
	}

	private static TreeNode deserialize(String[] datas, int index) {
		if(index >= datas.length || datas[index] == null || "".equals(datas[index]) || "null".equals(datas[index].trim())) {
			return null;
		}

		String val = datas[index].trim();
		TreeNode node = new TreeNode(Integer.parseInt(val));
		node.left = deserialize(datas, index*2+1);
		node.right = deserialize(datas, index*2+2);
		return node;
	}
}
