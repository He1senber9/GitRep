package club.vann.leetcode.offer.daily;

import java.util.Arrays;

/**
 * <p>难度：Easy</p>
 * <p>题目：最长和谐子序列</p>
 * <p>描述：和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。
 *
 * 现在，给你一个整数数组 nums ，请你在所有可能的子序列中找到最长的和谐子序列的长度。
 *
 * 数组的子序列是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,2,2,5,2,3,7]
 * 输出：5
 * 解释：最长的和谐子序列是 [3,2,2,2,3]
 * 示例 2：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：2
 * 示例 3：
 *
 * 输入：nums = [1,1,1,1]
 * 输出：0
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 2 * 104
 * -109 <= nums[i] <= 109
 * 通过次数33,265提交次数62,951
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-harmonious-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: GitRep
 * @description:
 * @author: fanyu
 * @create: 2021/11/20 08:45
 */
public class LeetCode_594 {
    public static void main(String[] args) {
        LeetCode_594 leetCode = new LeetCode_594();

        System.out.println("Result["+TestCase.ANS+"]: " + leetCode.findLHS(TestCase.NUMS));
        System.out.println("Result["+TestCase.ANS+"]: " + leetCode.findLHS(TestCase.NUMS));
    }

    /**
     * 解法一：
     *
     * @param nums
     * @return
     */
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = 0;
        int res = 0;
        for(right = 0; right < nums.length; right ++) {
            while(nums[right] - nums[left] > 1) {
                left ++;
            }

            if(nums[right] - nums[left] == 1) {
                res = Math.max(res, right-left+1);
            }
        }

        return res;
    }

    static class TestCase {
        public static int ANS = 5;
        public static int[] NUMS = {1,3,2,2,5,2,3,7};
    }
}
