package club.vann.leetcode.offer.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * <p>难度：Medium</p>
 * <p>题目：最大数</p>
 * <p>描述：给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 *
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [10,2]
 * 输出："210"
 * 示例 2：
 *
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出："1"
 * 示例 4：
 *
 * 输入：nums = [10]
 * 输出："10"
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 109
 * 通过次数58,502提交次数152,874
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2021/4/12
 * Time: 0:19
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LeetCode_179 {
    public static void main(String[] args) {
        LeetCode_179 leetCode = new LeetCode_179();

        System.out.println(leetCode.largestNumber(TestCase.NUMS));
        System.out.println(leetCode.largestNumber(TestCase.NUMS1));
        System.out.println(leetCode.largestNumber(TestCase.NUMS2));
        System.out.println(leetCode.largestNumber(TestCase.NUMS3));
        System.out.println(leetCode.largestNumber(TestCase.NUMS4));
    }

    /**
     * 解法一：
     *
     * @param nums
     * @return
     */
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] strs = new String[n];
        for(int i = 0; i < n; i ++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()) {
                    return o2.compareTo(o1);
                } else {
                    String str1 = o1+o2;
                    String str2 = o2+o1;
                    return str2.compareTo(str1);
                }
            }
        });

        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < n; i ++) {
            builder.append(strs[i]);
        }

        String ans = builder.toString();
        return builder.charAt(0) == '0' ? "0" : builder.toString();
    }

    static class TestCase {
        public static String ANS = "210";
        public static int[] NUMS = {10,2};

        public static String ANS1 = "9534330";
        public static int[] NUMS1 = {3,30,34,5,9};

        public static String ANS2 = "1";
        public static int[] NUMS2 = {1};

        public static String ANS3 = "10";
        public static int[] NUMS3 = {10};

        public static String ANS4 = "0";
        public static int[] NUMS4 = {00,00,0};
    }
}
