package club.vann.leetcode.offer;

import club.vann.leetcode.common.ListNode;

import java.util.Arrays;
import java.util.Stack;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 
 * 示例 1：
 * 
 * 输入：head = [1,3,2] 输出：[2,3,1]
 * 
 * 限制：
 * 
 * 0 <= 链表长度 <= 10000
 * 
 * @author vann
 *
 */
public class LeetCode_6 {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(2);
		
		node1.next = node2;
		node2.next = node3;
		
		LeetCode_6 leetCode = new LeetCode_6();
		int[] result = leetCode.reversePrint(null);
		System.out.println(Arrays.toString(result));
	}

	private int[] reversePrint(ListNode head) {
		Stack<Integer> stack = new Stack<Integer>();
		while(head != null) {
			stack.push(head.val);
			head = head.next;
		}
		
		if(stack.isEmpty()) {
			return new int[] {};
		}
		
		int[] result = new int[stack.size()];
		int index = 0;
		while(!stack.isEmpty()) {
			result[index] = stack.pop();
			index ++;
		}
		return result;
	}

}
