package leetcode.offer;

import java.util.Stack;

/**
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * 
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * 
 * 每个孩子至少分配到 1 个糖果。 
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。 那么这样下来，老师至少需要准备多少颗糖果呢？
 * 
 * 示例 1:
 * 
 * 输入: [1,0,2] 输出: 5 解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。 
 * 
 * 示例 2:
 * 
 * 输入: [1,2,2] 输出: 4 解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。 第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 * 
 * @author vann
 *
 */
public class LeetCode_135 {

	public static void main(String[] args) {
		int[] arr = {1,0,2};
		
		LeetCode_135 leetCode = new LeetCode_135();
		int result = leetCode.candy(arr);
		System.out.println(result);
	}
	
	public int candy(int[] ratings) {
		if(ratings == null || ratings.length == 0) {
			return 0;
		}
		
		int result = 0;
		int size = ratings.length;
		Stack<Integer> stack = new Stack<Integer>();
		
		int left = 0; // 标志左边的糖果数
		
		for(int n = 0; n < size; n ++) {
			if(!stack.isEmpty()) {
				if(ratings[n] <= stack.peek()) { // 如果当前的值比左边的值小，那么意味着栈中每一项都要+1；
					result = result + stack.size();
				} else { // 如果当前值比左边的值大
					stack.clear();
				}
			}
			
			left = 1;
			stack.push(ratings[n]);
			result += 1;
			
		}
        return result;
    }

}
