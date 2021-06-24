package club.vann.leetcode.offer.daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>难度：Hard</p>
 * <p>题目：直线上最多的点数</p>
 * <p>描述：给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：points = [[1,1],[2,2],[3,3]]
 * 输出：3
 * 示例 2：
 *
 *
 * 输入：points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * 输出：4
 *  
 *
 * 提示：
 *
 * 1 <= points.length <= 300
 * points[i].length == 2
 * -104 <= xi, yi <= 104
 * points 中的所有点 互不相同
 * 通过次数25,280提交次数95,707
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-points-on-a-line
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * @description:
 * @program: GitRep
 * @author: fanyu
 * @create: 2021-06-24  07:36:40
 */
public class LeetCode_149 {
    public static void main(String[] args) {
        LeetCode_149 leetCode = new LeetCode_149();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.maxPoints(TestCase.POINTS));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.maxPoints(TestCase.POINTS1));
    }

    /**
     * 解法一：
     *
     * @param points
     * @return
     */
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) {
            return n;
        }
        int ret = 0;
        for (int i = 0; i < n; i++) {
            if (ret >= n - i || ret > n / 2) {
                break;
            }
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int j = i + 1; j < n; j++) {
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                if (x == 0) {
                    y = 1;
                } else if (y == 0) {
                    x = 1;
                } else {
                    if (y < 0) {
                        x = -x;
                        y = -y;
                    }
                    int gcdXY = gcd(Math.abs(x), Math.abs(y));
                    x /= gcdXY;
                    y /= gcdXY;
                }
                int key = y + x * 20001;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            int maxn = 0;
            for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
                int num = entry.getValue();
                maxn = Math.max(maxn, num + 1);
            }
            ret = Math.max(ret, maxn);
        }
        return ret;
    }

    public int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }

    static class TestCase {
        public static int ANS = 3;
        public static int[][] POINTS = {{1, 1}, {2, 2}, {3, 3}};

        public static int ANS1 = 4;
        public static int[][] POINTS1 = {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
    }
}
