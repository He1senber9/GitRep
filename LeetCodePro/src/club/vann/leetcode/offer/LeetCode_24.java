package club.vann.leetcode.offer;

import club.vann.leetcode.common.ListNode;

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
		ListNode node = leetCode.reverseList3(TestCase.NODE);
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

	public ListNode reverseList1(ListNode head) {
		// 递归解法
		if(head == null) {
			return null;
		}

		ListNode curNode = head;
		ListNode preNode;
		if(curNode.next != null) {
			preNode = reverseList1(curNode.next);
			preNode.next = curNode;
			curNode = preNode;
		} else {
			curNode.next = null;
			preNode = curNode;
		}

		return curNode;
	}

	public ListNode reverseList2(ListNode head) {
		if(head == null) {
			return null;
		}

		if(head.next == null) {
			return head;
		}

		ListNode pre = head;
		ListNode cur = pre.next;
		pre.next = null;
		while(cur != null) {
			ListNode temp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = temp;
		}

		return pre;
	}

	/**
	 * 解法四：
	 *
	 * @param head
	 * @return
	 */
	private ListNode reverseList3(ListNode head) {
		if(head == null) {
			return head;
		}

		ListNode tag = reverseList(head.next);
		if(tag == null) {
			return head;
		}

		head.next = null;
		ListNode temp = tag;
		while(temp.next != null) {
			temp = temp.next;
		}

		temp.next = head;
		return tag;
	}

	static class TestCase {
		public static ListNode NODE = ListNode.deserialize("[1,2,3,4,5]");
	}
}
