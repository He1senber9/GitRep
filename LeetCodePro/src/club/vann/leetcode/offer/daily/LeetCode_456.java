package club.vann.leetcode.offer.daily;

import java.util.LinkedHashMap;
import java.util.TreeMap;

/**
 * <p>难度：Medium</p>
 * <p>题目：132模式</p>
 * <p>描述：给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：当 i < j < k 时，ai < ak < aj。设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。
 *
 * 注意：n 的值小于15000。
 *
 * 示例1:
 *
 * 输入: [1, 2, 3, 4]
 *
 * 输出: False
 *
 * 解释: 序列中不存在132模式的子序列。
 * 示例 2:
 *
 * 输入: [3, 1, 4, 2]
 *
 * 输出: True
 *
 * 解释: 序列中有 1 个132模式的子序列： [1, 4, 2].
 * 示例 3:
 *
 * 输入: [-1, 3, 2, 0]
 *
 * 输出: True
 *
 * 解释: 序列中有 3 个132模式的的子序列: [-1, 3, 2], [-1, 3, 0] 和 [-1, 2, 0].
 * 通过次数17,531提交次数58,432
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/132-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @author vann
 * @program GitRep
 * @description
 * @date 2021-03-24:08:35:07
 */
public class LeetCode_456 {
    public static void main(String[] args) {
        LeetCode_456 leetCode = new LeetCode_456();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.find132pattern(TestCase.NUMS));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.find132pattern(TestCase.NUMS1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.find132pattern(TestCase.NUMS2));
    }

    /**
     * 解法一：
     *
     * @param nums
     * @return
     */
    public boolean find132pattern(int[] nums) {
        if(nums == null || nums.length < 3) {
            return false;
        }

        int n = nums.length;

        int min = nums[0];
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for(int k = 2; k < n; k ++) {
            treeMap.put(nums[k], treeMap.getOrDefault(nums[k], 0) + 1);
        }

        // 枚举j
        for(int j = 1; j < n-1; j ++) {
            if (min < nums[j]) {
                Integer next = treeMap.ceilingKey(min + 1);
                if (next != null && next < nums[j]) {
                    return true;
                }
            }
            min = Math.min(min, nums[j]);
            treeMap.put(nums[j + 1], treeMap.get(nums[j + 1]) - 1);
            if (treeMap.get(nums[j + 1]) == 0) {
                treeMap.remove(nums[j + 1]);
            }
        }

        return false;
    }

    static class TestCase {
        public static boolean ANS = false;
        public static int[] NUMS = {1, 2, 3, 4};

        public static boolean ANS1 = true;
        public static int[] NUMS1 = {3, 1, 4, 2};

        public static boolean ANS2 = true;
        public static int[] NUMS2 = {-1, 3, 2, 0};
    }
}
