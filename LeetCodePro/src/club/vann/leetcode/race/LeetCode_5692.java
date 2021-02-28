package club.vann.leetcode.race;

import java.util.Arrays;

/**
 * <p>难度：Hard</p>
 * <p>题目：车队II</p>
 * <p>描述：在一条单车道上有 n 辆车，它们朝着同样的方向行驶。给你一个长度为 n 的数组 cars ，其中 cars[i] = [positioni, speedi] ，它表示：
 *
 * positioni 是第 i 辆车和道路起点之间的距离（单位：米）。题目保证 positioni < positioni+1 。
 * speedi 是第 i 辆车的初始速度（单位：米/秒）。
 * 简单起见，所有车子可以视为在数轴上移动的点。当两辆车占据同一个位置时，我们称它们相遇了。一旦两辆车相遇，它们会合并成一个车队，这个车队里的车有着同样的位置和相同的速度，速度为这个车队里 最慢 一辆车的速度。
 *
 * 请你返回一个数组 answer ，其中 answer[i] 是第 i 辆车与下一辆车相遇的时间（单位：秒），如果这辆车不会与下一辆车相遇，则 answer[i] 为 -1 。答案精度误差需在 10-5 以内。
 *
 *
 *
 * 示例 1：
 *
 * 输入：cars = [[1,2],[2,1],[4,3],[7,2]]
 * 输出：[1.00000,-1.00000,3.00000,-1.00000]
 * 解释：经过恰好 1 秒以后，第一辆车会与第二辆车相遇，并形成一个 1 m/s 的车队。经过恰好 3 秒以后，第三辆车会与第四辆车相遇，并形成一个 2 m/s 的车队。
 * 示例 2：
 *
 * 输入：cars = [[3,4],[5,4],[6,3],[9,1]]
 * 输出：[2.00000,1.00000,1.50000,-1.00000]
 *
 *
 * 提示：
 *
 * 1 <= cars.length <= 105
 * 1 <= positioni, speedi <= 106
 * positioni < positioni+1</p>
 * @author vann
 * @program GitRep
 * @description
 * @date 2021-02-28:11:13:51
 */
public class LeetCode_5692 {
    public static void main(String[] args) {
        LeetCode_5692 leetCode = new LeetCode_5692();

        System.out.println("Result["+ Arrays.toString(TestCase.ANS)+"] : " + Arrays.toString(leetCode.getCollisionTimes(TestCase.CARS)));
        System.out.println("Result["+ Arrays.toString(TestCase.ANS1)+"] : " + Arrays.toString(leetCode.getCollisionTimes(TestCase.CARS1)));
    }

    /**
     * 解法一：
     * 超时。
     * 题目保证pos[i] < pos[i+1]
     * @param cars
     * @return
     */
    public double[] getCollisionTimes(int[][] cars) {
        int n = cars.length;
        double[] res = new double[n];
        int base_pos = 0;
        for(int i = 0; i < n-1; i ++) {
            double time = Double.MAX_VALUE;
            int pos_i = cars[i][0] + base_pos;
            int speed_i = cars[i][1];

            // 分别计算第i辆车与其后的车最早相遇时间
            for(int j = i + 1; j < n; j ++) {
                int pos_j = cars[j][0] + base_pos;
                int speed_j = cars[j][1];

                if(speed_i <= speed_j) {
                    // 永远追不上
                    continue;
                }

                double t = (double) (pos_j-pos_i) / (speed_i-speed_j);
                time = Math.min(time, t);
            }

            if(time == Double.MAX_VALUE) {
                res[i] = -1.0;
            } else {
                res[i] = time;
            }
        }

        res[n-1] = -1.0;

        return res;
    }

    static class TestCase {
        public static double[] ANS = {1.00000, -1.00000, 3.00000, -1.00000};
        public static int[][] CARS = {{1, 2}, {2, 1}, {4, 3}, {7, 2}};

        public static double[] ANS1 = {2.00000,1.00000,1.50000,-1.00000};
        public static int[][] CARS1 = {{3, 4}, {5, 4}, {6, 3}, {9, 1}};
    }
}
