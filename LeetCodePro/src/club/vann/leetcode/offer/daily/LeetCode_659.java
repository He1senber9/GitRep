package club.vann.leetcode.offer.daily;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * <p>难度：Meidum</p>
 * <p>题目：分割数组为连续子序列</p>
 * <p>描述：给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个子序列，其中每个子序列都由连续整数组成且长度至少为 3 。
 *
 * 如果可以完成上述分割，则返回 true ；否则，返回 false 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: [1,2,3,3,4,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3
 * 3, 4, 5
 *  
 *
 * 示例 2：
 *
 * 输入: [1,2,3,3,4,4,5,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3, 4, 5
 * 3, 4, 5
 *  
 *
 * 示例 3：
 *
 * 输入: [1,2,3,4,4,5]
 * 输出: False
 *  
 *
 * 提示：
 *
 * 输入的数组长度范围为 [1, 10000]
 *  
 *
 * 通过次数6,513提交次数14,291
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-array-into-consecutive-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: LeetCodePro
 * @description:
 * @author: vann
 * @create: 2020-12-04 17:54
 **/
public class LeetCode_659 {
    public static void main(String[] args) {
        LeetCode_659 leetCode = new LeetCode_659();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.isPossible(TestCase.NUMS));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.isPossible(TestCase.NUMS1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.isPossible(TestCase.NUMS2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.isPossible(TestCase.NUMS3));
        System.out.println("Result["+TestCase.ANS4+"] : " + leetCode.isPossible(TestCase.NUMS4));
    }

    /**
     *  解法一：
     *  哈希表+最小堆
     *  时间复杂度：O(nlogn)，空间复杂度：O(n)
     * @param nums
     * @return
     */
    public boolean isPossible(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for(int n : nums) {
            if(!map.containsKey(n)) {
                map.put(n, new PriorityQueue<>());
            }

            if(map.containsKey(n-1)) {
                int prevLength = map.get(n - 1).poll();
                if (map.get(n - 1).isEmpty()) {
                    map.remove(n - 1);
                }
                map.get(n).offer(prevLength + 1);
            } else {
                map.get(n).offer(1);
            }
        }

        Set<Map.Entry<Integer, PriorityQueue<Integer>>> entrySet = map.entrySet();
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : entrySet) {
            PriorityQueue<Integer> queue = entry.getValue();
            if (queue.peek() < 3) {
                return false;
            }
        }
        return true;
    }

    static class TestCase {
        public static boolean ANS = true;
        public static int[] NUMS = {1,2,3,3,4,5};

        public static boolean ANS1 = true;
        public static int[] NUMS1 = {1,2,3,3,4,4,5,5};

        public static boolean ANS2 = false;
        public static int[] NUMS2 = {1,2,3,4,4,5};

        public static boolean ANS3 = true;
        public static int[] NUMS3 = {1,2,3,6,7,8};

        public static boolean ANS4 = false;
        public static int[] NUMS4 = {1,2,3,6,7};

        public static boolean ANS5 = true;
        public static int[] NUMS5 = {1,1,2,2,3,3};

        public static boolean ANS6 = true;
        public static int[] NUMS6 = {1,1,2,2,3,3,4};
    }
}
