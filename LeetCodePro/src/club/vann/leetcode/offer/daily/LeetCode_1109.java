package club.vann.leetcode.offer.daily;

import java.util.Arrays;

/**
 * <p>难度：Medium</p>
 * <p>题目：航班预定统计</p>
 * <p>描述：这里有 n 个航班，它们分别从 1 到 n 进行编号。
 *
 * 有一份航班预订表 bookings ，表中第 i 条预订记录 bookings[i] = [firsti, lasti, seatsi] 意味着在从 firsti 到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi 个座位。
 *
 * 请你返回一个长度为 n 的数组 answer，其中 answer[i] 是航班 i 上预订的座位总数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
 * 输出：[10,55,45,25,25]
 * 解释：
 * 航班编号        1   2   3   4   5
 * 预订记录 1 ：   10  10
 * 预订记录 2 ：       20  20
 * 预订记录 3 ：       25  25  25  25
 * 总座位数：      10  55  45  25  25
 * 因此，answer = [10,55,45,25,25]
 * 示例 2：
 *
 * 输入：bookings = [[1,2,10],[2,2,15]], n = 2
 * 输出：[10,25]
 * 解释：
 * 航班编号        1   2
 * 预订记录 1 ：   10  10
 * 预订记录 2 ：       15
 * 总座位数：      10  25
 * 因此，answer = [10,25]
 *  
 *
 * 提示：
 *
 * 1 <= n <= 2 * 104
 * 1 <= bookings.length <= 2 * 104
 * bookings[i].length == 3
 * 1 <= firsti <= lasti <= n
 * 1 <= seatsi <= 104
 * 通过次数31,503提交次数60,790
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/corporate-flight-bookings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @description:
 * @program: GitRep
 * @author: fanyu
 * @create: 2021-08-31  08:05:54
 */
public class LeetCode_1109 {
    public static void main(String[] args) {
        LeetCode_1109 leetCode = new LeetCode_1109();

        System.out.println("Result["+ Arrays.toString(TestCase.ANS) + "] : " + Arrays.toString(leetCode.corpFlightBookings(TestCase.BOOKINGS, TestCase.N)));
        System.out.println("Result["+ Arrays.toString(TestCase.ANS1) + "] : " + Arrays.toString(leetCode.corpFlightBookings(TestCase.BOOKINGS1, TestCase.N1)));
    }

    /**
     * 解法一：
     *
     * @param bookings
     * @param n
     * @return
     */
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];

        for(int[] book : bookings) {
            int start = book[0];
            int end = book[1];
            int offset = book[2];

            for(int i = start; i <= end; i ++) {
                ans[i-1] += offset;
            }
        }
        return ans;
    }

    /**
     * 解法二：
     *
     * @param bookings
     * @param n
     * @return
     */
    public int[] corpFlightBookings1(int[][] bookings, int n) {
        int[] nums = new int[n];

        for (int[] booking : bookings) {
            nums[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                nums[booking[1]] -= booking[2];
            }
        }
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }

    static class TestCase {
        public static int[] ANS = {10,55,45,25,25};
        public static int[][] BOOKINGS = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        public static int N = 5;

        public static int[] ANS1 = {10,25};
        public static int[][] BOOKINGS1 = {{1, 2, 10}, {2, 2, 15}};
        public static int N1 = 2;
    }
}
