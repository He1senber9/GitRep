package club.vann.leetcode.offer;

import club.vann.leetcode.common.ListNode;

/**
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 
 * 返回删除后的链表的头节点。
 * 
 * 注意：此题对比原题有改动
 * 
 * 示例 1:
 * 
 * 输入: head = [4,5,1,9], val = 5 输出: [4,1,9] 解释:
 * 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9. 示例 2:
 * 
 * 输入: head = [4,5,1,9], val = 1 输出: [4,5,9] 解释:
 * 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.  
 * 
 * 说明：
 * 
 * 题目保证链表中节点的值互不相同 若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
 * 
 * @author vann
 *
 */
public class LeetCode_18 {

	public static void main(String[] args) {
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node1 = new ListNode(1);
		ListNode node9 = new ListNode(9);
		
		node4.next = node5;
		node5.next = node1;
		node1.next = node9;
		
		LeetCode_18 leetCode = new LeetCode_18();
		ListNode resultNode = leetCode.deleteNode(node4, 9);
		while(resultNode != null) {
			System.out.print(resultNode.val);
			System.out.print(",");
			resultNode = resultNode.next;
		}
	}
	
	private ListNode deleteNode(ListNode head, int val) {
		if(head == null) {
			return head;
		}
		
		if(head.val == val) {
			return head.next;
		}
		
		ListNode front = head;
		ListNode next = front.next;
		while(next != null) {
			if(next.val == val) {
				front.next = next.next;
				break;
			}
			front = next;
			next = next.next;
		}
		
        return head;
    }

}
