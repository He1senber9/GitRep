package club.vann.leetcode.offer;

import java.util.Stack;

/**
 * Easy 含min函数的栈
 * 
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 * 调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * 
 *  
 * 
 * 示例:
 * 
 * MinStack minStack = new MinStack(); 
 * minStack.push(-2); 
 * minStack.push(0);
 * minStack.push(-3); 
 * minStack.min();  --> 返回 -3. 
 * 
 * minStack.pop(); minStack.top(); --> 返回 0. 
 * 
 * minStack.min(); --> 返回 -2.  
 * 
 * 提示：
 * 
 * 各函数的调用总次数不超过 20000 次
 * 
 * @author vann
 *
 */
public class LeetCode_30 {

	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		
		int min1 = minStack.min();   //--> 返回 -3.
		System.out.println(min1);
		
		minStack.pop();
		
		int top1 = minStack.top();      // --> 返回 0.
		System.out.println(top1);
		
		int min2 = minStack.min();   // --> 返回 -2.
		System.out.println(min2);
	}

}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
class MinStack {
	/** initialize your data structure here. */
	private Stack<Integer> stack = null;
	
    public MinStack() {
    	stack = new Stack<Integer>();
    }
    
    public void push(int x) {
    	stack.push(x);
    }
    
    public void pop() {
    	stack.pop();
    }
    
    public int top() {
    	return stack.peek();
    }
    
    public int min() {
    	return 0;
    }
}
