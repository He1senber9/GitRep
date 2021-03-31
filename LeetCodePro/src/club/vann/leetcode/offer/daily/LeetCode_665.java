package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Easy</p>
 * <p>题目：非递减数列</p>
 * <p>描述：给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 *
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [4,2,3]
 * 输出: true
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 * 示例 2:
 *
 * 输入: nums = [4,2,1]
 * 输出: false
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 *  
 *
 * 说明：
 *
 * 1 <= n <= 10 ^ 4
 * - 10 ^ 5 <= nums[i] <= 10 ^ 5
 * 通过次数37,696提交次数158,363
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-decreasing-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @author vann
 * @program GitRep
 * @description
 * @date 2021-02-07:08:52:18
 */
public class LeetCode_665 {
    public static void main(String[] args) {
        LeetCode_665 leetCode = new LeetCode_665();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.checkPossibility(TestCase.NUMS));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.checkPossibility(TestCase.NUMS1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.checkPossibility(TestCase.NUMS2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.checkPossibility(TestCase.NUMS3));
    }

    /**
     * 解法一：
     *
     * @param nums
     * @return
     */
    public boolean checkPossibility(int[] nums) {
        int len = nums.length;

        int cnt = 0;
        for(int i = 0; i < len-1; i ++) {
            int a = nums[i];
            int b = nums[i+1];
            if(a > b) {
                cnt ++;
                if(cnt > 1) {
                    return false;
                }

                if(i > 0 && nums[i-1] > b) {
                    nums[i+1] = nums[i];
                }
            }
        }
        return true;
    }

    static class TestCase {
        public static boolean ANS = true;
        public static int[] NUMS = {4,2,3};

        public static boolean ANS1 = false;
        public static int[] NUMS1 = {4,2,1};

        public static boolean ANS2 = false;
        public static int[] NUMS2 = {1,2,3,4,1,2,3,4};

        public static boolean ANS3 = true;
        public static int[] NUMS3 = {1,2,3,7,5,6,7,8};
    }
}
