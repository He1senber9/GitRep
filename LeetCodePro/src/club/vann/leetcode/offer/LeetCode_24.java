package club.vann.leetcode.offer;

import java.util.Stack;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * 
 *  
 * 
 * 示例:
 * 
 * 输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL  
 * 
 * 限制：
 * 
 * 0 <= 节点个数 <= 5000
 * 
 * @author vann
 *
 */
public class LeetCode_24 {

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
		
		LeetCode_24 leetCode = new LeetCode_24();
		ListNode node = leetCode.reverseList(node1);
		System.out.println(node);
	}

	private ListNode reverseList(ListNode head) {
		if(head == null) {
            return null;
        }

//        Stack<ListNode> stack = new Stack<ListNode>();
//        while(head != null) {
//            stack.push(head);
//            head = head.next;
//        }
//
//        ListNode root = stack.pop();
//        ListNode node = root;
//        while(!stack.isEmpty()) {
//            node.next = stack.pop();
//            node = node.next;
//        }
		
		ListNode pre = null;
        ListNode cur = head;
        ListNode tmp = null;
        while(cur != null) {
            tmp = cur.next;

            cur.next = pre;
            pre = cur;
            cur = tmp; 
        }

        return pre;
	}

}
