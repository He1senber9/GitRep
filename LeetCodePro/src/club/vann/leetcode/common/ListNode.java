package club.vann.leetcode.common;

public class ListNode {
	public int val;
	public ListNode next;
	
	public ListNode(int val) {
		this.val = val;
	}

	@Override
	public String toString() {
		ListNode node = this;
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		while(node != null) {
			builder.append(node.val + ",");
			node = node.next;
		}
		builder.deleteCharAt(builder.length()-1);
		builder.append("]\n");
		return builder.toString();
	}
	
}
