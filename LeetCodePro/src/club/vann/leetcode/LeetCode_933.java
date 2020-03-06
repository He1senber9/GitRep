package leetcode;

import java.util.concurrent.ConcurrentLinkedQueue;

public class LeetCode_933 {

	public static void main(String[] args) {

		RecentCounter obj = new RecentCounter();
		System.out.println(obj.ping(1));
		System.out.println(obj.ping(100));
		System.out.println(obj.ping(3001));
		System.out.println(obj.ping(3002));
	}

}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter(); 
 * int param_1 = obj.ping(t);
 */
class RecentCounter {

	private volatile int lastPing = 0; // 最近一次调用
	
	ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<Integer>();

	public RecentCounter() {

	}

	public int ping(int t) {
		queue.add(t);
		
		while(!queue.isEmpty()) {
			if(t - queue.peek() > 3000) {
				queue.poll();
			} else {
				break;
			}
		}
		
		return queue.size();
	}
}
