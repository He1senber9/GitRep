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

	/**
	 * 根据字符串反序列化链表
	 *
	 * @param data
	 * @return
	 */
	public static ListNode deserialize(String data) {
		String datas = data.substring(1, data.length()-1);
		datas = datas.replaceAll(" ", "");
		String[] nodes = datas.split(",");
		ListNode preHead = new ListNode(0);
		ListNode curNode = preHead;
		for(String str : nodes) {
			ListNode node = new ListNode(Integer.parseInt(str));
			curNode.next = node;
			curNode = node;
		}

		return preHead.next;
	}
}
