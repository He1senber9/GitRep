package club.vann.leetcode.offer.daily;

import java.util.Arrays;

/**
 * <p>难度：Medium</p>
 * <p>题目：用最少数量的箭引爆气球</p>
 * <p>描述：在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。由于它是水平的，所以纵坐标并不重要，因此只要知道开始和结束的横坐标就足够了。开始坐标总是小于结束坐标。
 *
 * 一支弓箭可以沿着 x 轴从不同点完全垂直地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
 *
 * 给你一个数组 points ，其中 points [i] = [xstart,xend] ，返回引爆所有气球所必须射出的最小弓箭数。
 *
 *  
 * 示例 1：
 *
 * 输入：points = [[10,16],[2,8],[1,6],[7,12]]
 * 输出：2
 * 解释：对于该样例，x = 6 可以射爆 [2,8],[1,6] 两个气球，以及 x = 11 射爆另外两个气球
 * 示例 2：
 *
 * 输入：points = [[1,2],[3,4],[5,6],[7,8]]
 * 输出：4
 * 示例 3：
 *
 * 输入：points = [[1,2],[2,3],[3,4],[4,5]]
 * 输出：2
 * 示例 4：
 *
 * 输入：points = [[1,2]]
 * 输出：1
 * 示例 5：
 *
 * 输入：points = [[2,3],[2,3]]
 * 输出：1
 *  
 *
 * 提示：
 *
 * 0 <= points.length <= 104
 * points[i].length == 2
 * -231 <= xstart < xend <= 231 - 1
 * 通过次数29,245提交次数58,651
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @program: LeetCodePro
 * @description:
 * @author: vann
 * @create: 2020-11-23 11:35
 **/
public class LeetCode_452 {
    public static void main(String[] args) {
        LeetCode_452 leetCode = new LeetCode_452();

//        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.findMinArrowShots(TestCase.POINTS));
//        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.findMinArrowShots(TestCase.POINTS1));
//        System.out.println("Result["+TestCase.ANS2+"] : " + leetCode.findMinArrowShots(TestCase.POINTS2));
//        System.out.println("Result["+TestCase.ANS3+"] : " + leetCode.findMinArrowShots(TestCase.POINTS3));
//        System.out.println("Result["+TestCase.ANS4+"] : " + leetCode.findMinArrowShots(TestCase.POINTS4));
        System.out.println("Result["+TestCase.ANS5+"] : " + leetCode.findMinArrowShots(TestCase.POINTS5));
    }

    /**
     * 解法一：
     *
     * @param points
     * @return
     */
    public int findMinArrowShots(int[][] points) {
        if(points == null || points.length == 0) {
            return 0;
        }

        int n = points.length; // 总共 n 个气球
        boolean[] flag = new boolean[n]; // 第 n 个气球是否被扎爆

        // 先升序排列points
        Arrays.sort(points, (int[] x, int[] y) -> {
            if(x[1] > y[1]) {
                return 1;
            } else if(x[1] < y[1]) {
                return -1;
            } else {
                return 0;
            }
        });

        int ans = 0;
        for(int i = 0; i < n; i ++) {
            if(flag[i]) {
                continue;
            }

            ans ++;
            int o = i;
            int p = o+1;
            while(p < n && points[o][1] >= points[p][0]) {
                flag[p] = true;
                p ++;
            }

        }
        return ans;
    }

    public int findMinArrowShots1(int[][] points) {
        if(points == null || points.length == 0) {
            return 0;
        }

        int n = points.length; // 总共 n 个气球

        // 先升序排列points
        Arrays.sort(points, (int[] x, int[] y) -> {
            return x[1] - y[1];
        });

        int pos = points[0][1];
        int ans = 1;

        for(int[] arr : points) {
            if(arr[0] > pos) {
                pos = arr[1];
                ++ans;
            }
        }
        return ans;
    }

    static class TestCase {
        public static int ANS = 2;
        public static int[][] POINTS = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};

        public static int ANS1 = 4;
        public static int[][] POINTS1 = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};

        public static int ANS2 = 2;
        public static int[][] POINTS2 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};

        public static int ANS3 = 1;
        public static int[][] POINTS3 = {{1,2}};

        public static int ANS4 = 1;
        public static int[][] POINTS4 = {{2,3},{2,3}};

        public static int ANS5 = 2;
        public static int[][] POINTS5 = {{-2147483646,-2147483645},{2147483646,2147483647}};
    }
}
