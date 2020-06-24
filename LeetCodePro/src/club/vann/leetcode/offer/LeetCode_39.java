package club.vann.leetcode.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>难度：Easy</p>
 * <p>题目：数组中出现次数超过一半的数字</p>
 * <p>描述：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *
 *  
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 *  
 *
 * 限制：
 *
 * 1 <= 数组长度 <= 50000
 *
 *  
 *
 * 注意：本题与主站 169 题相同：https://leetcode-cn.com/problems/majority-element/
 *
 *  
 *
 * 通过次数27,377提交次数40,554
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-06-23 16:51
 **/
public class LeetCode_39 {
    public static void main(String[] args) {
        LeetCode_39 leetCode = new LeetCode_39();

        System.out.println("Result["+TestCase.ans+"] : " + leetCode.majorityElement(TestCase.nums));
        System.out.println("Result["+TestCase.ans1+"] : " + leetCode.majorityElement(TestCase.nums1));
        System.out.println("Result["+TestCase.ans2+"] : " + leetCode.majorityElement(TestCase.nums2));
        System.out.println("Result["+TestCase.ans3+"] : " + leetCode.majorityElement(TestCase.nums3));
    }

    /**
     * 解法一：
     * @param nums
     * @return
     */
    private int majorityElement(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        if(nums.length <= 2) {
            return nums[0];
        }

        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int n = 0; n < len; n ++) {
            if(map.containsKey(nums[n])) {
                if(map.get(nums[n]) == len/2) {
                    return nums[n];
                }
                map.put(nums[n], map.get(nums[n]) + 1);
            } else {
                map.put(nums[n], 1);
            }
        }
        return 0;
    }

    static class TestCase {
        public static final int ans = 2;
        public static final int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};

        public static final int ans1 = 1;
        public static final int[] nums1 = {1};

        public static final int ans2 = 1;
        public static final int[] nums2 = {1,1};

        public static final int ans3 = 1;
        public static final int[] nums3 = {1,1,2};
    }
}
