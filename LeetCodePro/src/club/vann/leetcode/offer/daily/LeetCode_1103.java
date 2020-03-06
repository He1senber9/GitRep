package leetcode.daily;

import java.util.Arrays;

/**
 * Easy 分糖果 II
 * 
 * 排排坐，分糖果。
 * 
 * 我们买了一些糖果 candies，打算把它们分给排好队的 n = num_people 个小朋友。
 * 
 * 给第一个小朋友 1 颗糖果，第二个小朋友 2 颗，依此类推，直到给最后一个小朋友 n 颗糖果。
 * 
 * 然后，我们再回到队伍的起点，给第一个小朋友 n + 1 颗糖果，第二个小朋友 n + 2 颗，依此类推，直到给最后一个小朋友 2 * n 颗糖果。
 * 
 * 重复上述过程（每次都比上一次多给出一颗糖果，当到达队伍终点后再次从队伍起点开始），直到我们分完所有的糖果。注意，就算我们手中的剩下糖果数不够（不比前一次发出的糖果多），这些糖果也会全部发给当前的小朋友。
 * 
 * 返回一个长度为 num_people、元素之和为 candies 的数组，以表示糖果的最终分发情况（即 ans[i] 表示第 i 个小朋友分到的糖果数）。
 * 
 *  
 * 
 * 示例 1：
 * 
 * 输入：candies = 7, num_people = 4 输出：[1,2,3,1] 
 * 解释：
 *  第一次，ans[0] += 1，数组变为[1,0,0,0]。 
 *  第二次，ans[1] += 2，数组变为 [1,2,0,0]。 
 *  第三次，ans[2] += 3，数组变为 [1,2,3,0]。
 *  第四次，ans[3] += 1（因为此时只剩下 1 颗糖果），
 *  最终数组变为 [1,2,3,1]。 
 *  
 * 示例 2：
 * 
 * 输入：candies = 10, num_people = 3 输出：[5,2,3] 
 * 解释： 
 *  第一次，ans[0] += 1，数组变为 [1,0,0]。
 *  第二次，ans[1] += 2，数组变为 [1,2,0]。
 *  第三次，ans[2] += 3，数组变为 [1,2,3]。 
 *  第四次，ans[0] += 4，最终数组变为 [5,2,3]。  
 * 
 * 提示：
 * 
 * 1 <= candies <= 10^9 1 <= num_people <= 1000 通过次数8,520提交次数13,473
 * 
 * @author fanyu
 *
 */
public class LeetCode_1103 {

	public static void main(String[] args) {
		LeetCode_1103 leetCode = new LeetCode_1103();
		
		int candies = 7, num_people = 4;
		int[] result = leetCode.distributeCandies(candies, num_people);
		System.out.println("Result:[1,2,3,1] , " + Arrays.toString(result));
		
		int candies1 = 10, num_people1 = 3;
		result = leetCode.distributeCandies(candies1, num_people1);
		System.out.println("Result:[5,2,3] , " +Arrays.toString(result));

	}
	
	private int[] distributeCandies(int candies, int num_people) {
		// 如果只有一个人，那么就是这个人分到全部的糖果
		if(num_people == 1) {
			return new int[] {candies};
		}
		
		int[] result = new int[num_people];
		
		int index = 0;
		int curCandies = 1;
		while(candies >= 1) {
			result[index%num_people] = result[index%num_people] + curCandies;
			
			candies = candies - curCandies; // 计算剩下的糖果
			
			// 剩下糖果为0时，分配完毕。
			if(candies == 0) {
				break;
			} 
			
			// 剩下糖果不为0，则有2中可能： 剩下糖果数量 >= cur+1 或者 剩下糖果数量 < cur+1
			if(candies < curCandies+1) {
				curCandies = candies;
			} else {
				curCandies += 1;
			}
			
			index ++;
		}
		return result;
    }

}
