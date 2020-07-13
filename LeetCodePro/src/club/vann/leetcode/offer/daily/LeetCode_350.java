package club.vann.leetcode.offer.daily;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>难度：Easy</p>
 * <p>题目：两个数组的交集II</p>
 * <p>描述：给定两个数组，编写一个函数来计算它们的交集。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *  
 *
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶：
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * 通过次数116,393提交次数227,067
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/7/13
 * Time: 20:22
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_350 {
    public static void main(String[] args) {
        LeetCode_350 leetCode = new LeetCode_350();

        System.out.println(Arrays.toString(leetCode.intersect(TestCase.PARAMS[0], TestCase.PARAMS[1])));
        System.out.println(Arrays.toString(leetCode.intersect(TestCase.PARAMS1[0], TestCase.PARAMS1[1])));
    }

    /**
     * 解法一：
     *
     * @param nums1
     * @param nums2
     * @return
     */
    private int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums1) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        int[] intersection = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                intersection[index++] = num;
                count--;
                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }
        
        return Arrays.copyOfRange(intersection, 0, index);
    }

    static class TestCase {
        public static int[][] PARAMS = {{1,2,2,1}, {2,2}};

        public static int[][] PARAMS1 = {{4,9,5}, {9,4,9,8,4}};
    }
}
