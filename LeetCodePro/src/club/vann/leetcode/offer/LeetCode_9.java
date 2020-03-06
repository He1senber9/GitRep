package leetcode.offer;

import java.util.Stack;

/**
 * Easy 用两个栈实现队列
 * 
 * <p>
 * 用两个栈实现一个队列。</br>
 * 队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead，分别完成在队列尾部插入整数和在队列头部删除整数的功能。</br>
 * (若队列中没有元素，deleteHead 操作返回 -1 )
 * 
 * <p>
 * 示例 1：
 * 
 * 输入： ["CQueue","appendTail","deleteHead","deleteHead"] [[],[3],[],[]]
 * 输出：[null,null,3,-1] 
 * 
 * <p>
 * 示例 2：
 * 
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]] 
 * 输出：[null,-1,null,null,5,2] 
 * 
 * <p>
 * 提示：
 * 
 * 1 <= values <= 10000 最多会对 appendTail、deleteHead 进行 10000 次调用
 * 
 * 通过次数3,680提交次数4,912
 * 
 * @author vann
 *
 */
public class LeetCode_9 {

	public static void main(String[] args) {
//		CQueue cQueue = new CQueue();
//		cQueue.appendTail(3);
//		int result = cQueue.deleteHead();
//		System.out.println(result);
//		
//		result = cQueue.deleteHead();
//		System.out.println(result);
		
		CQueue cQueue = new CQueue();
		int result = cQueue.deleteHead();
		System.out.println(result);
		
		cQueue.appendTail(5);
		cQueue.appendTail(2);
		result = cQueue.deleteHead();
		System.out.println(result);
		
		result = cQueue.deleteHead();
		System.out.println(result);
	}

}

/**
 * Your CQueue object will be instantiated and called as such: 
 * CQueue obj = new CQueue(); 
 * obj.appendTail(value); 
 * int param_2 = obj.deleteHead();
 */
class CQueue {
	private Stack<Integer> dataStack = null; // 
	private Stack<Integer> delStack = null;

	public CQueue() {
		dataStack = new Stack<Integer>();
		delStack = new Stack<Integer>();
	}

	public void appendTail(int value) {
		dataStack.push(value);
	}

	public int deleteHead() {
		if(dataStack.isEmpty()) {
			return -1;
		}
		
		while(!dataStack.isEmpty()) {
			delStack.push(dataStack.pop());
		}
		
		int result = delStack.pop();
		
		while(!delStack.isEmpty()) {
			dataStack.push(delStack.pop());
		}
		
		return result;
	}
}
