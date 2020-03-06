package leetcode;

/**
 * 反转一个单链表。
 * 
 * 示例:
 * 
 * 输入: 1->2->3->4->5->NULL 
 * 输出: 5->4->3->2->1->NULL 
 * 
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * 
 * @author vann
 *
 */
public class LeetCode_206 {

	public static void main(String[] args) {
		ListNode node_1 = new ListNode(1);
		ListNode node_2 = new ListNode(2);
		ListNode node_3 = new ListNode(3);
		ListNode node_4 = new ListNode(4);
		ListNode node_5 = new ListNode(5);
		
		node_1.next = node_2;
		node_2.next = node_3;
		node_3.next = node_4;
		node_4.next = node_5;
		
		LeetCode_206 leetCode = new LeetCode_206();
//		ListNode node = node_1;
		ListNode node = leetCode.reverseList(node_1);
		
		while(node != null) {
			System.out.print(node.val + "->");
			node = node.next;
		}
	}
	
	private ListNode reverseList(ListNode head) {
        return recurrenceList(null, head);
    }
	
	private ListNode recurrenceList(ListNode curNode, ListNode nextNode) {
		if(nextNode == null) {
			return curNode;
		}
		ListNode next = nextNode.next;
		nextNode.next = curNode;
		return recurrenceList(nextNode, next);
	}

}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}
