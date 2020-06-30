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

	public static ListNode deserialize(String data) {
		ListNode head = new ListNode(0);
		ListNode cur = head;

		data = data.substring(1, data.length()-1);
		data = data.replaceAll(" ", "");
		String[] datas = data.split(",");

		for(String val : datas) {
			ListNode node = new ListNode(Integer.parseInt(val));
			cur.next = node;
			cur = cur.next;
		}

		return head.next;
	}

	public static void main(String[] args) {
		ListNode node = ListNode.deserialize("[1, 2, 3, 3, 2, 1]");
		System.out.println(node);
	}
}
