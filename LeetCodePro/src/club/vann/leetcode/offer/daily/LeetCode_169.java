package club.vann.leetcode.offer.daily;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>难度：Easy</p>
 * <p>题目：多数元素</p>
 * <p>描述：给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 * 通过次数120,696提交次数194,938
 *
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/3/13
 * Time: 8:24
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_169 {
    public static void main(String[] args) {
        int[] nums = {};
        int result = 0;
        LeetCode_169 leetCode = new LeetCode_169();

        nums = new int[]{3,2,3};
        result = leetCode.majorityElement(nums);
        System.out.println("Result[3]: " + result);

        nums = new int[]{2,2,1,1,1,2,2};
        result = leetCode.majorityElement(nums);
        System.out.println("Result[2]: " + result);

        nums = new int[]{1};
        result = leetCode.majorityElement(nums);
        System.out.println("Result[1]: " + result);
    }

    /**
     * 思路一：借助集合完成匹配，找出目标元素。
     * <p>时间复杂度：O(n)</p>
     * <p>空间复杂度：O(n)</p>
     * @param nums
     * @return
     */
    private int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int len = nums.length;

        if(len == 1) {
            return nums[0];
        }

        int result = 0;
        for(int n = 0; n < len; n++) {
            if(map.containsKey(nums[n])) {
                int count = map.get(nums[n]);
                if(count >= len/2) {
                    result = nums[n];
                    return nums[n];
                } else {
                    map.put(nums[n], count+1);
                }
            } else {
                map.put(nums[n], 1);
            }
        }
        return result;
    }

    /**
     * 思路二：借助集合完成匹配，找出目标元素。
     * <p>时间复杂度：O(n)</p>
     * <p>空间复杂度：O(n)</p>
     * @param nums
     * @return
     */
    private int majorityElement1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int len = nums.length;

        if(len == 1) {
            return nums[0];
        }

        int result = 0;
        for(int n = 0; n < len; n++) {
            if(map.containsKey(nums[n])) {
                int count = map.get(nums[n]);
                if(count >= len/2) {
                    result = nums[n];
                    return nums[n];
                } else {
                    map.put(nums[n], count+1);
                }
            } else {
                map.put(nums[n], 1);
            }
        }
        return result;
    }
}
