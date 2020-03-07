package club.vann.leetcode.offer.daily;

import java.util.ArrayList;
import java.util.LinkedList;
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
		
		System.out.println("--------------------------------");
		
		MaxQueue queue1 = leetCode.new MaxQueue();
		int pop_val = queue1.pop_front();
		System.out.print(pop_val + ", ");
		int max_val1 = queue1.max_value();
		System.out.print(max_val1 + ", ");
		
	}

	/**
	 * 自定义队列
	 * 
	 * @author fanyu
	 * @date 2020年3月7日
	 */
	class MaxQueue {

		private LinkedList<Integer> dataLinked = null;
		private LinkedList<Integer> indexLinked = null;
		
		public MaxQueue() {
			dataLinked = new LinkedList<Integer>();
			indexLinked = new LinkedList<Integer>();
		}

		/**
		 * 返回队列中的最大值。
		 * 
		 * @return 如果队列为空，返回 -1
		 */
		public int max_value() {
			if(dataLinked.isEmpty()) {
				return -1;
			}
			return indexLinked.peekFirst();
		}

		/**
		 * 
		 * @param value
		 */
		public void push_back(int value) {
			dataLinked.offer(value);
			
			if(!indexLinked.isEmpty()) {
				if(indexLinked.peekLast() < value) {
					indexLinked.pollLast();
				}
				
				indexLinked.offer(value);
			} else {
				indexLinked.offer(value);
			}
		}

		/**
		 * 获取队列中最前面的元素。
		 * 需要判断当前是否时最大值，如果是，需要找出剩下队列中的最大值。
		 * 
		 * @return 如果队列为空，返回-1
		 */
		public int pop_front() {
			if(dataLinked.isEmpty()) {
				return -1;
			}
			
			int v = dataLinked.pollFirst();
			if(v == indexLinked.peekFirst()) {
				indexLinked.pollFirst();
			}
			return v;
		}
	}
}