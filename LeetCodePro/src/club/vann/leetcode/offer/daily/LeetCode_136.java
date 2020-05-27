package club.vann.leetcode.offer.daily;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>难度：Easy</p>
 * <p>题目：只出现一次的数字</p>
 * <p>描述：给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 * 通过次数208,418提交次数304,995
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: GitRep
 * @description:
 * @author: vann
 * @create: 2020-05-14 21:15
 **/
public class LeetCode_136 {
    public static void main(String[] args) {
        LeetCode_136 leetCode = new LeetCode_136();

        System.out.println("Result["+TestCase.ans+"] " + leetCode.singleNumber2(TestCase.nums));
        System.out.println("Result["+TestCase.ans1+"] " + leetCode.singleNumber2(TestCase.nums1));
    }

    /**
     * 解法一：
     * 采用Set辅助
     * 时间复杂度：O(1)
     * 空间复杂度：O(n)
     * @param nums
     * @return
     */
    private int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }

        Set<Integer> set = new HashSet<Integer>();
        int len = nums.length;
        for(int n = 0; n < len; n ++) {
            if(set.contains(nums[n])) {
                set.remove(nums[n]);
            } else {
                set.add(nums[n]);
            }
        }
        return set.iterator().next();
    }

    /**
     * 解法二：
     * @param nums
     * @return
     */
    private int singleNumber2(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }

        int len = nums.length;
        int result = 0;
        for(int i = 0; i < len; i ++) {
            result = result ^ nums[i];
        }
        return result;
    }

    static class TestCase {
        static final int ans = 1;
        static final int[] nums = {2,2,1};

        static final int ans1 = 4;
        static final int[] nums1 = {4,1,2,1,2};
    }
}
