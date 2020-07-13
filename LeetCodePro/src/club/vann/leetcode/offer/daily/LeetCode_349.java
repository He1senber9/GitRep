package club.vann.leetcode.offer.daily;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * <p>难度：Easy</p>
 * <p>题目：两个数组的交集</p>
 * <p>描述：给定两个数组，编写一个函数来计算它们的交集。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *  
 *
 * 说明：
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 * 通过次数78,570提交次数112,432
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/7/13
 * Time: 20:31
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_349 {
    public static void main(String[] args) {
        LeetCode_349 leetCode = new LeetCode_349();

        System.out.println(Arrays.toString(leetCode.intersection(TestCase.PARAMS[0], TestCase.PARAMS[1])));
        System.out.println(Arrays.toString(leetCode.intersection(TestCase.PARAMS1[0], TestCase.PARAMS1[1])));
    }

    /**
     * 解法一：
     *
     * @param nums1
     * @param nums2
     * @return
     */
    private int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }

        HashSet<Integer> set1 = new HashSet<Integer>();//如果数据量大，应当考虑TreeSet
        for (Integer n : nums1) {
            set1.add(n);
        }
        List<Integer> list = new ArrayList<Integer>();
        for (Integer n : nums2) {
            if(set1.contains(n)){
                list.add(n);
                set1.remove(n);
            }
        }
        int[] output =new int[list.size()];
        for(int i=0;i<list.size();i++){
            output[i]=list.get(i);
        }
        return output;
    }

    static class TestCase {
        public static int[][] PARAMS = {{1,2,2,1}, {2,2}};

        public static int[][] PARAMS1 = {{4,9,5}, {9,4,9,8,4}};
    }
}
