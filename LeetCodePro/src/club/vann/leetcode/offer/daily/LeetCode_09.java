package club.vann.leetcode.offer.daily;

import java.util.Stack;

/**
 * <p>难度：Easy</p>
 * <p>题目：用两个栈实现队列</p>
 * <p>描述：用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 *
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * 提示：
 *
 * 1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用
 * 通过次数38,966提交次数54,331
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/6/30
 * Time: 6:47
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_09 {
    public static void main(String[] args) {
        LeetCode_09 leetCode = new LeetCode_09();
        CQueue queue = leetCode.new CQueue();
        queue.appendTail(3);
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());

        CQueue queue1 = leetCode.new CQueue();
        System.out.println(queue.deleteHead());
        queue.appendTail(5);
        queue.appendTail(2);
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
    }

    class CQueue {

        // 队列数据栈
        private Stack<Integer> dataStack = null;
        // 辅助栈
        private Stack<Integer> supStack = null;
        public CQueue() {
            dataStack = new Stack<Integer>();
            supStack = new Stack<Integer>();
        }

        public void appendTail(int value) {
            dataStack.push(value);
        }

        public int deleteHead() {
            if(dataStack.isEmpty()) {
                return -1;
            }

            while(!dataStack.isEmpty()) {
                int tmp = dataStack.pop();
                supStack.push(tmp);
            }

            int result = supStack.pop();
            while(!supStack.isEmpty()) {
                int tmp = supStack.pop();
                dataStack.push(tmp);
            }

            return result;
        }
    }
}
