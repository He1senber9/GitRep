package club.vann.leetcode.offer;

/**
 * Easy 合并两个排序的链表
 * 
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * 
 * 示例1：
 * 
 * 输入：1->2->4, 1->3->4 输出：1->1->2->3->4->4 限制：
 * 
 * 0 <= 链表长度 <= 1000
 * 
 * @author vann
 *
 */
public class LeetCode_25 {

	public static void main(String[] args) {
		ListNode node1_1 = new ListNode(1);
		ListNode node1_2 = new ListNode(2);
		ListNode node1_3 = new ListNode(4);
		node1_1.next = node1_2;
		node1_2.next = node1_3;
		
		ListNode node2_1 = new ListNode(1);
		ListNode node2_2 = new ListNode(3);
		ListNode node2_3 = new ListNode(4);
		node2_1.next = node2_2;
		node2_2.next = node2_3;
		
		LeetCode_25 leetCode = new LeetCode_25();
		ListNode result = leetCode.mergeTwoLists(node1_1, node2_1);
		System.out.println(result);
	}
	
	private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null) {
			return l2;
		}
		if(l2 == null) {
			return l1;
		}
		
		ListNode node = null;
		if(l1.val <= l2.val) {
			node = l1;
			node.next = mergeTwoLists(l1.next, l2);
		} else {
			node = l2;
			node.next = mergeTwoLists(l1, l2.next);
		}
		return node;
    }

}
