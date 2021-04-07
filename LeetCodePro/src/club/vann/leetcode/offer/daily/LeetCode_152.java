package club.vann.leetcode.offer.daily;

import java.nio.file.attribute.AclFileAttributeView;

/**
 * <p>难度：Medium</p>
 * <p>题目：乘积最大子数组</p>
 * <p>描述：给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 * 通过次数130,907提交次数316,884
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2021/4/7
 * Time: 16:40
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_152 {
    public static void main(String[] args) {
        LeetCode_152 leetCode = new LeetCode_152();
        System.out.println("Result["+TestCase.ANS+"] :" + leetCode.maxProduct(TestCase.NUMS));
    }

    /**
     * 解法一：
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int ans = nums[0];

        int min = nums[0];
        int max = nums[0];

        for(int i = 1; i < nums.length; i ++) {
            int curMin = Math.min(nums[i], Math.min(min*nums[i], max*nums[i]));
            int curMax = Math.max(nums[i], Math.max(min*nums[i], max*nums[i]));

            min = curMin;
            max = curMax;
            ans = Math.max(ans, max);
        }

        return ans;
    }

    static class TestCase {
        public static int ANS = 6;
        public static int[] NUMS = {2,3,-2,4};
    }
}
