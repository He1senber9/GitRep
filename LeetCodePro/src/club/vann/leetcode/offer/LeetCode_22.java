package leetcode.offer;

import java.util.Stack;

/**
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 * 
 * 示例：
 * 
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * 
 * 返回链表 4->5.
 * 
 * @author vann
 *
 */
public class LeetCode_22 {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		LeetCode_22 leetCode = new LeetCode_22();
		ListNode result = leetCode.getKthFromEnd(node1, 2);
	}
	
	private ListNode getKthFromEnd(ListNode head, int k) {
		Stack<ListNode> stack = new Stack<ListNode>();
		
		
		while(head != null) {
			stack.push(head);
			head = head.next;
		}
		
		int count = 0;
		while(!stack.isEmpty() && ++count < k) {
			stack.pop();
			count ++;
		}
        return stack.pop();
    }

}
