package club.vann.leetcode.offer.daily;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>难度：Easy</p>
 * <p>题目：数组的度</p>
 * <p>描述：给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 *
 * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[1, 2, 2, 3, 1]
 * 输出：2
 * 解释：
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 * 示例 2：
 *
 * 输入：[1,2,2,3,1,4,2]
 * 输出：6
 *  
 *
 * 提示：
 *
 * nums.length 在1到 50,000 区间范围内。
 * nums[i] 是一个在 0 到 49,999 范围内的整数。
 * 通过次数32,062提交次数57,186
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/degree-of-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @author vann
 * @program GitRep
 * @description
 * @date 2021-02-20:08:17:18
 */
public class LeetCode_697 {
    public static void main(String[] args) {
        LeetCode_697 leetCode = new LeetCode_697();

//        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.findShortestSubArray(TestCase.NUMS));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.findShortestSubArray(TestCase.NUMS1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.findShortestSubArray(TestCase.NUMS2));
    }

    /**
     * 解法一：
     *
     * @param nums
     * @return
     */
    public int findShortestSubArray(int[] nums) {
        int len = nums.length;
        int[] freqs = new int[50000];

        // 找出数组的度
        int freq = 0;
        for(int i = 0; i < len; i ++) {
            freqs[nums[i]] ++;
            if(freqs[nums[i]] > freq) {
                freq = freqs[nums[i]];
            }
        }

        List<Integer> list = new ArrayList<>();
        // 找出所有等于freq的元素
        for(int i = 0; i < 50000; i ++) {
            if(freqs[i] == freq) {
                list.add(i);
            }
        }

        int min = 50000;
        for(int num : list) {
            int left = 0, right = len-1;
            while(left <= right && nums[left] != num) {
                left ++;
            }

            while(left <= right && nums[right] != num) {
                right --;
            }
            min = Math.min(min, right-left+1);
        }
        return min;
    }

    static class TestCase {
        public static int ANS = 2;
        public static int[] NUMS = {1, 2, 2, 3, 1};

        public static int ANS1 = 6;
        public static int[] NUMS1 = {1,2,2,3,1,4,2};

        public static int ANS2 = 7;
        public static int[] NUMS2 = {2,1,1,2,1,3,3,3,1,3,1,3,2};
    }
}
