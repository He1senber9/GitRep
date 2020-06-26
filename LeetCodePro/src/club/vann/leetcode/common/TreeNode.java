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

	/**
	 * 二叉树的序列化
	 * @param root
	 * @return
	 */
	public static String serialize(TreeNode root) {
		//tree: [v1,v2,null,...]
		StringBuilder res = new StringBuilder("[");
		Queue<TreeNode> queue = new LinkedList();
		queue.add(root);
		while(!queue.isEmpty()){
			TreeNode cur = queue.remove();
			if(cur == null){
				res.append("null,");
			}else{
				res.append(cur.val + ",");
				queue.add(cur.left);
				queue.add(cur.right);
			}
		}
		res.setLength(res.length() - 1);
		res.append("]");
		return res.toString();
	}

	public static TreeNode deserialize(String data) {
		String[] nodes = data.substring(1, data.length()-1).split(",");
		TreeNode root = getNode(nodes[0]);
		Queue<TreeNode> parents = new LinkedList();
		TreeNode parent = root;
		boolean isLeft = true;
		for(int i = 1; i < nodes.length; i++){
			TreeNode cur = getNode(nodes[i]);
			if(isLeft){
				parent.left = cur;
			}else{
				parent.right = cur;
			}
			if(cur != null){
				parents.add(cur);
			}
			isLeft = !isLeft;
			if(isLeft){
				parent = parents.poll();
			}
		}
		return root;
	}

	private static TreeNode getNode(String val) {
		if(val.equals("null")){
			return null;
		}
		return new TreeNode(Integer.valueOf(val));
	}
}
