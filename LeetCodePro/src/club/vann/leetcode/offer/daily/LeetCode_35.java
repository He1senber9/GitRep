package club.vann.leetcode.offer.daily;

/**
 * <p>难度：Easy</p>
 * <p>题目：搜索插入位置</p>
 * <p>描述：给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * 通过次数189,748提交次数411,766
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-07-17 09:35
 **/
public class LeetCode_35 {
    public static void main(String[] args) {
        LeetCode_35 leetCode = new LeetCode_35();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.searchInsert(TestCase.PARAMS, 5));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.searchInsert(TestCase.PARAMS1, 2));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.searchInsert(TestCase.PARAMS2, 7));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.searchInsert(TestCase.PARAMS3, 0));

    }

    /**
     * 解法一：
     *
     * @param nums
     * @param target
     * @return
     */
    private int searchInsert(int[] nums, int target) {
        int len = nums.length;
        int index = 0;
        for(int n = 0; n < len; n ++, index++) {
            if(nums[n] < target) {
                continue;
            } else {
                break;
            }
        }
        return index;
    }

    static class TestCase {
        public static int ANS = 2;
        public static int[] PARAMS = {1,3,5,6};

        public static int ANS1 = 1;
        public static int[] PARAMS1 = {1,3,5,6};

        public static int ANS2 = 4;
        public static int[] PARAMS2 = {1,3,5,6};

        public static int ANS3 = 0;
        public static int[] PARAMS3 = {1,3,5,6};
    }
}
