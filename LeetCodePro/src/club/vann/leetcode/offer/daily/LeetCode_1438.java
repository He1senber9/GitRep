package club.vann.leetcode.offer.daily;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * <p>难度：Medium</p>
 * <p>题目：绝对差不超过限制的最长连续子数组</p>
 * <p>描述：给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
 *
 * 如果不存在满足条件的子数组，则返回 0 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [8,2,4,7], limit = 4
 * 输出：2
 * 解释：所有子数组如下：
 * [8] 最大绝对差 |8-8| = 0 <= 4.
 * [8,2] 最大绝对差 |8-2| = 6 > 4.
 * [8,2,4] 最大绝对差 |8-2| = 6 > 4.
 * [8,2,4,7] 最大绝对差 |8-2| = 6 > 4.
 * [2] 最大绝对差 |2-2| = 0 <= 4.
 * [2,4] 最大绝对差 |2-4| = 2 <= 4.
 * [2,4,7] 最大绝对差 |2-7| = 5 > 4.
 * [4] 最大绝对差 |4-4| = 0 <= 4.
 * [4,7] 最大绝对差 |4-7| = 3 <= 4.
 * [7] 最大绝对差 |7-7| = 0 <= 4.
 * 因此，满足题意的最长子数组的长度为 2 。
 * 示例 2：
 *
 * 输入：nums = [10,1,2,4,7,2], limit = 5
 * 输出：4
 * 解释：满足题意的最长子数组是 [2,4,7,2]，其最大绝对差 |2-7| = 5 <= 5 。
 * 示例 3：
 *
 * 输入：nums = [4,2,2,2,4,4,2,2], limit = 0
 * 输出：3
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 * 0 <= limit <= 10^9
 * 通过次数8,929提交次数22,308
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @author vann
 * @program GitRep
 * @description
 * @date 2021-02-21:08:13:12
 */
public class LeetCode_1438 {
    public static void main(String[] args) {
        LeetCode_1438 leetCode = new LeetCode_1438();

//        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.longestSubarray(TestCase.NUMS, TestCase.LIMIT));
//        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.longestSubarray(TestCase.NUMS1, TestCase.LIMIT1));
//        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.longestSubarray(TestCase.NUMS2, TestCase.LIMIT2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.longestSubarray(TestCase.NUMS3, TestCase.LIMIT3));
    }

    /**
     * 解法一：
     *  有序集合；
     * @param nums
     * @param limit
     * @return
     */
    public int longestSubarray(int[] nums, int limit) {
        int len = nums.length;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int res = 0;
        int left = 0, right = 0;

        while(right < len) {
            treeMap.put(nums[right], treeMap.getOrDefault(nums[right], 0) + 1);
            while(treeMap.lastKey() - treeMap.firstKey() > limit) {
                // 表明当前加入的nums[right]不能使[left,right]区间满足条件
                treeMap.put(nums[left], treeMap.get(nums[left]) - 1);
                if(treeMap.get(nums[left]) == 0) {
                    treeMap.remove(nums[left]);
                }
                left ++;
            }

            res = Math.max(res, right-left+1);
            right ++;
        }
        return res;
    }

    /**
     * 解法二：
     * 滑动窗口
     * @param nums
     * @param limit
     * @return
     */
    public int longestSubarray1(int[] nums, int limit) {
        int len = nums.length;
        Deque<Integer> maxQueue = new LinkedList<>();
        Deque<Integer> minQueue = new LinkedList<>();

        int left = 0, right = 0;
        int res = 0;

        while(right < len) {

            while(!maxQueue.isEmpty() && maxQueue.peekLast() < nums[right]) {
                maxQueue.pollLast();
            }

            while(!minQueue.isEmpty() && minQueue.peekLast() > nums[right]) {
                minQueue.pollLast();
            }

            maxQueue.offerLast(nums[right]);
            minQueue.offerLast(nums[right]);

            while(!maxQueue.isEmpty() && !minQueue.isEmpty() && maxQueue.peekFirst() - minQueue.peekFirst() > limit) {
                int val = nums[left];
                if(val == maxQueue.peekFirst()) {
                    maxQueue.pollFirst();
                }

                if(val == minQueue.peekFirst()) {
                    minQueue.pollFirst();
                }
                left ++;
            }

            res = Math.max(res, right-left+1);
            right ++;
        }
        return res;
    }

    static class TestCase {
        public static int ANS = 2;
        public static int[] NUMS = {8,2,4,7};
        public static int LIMIT = 4;

        public static int ANS1 = 4;
        public static int[] NUMS1 = {10,1,2,4,7,2};
        public static int LIMIT1 = 5;

        public static int ANS2 = 3;
        public static int[] NUMS2 = {4,2,2,2,4,4,2,2};
        public static int LIMIT2 = 0;

        public static int ANS3 = 4;
        public static int[] NUMS3 = {10,1,2,4,7,2};
        public static int LIMIT3 = 5;

    }
}
