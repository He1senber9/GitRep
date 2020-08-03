package club.vann.leetcode;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

/**
 * <p>难度：Medium</p>
 * <p>题目：最近的三数之和</p>
 * <p>描述：给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 *  
 *
 * 示例：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *  
 *
 * 提示：
 *
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 * 通过次数140,062提交次数306,284
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-08-03 14:00
 **/
public class LeetCode_16 {
    public static void main(String[] args) {
        LeetCode_16 leetCode = new LeetCode_16();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.threeSumClosest(TestCase.NUMS, TestCase.TARGET));
    }

    /**
     * 解法一
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;

        int res = 0;
        int min = Integer.MAX_VALUE;
        for(int a = 0; a < len-2; a ++) {
            for(int b = a+1; b < len-1; b ++) {
                for(int c = b+1; c < len; c ++) {
                    int val = nums[a]+nums[b]+nums[c];
                    if(Math.abs(val - target) <= min) {
                        min = Math.abs(val - target);
                        res = val;
                    }
                }
            }
        }

        return res;
    }

    static class TestCase {
        public static int ANS = 2;
        public static int TARGET = 1;
        public static int[] NUMS = {-1,2,1,-4};
    }
}
