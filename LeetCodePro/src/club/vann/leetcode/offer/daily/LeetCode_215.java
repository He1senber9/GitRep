package club.vann.leetcode.offer.daily;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>难度：Medium</p>
 * <p>题目：数组中第K大的元素</p>
 * <p>描述：在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *
 * 通过次数133,480提交次数212,137
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/6/29
 * Time: 7:11
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_215 {
    public static void main(String[] args) {
        LeetCode_215 leetCode = new LeetCode_215();

        System.out.println("Result["+TestCase.ans+"] : " + leetCode.findKthLargest(TestCase.nums, 2));
        System.out.println("Result["+TestCase.ans1+"] : " + leetCode.findKthLargest(TestCase.nums1, 4));
    }

    private int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return 0;
        }



        return 0;
    }

    static class TestCase {
        public static final int ans = 5;
        public static int[] nums = {3,2,1,5,6,4};

        public static final int ans1 = 5;
        public static int[] nums1 = {3,2,3,1,2,4,5,5,6};
    }
}
