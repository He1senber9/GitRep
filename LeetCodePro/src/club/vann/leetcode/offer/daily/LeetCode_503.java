package club.vann.leetcode.offer.daily;

import java.util.Arrays;
import java.util.Stack;

/**
 * <p>难度：Medium</p>
 * <p>题目：下一个更大元素II</p>
 * <p>描述：给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 *
 * 示例 1:
 *
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * 注意: 输入数组的长度不会超过 10000。
 *
 * 通过次数46,232提交次数77,526
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-greater-element-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @author vann
 * @program GitRep
 * @description
 * @date 2021-03-06:08:41:55
 */
public class LeetCode_503 {
    public static void main(String[] args) {
        LeetCode_503 leetCode = new LeetCode_503();

        System.out.println("Result["+ Arrays.toString(TestCase.ANS)+"] : " + Arrays.toString(leetCode.nextGreaterElements(TestCase.NUMS)));
        System.out.println("Result["+ Arrays.toString(TestCase.ANS1)+"] : " + Arrays.toString(leetCode.nextGreaterElements(TestCase.NUMS1)));
    }

    /**
     * 解法一：
     *
     * @param nums
     * @return
     */
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < (n*2-1); i ++) {
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i%n]) {
                ans[stack.pop()] = nums[i%n];
            }
            stack.push(i%n);
        }

        return ans;
    }

    static class TestCase {
        public static int[] ANS = {2,-1,2};
        public static int[] NUMS = {1,2,1};

        public static int[] ANS1 = {2, 3, 4, -1, 4};
        public static int[] NUMS1 = {1,2,3,4,3};
    }
}
