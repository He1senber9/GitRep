package club.vann.leetcode.offer.daily;

import java.util.TreeSet;

/**
 * <p>难度：Medium</p>
 * <p>题目：存在重复的元素III</p>
 * <p>描述：给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在两个下标 i 和 j，使得 abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
 *
 * 如果存在则返回 true，不存在返回 false。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,1], k = 3, t = 0
 * 输出：true
 * 示例 2：
 *
 * 输入：nums = [1,0,1,1], k = 1, t = 2
 * 输出：true
 * 示例 3：
 *
 * 输入：nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出：false
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 2 * 104
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 104
 * 0 <= t <= 231 - 1
 * 通过次数33,366提交次数125,109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @ClassName LeetCode_220
 * @Description TODO
 * @User fanyu
 * @Date 2021/4/17 8:35
 */
public class LeetCode_220 {
    public static void main(String[] args) {
        LeetCode_220 leetCode = new LeetCode_220();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.containsNearbyAlmostDuplicate(TestCase.NUMS, TestCase.PAR[0], TestCase.PAR[1]));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.containsNearbyAlmostDuplicate(TestCase.NUMS1, TestCase.PAR1[0], TestCase.PAR1[1]));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.containsNearbyAlmostDuplicate(TestCase.NUMS2, TestCase.PAR2[0], TestCase.PAR2[1]));
    }

    /**
     * 解法一：
     *
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> treeSet = new TreeSet<>();
        for(int i = 0; i < n; i ++) {
            Long cell = treeSet.ceiling((long)nums[i]- (long)t);
            if(cell != null && cell <= (long) nums[i] + (long) t) {
                return true;
            }

            treeSet.add((long) nums[i]);
            if(i >= k) {
                treeSet.remove((long) nums[i-k]);
            }
        }
        return false;
    }

    static class TestCase {
        public static boolean ANS = true;
        public static int[] NUMS = {1,2,3,1};
        public static int[] PAR = {3,0};

        public static boolean ANS1 = true;
        public static int[] NUMS1 = {1,0,1,1};
        public static int[] PAR1 = {1,2};

        public static boolean ANS2 = false;
        public static int[] NUMS2 = {1,5,9,1,5,9};
        public static int[] PAR2 = {2,3};
    }
}
