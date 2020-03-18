package club.vann.leetcode.race;

import java.util.Stack;

/**
 * <p>请你设计一个支持下述操作的栈。
 *
 * 实现自定义栈类 CustomStack ：
 *
 * CustomStack(int maxSize)：用 maxSize 初始化对象，maxSize 是栈中最多能容纳的元素数量，栈在增长到 maxSize 之后则不支持 push 操作。
 * void push(int x)：如果栈还未增长到 maxSize ，就将 x 添加到栈顶。
 * int pop()：返回栈顶的值，或栈为空时返回 -1 。
 * void inc(int k, int val)：栈底的 k 个元素的值都增加 val 。如果栈中元素总数小于 k ，则栈中的所有元素都增加 val 。
 *
 *
 * 示例：
 *
 * 输入：
 * ["CustomStack","push","push","pop","push","push","push","increment","increment","pop","pop","pop","pop"]
 * [[3],[1],[2],[],[2],[3],[4],[5,100],[2,100],[],[],[],[]]
 * 输出：
 * [null,null,null,2,null,null,null,null,null,103,202,201,-1]
 * 解释：
 * CustomStack customStack = new CustomStack(3); // 栈是空的 []
 * customStack.push(1);                          // 栈变为 [1]
 * customStack.push(2);                          // 栈变为 [1, 2]
 * customStack.pop();                            // 返回 2 --> 返回栈顶值 2，栈变为 [1]
 * customStack.push(2);                          // 栈变为 [1, 2]
 * customStack.push(3);                          // 栈变为 [1, 2, 3]
 * customStack.push(4);                          // 栈仍然是 [1, 2, 3]，不能添加其他元素使栈大小变为 4
 * customStack.increment(5, 100);                // 栈变为 [101, 102, 103]
 * customStack.increment(2, 100);                // 栈变为 [201, 202, 103]
 * customStack.pop();                            // 返回 103 --> 返回栈顶值 103，栈变为 [201, 202]
 * customStack.pop();                            // 返回 202 --> 返回栈顶值 202，栈变为 [201]
 * customStack.pop();                            // 返回 201 --> 返回栈顶值 201，栈变为 []
 * customStack.pop();                            // 返回 -1 --> 栈为空，返回 -1
 *
 *
 * 提示：
 *
 * 1 <= maxSize <= 1000
 * 1 <= x <= 1000
 * 1 <= k <= 1000
 * 0 <= val <= 100
 * 每种方法 increment，push 以及 pop 分别最多调用 1000 次</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/3/18
 * Time: 22:25
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_1381 {
    public static void main(String[] args) {
        LeetCode_1381 leetCode = new LeetCode_1381();

        CustomStack stack = new CustomStack(3);
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.increment(5,100);
        stack.increment(2,100);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}

class CustomStack {

    private final int count;
    private Stack<Integer> stack = null;
    private Stack<Integer> increStack = null;

    public CustomStack(int maxSize) {
        count = maxSize;
        stack = new Stack<Integer>();
        increStack = new Stack<Integer>();
    }

    public void push(int x) {
        int size = stack.size();
        if(size < count) {
            stack.push(x);
        }
    }

    public int pop() {
        if(stack.isEmpty()) {
            return -1;
        } else {
            return stack.pop();
        }
    }

    public void increment(int k, int val) {
        while(!stack.isEmpty()) {
            increStack.push(stack.pop());
        }

        int i = 0;
        while(!increStack.isEmpty()) {
            int v = increStack.pop();
            if(i < k) {
                stack.push(v+val);
            } else {
                stack.push(v);
            }
            i++;
        }
    }
}
