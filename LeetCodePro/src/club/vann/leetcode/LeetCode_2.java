/**
 * 
 */
package club.vann.leetcode;

import club.vann.leetcode.common.ListNode;

/**
 * <p>
 * 难度：Midum
 * <p>
 * 题目：两数相加
 * <p>
 * 描述：如果给出两个 非空 的链表用来表示两 非负 的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们每个节点只能存储 一位 数字。
 * 如果我们将这两个数相加起来，则会返回一个新的链表来表示他们的和。
 * 
 * <p>
 * 示例： 输入：（2->4->3) + (5->6->4) 输出：7->0->8 说明：342 + 465 = 807
 * 
 * <p>
 * 注意：您可以假设除了数字0之外，这两个数都不会以0开头。
 * 
 * 通过次数347,801提交次数944,331
 * 
 * @author vann
 * @date Mar 9, 2020
 */
public class LeetCode_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		
		LeetCode_2 leetCode = new LeetCode_2();
//		ListNode result = leetCode.addTwoNumbers(l1, l2);
		ListNode result = leetCode.addTwoNumbers1(l1, l2);
		System.out.println(result);
		
		l1 = new ListNode(0);
		l2 = new ListNode(0);
		result = leetCode.addTwoNumbers1(l1, l2);
		System.out.println(result);
		
		l1 = new ListNode(5);
		l2 = new ListNode(5);
		result = leetCode.addTwoNumbers1(l1, l2);
		System.out.println(result);
	}
	
	private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1.val == 0) {
			return l2;
		}
		if(l2.val == 0) {
			return l1;
		}
		
		ListNode result = new ListNode(0);
		ListNode node = result;
		
		int k = 0; // 进位标志
		int v1 = 0, v2 = 0;
		while(l1!= null || l2 != null) {
			if(l1 != null) {
				v1 = l1.val;
			}
			if(l2 != null) {
				v2 = l2.val;
			}
			
			int t = v1 + v2 + k;
			if(t >= 10) {
				k = 1;
			} else {
				k = 0;
			}
			
			node.val = t%10;
			v1 = 0;
			v2 = 0;
			if(l1.next != null || l2.next != null) {
				node.next = new ListNode(0);
				node = node.next;
			}
			
			l1 = l1.next;
			l2 = l2.next;
		}
		
		while(result.val == 0) {
			result = result.next;
		}
		return result;
    }
	
	private ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
		
		return addTwoNumbers1(l1, l2, 0);
	}
	
	private ListNode addTwoNumbers1(ListNode l1, ListNode l2, int k) {
		int v = k;
		
		if(l1 == null && l2 == null && k == 0) {
			return null;
		}
		
		if(l1 != null) {
			v += l1.val;
			l1 = l1.next;
		}
		if(l2 != null) {
			v += l2.val;
			l2 = l2.next;
		}
		
		ListNode node = new ListNode(v % 10);
		
		if(v >= 10) {
			k = 1;
		} else {
			k = 0;
		}
		
		node.next = addTwoNumbers1(l1, l2, k);
		return node;
	}

}
