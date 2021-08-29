package club.vann.leetcode.race.race20210829;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <p>难度：medium</p>
 * <p>题目：找出数组中的第 K 大整数</p>
 * <p>描述：给你一个字符串数组 nums 和一个整数 k 。nums 中的每个字符串都表示一个不含前导零的整数。
 *
 * 返回 nums 中表示第 k 大整数的字符串。
 *
 * 注意：重复的数字在统计时会视为不同元素考虑。例如，如果 nums 是 ["1","2","2"]，那么 "2" 是最大的整数，"2" 是第二大的整数，"1" 是第三大的整数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = ["3","6","7","10"], k = 4
 * 输出："3"
 * 解释：
 * nums 中的数字按非递减顺序排列为 ["3","6","7","10"]
 * 其中第 4 大整数是 "3"
 * 示例 2：
 *
 * 输入：nums = ["2","21","12","1"], k = 3
 * 输出："2"
 * 解释：
 * nums 中的数字按非递减顺序排列为 ["1","2","12","21"]
 * 其中第 3 大整数是 "2"
 * 示例 3：
 *
 * 输入：nums = ["0","0"], k = 2
 * 输出："0"
 * 解释：
 * nums 中的数字按非递减顺序排列为 ["0","0"]
 * 其中第 2 大整数是 "0"
 *
 *
 * 提示：
 *
 * 1 <= k <= nums.length <= 104
 * 1 <= nums[i].length <= 100
 * nums[i] 仅由数字组成
 * nums[i] 不含任何前导零</p>
 * @description:
 * @program: GitRep
 * @author: fanyu
 * @create: 2021-08-29  10:46:40
 */
public class LeetCode_5855 {
    public static void main(String[] args) {
        LeetCode_5855 leetCode = new LeetCode_5855();

        System.out.println("Result[" + TestCase.ANS + " ] : " + leetCode.kthLargestNumber(TestCase.NUMS, TestCase.K));
        System.out.println("Result[" + TestCase.ANS1 + " ] : " + leetCode.kthLargestNumber(TestCase.NUMS1, TestCase.K1));
    }

    /**
     * 解法一：
     *
     * @param nums
     * @param k
     * @return
     */
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> queue = new PriorityQueue<String>(new Comparator<String>() {
            public int compare(String s1, String s2) {
//                if(s1.length() == s2.length()) {
//                    return s2.compareTo(s1);
//                } else {
//                    return s2.length() - s1.length();
//                }
                return s2.compareTo(s1);
            }
        });

        for(String str : nums) {
            queue.offer(str);
        }

        String ans = null;
        while(k > 0) {
            ans = queue.poll();
            k --;
        }

        return ans;
    }

    static class TestCase {
        public static String ANS = "3";
        public static String[] NUMS = {"3","6","7","10"};
        public static int K = 3;

        public static String ANS1 = "2";
        public static String[] NUMS1 = {"2","21","12","1"};
        public static int K1 = 3;
    }
}
