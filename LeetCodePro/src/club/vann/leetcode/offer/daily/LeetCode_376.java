package club.vann.leetcode.offer.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>难度：Medium</p>
 * <p>题目：摆动序列</p>
 * <p>描述：如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。
 *
 * 例如， [1,7,4,9,2,5] 是一个摆动序列，因为差值 (6,-3,5,-7,3) 是正负交替出现的。相反, [1,4,7,2,5] 和 [1,7,4,5,5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
 *
 * 给定一个整数序列，返回作为摆动序列的最长子序列的长度。 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。
 *
 * 示例 1:
 *
 * 输入: [1,7,4,9,2,5]
 * 输出: 6
 * 解释: 整个序列均为摆动序列。
 * 示例 2:
 *
 * 输入: [1,17,5,10,13,15,10,5,16,8]
 * 输出: 7
 * 解释: 这个序列包含几个长度为 7 摆动序列，其中一个可为[1,17,10,13,10,16,8]。
 * 示例 3:
 *
 * 输入: [1,2,3,4,5,6,7,8,9]
 * 输出: 2
 * 进阶:
 * 你能否用 O(n) 时间复杂度完成此题?
 *
 * 通过次数46,357提交次数102,984
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/wiggle-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: LeetCodePro
 * @description:
 * @author: vann
 * @create: 2020-12-13 17:58
 **/
public class LeetCode_376 {
    public static void main(String[] args) {
        LeetCode_376 leetCode = new LeetCode_376();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.wiggleMaxLength(TestCase.NUMS));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.wiggleMaxLength(TestCase.NUMS1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.wiggleMaxLength(TestCase.NUMS2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.wiggleMaxLength(TestCase.NUMS3));
    }

    /**
     * 解法一：
     * 采用动态规划思路
     *
     * @param nums
     * @return
     */
    private int wiggleMaxLength(int[] nums) {
        if(nums == null) {
            return 0;
        }
        int len = nums.length;
        if(len < 2) {
            return len;
        }

        int[] up = new int[len];
        int[] down = new int[len];
        up[0] = down[0] = 1;

        for(int i = 1; i < len; i ++) {
            if(nums[i-1] > nums[i]) {
                up[i] = up[i-1];
                down[i] = Math.max(down[i-1], up[i-1]+1);
            } else if(nums[i-1] < nums[i]){
                up[i] = Math.max(up[i-1], down[i-1]+1);
                down[i] = down[i-1];
            } else {
                up[i] = up[i-1];
                down[i] = down[i-1];
            }
        }

        return Math.max(up[len-1], down[len-1]);
    }

    static class TestCase {
        public static int ANS = 6;
        public static int[] NUMS = {1,7,4,9,2,5};

        public static int ANS1 = 7;
        public static int[] NUMS1 = {1,17,5,10,13,15,10,5,16,8};

        public static int ANS2 = 2;
        public static int[] NUMS2 = {1,2,3,4,5,6,7,8,9};

        public static int ANS3 = 1;
        public static int[] NUMS3 = {0,0};
    }
}
