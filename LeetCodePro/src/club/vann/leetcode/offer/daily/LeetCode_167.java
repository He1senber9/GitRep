package club.vann.leetcode.offer.daily;

import java.util.Arrays;

/**
 * <p>难度：Easy</p>
 * <p>题目：两数之和II-输入有序数组</p>
 * <p>描述：给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 说明:
 *
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 *
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 * 通过次数111,022提交次数201,826
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-07-20 08:33
 **/
public class LeetCode_167 {
    public static void main(String[] args) {
        LeetCode_167 leetCode = new LeetCode_167();

        System.out.println("Result["+ Arrays.toString(TestCase.ANS)+"] : " + Arrays.toString(leetCode.twoSum1(TestCase.NUMS, TestCase.TARGET)));
        System.out.println("Result["+ Arrays.toString(TestCase.ANS1)+"] : " + Arrays.toString(leetCode.twoSum1(TestCase.NUMS1, TestCase.TARGET1)));

    }

    /**
     * 解法一：
     * 暴力遍历
     * @param numbers
     * @param target
     * @return
     */
    private int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int len = numbers.length;
        for(int index1 = 0; index1 < len-1; index1 ++) {

            for(int index2 = index1+1; index2 < len; index2 ++) {
                if(numbers[index1] + numbers[index2] == target) {
                    ans[0] = index1+1;
                    ans[1] = index2+1;
                    break;
                }
            }
        }

        return ans;
    }

    /**
     * 解法二：
     * 采用双指针
     * @param numbers
     * @param target
     * @return
     */
    private int[] twoSum1(int[] numbers, int target) {
        int[] ans = new int[2];
        int len = numbers.length;
        int left = 0, right = len-1;
        while(left < right) {
            int sum = numbers[left] + numbers[right];
            if(sum == target) {
                ans[0] = left+1;
                ans[1] = right+1;
                break;
            } else if(sum < target) {
                left ++;
            } else if(sum > target) {
                right --;
            }
        }
        return ans;
    }

    static class TestCase {
        public static int[] ANS = {1,2};
        public static int TARGET = 9;
        public static int[] NUMS = {2, 7, 11, 15};

        public static int[] ANS1 = {4,5};
        public static int TARGET1 = 5;
        public static int[] NUMS1 = {1, 2, 3, 4, 5, 6};
    }
}
