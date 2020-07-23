package club.vann.leetcode;

/**
 * <p>难度：Medium</p>
 * <p>题目：搜索旋转数组</p>
 * <p>描述：假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 * 通过次数147,303提交次数384,145
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-07-22 13:45
 **/
public class LeetCode_33 {
    public static void main(String[] args) {
        LeetCode_33 leetCode = new LeetCode_33();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.search(TestCase.NUMS, TestCase.TARGET));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.search(TestCase.NUMS1, TestCase.TARGET1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.search(TestCase.NUMS2, TestCase.TARGET2));
        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.search(TestCase.NUMS3, TestCase.TARGET3));
        System.out.println("Result["+TestCase.ANS4+"] : " + leetCode.search(TestCase.NUMS4, TestCase.TARGET4));
        System.out.println("Result["+TestCase.ANS5+"] : " + leetCode.search(TestCase.NUMS5, TestCase.TARGET5));
    }

    /**
     * 解法一：
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len-1;

        while(left <= right) {
            int mid = left + (right-left)/2;
            if(target == nums[mid]) {
                return mid;
            }

            if(nums[left] <= nums[mid]) {
                if(nums[left] <= target && target < nums[mid]) {
                    right = mid -1;
                } else {
                    left = mid + 1;
                }
            } else {
                if(nums[mid] < target && target < nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    static class TestCase {
        public static int ANS = 4;
        public static int TARGET = 0;
        public static int[] NUMS = {4,5,6,7,0,1,2};

        public static int ANS1 = -1;
        public static int TARGET1 = 3;
        public static int[] NUMS1 = {4,5,6,7,0,1,2};

        public static int ANS2 = 3;
        public static int TARGET2 = 4;
        public static int[] NUMS2 = {1,2,3,4,5,6,7};

        public static int ANS3 = -1;
        public static int TARGET3 = 4;
        public static int[] NUMS3 = {1,2,3,5,6,7};

        public static int ANS4 = 0;
        public static int TARGET4 = 5;
        public static int[] NUMS4 = {5,1,3};

        public static int ANS5 = 1;
        public static int TARGET5 = 1;
        public static int[] NUMS5 = {3,1};
    }
}
