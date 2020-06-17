package club.vann.leetcode.offer.daily;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>难度：Medium</p>
 * <p>题目：三数之和</p>
 * <p>描述：给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 * 通过次数235,898提交次数861,824
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-06-12 08:48
 **/
public class LeetCode_15 {
    public static void main(String[] args) {
        LeetCode_15 leetCode = new LeetCode_15();

        System.out.println("Result[] : " + leetCode.threeSum(TestCase.nums));
        System.out.println("Result[] : " + leetCode.threeSum(TestCase.nums));
        System.out.println("Result[] : " + leetCode.threeSum(TestCase.nums));
    }

    /**
     * 解法一：
     * 采用set对已经统计过的数判重
     *
     * @param nums
     * @return
     */
    private List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 3) {
            return result;
        }

        Set<Integer> set = new HashSet<Integer>();
        int len = nums.length;

        for(int n = 0; n < len; n ++) {
            if(set.contains(nums[n])) {

            } else {
                set.add(nums[n]);
            }
        }

        return result;
    }

    static class TestCase {
        public static final int[] nums = {-1, 0, 1, 2, -1, -4};
        public static final int[] nums1 = {1, 1, 1};
        public static final int[] nums2 = {0, 0, 0, 0};
    }
}
