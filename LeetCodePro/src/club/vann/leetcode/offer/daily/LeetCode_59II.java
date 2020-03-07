package club.vann.leetcode.offer.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 难度：Midum
 * <p>
 * 题目：队列的最大值
 * <p>
 * 描述：请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和
 * pop_front的时间复杂度都是O(1)。
 * 
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 * <p>
 * 示例 1：
 * 
 * 输入: ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]] 输出: [null,null,null,2,1,2]
 * <p>
 * 示例 2：
 * 
 * 输入: ["MaxQueue","pop_front","max_value"] [[],[],[]] 输出: [null,-1,-1]  
 * 
 * 限制：
 * 
 * 1 <= push_back,pop_front,max_value的总操作数 <= 10000 1 <= value <= 10^5
 * 通过次数3,008提交次数6,448
 * 
 * @author fanyu
 * @date 2020年3月7日
 */
public class LeetCode_59II {

	public static void main(String[] args) {
		LeetCode_59II leetCode = new LeetCode_59II();
		MaxQueue queue = leetCode.new MaxQueue();
		queue.push_back(1);
		queue.push_back(2);
		int max_val = queue.max_value();
		System.out.print(max_val + ", ");
		int pop_front = queue.pop_front();
		System.out.print(pop_front + ", ");
		max_val = queue.max_value();
		System.out.print(max_val);
	}

	/**
	 * 自定义队列
	 * 
	 * @author fanyu
	 * @date 2020年3月7日
	 */
	class MaxQueue {

		volatile int a = 0;
		public MaxQueue() {
			List<Integer> list = new ArrayList<Integer>();
		}

		/**
		 * 返回队列中的最大值。
		 * 
		 * @return 如果队列为空，返回 -1
		 */
		public int max_value() {
			return 0;
		}

		/**
		 * 
		 * @param value
		 */
		public void push_back(int value) {

		}

		/**
		 * 获取队列中最前面的元素。
		 * 需要判断当前是否时最大值，如果是，需要找出剩下队列中的最大值。
		 * 
		 * @return 如果队列为空，返回-1
		 */
		public int pop_front() {
			return 0;
		}
	}
}