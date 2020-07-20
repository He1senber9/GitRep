package club.vann.leetcode.offer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>难度：Easy</p>
 * <p>题目：克牌中的顺子</p>
 * <p>描述：从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5]
 * 输出: True
 *  
 *
 * 示例 2:
 *
 * 输入: [0,0,1,2,5]
 * 输出: True
 *  
 *
 * 限制：
 *
 * 数组长度为 5 
 *
 * 数组的数取值为 [0, 13] .
 *
 * 通过次数20,248提交次数45,580
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-07-20 14:44
 **/
public class LeetCode_61 {
    public static void main(String[] args) {
        LeetCode_61 leetCode = new LeetCode_61();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.isStraight(TestCase.NUMS));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.isStraight(TestCase.NUMS1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.isStraight(TestCase.NUMS2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.isStraight(TestCase.NUMS3));
    }

    /**
     * 解法一：
     *
     * @param nums
     * @return
     */
    private boolean isStraight(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int min = 14, max = 0;
        for(int num : nums) {
            if(num == 0) {
                continue;
            }
            if(set.contains(num)) {
                return false;
            }
            set.add(num);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return max-min < 5;
    }

    static class TestCase {
        public static boolean ANS = true;
        public static int[] NUMS = {1,2,3,4,5};

        public static boolean ANS1 = true;
        public static int[] NUMS1 = {0,0,1,2,5};

        public static boolean ANS2 = true;
        public static int[] NUMS2 = {0,1,2,3,4};

        public static boolean ANS3 = false;
        public static int[] NUMS3 = {0,0,2,2,5};
    }
}
