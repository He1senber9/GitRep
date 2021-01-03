package club.vann.leetcode.offer.daily;

import java.util.Arrays;

/**
 * <p>难度：Medium</p>
 * <p>题目：无重叠区间</p>
 * <p>描述：给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 *
 * 注意:
 *
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * 示例 1:
 *
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 *
 * 输出: 1
 *
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * 示例 2:
 *
 * 输入: [ [1,2], [1,2], [1,2] ]
 *
 * 输出: 2
 *
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 * 示例 3:
 *
 * 输入: [ [1,2], [2,3] ]
 *
 * 输出: 0
 *
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 * 通过次数34,491提交次数73,779
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-overlapping-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-12-31 09:04
 **/
public class LeetCode_435 {
    public static void main(String[] args) {
        LeetCode_435 leetCode = new LeetCode_435();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.eraseOverlapIntervals(TestCase.INTERVALS));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.eraseOverlapIntervals(TestCase.INTERVALS1));
        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.eraseOverlapIntervals(TestCase.INTERVALS2));
    }

    /**
     * 解法一：
     *
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals == null || intervals.length == 0) {
            return 0;
        }

        int len = intervals.length;
        // 先按照左端点排序
        Arrays.sort(intervals, (x,y)->{
            return x[0] - y[0];
        });

        // dp[i]表示以第i个区间为最后一个区间，能挑选出不重叠区间的最大数量
        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        for(int i = 1; i < len; i ++) {
            for(int j = 0; j < i; j ++) {
                if(intervals[j][1] <= intervals[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        int max = 0;
        for(int i : dp) {
            max = Math.max(max, i);
        }
        return len - max;
    }

    static class TestCase {
        public static int ANS = 1;
        public static int[][] INTERVALS = {{1,2}, {2,3},{3,4},{1,3}};

        public static int ANS1 = 2;
        public static int[][] INTERVALS1 = {{1,2}, {1,2},{1,2}};

        public static int ANS2 = 0;
        public static int[][] INTERVALS2 = {{1,2}, {2,3}};
    }
}
