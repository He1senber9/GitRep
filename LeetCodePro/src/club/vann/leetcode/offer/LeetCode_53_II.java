package club.vann.leetcode.offer;

/**
 * <p>难度：Easy</p>
 * <p>题目：～n-1中缺失的数字</p>
 * <p>描述：一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [0,1,3]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 *  
 *
 * 限制：
 *
 * 1 <= 数组长度 <= 10000
 *
 * 通过次数35,665提交次数80,693
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-07-20 16:26
 **/
public class LeetCode_53_II {
    public static void main(String[] args) {
        LeetCode_53_II leetCode = new LeetCode_53_II();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.missingNumber(TestCase.NUMS));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.missingNumber(TestCase.NUMS1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.missingNumber(TestCase.NUMS2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.missingNumber(TestCase.NUMS3));
    }

    /**
     * 解法一：
     *
     * @param nums
     * @return
     */
    private int missingNumber(int[] nums) {
        int len = nums.length;
        int res = -1;
        for(int n = 0; n < len; n ++) {
            if(nums[n] != n) {
                res = n;
                break;
            }
        }
        return res== -1 ? len : res;
    }

    static class TestCase {
        public static int ANS = 2;
        public static int[] NUMS = {0,1,3};

        public static int ANS1 = 8;
        public static int[] NUMS1 = {0,1,2,3,4,5,6,7,9};

        public static int ANS2 = 1;
        public static int[] NUMS2 = {0};

        public static int ANS3 = 0;
        public static int[] NUMS3 = {1,2};
    }
}
