package club.vann.leetcode.offer.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Tailbase
 * @description:
 * @author: vann
 * @create: 2020-07-14 13:54
 **/
public class LeetCode_120 {
    public static void main(String[] args) {
        LeetCode_120 leetCode = new LeetCode_120();

        System.out.println("Result["+TestCase.ANS+"] : " + leetCode.minimumTotal(TestCase.triangle()));
        System.out.println("Result["+TestCase.ANS1+"] : " + leetCode.minimumTotal1(TestCase.triangle1()));
    }

    /**
     * 解法一：
     *  借助辅助空间
     * @param triangle
     * @return
     */
    private int minimumTotal(List<List<Integer>> triangle) {
        int height = triangle.size();
        int[][] sup = new int[height][];
        sup[0] = new int[]{triangle.get(0).get(0)};
        for(int h = 1; h < height; h ++) {
            List<Integer> list = triangle.get(h);
            sup[h] = new int[list.size()];
            for(int i = 0; i < list.size(); i ++) {
                if(i-1 < 0) {
                    sup[h][i] = sup[h-1][i]+list.get(i);
                } else if(i >= sup[h-1].length) {
                    sup[h][i] = sup[h-1][i-1]+list.get(i);
                } else {
                    int v1 = sup[h-1][i-1];
                    int v2 = sup[h-1][i];
                    sup[h][i] = Math.min(v1, v2) + list.get(i);
                }
            }
        }

        int result = Integer.MAX_VALUE;
        int len = sup[height-1].length;
        for(int n = 0; n < len; n ++) {
            result = Math.min(result, sup[height-1][n]);
        }
        return result;
    }

    /**
     * 解法二：
     * 优化空间
     * dp[h][i]:
     * 1. dp[h-1][0]+c[h][i]   i == 0;
     * 2. dp[h-1][i-1]+c[h][i]  h == i;
     * 3. min(dp[h-1][i-1], dp[h-1][i]) + c[h][i]
     * @param triangle
     * @return
     */
    private int minimumTotal1(List<List<Integer>> triangle) {
        int height = triangle.size();
        int[][] dp = new int[2][height];
        dp[0][0] = triangle.get(0).get(0);
        for(int h = 1; h < height; h ++) {
            int cur = h % 2;
            int pre = 1 - cur;
            dp[cur][0] = dp[pre][0] + triangle.get(h).get(0);
            for (int j = 1; j < h; ++j) {
                dp[cur][j] = Math.min(dp[pre][j - 1], dp[pre][j]) + triangle.get(h).get(j);
            }
            dp[cur][h] = dp[pre][h - 1] + triangle.get(h).get(h);
        }

        int minTotal = dp[(height - 1) % 2][0];
        for (int i = 1; i < height; ++i) {
            minTotal = Math.min(minTotal, dp[(height - 1) % 2][i]);
        }
        return minTotal;
    }

    static class TestCase {
        public static final int ANS =11;
        public static List<List<Integer>> triangle() {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> list0 = new ArrayList<>();
            list0.add(2);
            result.add(list0);

            List<Integer> list1 = new ArrayList<>();
            list1.add(3);
            list1.add(4);
            result.add(list1);

            List<Integer> list2 = new ArrayList<>();
            list2.add(6);
            list2.add(5);
            list2.add(7);
            result.add(list2);

            List<Integer> list3 = new ArrayList<>();
            list3.add(4);
            list3.add(1);
            list3.add(8);
            list3.add(3);
            result.add(list3);

            return result;
        }

        public static final int ANS1 = 15;
        public static List<List<Integer>> triangle1() {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> list0 = new ArrayList<>();
            list0.add(2);
            result.add(list0);

            List<Integer> list1 = new ArrayList<>();
            list1.add(3);
            list1.add(4);
            result.add(list1);

            List<Integer> list2 = new ArrayList<>();
            list2.add(6);
            list2.add(5);
            list2.add(7);
            result.add(list2);

            List<Integer> list3 = new ArrayList<>();
            list3.add(4);
            list3.add(6);
            list3.add(8);
            list3.add(3);
            result.add(list3);

            return result;
        }
    }
}
