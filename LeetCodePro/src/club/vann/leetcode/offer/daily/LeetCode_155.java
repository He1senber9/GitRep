package club.vann.leetcode.offer.daily;

import java.util.Stack;

/**
 * <p>难度：Easy</p>
 * <p>题目：最小栈</p>
 * <p>描述：设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *  
 *
 * 示例:
 *
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *  
 *
 * 提示：
 *
 * pop、top 和 getMin 操作总是在 非空栈 上调用。
 * 通过次数101,419提交次数191,620
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: GitRep
 * @description:
 * @author: vann
 * @create: 2020-05-12 06:51
 **/
public class LeetCode_155 {
    public static void main(String[] args) {
        MinStack minStack = new LeetCode_155().new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());  // 返回 -3.
        minStack.pop();
        System.out.println(minStack.top());      // 返回 0.
        System.out.println(minStack.getMin());   // 返回 -2.

    }

    class MinStack {

        Stack<Integer> dataStack; // 数据集合
        Stack<Integer> minStack;

        /** initialize your data structure here. */
        public MinStack() {
            dataStack = new Stack<Integer>();
            minStack = new Stack<Integer>();
        }

        public void push(int x) {
            dataStack.push(x);
            if(!minStack.isEmpty()) {
                if(minStack.peek() >= x) {
                    minStack.push(x);
                }
            } else {
                minStack.push(x);
            }
        }

        public void pop() {
            int result = 0;
            if(!dataStack.isEmpty()) {
                result = dataStack.pop();
            } else {
                return;
            }

            // 当前元素只可能大于等于 minStack.peek();
            if(result == minStack.peek()) {
                minStack.pop();
            }

        }

        public int top() {
            int result = 0;
            if(!dataStack.isEmpty()) {
                result = dataStack.peek();
            }
            return 0;
        }

        public int getMin() {
            int result = 0;
            if(!minStack.isEmpty()) {
                result = minStack.peek();
            }
            return result;
        }
    }

    static class TestCase {

    }
}
