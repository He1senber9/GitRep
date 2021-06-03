package club.vann.leetcode.offer.daily;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>难度：Medium</p>
 * <p>题目：连续数组</p>
 * <p>描述：给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量0和1的最长连续子数组。
 * 示例 2:
 *
 * 输入: nums = [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * nums[i] 不是 0 就是 1
 * 通过次数13,659提交次数28,446
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contiguous-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @description:
 * @program: GitRep
 * @author: fanyu
 * @create: 2021-06-03  08:21:35
 */
public class LeetCode_525 {
    public static void main(String[] args) {
        LeetCode_525 leetCode = new LeetCode_525();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.findMaxLength1(TestCase.NUMS));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.findMaxLength1(TestCase.NUMS1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.findMaxLength1(TestCase.NUMS2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.findMaxLength1(TestCase.NUMS3));
        System.out.println("Result["+TestCase.ANS4+"] : " + leetCode.findMaxLength1(TestCase.NUMS4));
        System.out.println("Result["+TestCase.ANS5+"] : " + leetCode.findMaxLength1(TestCase.NUMS5));
        System.out.println("Result["+TestCase.ANS6+"] : " + leetCode.findMaxLength1(TestCase.NUMS6));
        System.out.println("Result["+TestCase.ANS7+"] : " + leetCode.findMaxLength1(TestCase.NUMS7));
        System.out.println("Result["+TestCase.ANS8+"] : " + leetCode.findMaxLength1(TestCase.NUMS8));
    }

    /**
     * 解法一：
     *
     * @param nums
     * @return
     */
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        if(n == 1) {
             return 0;
        }

        int ans = 0;
        for(int left = 0; left < n-1; left ++) {
            int count0 = 0, count1 = 0;
            for(int right = left; right < n; right ++) {
                if(nums[right] == 0) {
                    count0 ++;
                } else {
                    count1 ++;
                }
                if(count0 == count1) {
                    ans = Math.max(ans, count0*2);
                }
            }
        }
        return ans;
    }

    /**
     * 解法二：
     *
     * @param nums
     * @return
     */
    public int findMaxLength1(int[] nums) {
        int n = nums.length;
        int count = 0;
        int ans = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i = 0; i < n; i ++) {
            if(nums[i] == 1) {
                count ++;
            } else {
                count --;
            }

            if(map.containsKey(count)) {
                int preIndex = map.get(count);
                ans = Math.max(ans, i-preIndex);
            } else {
                map.put(count, i);
            }
        }
        return ans;
    }

    static class TestCase {
        public static int ANS = 2;
        public static int[] NUMS = {0,1};

        public static int ANS1 = 2;
        public static int[] NUMS1 = {0,1,0};

        public static int ANS2 = 4;
        public static int[] NUMS2 = {0,1,0,1};

        public static int ANS3 = 4;
        public static int[] NUMS3 = {0,0,1,1};

        public static int ANS4 = 4;
        public static int[] NUMS4 = {0,1,1,0,1};

        public static int ANS5 = 2;
        public static int[] NUMS5 = {1,1,1,1,0};

        public static int ANS6 = 4;
        public static int[] NUMS6 = {1,1,1,1,0,0};

        public static int ANS7 = 6;
        public static int[] NUMS7 = {1,1,1,1,0,0,0};

        public static int ANS8 = 4;
        public static int[] NUMS8 = {0,1,1,0,1,1,1,0};
    }
}
